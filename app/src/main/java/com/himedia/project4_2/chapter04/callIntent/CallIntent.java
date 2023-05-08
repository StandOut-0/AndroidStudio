package com.himedia.project4_2.chapter04.callIntent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.himedia.project4_2.R;

public class CallIntent extends AppCompatActivity {

Button btnDial;
Button btnFinish;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ch4_callintent);
        setTitle("Activity Test");

        android.util.Log.i("액티비티 테스트", "onCreate");
        showToast("onCreate 호출");





        btnDial = findViewById(R.id.btnDial);
        btnFinish = findViewById(R.id.btnFinish);


        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-2574-2411"));
                startActivity(intent);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i("액티비티 테스트", "onDestroy()");
        showToast("onDestroy 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i("액티비티 테스트", "onPause()");
        showToast("onPause 호출");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i("액티비티 테스트", "onRestart()");
        showToast("onRestart 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("액티비티 테스트", "onResume()");
        showToast("onResume 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i("액티비티 테스트", "onStart()");
        showToast("onStart 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("액티비티 테스트", "onStop()");
        showToast("onStop 호출");
    }


    public void showToast(String data){
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }




}
