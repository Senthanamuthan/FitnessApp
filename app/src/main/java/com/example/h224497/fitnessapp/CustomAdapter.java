package com.example.h224497.fitnessapp;

/**
 * Created by H224497 on 6/3/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class CustomAdapter extends BaseAdapter{

    String [] result;
    Context context;
    String messagerec;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(Home1Activity mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_single, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
                if(position == 0){
                    Toast.makeText(context, "You Clicked at " , Toast.LENGTH_SHORT).show();
                    Intent intentLoadNewActivity = new Intent(context,RegActivity.class);

                    context.startActivity(intentLoadNewActivity);
                }

                else if(position == 1){
                  //  Toast.makeText(context, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                    Intent intentLoadNewActivity = new Intent(context,Challenge.class);

                    context.startActivity(intentLoadNewActivity);
                }
                else if(position == 2){
                  //  Toast.makeText(Home1Activity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                    Intent intentLoadNewActivity = new Intent(context,Login2Activity.class);

                    context.startActivity(intentLoadNewActivity);
                }
               else if(position == 3){
                  //  Toast.makeText(Home1Activity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                    Intent intentLoadNewActivity = new Intent(context,LeaderboardActivity.class);

                    context.startActivity(intentLoadNewActivity);
                }
                else if(position == 4){
                   // Toast.makeText(Home1Activity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                    Intent intentLoadNewActivity = new Intent(context,graphpre.class);

                    context.startActivity(intentLoadNewActivity);
                }
              /*  else if(position == 5){
                   // Toast.makeText(Home1Activity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                    Intent intentLoadNewActivity = new Intent(context,Login2Activity.class);

                    context.startActivity(intentLoadNewActivity);
                }*/

                else{
                    Toast.makeText(context, "You Clicked at " , Toast.LENGTH_SHORT).show();

                }

            }
        });
       return rowView;
    }

}