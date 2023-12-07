package com.example.powapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class NewsFeedActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsFeedAdapter adapter;
    private List<NewsItem> newsItems;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        recyclerView = findViewById(R.id.news_feed_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        newsItems = Arrays.asList(
                new NewsItem("Friedrich Nietzsche: The Philosopher Who Took On The World", "https://www.youtube.com/embed/1KkuwWn7Dmo?si=A9DFE1cTQDIdzMJe", "https://i9.ytimg.com/vi/1KkuwWn7Dmo/maxresdefault.jpg?v=64cfd9fd&sqp=CIyrxKsG&rs=AOn4CLARCuGMX6fgDrMk4x3K2XPIsypmxw"),
                new NewsItem("Kierkegaard's Philosophy - How To Believe In Yourself Against All Odds", "https://www.youtube.com/embed/fr8i1T1vy_0?si=C6fZjuEk_yOEP24v", "https://i9.ytimg.com/vi/fr8i1T1vy_0/maxresdefault.jpg?v=649d840b&sqp=CLitxKsG&rs=AOn4CLBG2GtGkHhuHagwLbnRBV7m8ISs0w"),
                new NewsItem("What Can You Really Know? The Philosophy of Michel Foucault", "https://www.youtube.com/embed/xxvydQnocTw?si=9FBeG9NyCh8rPW5P", "https://i9.ytimg.com/vi/xxvydQnocTw/maxresdefault.jpg?v=6448088d&sqp=CLitxKsG&rs=AOn4CLD361xgGr-itXIVmx651Se7WtIS7g"),
                new NewsItem("The Greatest Philosopher You've Never Heard Of - Reiner Schürmann", "https://www.youtube.com/embed/8IVRkbC5Ux8?si=3-5tCI0cd0fZbno0", "https://i9.ytimg.com/vi/8IVRkbC5Ux8/maxresdefault.jpg?v=63e6bdf2&sqp=CLitxKsG&rs=AOn4CLC1alrEwzoO7rhwChY6NneR-aQnhQ"),
                new NewsItem("Absurdism - Is Life Meaningless? (The Philosophy of Albert Camus)", "https://www.youtube.com/embed/68bex8T-ZWE?si=4od7H5LECHtLp9tw", "https://i9.ytimg.com/vi/68bex8T-ZWE/maxresdefault.jpg?v=64046c63&sqp=COSvxKsG&rs=AOn4CLC-4tH-zJNV8X7MCdn9o5ySWaZvxQ"),
                new NewsItem("Why The World is Falling Apart - Ep 1 - The Internet & Pandora's Box", "https://www.youtube.com/embed/j_2Lb7CUbR0?si=VElfXuYTV2oaJXh6", "https://i9.ytimg.com/vi/j_2Lb7CUbR0/maxresdefault.jpg?v=654f2cb2&sqp=COSvxKsG&rs=AOn4CLBeYSWiy89nS35EBJrJuFi5qaJ8Yg")

        );

        adapter = new NewsFeedAdapter(newsItems);
        recyclerView.setAdapter(adapter);

        Button btnBackToMain = findViewById(R.id.btnBackToMain);
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsFeedActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
