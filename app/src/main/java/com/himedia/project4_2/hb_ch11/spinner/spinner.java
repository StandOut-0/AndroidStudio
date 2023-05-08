package com.himedia.project4_2.hb_ch11.spinner;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.himedia.project4_2.R;

public class spinner extends AppCompatActivity  {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hb_ch11_spinner);
        setTitle("스피너 테스트");

        final String[] movie = { "아바타", "힘을내요 미스터리", "포드vs페라리","쥬만지", "대부",
                "국가대표", "토이스토리3", "마당을 나온 암탉", "죽은 시인의 사회", "서유기" };

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, movie);
        spinner.setAdapter(adapter);

    }
}
