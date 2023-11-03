package com.example.fwms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.animation.ObjectAnimator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class freshness extends AppCompatActivity {
    CardView freshbtn,pfbtn,stalebtn;
    LinearLayout maincontainer;
    TextView quality_txt,txtfresh,txtstale,txtpf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freshness);

        freshbtn = findViewById(R.id.freshbtn);
        pfbtn = findViewById(R.id.pfbtn);
        stalebtn = findViewById(R.id.stalebtn);
        quality_txt = findViewById(R.id.quality_txt);
        maincontainer =  findViewById(R.id.maincontainer);
        txtfresh = findViewById(R.id.txtfresh);
        txtpf = findViewById(R.id.txtpf);
        txtstale = findViewById(R.id.txtstale);
        Intent toquantity;
        Intent toanimalqnt;
        Intent tostaletype;
        toquantity = new Intent(freshness.this, quantity.class);
        toanimalqnt =new Intent(freshness.this,quantityanimals.class);
        tostaletype =new Intent(freshness.this,stale.class);
        ObjectAnimator animation = ObjectAnimator.ofFloat(maincontainer, "translationY", -150f);
        freshbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toquantity);
                txtfresh.setBackgroundColor(getResources().getColor(R.color.click));
                txtpf.setBackground(getResources().getDrawable(R.drawable.buttonbg));
                txtstale.setBackground(getResources().getDrawable(R.drawable.buttonbg));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtfresh.setBackground(getResources().getDrawable(R.drawable.buttonbg));
                    }
                }, 300);
            }
        });
        pfbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toanimalqnt);
                txtpf.setBackgroundColor(getResources().getColor(R.color.click));
                txtfresh.setBackground(getResources().getDrawable(R.drawable.buttonbg));
                txtstale.setBackground(getResources().getDrawable(R.drawable.buttonbg));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtpf.setBackground(getResources().getDrawable(R.drawable.buttonbg));
                    }
                },300);
            }
        });
        stalebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(tostaletype);
                txtstale.setBackgroundColor(getResources().getColor(R.color.click));
                txtpf.setBackground(getResources().getDrawable(R.drawable.buttonbg));
                txtfresh.setBackground(getResources().getDrawable(R.drawable.buttonbg));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtstale.setBackground(getResources().getDrawable(R.drawable.buttonbg));
                    }
                }, 300);
            }
        });
        }
    }
