package barron.pw.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

public class sonoyun extends Activity {
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int i=0;
int alfa;
    int sesin=0;
    TextView tw;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonoyun);
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
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
         tw=(TextView) findViewById(R.id.textView10);


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Select the brighter color to win coins!")
                .setPositiveButton("Start New Game", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
               ;builder.create().show();



        final Handler handler = new Handler();
        Thread feedthread = new Thread()
        {
            @Override
            public void run() {
                super.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Toast.makeText(getApplicationContext(), "UI", Toast.LENGTH_SHORT).show();



                        final FrameLayout sol = (FrameLayout)findViewById(R.id.sol);
                        final   FrameLayout sag = (FrameLayout)findViewById(R.id.sag);

                        Random rnd = new Random();
                        alfa=rnd.nextInt(255);
                        int color = Color.argb(alfa, 150, 150, 150);
                        int color2 = Color.argb(100, 180, 180, 180);

                        sol.setBackgroundColor(color);
                        sag.setBackgroundColor(color2);
                        if(alfa<100){

                            sol.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //win points
                                    SharedPreferences sharedpreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
                                    int myInt = sharedpreferences.getInt("coins", 0);
                                    SharedPreferences.Editor editor = sharedpreferences.edit();

                                    editor.putInt("coins", myInt + 10);

                                    editor.commit();
                                    sesin=sesin+10;
                                    TextView tw=(TextView) findViewById(R.id.textView10);
                                    tw.setText(String.valueOf(sesin));

                                }
                            });
                            sag.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //loss
                                    mInterstitialAd = new InterstitialAd(getApplicationContext());

                                    // set the ad unit ID
                                    mInterstitialAd.setAdUnitId("ca-app-pub-2076428269239567/8529208130");

                                    AdRequest adRequest2 = new AdRequest.Builder()
                                            .build();

                                    // Load ads into Interstitial Ads
                                    mInterstitialAd.loadAd(adRequest2);

                                    mInterstitialAd.setAdListener(new AdListener() {
                                        public void onAdLoaded() {
                                            showInterstitial();
                                        }
                                    });
                                    Intent i=new Intent(getApplicationContext(),gameover.class);
                                    i.putExtra("id", tw.getText().toString());
                                    startActivity(i);
                                    finish();
                                }
                            });
                        }else{
                            sag.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ///win
                                    SharedPreferences sharedpreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
                                    int myInt = sharedpreferences.getInt("coins", 0);
                                    SharedPreferences.Editor editor = sharedpreferences.edit();

                                    editor.putInt("coins", myInt + 10);

                                    editor.commit();
                                    sesin=sesin+10;
                                    TextView tw=(TextView) findViewById(R.id.textView10);
                                    tw.setText(String.valueOf(sesin));


                                }
                            });
                            sol.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //loss
                                    mInterstitialAd = new InterstitialAd(getApplicationContext());

                                    // set the ad unit ID
                                    mInterstitialAd.setAdUnitId("ca-app-pub-2076428269239567/8529208130");

                                    AdRequest adRequest2 = new AdRequest.Builder()
                                            .build();

                                    // Load ads into Interstitial Ads
                                    mInterstitialAd.loadAd(adRequest2);

                                    mInterstitialAd.setAdListener(new AdListener() {
                                        public void onAdLoaded() {
                                            showInterstitial();
                                        }
                                    });
                                    Intent i=new Intent(getApplicationContext(),gameover.class);
                                    i.putExtra("id", tw.getText().toString());
                                    startActivity(i);
                                    finish();

                                }
                            });
                        }





                    }
                });
                handler.postDelayed(this, 1100);
            }
        };
        handler.postDelayed(feedthread, 1100);








        mProgressBar=(ProgressBar)findViewById(R.id.progressBar4);
        mProgressBar.setProgress(i);
        mCountDownTimer=new CountDownTimer(100000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress"+ i+ millisUntilFinished);
                i++;
                mProgressBar.setProgress(i);

            }

            @Override
            public void onFinish() {
                //Do what you want
                i++;
                mProgressBar.setProgress(i);
            }
        };
       // mCountDownTimer.start();
    }



    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {

            mInterstitialAd.show();


        }
    }
}
