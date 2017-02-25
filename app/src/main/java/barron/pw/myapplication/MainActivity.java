package barron.pw.myapplication;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    InterstitialAd mInterstitialAd;
    private FragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    public static boolean tamam=false;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }
    @Override
    public void onBackPressed()
    {

        startActivity(new Intent(MainActivity.this,Selection.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions =   View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);

        SharedPreferences sharedpreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);

        int myInt = sharedpreferences.getInt("coins", 0);
        TextView coin = (TextView)findViewById(R.id.textView);
        coin.setText("Coins : "+String.valueOf(myInt+10));
        FrameLayout kazan = (FrameLayout)findViewById(R.id.kazan);
        kazan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //  startActivity(new Intent(MainActivity.this,oyun.class));
                startActivity(new Intent(MainActivity.this,oyun.class));

//                mInterstitialAd = new InterstitialAd(getApplicationContext());
//
//                // set the ad unit ID
//                mInterstitialAd.setAdUnitId("ca-app-pub-2076428269239567/8529208130");
//
//                AdRequest adRequest2 = new AdRequest.Builder()
//                        .build();
//
//                // Load ads into Interstitial Ads
//                mInterstitialAd.loadAd(adRequest2);
//
//                mInterstitialAd.setAdListener(new AdListener() {
//                    public void onAdLoaded() {
//                        showInterstitial();
//                    }
//                });
//                mInterstitialAd.setAdListener(new AdListener() {
//                    @Override
//                    public void onAdClosed() {
//                        //write to coins
//                        SharedPreferences sharedpreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
//
//                        int myInt = sharedpreferences.getInt("coins", 0);
//                        SharedPreferences.Editor editor = sharedpreferences.edit();
//
//                        editor.putInt("coins", myInt + 10);
//                        TextView coin = (TextView) findViewById(R.id.textView);
//                        coin.setText("Coins : " + myInt + 10);
//                        editor.commit();
//                        finish();
//                    }
//                });




            }
        });


        AdView  mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interid));

        AdRequest adRequest2 = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest2);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
Button load = (Button)findViewById(R.id.button);




        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterstitialAd = new InterstitialAd(getApplicationContext());

                // set the ad unit ID
                mInterstitialAd.setAdUnitId(getResources().getString(R.string.interid));

                AdRequest adRequest2 = new AdRequest.Builder()
                        .build();

                // Load ads into Interstitial Ads
                mInterstitialAd.loadAd(adRequest2);

                mInterstitialAd.setAdListener(new AdListener() {
                    public void onAdLoaded() {
                        showInterstitial();
                    }
                });
            }
        });






        // Create the adapter that will return a fragment for each section
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            private final Fragment[] mFragments = new Fragment[] {
                    new stalkers(),
                    new all(),
                    new all(),
                    new coins(),
                    new all()
            };
            private final String[] mFragmentNames = new String[] {
                    "Profiles of Stalkers",
                    "Secret Admirers",
                    "Who Blocked Me",
                    "Earn Coins",
                    "Chances of Stalking"

            };
            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }
            @Override
            public int getCount() {
                return mFragments.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return mFragmentNames[position];
            }
        };
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(mViewPager);






    }
    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {

            mInterstitialAd.show();


        }
}}
