
package com.example.taufiq.news.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {

    @SerializedName("articles")
    private List<Article> mArticles;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("totalResults")
    private List<Article> mTotalResults;

    public List<Article> getArticles() {
        return mArticles;
    }

    public void setArticles(List<Article> articles) {
        mArticles = articles;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public List<Article> getmTotalResults() {
        return mTotalResults;
    }

    public void setmTotalResults(List<Article> mTotalResults) {
        this.mTotalResults = mTotalResults;
    }
}
