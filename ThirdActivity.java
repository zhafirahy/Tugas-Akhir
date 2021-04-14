package com.example.harisabtu;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ThirdActivity  extends AppCompatActivity {

    final ArrayList<Double> dataArray = new ArrayList<>();
    private static final String TAG = "GraphFragment";
    private LineGraphSeries<DataPoint> series;
    private double graphLastXValue = 0d;
    double graphYValue = 0d;
    TextView T;
    GraphView a;
    FirebaseDatabase database;
    DatabaseReference reff;
    SimpleDateFormat sdf = new SimpleDateFormat("MMM");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        a = findViewById(R.id.graph);
        database = FirebaseDatabase.getInstance();
        reff = database.getReference("qq").child("nomor");

        a.getViewport().setMinY(-0.5);
        a.getViewport().setMaxY(2);
        a.getViewport().setYAxisBoundsManual(true);
        a.getViewport().setMinX(0);
        a.getViewport().setMaxX(30);
        a.getViewport().setXAxisBoundsManual(true);

        a.getViewport().setScrollable(true);
        a.setHorizontalScrollBarEnabled(true);

        a.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        a.getGridLabelRenderer().setVerticalLabelsVisible(false);
        a.getGridLabelRenderer().setHorizontalAxisTitle("time (s)");
        a.getGridLabelRenderer().setHorizontalAxisTitleTextSize(22);
        a.getGridLabelRenderer().setVerticalAxisTitle("amplitudo (A)");
        a.getGridLabelRenderer().setVerticalAxisTitleTextSize(22);
        a.getViewport().setDrawBorder(true);

        series = new LineGraphSeries<>();
        a.addSeries(series);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final String s=String.valueOf(snapshot.getValue(double.class));
                ThirdActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (s.trim().equals("")) {
                            graphYValue = 0.0;
                        } else {
                            graphYValue = Double.parseDouble(s.trim());
                        }
                        dataArray.add(graphYValue);
                        graphLastXValue += 0.3;
                        series.appendData(new DataPoint(graphLastXValue, graphYValue), true, 100);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
