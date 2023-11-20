package com.example.powapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        String quote = "This is probably the deepest and most significant philosophical quote you have ever read";
        String author = "Sigma giga chad";
        String formattedQuote = String.format("\"%s\"\n\n- %s", quote, author);

        quoteTextView.setText(formattedQuote);

    }
}