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
                new NewsItem("Friedrich Nietzsche: The Philosopher Who Took On The World", "https://www.youtube.com/watch?v=1KkuwWn7Dmo&ab_channel=PowerofThought", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/c9026b1c-5a20-404c-bf22-83edfb5e2ec0/dgjc4zv-acd053dc-c352-4fc7-b5cd-f25db35d5998.png/v1/fill/w_1192,h_670,q_70,strp/friedrich_nietzsche__the_real_story_tn_by_zeiky08_dgjc4zv-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NzIwIiwicGF0aCI6IlwvZlwvYzkwMjZiMWMtNWEyMC00MDRjLWJmMjItODNlZGZiNWUyZWMwXC9kZ2pjNHp2LWFjZDA1M2RjLWMzNTItNGZjNy1iNWNkLWYyNWRiMzVkNTk5OC5wbmciLCJ3aWR0aCI6Ijw9MTI4MCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.HQAv_SL1pSzO51i584qz57OXU3TJ6Sg98_pJNs5zKOI"),
                new NewsItem("Kierkegaard's Philosophy - How To Believe In Yourself Against All Odds", "https://www.youtube.com/watch?v=fr8i1T1vy_0&ab_channel=PowerofThought", "https://i9.ytimg.com/vi/fr8i1T1vy_0/maxresdefault.jpg?v=649d840b&sqp=CKyYxKsG&rs=AOn4CLApWb6ZeEKu_I0OECqoYIQMwEzimQ"),
                new NewsItem("What Can You Really Know? The Philosophy of Michel Foucault", "https://www.youtube.com/watch?v=xxvydQnocTw&ab_channel=PowerofThought", "https://i9.ytimg.com/vi/xxvydQnocTw/maxresdefault.jpg?v=6448088d&sqp=CKyYxKsG&rs=AOn4CLDNCet1n_FqFozUSz8tif6U28BzSg"),
                new NewsItem("The Greatest Philosopher You've Never Heard Of - Reiner Schürmann", "https://www.youtube.com/watch?v=8IVRkbC5Ux8&ab_channel=PowerofThought", "https://i9.ytimg.com/vi/8IVRkbC5Ux8/maxresdefault.jpg?v=63e6bdf2&sqp=CKyYxKsG&rs=AOn4CLCQoGHzGY1_8VV9O5ZkyI2J8QDb8Q"),
                new NewsItem("Absurdism - Is Life Meaningless? (The Philosophy of Albert Camus)", "https://www.youtube.com/watch?v=68bex8T-ZWE&ab_channel=PowerofThought", "https://i9.ytimg.com/vi/68bex8T-ZWE/maxresdefault.jpg?v=64046c63&sqp=CKyYxKsG&rs=AOn4CLBpTsGUY1Ymk5JQoEeNW85jkTlrgw"),
                new NewsItem("Charles Bukowski's Philosophy On Life - Be Real", "https://www.youtube.com/watch?v=ddwqTc_l3UU&ab_channel=PowerofThought", "https://i9.ytimg.com/vi/ddwqTc_l3UU/maxresdefault.jpg?v=6473830c&sqp=CNiaxKsG&rs=AOn4CLDmQDoWTop6H7rpPx3Plc1OVmViHg")
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
