package com.example.h224497.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Login2Activity extends AppCompatActivity {

   // TextView t1, t2;
    Context context=this;
    EditText uname, pwd;
    Button login;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    //    t1 = (TextView) findViewById(R.id.t1);
     //   t2 = (TextView) findViewById(R.id.t2);
        uname = (EditText) findViewById(R.id.uname);
        pwd = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intentLoadNewActivity = new Intent(Login2Activity.this,RegActivity.class);
               // intentLoadNewActivity.putExtra("E1",id1);
                RequestObject object = new RequestObject();
                String id3=uname.getText().toString().toUpperCase();
                Toast.makeText(getApplicationContext(),id3, Toast.LENGTH_LONG).show();
                String stat3=pwd.getText().toString().toUpperCase();
                Toast.makeText(getApplicationContext(),stat3, Toast.LENGTH_LONG).show();
                //RequestObject object = new RequestObject();

                object.setUname(id3);
                object.setPassword(stat3);
                Gson gson = new Gson();

                String json = gson.toJson(object);

                String api = "http://199.63.14.73:9999/api/Feedback/PostLoginComment";
                Toast.makeText(getApplicationContext(),json, Toast.LENGTH_LONG).show();
              HttpResponse res = makeRequest(api, json);
               Log.v("response", res.toString());

                try {
                    BufferedReader rd = new BufferedReader(new InputStreamReader(
                            res.getEntity().getContent()));

                    final String line = rd.readLine();
                    Toast.makeText(getApplicationContext(),line, Toast.LENGTH_LONG).show();
                    String filename = "pin";

                    File file = new File(context.getFilesDir(), filename);
                    FileOutputStream outputStream;

                    try {
                        outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                        outputStream.write(line.getBytes());
                        outputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(), line, Toast.LENGTH_LONG).show();
                }catch(IOException e) {

                }
                startActivity(intentLoadNewActivity);
            }
        });
    }

    public static HttpResponse makeRequest(String uri, String json) {
        try {
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(new StringEntity(json));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");


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

        private String uname;
        private String password;

        public String getUname() {
            return uname;
        }
        public void setUname(String unam) {
            uname = unam;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String passwor) {
            password = passwor;
        }

    }

}
