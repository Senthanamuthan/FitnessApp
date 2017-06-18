package com.example.h224497.fitnessapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class RegActivity extends AppCompatActivity {
    EditText name, dob,age,email,mob,ht,wt;
    RadioGroup rg2,rg4;
    RadioButton r1,r2,r3,r4;
    String gettt,gettt1;
    Button button143;
    SQLiteDatabase myDB= null;
    String TableName = "P8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        name = (EditText) findViewById(R.id.editText1);
        dob = (EditText) findViewById(R.id.editText2);
        age= (EditText) findViewById(R.id.editText17);
        email = (EditText) findViewById(R.id.editText18);
        mob = (EditText) findViewById(R.id.editText5);
        ht = (EditText) findViewById(R.id.editText51);
        wt= (EditText) findViewById(R.id.editText52);

        rg2 = (RadioGroup) findViewById(R.id.radioButtonGroup);
        rg4 = (RadioGroup) findViewById(R.id.radioButtonGroup1);

        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton1);
        r4 = (RadioButton) findViewById(R.id.radioButton21);
        myDB = openOrCreateDatabase("PatientDB", MODE_PRIVATE, null);

        // Create table with 16 usef columns (Name and Age)

        myDB.execSQL("CREATE TABLE IF NOT EXISTS " + TableName
                + " (Name VARCHAR(30), Wet VARCHAR(10),Het VARCHAR(10));");
        button143 = (Button) findViewById(R.id.button2);
        button143.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                final String te = name.getText().toString();
                final String dob1 = dob.getText().toString();
                final String ag = age.getText().toString();
                final String em = email.getText().toString();
                final String mo = mob.getText().toString();
                final String he = ht.getText().toString();
                final String we = wt.getText().toString();
                if (r1.isChecked()) {
                    gettt = "M";
                } else if (r2.isChecked()) {
                    gettt = "F";
                }

                if (r3.isChecked()) {
                    gettt1 = "Yes";
                } else if (r4.isChecked()) {
                    gettt1 = "No";
                }
                myDB.execSQL("INSERT INTO " + TableName + " (Name,Wet,Het)" + " VALUES ('"
                        + te + "','" + we + "','" + he + "');");

                RequestObject object = new RequestObject();

                object.setName(te);
                object.setDob(dob1);
                object.setAge(ag);
                object.setMobileNo(mo);
                object.setEmail(em);
                object.setHt(he);
                object.setWt(we);
                object.setGender(gettt);
                object.setCoach(gettt1);

                Gson gson = new Gson();

                String json = gson.toJson(object);


                String api = "http://10.78.31.159:9999/api/Patients/PostPatient";
                // makeRequest(api, json);



            }
        });
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

        private String Name;
        private String Age;
        private String MobileNo;
        private String Dob;
        private String Email;
        private String Gender;
        private String Ht;
        private String Wt;
        private String ge;
        private String ge1;



        // private List<QIDValuePair> qidValuePair;
        // public void setPIN(String ppin) {
        //   PIN = ppin;
        //}
        /*public String getName() {
            return Name;
        }*/
        public void setName(String nAME) {
            Name = nAME;
        }


        public void setAge(String age) {

            Age = age;
        }

        public void setDob(String dobb) {

            Dob = dobb;
        }

        public void setMobileNo(String dobb1) {

            MobileNo = dobb1;
        }

        public void setEmail(String dobb2) {

            Email= dobb2;
        }

        public void setHt(String dobb3) {

            Ht = dobb3;
        }

        public void setWt(String dobb4) {

            Wt = dobb4;
        }

        public void setGender(String gett5) {

            ge = gett5;
        }
        public void setCoach(String gett6) {

            ge1 = gett6;
        }
    }

}

