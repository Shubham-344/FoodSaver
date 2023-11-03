package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.icu.number.Scale;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

public class quantity extends AppCompatActivity {
    CardView individualbtn, groupbtn, cardslot1, cardslot2, cardslot3, cardslot4, cardslot5, cardslot6, cardslot7, cardslot8;
    TextView slot1, slot2, slot3, slot4, qnttxt, slot5, slot6, slot7, slot8;
    LinearLayout selectbtns, btns, btns2;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);

        individualbtn = findViewById(R.id.individualbtn);
        groupbtn = findViewById(R.id.groupbtn);
        slot1 = findViewById(R.id.qnt_slot1);
        slot2 = findViewById(R.id.qnt_slot2);
        slot3 = findViewById(R.id.qnt_slot3);
        slot4 = findViewById(R.id.qnt_slot4);
        slot5 = findViewById(R.id.qnt_slot5);
        slot6 = findViewById(R.id.qnt_slot6);
        slot7 = findViewById(R.id.qnt_slot7);
        slot8 = findViewById(R.id.qnt_slot8);
        selectbtns = findViewById(R.id.selectbtns);
        qnttxt = findViewById(R.id.qnttxt);
        btns = findViewById(R.id.btns);
        btns2 = findViewById(R.id.btns2);
        Intent tomaps3;
        tomaps3 = new Intent(quantity.this, Maps3.class);
        Intent tomaps4;
        tomaps4 = new Intent(quantity.this, Maps4.class);
        Intent tomap1;
        tomap1 = new Intent(quantity.this, Maps1.class);
        Intent tomap2;
        tomap2 = new Intent(quantity.this, Maps2.class);
        individualbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = 0;
                slot1.setText("<5 PEOPLE");
                slot2.setText("5-10 PEOPLE");
                slot3.setText("10-20 PEOPLE");
                slot4.setText("20-25 PEOPLE");
                ObjectAnimator animation = ObjectAnimator.ofFloat(selectbtns, "translationY", -600f);
                ObjectAnimator animation3 = ObjectAnimator.ofFloat(selectbtns, "scaleX", 0.8f);
                ObjectAnimator animation4 = ObjectAnimator.ofFloat(selectbtns, "scaleY", 0.8f);
                ObjectAnimator animation2 = ObjectAnimator.ofFloat(qnttxt, "translationY", -300f);
                animation.setDuration(500);
                animation.start();
                animation.setRepeatMode(ValueAnimator.RESTART);
                animation2.setDuration(500);
                animation2.start();
                animation2.setRepeatMode(ValueAnimator.RESTART);
                animation3.start();
                animation3.setDuration(500);
                animation4.start();
                animation4.setDuration(500);
                slot1.setBackground(getResources().getDrawable(R.drawable.individualbtns));
                slot2.setBackground(getResources().getDrawable(R.drawable.individualbtns));
                slot3.setBackground(getResources().getDrawable(R.drawable.individualbtns));
                slot4.setBackground(getResources().getDrawable(R.drawable.individualbtns));

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btns.setVisibility(btns.VISIBLE);
                        btns2.setVisibility(btns.INVISIBLE);
                    }
                }, 500);
            }
        });
        groupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = 1;
                slot5.setText("25-50 PEOPLE");
                slot6.setText("50-100 PEOPLE");
                slot7.setText("100-200 PEOPLE");
                slot8.setText(">200 PEOPLE");
                ObjectAnimator animation = ObjectAnimator.ofFloat(selectbtns, "translationY", -600f);
                ObjectAnimator animation3 = ObjectAnimator.ofFloat(selectbtns, "scaleX", 0.8f);
                ObjectAnimator animation4 = ObjectAnimator.ofFloat(selectbtns, "scaleY", 0.8f);
                ObjectAnimator animation2 = ObjectAnimator.ofFloat(qnttxt, "translationY", -300f);
                animation.setDuration(500);
                animation.start();
                animation.setRepeatMode(ValueAnimator.RESTART);
                animation2.setDuration(500);
                animation2.start();
                animation2.setRepeatMode(ValueAnimator.RESTART);
                animation3.start();
                animation3.setDuration(500);
                animation4.start();
                animation4.setDuration(500);
                slot5.setBackground(getResources().getDrawable(R.drawable.groupbtns));
                slot6.setBackground(getResources().getDrawable(R.drawable.groupbtns));
                slot7.setBackground(getResources().getDrawable(R.drawable.groupbtns));
                slot8.setBackground(getResources().getDrawable(R.drawable.groupbtns));

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btns2.setVisibility(btns.VISIBLE);
                        btns.setVisibility(btns.INVISIBLE);
                    }
                }, 500);
            }
        });
        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomap1);
            }
        });
        slot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomap1);
            }
        });
        slot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomap2);
            }
        });
        slot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomap2);
            }
        });
        slot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomaps3);
            }
        });
        slot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomaps3);
            }
        });
        slot7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomaps4);
            }
        });
        slot8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomaps4);
            }
        });
    }
}