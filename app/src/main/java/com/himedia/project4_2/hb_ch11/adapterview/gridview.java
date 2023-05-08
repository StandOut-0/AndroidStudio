package com.himedia.project4_2.hb_ch11.adapterview;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.himedia.project4_2.R;


public class gridview extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hb_ch11_gridview);
        setTitle("그리드뷰 영화 포스터");

//        gridView1객체와 아래 생성한 class를 찾아 객체를 만들었다.
        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);

//        GridView객체에 class에 정의한것을 set한다.
        gv.setAdapter(gAdapter);
    }


//   extends BaseAdapter
//   스크롤이 보이지 않을 자식 View까지 미리 그려 메모리 사용량이 증가하는 ScrollView를 대신
//   현재 화면에 보이지 않는 자식 뷰를 미리 생성하지 않고 스크롤되어 보여야할 때 생성
    public class MyGridAdapter extends BaseAdapter {

        Context context; //Context 액티비티와 애플리케이션에 대한 정보
        public MyGridAdapter(Context c) {
            context = c;
        }



//    BaseAdapter
        //BaseAdapter가 제공하는 getCount, posterID[]의 길이로 지정한다.
        public int getCount() {return posterID.length;}

        //BaseAdapter가 제공하는 getItem, 아무런세팅을 하지않았다.
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }
    //BaseAdapter가 제공하는 getItemId, 아무런세팅을 하지않았다.
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        //이미지를 posterID 배열에 저장
        Integer[] posterID = { R.drawable.mov01, R.drawable.mov02,
                R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
                R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
                R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
                R.drawable.mov10 };

        public View getView(int position, View convertView, ViewGroup parent) {
            //dialog용.xml에 ImageView설정
            ImageView imageview = new ImageView(context); //객체를 가져와
            imageview.setLayoutParams(new GridView.LayoutParams(200, 300)); //창 크기를 정하기
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);//가운데 정렬하기
            imageview.setPadding(5, 5, 5, 5);//패딩값 적용하기
            imageview.setImageResource(posterID[position]);//이미지경로 넣어주기

            final int pos = position;
            //imageview를 클릭하면
            imageview.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    //AlertDialog으로 예쁘게 창 위에 띄울예정.
                    //기본세팅을 한다.
                    AlertDialog.Builder dlg = new AlertDialog.Builder(gridview.this);
                    dlg.setTitle("큰 포스터");
                    dlg.setIcon(R.drawable.ic_launcher);
                    dlg.setNegativeButton("닫기", null);

                    //AlertDialog body 부분에 setView로 hb_ch11_gridview_dialog를 가져와 띄울건데
                    //inflate를 이용해 layout에 그때 그때 다른 layout을 집어 넣을 수 있게 할것이다.

                    //View를 준비하자
                    //이 View는 inflate 형식으로 만들어진다.
                    //gridview형식으로 hb_ch11_gridview_dialog를 불러와 저장한다.
                    View dialogView = (View) View.inflate(
                            gridview.this, R.layout.hb_ch11_gridview_dialog, null);

                    //hb_ch11_gridview_dialog안에 있는 ImageView의 이미지 주소를
                    ImageView ivPoster = (ImageView) dialogView
                            .findViewById(R.id.ivPoster);
                    //pos = posterID[position] pos번째 로 세팅한다.
                    ivPoster.setImageResource(posterID[pos]);

                    //이를 body부분에 set하고 show 보여주자.
                    dlg.setView(dialogView);
                    dlg.show();



                }
            });

            return imageview;
        }

    }


}
