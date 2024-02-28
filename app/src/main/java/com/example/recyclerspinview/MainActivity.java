package com.example.recyclerspinview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerspinview.recyclerview.RecyclerViewActivity;
import com.example.recyclerspinview.viewpager.ViewpagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSpinViewFlowClick(View view) {
        Intent intent = new Intent(this, SpinViewActivity.class);
        startActivity(intent);
    }

    public void on3DSpinViewFlowClick(View view) {
        Intent intent = new Intent(this, SpinView3DActivity.class);
        startActivity(intent);
    }

    public void onViewPagerClick(View view) {
        Intent intent = new Intent(this, ViewpagerActivity.class);
        startActivity(intent);
    }

    public void onRecyclerViewClick(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }



}
