package com.mcdenny.android.news.utils;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.mcdenny.android.news.News;

import java.util.List;

import static android.content.ContentValues.TAG;

public class NewsLoader extends AsyncTaskLoader<List<News>> {
    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        Log.i(TAG, "NewsLoader: "+ url);
        mUrl = url;
    }

    @Override
    public List<News> loadInBackground() {
        if(mUrl == null) return null;

        List<News> newsList = QueryUtils.fetchNewsData(mUrl);
        return newsList;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
