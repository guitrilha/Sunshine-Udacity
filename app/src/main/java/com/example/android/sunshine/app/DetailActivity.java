package com.example.android.sunshine.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        if (intent != null) {
            String forecast = intent.getStringExtra(Intent.EXTRA_TEXT);
            ((TextView) findViewById(R.id.forecast_textview)).setText(forecast);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
