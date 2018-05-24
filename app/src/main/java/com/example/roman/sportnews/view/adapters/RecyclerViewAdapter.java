package com.example.roman.sportnews.view.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.roman.sportnews.R;
import com.example.roman.sportnews.network.requests.models.Event;
import com.example.roman.sportnews.ui.GalleryActivity;


import java.util.ArrayList;

/**
 * Created by User on 1/1/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Event> events = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<Event> events) {
        this.events = events;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        final Event event=events.get(position);
        holder.title.setText(event.getTitle());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("article",event.getArticle());
                intent.putExtra("coefficient",event.getCoefficient());
                intent.putExtra("place",event.getPlace());
                intent.putExtra("preview",event.getPreview());
                intent.putExtra("time",event.getTime());
                intent.putExtra("title",event.getTitle());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView title;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}