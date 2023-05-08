package com.himedia.project4_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class TextLength extends AppCompatActivity {

    EditText editText;
    TextView input_length;
    Button btn1;

    String name;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textlength);

        editText = findViewById(R.id.editTextTextMultiLine3);
        input_length = findViewById(R.id.textView);
        btn1 = findViewById(R.id.send);

        android.util.Log.i("엑티비티 테스트", ",oncreate");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editText.getText().toString();
                showToast(name);
            }
        });

        if(savedInstanceState != null){
    name=savedInstanceState.getString("name", name);
            showToast("값복원"+name);
        }

//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                input_length.setText(editText.length());
//
//            }
//        });
//editTextTextMultiLine3
        //textView
        //send
        //close


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", name);
    }

    public void showToast(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}