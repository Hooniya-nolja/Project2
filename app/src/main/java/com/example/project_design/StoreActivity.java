package com.example.project_design;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.daum.android.map.MapView;

public class StoreActivity extends AppCompatActivity {
    TextView textview;
    MapView mapView;
    ViewGroup mapViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("홍대 스타벅스");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF87CEFA));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.store_layout);
        textview = (TextView) findViewById(R.id.textview);
        Intent intent = getIntent();
        textview.setText(intent.getStringExtra("nameText").toString());

        mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            super.onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}