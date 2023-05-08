package com.himedia.project4_2.chapter02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.himedia.project4_2.R;

public class Doitmission3_photomove extends AppCompatActivity {


    Button top;
    Button down;

    ImageView view_t;
    ImageView view_b;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch2_doitmission3_photomove);
        setTitle("안드로이드 사진 옮기기");

        top=findViewById(R.id.send);
        down=findViewById(R.id.close);
        view_t=findViewById(R.id.view_t);
        view_b=findViewById(R.id.view_b);

        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_t.setImageResource(R.drawable.hb_ch10_vote_q10);
                view_t.setVisibility(View.VISIBLE);
                view_b.setVisibility(View.INVISIBLE);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_b.setImageResource(R.drawable.hb_ch10_vote_q10);
                view_b.setVisibility(View.VISIBLE);
                view_t.setVisibility(View.INVISIBLE);
            }
        });

    }

}
