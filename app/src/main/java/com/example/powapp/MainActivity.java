package com.example.powapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.widget.Toast;
import android.content.Context;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openNewsFeedButton = findViewById(R.id.btnOpenNewsFeed);
        openNewsFeedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsFeedActivity.class);
                startActivity(intent);
            }
        });

        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        ImageView backgroundImageView = findViewById(R.id.backgroundImageView);

        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                backgroundImageView.setBackgroundResource(R.drawable.sunday_background);
                break;
            case Calendar.MONDAY:
                backgroundImageView.setBackgroundResource(R.drawable.monday_background);
                break;
            case Calendar.TUESDAY:
                backgroundImageView.setBackgroundResource(R.drawable.tuesday_background);
                break;
            case Calendar.WEDNESDAY:
                backgroundImageView.setBackgroundResource(R.drawable.wednesday_background);
                break;
            case Calendar.THURSDAY:
                backgroundImageView.setBackgroundResource(R.drawable.thursday_background);
                break;
            case Calendar.FRIDAY:
                backgroundImageView.setBackgroundResource(R.drawable.friday_background);
                break;
            case Calendar.SATURDAY:
                backgroundImageView.setBackgroundResource(R.drawable.saturday_background);
                break;
        }

        TextView quoteTextView = findViewById(R.id.quoteTextView);
        ImageButton shareButton = findViewById(R.id.shareButton);

        String quote = "This is probably the deepest and most significant philosophical quote you have ever read";
        String author = "Sigma giga chad";
        String url = "https://youtu.be/dQw4w9WgXcQ?si=NBGWWnWDvQIIgSVU";
        String formattedQuote = String.format("\"%s\"\n\n- %s", quote, author);

        quoteTextView.setText(formattedQuote);

        quoteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String copiedText = formattedQuote + "\n\nLearn More: \"" + url + "\"";
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("POW App Quote", copiedText);
                clipboardManager.setPrimaryClip(clipData);
                //Toast.makeText(MainActivity.this, "Quote copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

    }
}