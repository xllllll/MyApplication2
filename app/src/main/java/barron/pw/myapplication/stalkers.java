package barron.pw.myapplication;


import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class stalkers extends Fragment {

    public stalkers() {
        // Required empty public constructor
    }
    InterstitialAd mInterstitialAd;
    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {

            mInterstitialAd.show();


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mInterstitialAd = new InterstitialAd(getActivity());

        // set the ad unit ID
        mInterstitialAd.setAdUnitId("ca-app-pub-2076428269239567/8529208130");

        AdRequest adRequest2 = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest2);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {

                //showInterstitial();
            }
        });

        Cursor c = getActivity().getContentResolver().query(
                ContactsContract.RawContacts.CONTENT_URI,
                new String[] { ContactsContract.RawContacts.CONTACT_ID, ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY },
                ContactsContract.RawContacts.ACCOUNT_TYPE + "= ?",
                new String[] { "com.whatsapp" },
                null);
        Cursor f = getActivity().getContentResolver().query(
                ContactsContract.RawContacts.CONTENT_URI,
                new String[] { ContactsContract.RawContacts.CONTACT_ID, ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY },
                ContactsContract.RawContacts.ACCOUNT_TYPE + "= ?",
                new String[] { "com.facebook" },
                null);
        Cursor d = getActivity().getContentResolver().query(
                ContactsContract.RawContacts.CONTENT_URI,
                new String[] { ContactsContract.RawContacts.CONTACT_ID, ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY },
                ContactsContract.RawContacts.ACCOUNT_TYPE + "= ?",
                new String[] { "com.twitter" },
                null);
        Cursor e = getActivity().getContentResolver().query(
                ContactsContract.RawContacts.CONTENT_URI,
                new String[] { ContactsContract.RawContacts.CONTACT_ID, ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY },
                ContactsContract.RawContacts.ACCOUNT_TYPE + "= ?",
                new String[] { "com.instagram" },
                null);
        e.getColumnCount();
        d.getColumnCount();
        f.getColumnCount();

        View v= inflater.inflate(R.layout.fragment_stalkers, container, false);

        final ListView listView = (ListView) v.findViewById(R.id.kontaklist);

        ArrayList <ChatNew> mesagelist = new ArrayList<ChatNew>();
        NewAdapter adapter = new NewAdapter(getContext(), mesagelist);
        ArrayList<String> myWhatsappContacts = new ArrayList<String>();
        listView.setAdapter(adapter);

        int contactNameColumn = c.getColumnIndex(ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY);
        c.getColumnCount();
        MainActivity.tamam=false;
if(!MainActivity.tamam){

for(int i=0; i<5; i++){
        Random r = new Random();
        int i1 = r.nextInt( c.getCount() - 1) + 1;
        c.moveToPosition(i1);
        myWhatsappContacts.add(c.getString(contactNameColumn));
        ChatNew cn =new ChatNew(c.getString(contactNameColumn));
        adapter.add(cn);

}
    MainActivity.tamam=true;
    }


        while (c.moveToNext())
        {c.getColumnCount();
            // You can also read RawContacts.CONTACT_ID to read the
            // ContactsContract.Contacts table or any of the other related ones.


        }
        Log.d("kontak",myWhatsappContacts.toString());
        adapter.notifyDataSetChanged();


return v;
    }

}
