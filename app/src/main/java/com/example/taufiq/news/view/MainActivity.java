package com.example.taufiq.news.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taufiq.news.BuildConfig;
import com.example.taufiq.news.R;
import com.example.taufiq.news.adapter.NewsAdapter;
import com.example.taufiq.news.api.ApiClient;
import com.example.taufiq.news.api.ApiRoute;
import com.example.taufiq.news.model.Article;
import com.example.taufiq.news.model.News;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Article> articles;
    private NewsAdapter newsAdapter;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        initNetwork();
        initList();
    }


    private void initList() {
        RecyclerView recyclerView = findViewById(R.id.news_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        articles = new ArrayList<>();
        newsAdapter = new NewsAdapter(MainActivity.this, articles);
        recyclerView.setAdapter(newsAdapter);
    }

    private void initNetwork() {
        String source = getResources().getString(R.string.the_source);
        final String API_KEY = BuildConfig.API_KEY;
        ApiRoute apiRoute = ApiClient.getClient().create(ApiRoute.class);
        Call<News> call = apiRoute.getNews(source, API_KEY);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(@NotNull Call<News> call, @NotNull Response<News> response) {
                if (response.body() != null) {
                    articles.addAll(response.body().getArticles());
                    newsAdapter.notifyDataSetChanged();
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NotNull Call<News> call, @NotNull Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast connection_error = Toast.makeText(MainActivity.this, "Connection Error", Toast.LENGTH_SHORT);
                connection_error.show();
            }
        });
    }
}
