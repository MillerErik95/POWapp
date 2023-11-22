package com.example.powapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private ImageView backgroundImageView;
    private ImageButton shareButton;

    private String quote;
    private String author;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        backgroundImageView = findViewById(R.id.backgroundImageView);
        shareButton = findViewById(R.id.shareButton);

        new FetchQuoteTask().execute();

        setDayOfWeekBackground();
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
                String copiedText = String.format("\"%s\"\n\n- %s\n\nLearn More: \"%s\"", quote, author, url);
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("POW App Quote", copiedText);
                clipboardManager.setPrimaryClip(clipData);
            }
        });
    }

    private void setDayOfWeekBackground() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        int[] dayBackgrounds = {
                R.drawable.sunday_background,
                R.drawable.monday_background,
                R.drawable.tuesday_background,
                R.drawable.wednesday_background,
                R.drawable.thursday_background,
                R.drawable.friday_background,
                R.drawable.saturday_background
        };

        int background = dayBackgrounds[dayOfWeek - 1];
        backgroundImageView.setBackgroundResource(background);
    }

    public class Quote {
        private String source;
        private String quote;

        public String getSource() {
            return source;
        }

        public String getQuote() {
            return quote;
        }
    }

    interface QuoteService {
        @GET("quotes")
        Call<List<Quote>> getQuotes();
    }

    private class FetchQuoteTask extends AsyncTask<Void, Void, List<Quote>> {
        @Override
        protected List<Quote> doInBackground(Void... params) {
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://philosophy-quotes-api.glitch.me/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                QuoteService service = retrofit.create(QuoteService.class);
                Call<List<Quote>> call = service.getQuotes();
                return call.execute().body();
            } catch (IOException e) {
                Log.e("MainActivity", "Error fetching quotes", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Quote> quotes) {
            if (quotes != null && !quotes.isEmpty()) {
                int randomIndex = new Random().nextInt(quotes.size());
                Quote randomQuote = quotes.get(randomIndex);

                author = randomQuote.getSource();
                quote = randomQuote.getQuote();

                url = "https://en.wikipedia.org/wiki/" + author;
                String formattedQuote = String.format("\"%s\"\n\n- %s", quote, author);
                quoteTextView.setText(formattedQuote);
            }
        }
    }
}
