package com.mcdenny.android.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class NewsAdapter extends ArrayAdapter<News> {


    private static class ViewHolder {
        TextView title;
        TextView datePublished;
        TextView section;

    }

    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        News news = getItem(position);
        View rowView = convertView;
        ViewHolder viewHolder;

        if( rowView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            rowView = inflater.inflate(R.layout.news_layout, parent, false);

            viewHolder.title = (TextView) rowView.findViewById(R.id.news_title);
            viewHolder.datePublished = (TextView) rowView.findViewById(R.id.date_published);
            viewHolder.section = (TextView) rowView.findViewById(R.id.news_section);


            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        viewHolder.title.setText(news.getWebTitle());
        viewHolder.datePublished.setText(news.getPublicationDate());
        viewHolder.section.setText(news.getSection());


        return rowView;
    }
}
