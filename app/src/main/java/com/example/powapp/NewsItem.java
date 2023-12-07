package com.example.powapp;

public class NewsItem {
    private String title;
    private String videoUrl;
    private String thumbnailUrl;

    public NewsItem(String title, String videoUrl, String thumbnailUrl) {
        this.title = title;
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    // Getters

    public String getTitle() {
        return title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

}

}

