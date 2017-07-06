package com.example.rishabh.gettinbored.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.gettinbored.R;
import com.example.rishabh.gettinbored.model.articles;
import com.example.rishabh.gettinbored.model.newsclass;

import java.util.ArrayList;

/**
 * Created by RISHABH on 05-07-2017.
 */

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.NewsViewHolder>{

    Context context;
    ArrayList<newsclass> newsclassArrayList;
    public static final String TAG="hello";

    public newsAdapter(Context context, ArrayList<newsclass> newsclassArrayList) {
        this.context = context;
        this.newsclassArrayList = newsclassArrayList;
        Log.d(TAG, "newsAdapter: entered");
    }

    @Override
    public newsAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d(TAG, "onCreateViewHolder: created");
        View itemview=li.inflate(R.layout.newslayout,parent,false);
        return new NewsViewHolder(itemview);
    }
    public void updatenews(ArrayList<newsclass> newsclassArrayListt) {
        this.newsclassArrayList=newsclassArrayListt;
        notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(newsAdapter.NewsViewHolder holder, int position) {
        final newsclass newsclasses=newsclassArrayList.get(position);
        holder.newsauthor.setText(newsclasses.getArticles().getAuthor());
        holder.newstitle.setText(newsclasses.getArticles().getTitle());
        holder.newsdescription.setText(newsclasses.getArticles().getDescription());
        holder.newsurl.setText(newsclasses.getArticles().getUrl());
        Log.d(TAG, "onBindViewHolder: binded");
        holder.newspicurl.setText(newsclasses.getArticles().getUrlToImage());
        holder.newspublished.setText(newsclasses.getArticles().getPublishedAt());
      /*  holder.newsstatus.setText(newsclasses.getStatus());
        holder.newssource.setText(newsclasses.getSource());
        holder.newssortBy.setText(newsclasses.getSortBy());*/
    }

    @Override
    public int getItemCount() {
        return newsclassArrayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView newstitle,newsdescription,newsurl,newspicurl,newspublished,newsauthor;
        TextView newsstatus,newssource,newssortBy;
        public NewsViewHolder(View itemView) {
            super(itemView);
            newsauthor=(TextView)itemView.findViewById(R.id.newsauthor);
         /*   newsstatus=(TextView)itemView.findViewById(R.id.newsstatus);
            newssource=(TextView)itemView.findViewById(R.id.newssource);
            newssortBy=(TextView)itemView.findViewById(R.id.newssortBy);   */
            newstitle=(TextView)itemView.findViewById(R.id.newstitle);
            newsdescription=(TextView)itemView.findViewById(R.id.newsdescription);
            newsurl=(TextView)itemView.findViewById(R.id.newsurl);
            newspicurl=(TextView)itemView.findViewById(R.id.newspicurl);
            newspublished=(TextView)itemView.findViewById(R.id.newspublished);
        }
    }
}
