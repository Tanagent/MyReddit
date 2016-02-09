package com.example.brian.myreddit;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by Brian on 2/8/2016.
 */
public class ListRowViewHolder extends RecyclerView.ViewHolder {

    protected NetworkImageView thumbnail;
    protected TextView title;
    protected TextView subreddit;
    protected TextView author;
    protected TextView url;
    protected RelativeLayout relativeLayout;

    public ListRowViewHolder(View itemView) {
        super(itemView);
        this.thumbnail = (NetworkImageView) itemView.findViewById(R.id.network_image);
        this.title = (TextView) itemView.findViewById(R.id.article_title);
        this.subreddit = (TextView) itemView.findViewById(R.id.subreddit);
        this.author = (TextView) itemView.findViewById(R.id.url);
        this.relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_layout);
        itemView.setClickable(true);
    }
}
