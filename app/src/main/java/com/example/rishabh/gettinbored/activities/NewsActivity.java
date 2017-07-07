package com.example.rishabh.gettinbored.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.adapter.newsAdapter;
import com.example.rishabh.gettinbored.api.newsApi;
import com.example.rishabh.gettinbored.model.newsclass;

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
      /*  newsadapter=new newsAdapter(this,);
        rvnews.setAdapter(newsadapter);*/


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final newsApi newsapi=retrofit.create(newsApi.class);

        newsapi.getnews().enqueue(new Callback<newsclass>() {
            @Override
            public void onResponse(Call<newsclass> call, Response<newsclass> response) {

                newsadapter=new newsAdapter(NewsActivity.this,response.body().getArticles());
                rvnews.setAdapter(newsadapter);
            }

            @Override
            public void onFailure(Call<newsclass> call, Throwable t) {

            }
        });
       




    }
}
