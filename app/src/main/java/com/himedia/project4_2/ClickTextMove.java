package com.himedia.project4_2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClickTextMove extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_txtmove);


        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(200, 200, 200));
        setContentView(baseLayout,parms);

        Button btn = new Button(this);
        btn.setText("클릭하면 알림이 뜹니다");
        btn.setBackgroundColor(Color.rgb(150, 150, 150));
        baseLayout.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "코드로 생성한 버튼입니다.", Toast.LENGTH_SHORT).show();
            }
        });




        EditText editText = new EditText(this);
        baseLayout.addView(editText);

        Button btn_txtMove = new Button(this);
        btn_txtMove.setText("클릭하면 텍스트를 옮깁니다");
        baseLayout.addView(btn_txtMove);


        TextView txtView = new TextView(this);
        baseLayout.addView(txtView);

        btn_txtMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtView.setText(editText.getText());
            }
        });





    }

}
