package com.himedia.project4_2.hb_ch04_radiophotoselect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.himedia.project4_2.R;

public class radiophotoselect extends AppCompatActivity {

    TextView text1, text2;
    Switch switchAgree;
    RadioGroup rGroup1;
    RadioButton radioArray[] = new RadioButton[3];
    ImageView imgPet;
    Button btnQuit, btnRerun;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MainActivity_photoSelect
        setContentView(R.layout.hb_ch04_radiophotoselect);
        setTitle("안드로이드 사진 보기");

        // 위젯을 변수에 대입
        text1 = (TextView) findViewById(R.id.Text1);
        switchAgree = (Switch) findViewById(R.id.switchAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        radioArray[0] = (RadioButton) findViewById(R.id.Rdo100);
        radioArray[1] = (RadioButton) findViewById(R.id.Rdo110);
        radioArray[2] = (RadioButton) findViewById(R.id.Rdo120);

        imgPet = (ImageView) findViewById(R.id.ImgIcon);

        btnQuit = (Button) findViewById(R.id.btnDial);
        btnRerun = (Button) findViewById(R.id.btnFinish);

        // 동의함 체크박스의 체크가 변경되면
        switchAgree
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton arg0,
                                                 boolean arg1) {
                        // 체크되면 모두 보이도록 설정
                        if (switchAgree.isChecked() == true) {
                            text2.setVisibility(View.VISIBLE);
                            rGroup1.setVisibility(View.VISIBLE);
                            imgPet.setVisibility(View.VISIBLE);
                            btnQuit.setVisibility(View.VISIBLE);
                            btnRerun.setVisibility(View.VISIBLE);
                        } else {
                            text2.setVisibility(View.INVISIBLE);
                            rGroup1.setVisibility(View.INVISIBLE);
                            imgPet.setVisibility(View.INVISIBLE);
                            btnQuit.setVisibility(View.INVISIBLE);
                            btnRerun.setVisibility(View.INVISIBLE);
                        }
                    }
                });

        // 라디오버튼을 클릭할 때, 이미지 뷰를 변경시킴 ==> 배열로 처리함.
        final int draw[] = { R.drawable.hb_ch10_vote_q10,
                R.drawable.r11, R.drawable.s12};

        for (int i = 0; i < radioArray.length; i++) {
            final int index; // 주의! 꼭 필요함.
            index = i;
            radioArray[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    imgPet.setImageResource(draw[index]);
                }
            });
        }

        // 종료 버튼을 클릭하면
        btnQuit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });

        // 처음으로 버튼을 클릭하면
        btnRerun.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                imgPet.setVisibility(View.INVISIBLE);
                btnQuit.setVisibility(View.INVISIBLE);
                btnRerun.setVisibility(View.INVISIBLE);

                rGroup1.clearCheck();
                switchAgree.setChecked(false);

            }
        });

    }

}
