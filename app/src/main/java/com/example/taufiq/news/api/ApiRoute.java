package com.example.taufiq.news.api;

import com.example.taufiq.news.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created By Taufiq on 9/28/2019.
 */
public interface ApiRoute {


    /*
     * https://baseUrl/top-headlines?source&apiKey
     * */
    @GET("top-headlines")
    Call<News> getNews(
            @Query("sources") String source,
            @Query("apiKey") String apiKey
    );
}
