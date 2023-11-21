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
    private List<String> newsItems;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        recyclerView = findViewById(R.id.news_feed_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        newsItems = Arrays.asList("News Item 1", "News Item 2", "News Item 3");

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
