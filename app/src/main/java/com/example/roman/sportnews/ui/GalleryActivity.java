package com.example.roman.sportnews.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.roman.sportnews.R;
import com.example.roman.sportnews.network.requests.RetrofitService;
import com.example.roman.sportnews.network.requests.models.Article;
import com.example.roman.sportnews.network.requests.models.News;
import com.example.roman.sportnews.network.requests.services.ApiRequests;
import com.example.roman.sportnews.view.adapters.NewsAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Roman on 24.05.2018.
 */

public class GalleryActivity extends AppCompatActivity {
    TextView title,time,place,article,coefficient,preview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        Intent intent=getIntent();
        title=(TextView) findViewById(R.id.title);
        time=(TextView) findViewById(R.id.time);
        place=(TextView) findViewById(R.id.place);
        coefficient=(TextView) findViewById(R.id.coefficient);
        preview=(TextView) findViewById(R.id.preview);

        title.setText(intent.getStringExtra("title"));
        time.setText(intent.getStringExtra("time"));
        place.setText(intent.getStringExtra("place"));
        coefficient.setText(intent.getStringExtra("coefficient"));
        preview.setText(intent.getStringExtra("preview"));
        System.out.println(intent.getStringExtra("article"));
        Map<String,String> articleMap=new HashMap<String, String>();
        articleMap.put("article",intent.getStringExtra("article"));

        RetrofitService.createService(ApiRequests.class)
                .article(articleMap).enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if(response.isSuccessful()){
                    System.out.println("eeeeeeeeeeeeeeeeeeee");
                    initRecyclerView(response.body().getNewsArrayList());
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        });
    }
    private void initRecyclerView(ArrayList<News> newsArrayList){
        RecyclerView recyclerView = findViewById(R.id.recycler_gallery);
        NewsAdapter adapter = new NewsAdapter(this, newsArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
