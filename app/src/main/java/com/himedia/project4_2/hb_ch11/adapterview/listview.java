package com.himedia.project4_2.hb_ch11.adapterview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.himedia.project4_2.R;

public class listview extends AppCompatActivity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hb_ch11_listview);
        setTitle("리스트");

        final String[] mid = { "리스트1", "리스트2", "리스트3","리스트4","리스트5","리스트6","리스트7","리스트8","리스트9","리스트10"};

        ListView list = (ListView) findViewById(R.id.listView1);

        //ArrayAdapter객체 만들어 레이아웃 안에 리스트 배열 넣기
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mid);
        list.setAdapter(adapter);

        //리스트뷰에 클릭했을때
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                //Toast띄우기
                Toast.makeText(getApplicationContext(), mid[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
