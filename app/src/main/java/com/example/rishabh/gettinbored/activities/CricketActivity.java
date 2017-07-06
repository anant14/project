package com.example.rishabh.gettinbored.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.rishabh.gettinbored.R;

public class CricketActivity extends AppCompatActivity {

    RecyclerView rvcricket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);
        rvcricket=(RecyclerView)findViewById(R.id.rvcricket);
    }
}
