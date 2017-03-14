package com.example.minhvu.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String TAG = "MyActivity";

    public String onSTOP = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "This is on start function");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "This is on resume function");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "This is on pause function");
        super.onPause();
    }

    @Override
    protected void onStop() {
        try {
            Log.v(TAG, "This is on stop function");
        } catch (Exception e) {
            Log.e("Some tag", "This is on stop function using log.e with throwable"
                    ,e);
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.w(TAG, "This is on destroy function");
        super.onDestroy();
    }
}
