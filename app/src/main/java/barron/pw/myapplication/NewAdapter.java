package barron.pw.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
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
        if (1==1) {

            if(1==1){
                convertView =  LayoutInflater.from(getContext()).inflate(R.layout.kontak, parent, false);
            }else{
               // convertView = LayoutInflater.from(getContext()).inflate(R.layout.chat_list_item_topic_each_message, parent, false);
            }
        }

        // Lookup view for data population
        //RelativeLayout sing = (RelativeLayout) convertView.findViewById(R.id.sing);

        TextView kontak = (TextView) convertView.findViewById(R.id.kontak);
        TextView lastseen = (TextView) convertView.findViewById(R.id.textView5);
            Random r = new Random();
            int i1 = r.nextInt( 59 - 1) + 1;


        SharedPreferences sharedpreferences = getContext().getSharedPreferences(getContext().getPackageName(), Context.MODE_PRIVATE);

        int myInt = sharedpreferences.getInt("coins", 0);
        if ((i1 % 2) == 0 && myInt<3000) {
            // number is even
            lastseen.setText("*** 3000 Coins ***");
            lastseen.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryDark));


            kontak.setText("*** 3000 Coins ***");
            kontak.setTextColor(getContext().getResources().getColor(R.color.colorPrimaryDark));
        }

        else {
            // number is odd
            lastseen.setText(i1+ " Minutes Ago");


            kontak.setText(user.getMessage());
        }



       // lastseen.setText(user.getMessage());
        //date.setText(String.valueOf(user.getTimeMillis().split("GMT")[0]));
        // Return the completed view to render on screen
        return convertView;
    }
}