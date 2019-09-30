package com.example.taufiq.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.taufiq.news.R;
import com.example.taufiq.news.model.Article;

import java.util.List;

/**
 * Created By Taufiq on 9/30/2019.
 */


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.newsViewHolder> {

    private Context context;
    private List<Article> articles;

    public NewsAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }


    @NonNull
    @Override
    public newsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new newsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull newsViewHolder holder, int position) {
        holder.bind(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class newsViewHolder extends RecyclerView.ViewHolder {

        TextView tv_author, tv_desc, tv_title;
        ImageView backdrop;

        public newsViewHolder(@NonNull View view) {
            super(view);
            tv_author = view.findViewById(R.id.author);
            tv_desc = view.findViewById(R.id.news_desc);
            tv_title = view.findViewById(R.id.news_title);
            backdrop = view.findViewById(R.id.news_backdrop);
        }

         void bind(final Article article) {
            String title = article.getTitle();
            String author = article.getAuthor();
            String desc = article.getDescription();
            String imageUrl = article.getUrlToImage();

            Glide.with(itemView).load(imageUrl)
                    .into(backdrop);

            tv_title.setText(title);
            tv_desc.setText(desc);
            tv_author.setText(author);


        }
    }
}
