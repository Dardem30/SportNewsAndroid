package com.example.roman.sportnews.network.requests.services;

import com.example.roman.sportnews.network.requests.models.Article;
import com.example.roman.sportnews.network.requests.models.ListEvents;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by Roman on 24.05.2018.
 */

public interface ApiRequests {
    @GET("list.php")
    Call<ListEvents> eventList(@QueryMap Map<String, String> options);
    @GET("post.php")
    Call<Article> article(@QueryMap Map<String, String> options);
}
