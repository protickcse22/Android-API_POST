package com.softbd.postrequestproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class individual_post extends AppCompatActivity {

    private TextView titleTV, cluesTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_post);
        titleTV = findViewById(R.id.titleTV);
        cluesTV = findViewById(R.id.cluesTV);
        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String clues = intent.getStringExtra("Clues");
        titleTV.setText(title);
        cluesTV.setText(Html.fromHtml(clues));
    }
}
