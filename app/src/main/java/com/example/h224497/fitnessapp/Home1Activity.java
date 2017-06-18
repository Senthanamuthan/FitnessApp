package com.example.h224497.fitnessapp;

        import android.content.Intent;
        import android.os.Bundle;
        import android.app.Activity;
        import android.os.StrictMode;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.GridView;
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

public class Home1Activity extends Activity {
    GridView grid;
    String messagerec;


    public static String [] prgmNameList={ "Living Room",
            "Master Bedroom",
            "Kitchen",
            "Workroom",
            "Washroom",
            "Dining room",
            //"Kids room",
            //"Studyroom",
           };
    public static int [] prgmImages={ R.drawable.food,
            R.drawable.water,
            R.drawable.workout,
            R.drawable.location,
            R.drawable.graph,
            R.drawable.share,
         //   R.drawable.icon8,
         //   R.drawable.icon9,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        grid=(GridView) findViewById(R.id.gridView1);
        grid.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

       /* CustomGrid adapter = new CustomGrid(Home1Activity.this, web, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);*/


    }

}