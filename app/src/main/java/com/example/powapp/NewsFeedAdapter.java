package com.example.powapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.NewsViewHolder> {

    private List<NewsItem> newsItems;

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

        // Load the thumbnail image using Picasso
        Picasso.get().load(item.getThumbnailUrl()).into(holder.imageNewsThumbnail);

        // Configure the WebView to load the video URL
        holder.webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript for the WebView

        // Set a WebViewClient to override default behavior
        holder.webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // Hide the loading thumbnail once the page is fully loaded
                holder.imageNewsThumbnail.setVisibility(View.GONE);
            }
        });

        // Construct the HTML content for the WebView with the iframe embed code
        String embedUrl = item.getVideoUrl(); // Make sure this is the embed URL
        String frameVideo = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"" + embedUrl +
                "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        // Load the HTML content into the WebView
        holder.webView.loadData(frameVideo, "text/html", "UTF-8");

        // Optional: Set an OnClickListener on the thumbnail to reload the video when clicked
        holder.imageNewsThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.webView.loadData(frameVideo, "text/html", "UTF-8");
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
        WebView webView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            tvNewsItem = itemView.findViewById(R.id.tvNewsItem);
            imageNewsThumbnail = itemView.findViewById(R.id.imageNewsThumbnail);
            webView = itemView.findViewById(R.id.webView);
        }
    }
}