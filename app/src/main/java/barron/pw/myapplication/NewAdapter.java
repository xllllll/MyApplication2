package barron.pw.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by hp on 2/24/2017.
 */

public class NewAdapter extends ArrayAdapter<ChatNew> {
    public NewAdapter(Context context, ArrayList<ChatNew> dss) {
        super(context,0,  dss);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final ChatNew user = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (1 == 1) {

            if (1 == 1) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.kontak, parent, false);
            } else {
                // convertView = LayoutInflater.from(getContext()).inflate(R.layout.chat_list_item_topic_each_message, parent, false);
            }
        }

        // Lookup view for data population
        //RelativeLayout sing = (RelativeLayout) convertView.findViewById(R.id.sing);

        TextView kontak = (TextView) convertView.findViewById(R.id.kontak);
        TextView lastseen = (TextView) convertView.findViewById(R.id.textView5);
        ImageView i2 = (ImageView) convertView.findViewById(R.id.imageView2);

        Random r = new Random();
        int i1 = r.nextInt(59 - 1) + 1;


        SharedPreferences sharedpreferences = getContext().getSharedPreferences(getContext().getPackageName(), Context.MODE_PRIVATE);

        int myInt = sharedpreferences.getInt("coins", 0);
        int open = sharedpreferences.getInt("opened", 0);
        int time = sharedpreferences.getInt("time", 0);
        Date date = new Date();   // given date
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date
        calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        if (time > calendar.get(Calendar.HOUR_OF_DAY)) {

        }
        if (myInt > 2999) {
            SharedPreferences.Editor editor = sharedpreferences.edit();

            // calendar.get(Calendar.HOUR);
            editor.putInt("coins", myInt - 3000);
            editor.putInt("opened", 1);
            editor.putInt("time", calendar.get(Calendar.HOUR_OF_DAY) + 2);

            Calendar.getInstance().get(Calendar.MILLISECOND);
            editor.commit();
            // number is odd
            lastseen.setText(i1 + " Minutes Ago");


            kontak.setText(user.getMessage());

        } else if (myInt<3000 && time > calendar.get(Calendar.HOUR_OF_DAY))
        {

            // number is odd
            lastseen.setText(i1+ " Minutes Ago");


            kontak.setText(user.getMessage());


        }
        else{

            SharedPreferences.Editor editor = sharedpreferences.edit();

           // editor.putInt("coins", myInt -3000);
            editor.putInt("opened", 0);
            editor.putInt("time",   0);

            Calendar.getInstance().get(Calendar.MILLISECOND);
            editor.commit();

            if ((i1 % 2) == 0 && myInt<3000) {
                // number is even
                lastseen.setText("*** 3000 Coins ***");
                lastseen.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryDark));

                Random rx = new Random();
                int i1x = rx.nextInt(59 - 1) + 1;
File f = new File("/data/data/com.instagram.android")    ;
                File fa = new File("/data/data/com.facebook.orca")    ;

                //if(f.exists())
                    if(i1x %2==0 && f.exists()){
                    i2.setBackgroundResource(R.drawable.ws);

                }else if(i1x %2==0 && fa.exists()){
                    i2.setBackgroundResource(R.drawable.ws);

                }else{
                        i2.setBackgroundResource(R.drawable.ws);

                    }

                kontak.setText("*** 3000 Coins ***");
                kontak.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryDark));

                lastseen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getContext().startActivity(new Intent(getContext(),sonoyun.class));

                    }
                });
                kontak.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getContext().startActivity(new Intent(getContext(),sonoyun.class));

                    }
                });
            }

            else {
                Random rxc = new Random();
                int ixc = rxc.nextInt(23 - 1) + 1;
                // number is odd
                if(ixc%2==0){
                    lastseen.setText(i1+ " Minutes Ago");
                    i2.setBackgroundResource(R.drawable.ws);
                }else{
                    Random rx = new Random();
                    int ix = rx.nextInt(23 - 1) + 1;
                    lastseen.setText(ix+ " Hours Ago");
                    i2.setBackgroundResource(R.drawable.ws);

                }



                kontak.setText(user.getMessage());
            }

        }



       // lastseen.setText(user.getMessage());
        //date.setText(String.valueOf(user.getTimeMillis().split("GMT")[0]));
        // Return the completed view to render on screen
        return convertView;
    }
}