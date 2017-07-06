package com.example.rishabh.gettinbored;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rishabh.gettinbored.activities.CricketActivity;
import com.example.rishabh.gettinbored.activities.FoodActivity;
import com.example.rishabh.gettinbored.activities.NewsActivity;

public class MainActivity extends AppCompatActivity {

    Button btnnews,btncricket,btnfoodstuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnnews=(Button)findViewById(R.id.btnnews);
        btnfoodstuff=(Button)findViewById(R.id.btnfoodstuff);
        btncricket=(Button)findViewById(R.id.btncricket);
        btnnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news = new Intent(MainActivity.this,NewsActivity.class);
                startActivity(news);
            }
        });
        btncricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cricket = new Intent(MainActivity.this,CricketActivity.class);
                startActivity(cricket);
            }
        });
        btnfoodstuff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent food = new Intent(MainActivity.this,FoodActivity.class);
                startActivity(food);
            }
        });
    }
}
