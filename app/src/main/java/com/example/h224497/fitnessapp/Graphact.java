package com.example.h224497.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;







public class Graphact extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphact);


        final String a="110.000f";

        BarChart chart = (BarChart) findViewById(R.id.chart);

        BarData data = new BarData(getXAxisValues(), getDataSet());
        chart.setData(data);
        chart.setDescription("My Chart");
        chart.animateXY(2000, 2000);
        chart.invalidate();
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;
        //float a=120.000f;
        final String b = getIntent().getStringExtra("a11");
        float flo = Float.parseFloat(b);
        final String b1 = getIntent().getStringExtra("a2");
        float g1 = Float.parseFloat(b1);
        final String b2 = getIntent().getStringExtra("a3");
        float g2 = Float.parseFloat(b2);
        final String b3 = getIntent().getStringExtra("a4");
        float g3 = Float.parseFloat(b3);
        final String b4 = getIntent().getStringExtra("a5");
        float g4 = Float.parseFloat(b4);
        final String b5 = getIntent().getStringExtra("a6");
        float g5 = Float.parseFloat(b5);



        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(flo, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(g1, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(g2, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(g3, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(g4, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(g5, 5); // Jun
        valueSet1.add(v1e6);

        /*ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
        valueSet2.add(v2e6);*/

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Weight in kg");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        // BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        // barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        // dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }
}

