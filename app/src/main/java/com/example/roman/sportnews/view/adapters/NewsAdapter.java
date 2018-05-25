package com.example.roman.sportnews.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;


import com.example.roman.sportnews.R;
import com.example.roman.sportnews.network.requests.models.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
  private static final String TAG = "RecyclerViewAdapter";

  private ArrayList<News> newsArrayList = new ArrayList<>();
  private Context mContext;

  public NewsAdapter(Context mContext, ArrayList<News> newsArrayList) {
    this.newsArrayList = newsArrayList;
    this.mContext = mContext;
  }

  @Override
  public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
    NewsAdapter.ViewHolder holder = new NewsAdapter.ViewHolder(view);
    return holder;
  }

  @Override
  public void onBindViewHolder(NewsAdapter.ViewHolder holder, final int position) {
    Log.d(TAG, "onBindViewHolder: called.");
    final News news=newsArrayList.get(position);
    holder.header.setText(news.getHeader());
    holder.text.setText(news.getText());
  }

  @Override
  public int getItemCount() {
    return newsArrayList.size();
  }


  public class ViewHolder extends RecyclerView.ViewHolder{


    TextView header;
    TextView text;
    LinearLayout linearLayout;

    public ViewHolder(View itemView) {
      super(itemView);
      header = itemView.findViewById(R.id.header);
      text = itemView.findViewById(R.id.textH);
      linearLayout = itemView.findViewById(R.id.news_layout);
    }
  }
}