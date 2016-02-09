package com.example.brian.myreddit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

/**
 * Created by Brian on 2/9/2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<ListRowViewHolder> {

    private List<ListItems> listItemsList;
    private Context context;
    private ImageLoader imageLoader;
    private int focusedItem = 0;

    public MyRecyclerAdapter(Context context, List<ListItems> listItemsList) {
        this.context = context;
        this.listItemsList = listItemsList;
    }

    @Override
    public ListRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, null);
        ListRowViewHolder holder = new ListRowViewHolder(view);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView redditUrl = (TextView) v.findViewById(R.id.url);
                String postUrl = redditUrl.getText().toString();
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("url", postUrl);
                context.startActivity(intent;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ListRowViewHolder holder, int position) {
        ListItems listItems = listItemsList.get(position);
        holder.itemView.setSelected(focusedItem == position);

        holder.getLayoutPosition();

        imageLoader = MySingleton.getInstance(context).getImageLoader();
        holder.thumbnail.setImageUrl(listItems.getThumbnail(), imageLoader);
        holder.thumbnail.setDefaultImageResId(android.R.drawable.ic_menu_report_image);

        holder.title.setText(Html.fromHtml(listItems.getTitle()));
        holder.subreddit.setText(Html.fromHtml(listItems.getSubreddit()));
        holder.author.setText(Html.fromHtml(listItems.getAuthor()));
        holder.url.setText(Html.fromHtml(listItems.getUrl()));
    }

    public void clearAdapter() {
        listItemsList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (null != listItemsList ? listItemsList.size() : 0);
    }
}
