

        package com.example.h224497.fitnessapp;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class graphpre extends AppCompatActivity {
    EditText ed,ed1,ed2,ed3,ed4,ed5;
    Button button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphpre);
        button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ed = (EditText)findViewById(R.id.editText8);
                // float tes = Float.valueOf(ed.getText().toString());
                final String tes = ed.getText().toString();
                ed1 = (EditText)findViewById(R.id.editText12);
                final String tes1 = ed1.getText().toString();
                ed2= (EditText)findViewById(R.id.editText13);
                final String tes2 = ed2.getText().toString();
                ed3 = (EditText)findViewById(R.id.editText14);
                final String tes3 = ed3.getText().toString();
                ed4 = (EditText)findViewById(R.id.editText15);
                final String tes4 = ed4.getText().toString();
                ed5 = (EditText)findViewById(R.id.editText16);
                final String tes5 = ed5.getText().toString();




                Intent int41 = new Intent(graphpre.this,Graphact.class);
                int41.putExtra("a11", tes);
                int41.putExtra("a2", tes1);
                int41.putExtra("a3", tes2);
                int41.putExtra("a4", tes3);
                int41.putExtra("a5", tes4);
                int41.putExtra("a6", tes5);






                startActivity(int41);


            }
        });




    }
}










