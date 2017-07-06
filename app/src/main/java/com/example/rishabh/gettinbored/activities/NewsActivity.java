package com.example.rishabh.gettinbored.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.adapter.newsAdapter;
import com.example.rishabh.gettinbored.api.newsApi;
import com.example.rishabh.gettinbored.model.articles;
import com.example.rishabh.gettinbored.model.newsclass;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivity extends AppCompatActivity {

    RecyclerView rvnews;
    newsAdapter newsadapter;
    public static final String TAG="newsactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        rvnews=(RecyclerView)findViewById(R.id.rvnews);
        rvnews.setLayoutManager(new LinearLayoutManager(NewsActivity.this));
        Log.d(TAG, "onCreate: vdv");
        newsadapter=new newsAdapter(this,new ArrayList<newsclass>());


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final newsApi newsapi=retrofit.create(newsApi.class);

        newsapi.getnews().enqueue(new Callback<ArrayList<newsclass>>() {
            @Override
            public void onResponse(Call<ArrayList<newsclass>> call, Response<ArrayList<newsclass>> response) {
                rvnews.setAdapter(newsadapter);
                newsadapter.updatenews(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<newsclass>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
                Toast.makeText(NewsActivity.this, "No news", Toast.LENGTH_SHORT).show();
            }
        });
       




    }
}
