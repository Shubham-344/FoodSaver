package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class quantityanimals extends AppCompatActivity {
    TextView qnt_slot1, qnt_slot2, qnt_slot3, qnt_slot4;
    CardView btn1,btn2,btn3,btn4;
    Intent animmap;
    LinearLayout linearbtns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantityanimals);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        qnt_slot1 = findViewById(R.id.qnt_slot1);
        qnt_slot2 = findViewById(R.id.qnt_slot2);
        qnt_slot3 = findViewById(R.id.qnt_slot3);
        qnt_slot4 = findViewById(R.id.qnt_slot4);
        linearbtns = findViewById(R.id.linearbtns);
        ObjectAnimator animation = ObjectAnimator.ofFloat(linearbtns, "translationY", -150f);
        animation.start();
        animation.setDuration(700);
        Intent tomaps5;
        tomaps5 = new Intent(quantityanimals.this, Maps5.class);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomaps5);
            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomaps5);
            }

        });
        Intent tomaps6;
        tomaps6 = new Intent(quantityanimals.this, Maps6.class);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomaps6);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tomaps6);
            }
        });

    }
}