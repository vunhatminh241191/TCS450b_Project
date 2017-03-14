package com.example.minhvu.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TAG = "Display MessageActivity";
    public String onSTOP = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "This is on start function");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.w(TAG, "This is on resume function");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.wtf(TAG, "This is on pause function");
        super.onPause();
    }

    @Override
    protected void onStop() {
        try {
            Log.i(TAG, "This is on stop function, and onSTOP variable is not null" + onSTOP);
        } catch (Exception e) {
            Log.wtf(TAG, "This is on stop function, and onSTOP variable is null", e);
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "This is on destroy function");
        super.onDestroy();
    }
}
