package com.himedia.project4_2.hb_ch10_vote;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.himedia.project4_2.R;

public class hb_ch10_vote_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.hb_ch10_vote_result);
        setTitle("투표 결과");


        // result 화면에 띄울 imgview와 txt영역을 가져온다.
        TextView tvTop = (TextView) findViewById(R.id.tvTop);
        ImageView ivTop = (ImageView) findViewById(R.id.ivTop);


        // main에서 보낸 intent를 받아낸다.
        // 앞에서 intent.putExtra로 voteCount와 imgName배열을 받아냈었다.
        // 각각을 voteResult imageName으로 받아내 사용하기로 한다.
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        //Integer형 imageFileId배열에 drawable폴더에있는 이미지 들을 순서대로 담고
        Integer imageFileId[] = {R.drawable.hb_ch10_vote_pic1, R.drawable.hb_ch10_vote_pic2,
                R.drawable.hb_ch10_vote_pic3, R.drawable.hb_ch10_vote_pic4, R.drawable.hb_ch10_vote_pic5,
                R.drawable.hb_ch10_vote_pic6, R.drawable.hb_ch10_vote_pic7, R.drawable.hb_ch10_vote_pic8,
                R.drawable.hb_ch10_vote_pic9};


        //최고값을 maxEntry에 저장하기전 초기화한다.
        int maxEntry = 0;
        for (int i = 1; i < voteResult.length; i++) { //9번 돌려
            if (voteResult[maxEntry] < voteResult[i])//i번째 값을 비교해 최고값을 구한다.
                maxEntry = i;//최고값 순서 i를 maxEntry에 넣는다.
        }

        //최고값 순서 i와 동일한 순서 imageName을 찾아내 setText
        //최고값 순서 i와 동일한 순서 imageFileId 찾아내 setImageResource
        tvTop.setText(imageName[maxEntry]);
        ivTop.setImageResource(imageFileId[maxEntry]);


//        최고값의 이미지 name과 이미지를 표현하는것까지 끝났다.


//        //TextView와 RatingBar배열을 만들어
//        TextView tv[] = new TextView[imageName.length];
//        RatingBar rbar[] = new RatingBar[imageName.length];
//
//        // 각각에 객체 id를 넣고
//        Integer tvID[] = { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
//                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
//        Integer rbarID[] = { R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
//                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9 };
//
//        // 각 리스트 9번 돌려 객체를 찾아 배열에 다시 넣는다.
//        for (int i = 0; i < voteResult.length; i++) {
//            tv[i] = (TextView) findViewById(tvID[i]);
//            rbar[i] = (RatingBar) findViewById(rbarID[i]);
//        }
//
//        // 각 리스트 9번 돌려 setText해주고 setRating해준다.
//        for (int i = 0; i < voteResult.length; i++) {
//            tv[i].setText(imageName[i]);
//            rbar[i].setRating((float) voteResult[i]);
//        }






//        이것도 마찬가지로 굳이 왜 id배열을 더 만들어야 하는지 의문이 생겨 추가 테스트했다.
        //TextView와 RatingBar배열을 만들어
        TextView tv[] = {
                findViewById(R.id.tv1), findViewById(R.id.tv2), findViewById(R.id.tv3),
                findViewById(R.id.tv4), findViewById(R.id.tv5), findViewById(R.id.tv6),
                findViewById(R.id.tv7), findViewById(R.id.tv8), findViewById(R.id.tv9)
        };
        RatingBar rbar[] = {
                findViewById(R.id.rbar1), findViewById(R.id.rbar2), findViewById(R.id.rbar3),
                findViewById(R.id.rbar4), findViewById(R.id.rbar5), findViewById(R.id.rbar6),
                findViewById(R.id.rbar7), findViewById(R.id.rbar8), findViewById(R.id.rbar9)
        };

        // 각 리스트 9번 돌려 setText해주고 setRating해준다.
        for (int i = 0; i < voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        //btnReturn를 클릭하면 해당 result화면을 닫는다.
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();

            }
        });

    }

}