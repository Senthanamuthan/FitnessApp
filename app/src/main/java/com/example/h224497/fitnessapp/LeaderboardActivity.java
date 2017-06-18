package com.example.h224497.fitnessapp;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {
    final ArrayList<String> Toppers_names= new ArrayList<String>();
    final ArrayList<Double> Toppers_weightloss= new ArrayList<Double>();
    TextView a2,b2,c2,d2,e2,f2,switch1,switch2,switch3,switch4,switch5,switch6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        a2=(TextView) findViewById(R.id.a2);
        b2=(TextView) findViewById(R.id.b2);
        c2=(TextView) findViewById(R.id.c2);
        d2=(TextView) findViewById(R.id.d2);
        e2=(TextView) findViewById(R.id.e2);
        f2=(TextView) findViewById(R.id.f2);
        switch1=(TextView) findViewById(R.id.switch1);
        switch2=(TextView) findViewById(R.id.switch2);
        switch3=(TextView) findViewById(R.id.switch3);
        switch4=(TextView) findViewById(R.id.switch4);
        switch5=(TextView) findViewById(R.id.switch5);
        switch6=(TextView) findViewById(R.id.switch6);

        String api1= "http://199.63.14.73:9999/api/Feedback/GetLeaderboardDetails";
        new LeaderboardActivity.HttpGetZonesDetails().execute(api1);

     //   giveui();

    }
    class HttpGetZonesDetails extends AsyncTask<String,String, String> {
        //private  static String sendid;

        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }

        protected void onPostExecute(String response) {
            final String response1=response;

            try {

                JSONArray jArray = new JSONArray(response);
                for (int i = 0; i < jArray.length(); i++) {

                    JSONObject jObject = jArray.getJSONObject(i);

                    String Zone_Name = jObject.getString("Name");
                    double Zone_ID = jObject.getInt("Weightloss");
                    Toppers_names.add(Zone_Name);
                    Toppers_weightloss.add((Zone_ID));
                    String rr = "Received! " + Zone_ID + Zone_Name;
                     Toast.makeText(getBaseContext(), rr, Toast.LENGTH_LONG).show();


                } // End Loop
                String a= Toppers_names.get(0);
                a2.setText(a);
                String b= Toppers_names.get(1);
                b2.setText(b);
                String c= Toppers_names.get(2);
                c2.setText(c);
                String d= Toppers_names.get(3);
                d2.setText(d);
                String e= Toppers_names.get(4);
                e2.setText(e);
                String f= Toppers_names.get(5);
                f2.setText(f);
                Double wa1= Toppers_weightloss.get(0);
                String w1=Double.toString(wa1);
                switch1.setText(w1);
                Double wa2= Toppers_weightloss.get(1);
                String w2=Double.toString(wa2);
                switch2.setText(w2);
                Double wa3= Toppers_weightloss.get(2);
                String w3=Double.toString(wa3);
                switch3.setText(w3);
                Double wa4= Toppers_weightloss.get(3);
                String w4=Double.toString(wa4);
                switch4.setText(w4);
                Double wa5= Toppers_weightloss.get(4);
                String w5=Double.toString(wa5);
                switch5.setText(w5);
                Double wa6= Toppers_weightloss.get(5);
                String w6=Double.toString(wa6);
                switch6.setText(w6);
            }
            catch (JSONException e) {
                Log.e("JSONException", "Error: " + e.toString());
            } /// / catch (JSONException e)

        }
    }
   public void giveui(){
        String a= Toppers_names.get(0);
       a2.setText(a);
       String b= Toppers_names.get(0);
       b2.setText(b);
       String c= Toppers_names.get(0);
       c2.setText(c);
       String d= Toppers_names.get(0);
       d2.setText(d);
       String e= Toppers_names.get(0);
       e2.setText(e);
       String f= Toppers_names.get(0);
       f2.setText(f);
       Double wa1= Toppers_weightloss.get(0);
       String w1=Double.toString(wa1);
       a2.setText(w1);
       Double wa2= Toppers_weightloss.get(1);
       String w2=Double.toString(wa2);
       a2.setText(w2);
       Double wa3= Toppers_weightloss.get(2);
       String w3=Double.toString(wa3);
       a2.setText(w3);
       Double wa4= Toppers_weightloss.get(3);
       String w4=Double.toString(wa4);
       a2.setText(w4);
       Double wa5= Toppers_weightloss.get(4);
       String w5=Double.toString(wa5);
       a2.setText(w5);
       Double wa6= Toppers_weightloss.get(5);
       String w6=Double.toString(wa6);
       a2.setText(w6);


    }
    public static String GET(String url) {
        InputStream inputStream = null;
        String result = "";
        try {

            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
            inputStream = httpResponse.getEntity().getContent();
            if (inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        return result;
    }
    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }
}
