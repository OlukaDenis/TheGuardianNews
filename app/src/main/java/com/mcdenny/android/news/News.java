package com.mcdenny.android.news;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class News {
    private String mWebTitle;
    private String mDatepublished;
    private String mWebsiteUri;
    private String mSectionName;
    


    public News(JSONObject newsObject) {
        try {
            this.mWebTitle = newsObject.getString("webTitle");
            this.mDatepublished = newsObject.getString("webPublicationDate");
            this.mWebsiteUri = newsObject.getString("webUrl");
            this.mSectionName = newsObject.getString("sectionName");

        } catch (JSONException e) {
            Log.e(TAG, "Error creating a News object from JSONObject", e);
        }
    }

    public String getWebTitle() { return mWebTitle; }
    public String getPublicationDate() { return mDatepublished; }
    public String getWebUrl() { return mWebsiteUri; }
    public String getSection() { return mSectionName; }


    public static List<News> getNewsListFromJson(JSONArray jsonNewsObjects) {
        if( jsonNewsObjects == null || jsonNewsObjects.length() == 0) return null;

        List<News> newsList = new ArrayList<News>();

        //Extract news objects and from JSONArray
        for(int i = 0; i < jsonNewsObjects.length(); i++) {
            try {
                JSONObject newsObject = jsonNewsObjects.getJSONObject(i);
                newsList.add(new News(newsObject));
            } catch (JSONException e) {
                Log.e(TAG, "Error extracting news objects from JSONArray: ", e);
            }
        }

        return newsList;
    }
}
