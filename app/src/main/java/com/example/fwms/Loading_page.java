package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Loading_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);

        Intent snext = new Intent(Loading_page.this,freshness.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(snext);
                finish();
            }
        },2300);
    }
}