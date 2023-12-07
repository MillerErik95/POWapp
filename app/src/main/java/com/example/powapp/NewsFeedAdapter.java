package com.example.powapp;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.NewsViewHolder> {

    private List<NewsItem> newsItems;   // Data Source

    public NewsFeedAdapter(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_feed, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem item = newsItems.get(position);
        holder.tvNewsItem.setText(item.getTitle());

        Picasso.get().load(item.getThumbnailUrl()).into(holder.imageNewsThumbnail);

        holder.videoView.setVideoURI(Uri.parse(item.getVideoUrl()));

        holder.imageNewsThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imageNewsThumbnail.setVisibility(View.GONE);
                holder.videoView.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView tvNewsItem;
        ImageView imageNewsThumbnail;
        VideoView videoView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            tvNewsItem = itemView.findViewById(R.id.tvNewsItem);
            imageNewsThumbnail = itemView.findViewById(R.id.imageNewsThumbnail);
            videoView = itemView.findViewById(R.id.videoView);
        }
    }

}
