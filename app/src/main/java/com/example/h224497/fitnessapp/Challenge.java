package com.example.h224497.fitnessapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class Challenge extends AppCompatActivity {
    Button button143;
    EditText todwt;
    SQLiteDatabase myDB= null;
    String TableName = "P7";
    String ret="";
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        todwt = (EditText) findViewById(R.id.editText10);
        button143 = (Button) findViewById(R.id.button5);
        button143.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                final String te = todwt.getText().toString();

                myDB =openOrCreateDatabase("PatientDB", MODE_PRIVATE, null);

                //getting the cursor object
                String q = "SELECT * FROM P7";// WHERE Name='" + screenName + "'";

                Cursor c = myDB.rawQuery(q, null);
                c.moveToFirst();


                if (c != null) {
                    int Column1 = c.getColumnIndex("Name");
                    final String n = c.getString(Column1);

                   //change
                  //  final String pii="12";
                    final String pii = readFromFile1(context);
                    Toast.makeText(getApplicationContext(), n, Toast.LENGTH_LONG).show();

                    RequestObject object = new RequestObject();

                    object.setpin(pii);
                    object.setname(n);
                    object.setWeightloss(te);


                    Gson gson = new Gson();

                    String json = gson.toJson(object);


                    String api = "http://199.63.14.73:9999/api/Feedback/PostChallengeComment";
                     makeRequest(api, json);
                }
            }
        });
    }

    private String readFromFile1(Context context) {

        try {

            InputStream inputStream = context.openFileInput("pin");
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
                // Toast.makeText(getBaseContext(), ret, Toast.LENGTH_LONG).show();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        //Toast.makeText(getApplicationContext(),ret, Toast.LENGTH_LONG).show();
        return ret;
    }
    public static HttpResponse makeRequest(String uri, String json) {
        try {
            HttpClient client = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(new StringEntity(json));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            //HttpResponse response = client.execute(httpPost);
            //BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            // final String line=rd.readLine();


            return new DefaultHttpClient().execute(httpPost);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public class RequestObject {

        private String pin;
        private String name;
        private String weightloss;


        // private List<QIDValuePair> qidValuePair;
        // public void setPIN(String ppin) {
        //   PIN = ppin;
        //}
        /*public String getName() {
            return Name;
        }*/
        public void setpin(String pinn) {
            pin = pinn;
        }


        public void setname(String namee) {

            name = namee;
        }

        public void setWeightloss(String wei) {

            weightloss = wei;
        }


    }
}