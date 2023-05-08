package com.himedia.project4_2.hb_ch10_vote;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.himedia.project4_2.R;

public class hb_ch10_vote_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hb_ch10_vote_main);
        setTitle("명화 선호도 투표 (개선)");

//        voteCount: 투표수
//

        //투표수 초기화
        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++) voteCount[i] = 0;

//        이미지 객체 담기
//        log에 출력하면  R.id.iv1는 출력해볼 수 없으나
//        String.valueOf(R.id.iv1)로 출력해보면 해당 객체 주소값 2131231248로 찍히는 것을 확인 할 수 있다.
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        Log.v("sanghee", String.valueOf(R.id.iv1));

//        이미지이름 저장
        final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서"};



//        image
//        ImageView image[] = new ImageView[9];
//        for (int i = 0; i < imageId.length; i++) { //9번돌려
//            final int index; // 주의! 꼭 필요함..
//            index = i;
//
////          같은 순서대로 imageId에 담긴 객체를 ImageView image안에 넣고
//            image[index] = (ImageView) findViewById(imageId[index]);
////          그것이 클릭되었을때
//            image[index].setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
//                    // voteCount의 해당 객체 투표수가 증가한다.
//                    voteCount[index]++;
//                    //동시에 Toast로 띄워준다.
//                    Toast.makeText(getApplicationContext(),
//                            imgName[index] + ": 총 " + voteCount[index] + " 표",
//                            Toast.LENGTH_SHORT).show();
//                }
//            });
//        }



        //  이부분에서 의문이 들었는데 왜 굳이 배열을 두개 만들어야 할까
        ImageView image[] = {
                findViewById(R.id.iv1), findViewById(R.id.iv2), findViewById(R.id.iv3),
                findViewById(R.id.iv4), findViewById(R.id.iv5), findViewById(R.id.iv6),
                findViewById(R.id.iv7), findViewById(R.id.iv8), findViewById(R.id.iv9)
        };


//        오.. 잘 돌아가긴 하는데
//        우선 R.id.iv1에 hover 해 보면 public static abstract final int iv1 = 1000024라고 뜨는데
//        이 값이 Integer값이기 때문에 배열안에는 지정한 형만 들어올 수 있다는걸 보여주기 위해 굳이 분리한건가보다
//        그러면 findViewById는 형이 뭐지..? 최상윈가? id값으로 모든 형을 불러올 수 있으니까..

//        아니면 findViewById를 hover 했을때 아래와 같이 뜨는데
//        public <T extends android.view.View> T findViewById(     @IdRes int id )
//        android의 View 모든 형을 extends 받은 제너릭 타입 함수 findViewById라
//        @IdRes 언어테이션 주석임 int형 id값으로 모든 view를 가질 수 있는 칭구인가보다


        for (int i = 0; i < image.length; i++) { //9번돌려
            final int index; // 주의! 꼭 필요함..
            index = i;

//          같은 순서대로 imageId에 담긴 객체를 ImageView image안에 넣고
//            image[index] = (ImageView) findViewById(imageId[index]);
//          그것이 클릭되었을때
            image[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    // voteCount의 해당 객체 투표수가 증가한다.
                    voteCount[index]++;
                    //동시에 Toast로 띄워준다.
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총 " + voteCount[index] + " 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }


        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // btnFinish이 클릭되었을때 결과class로 intent 객체를 만들어
                Intent intent = new Intent(getApplicationContext(),
                        hb_ch10_vote_result.class);
                //intent.putExtra로 VoteCount 와 ImageName를 전달한다.
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                //이동한다.
                startActivity(intent);
            }
        });

    }

}
