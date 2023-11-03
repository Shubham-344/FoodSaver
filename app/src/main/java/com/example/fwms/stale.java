package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class stale extends AppCompatActivity {
    CardView slotbtn1, slotbtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stale);
        slotbtn1 = findViewById(R.id.slotbtn1);
        slotbtn2 = findViewById(R.id.slotbtn2);
        Intent tomaps7;
        tomaps7 = new Intent(stale.this,Maps7.class);
        Intent tomaps8;
        tomaps8 = new Intent(stale.this,Maps8.class);
        ObjectAnimator animation = ObjectAnimator.ofFloat(slotbtn1, "translationY", -150f);
        animation.start();
        animation.setDuration(700);
        ObjectAnimator animation2 = ObjectAnimator.ofFloat(slotbtn2, "translationY", -150f);
        animation2.start();
        animation2.setDuration(700);
        slotbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomaps7);
            }
        });
        slotbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomaps8);
            }
        });
    }

}