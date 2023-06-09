//package com.himedia.project4_2;
//
//
//import static com.himedia.project4_2.R.drawable;
//import static com.himedia.project4_2.R.id;
//import static com.himedia.project4_2.R.layout;
//
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.Environment;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//
//
//public class MainActivity_audioplayer extends AppCompatActivity {
//
//    ListView listViewMP3;
//    Button btnPlay, btnPause, btnStop;
//    TextView tvMP3;
//    ProgressBar pbMP3;
//
//    ArrayList<String> mp3List;
//    String selectedMP3;
//
//    String mp3Path;
//    MediaPlayer mPlayer;
//    boolean PAUSED ; // 음악이 일시정지 중인지 체크.
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(layout.activity_audioplayer);
//        setTitle("간단 MP3 플레이어(개선)");
//
//        mp3Path = Environment.getExternalStorageDirectory().getPath() + "/" ;
//        PAUSED = false;
//
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(drawable.music);
//        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
//
//
//        // SDCard의 파일을 읽어서 리스트뷰에 출력
//        mp3List = new ArrayList<String>(); // 가변적 문자열
//
//        File[] listFiles = new File(mp3Path).listFiles();
//        String fileName, extName;
//        for (File file : listFiles) {
//            fileName = file.getName();
//            extName = fileName.substring(fileName.length() - 3);
//            if (extName.equals((String) "mp3")) // 확장명이 mp3일 때만 추가함.
//                mp3List.add(fileName);
//        }
//
//        ListView listViewMP3 = (ListView) findViewById(id.listViewMP3);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_single_choice, mp3List);
//        listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        listViewMP3.setAdapter(adapter);
//        listViewMP3.setItemChecked(0, true);
//
//        listViewMP3
//                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    public void onItemClick(AdapterView<?> arg0, View arg1,
//                                            int arg2, long arg3) {
//                        selectedMP3 = mp3List.get(arg2);
//                    }
//                });
//        selectedMP3 = mp3List.get(0);
//
//        btnPlay = (Button) findViewById(id.btnPlay);
//        btnPause = (Button) findViewById(id.btnPause);
//        btnStop = (Button) findViewById(id.btnStop);
//        tvMP3 = (TextView) findViewById(id.tvMP3);
//        pbMP3 = (ProgressBar) findViewById(id.pbMP3);
//
//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                try {
//                    mPlayer = new MediaPlayer();
//                    mPlayer.setDataSource(mp3Path + selectedMP3);
//                    mPlayer.prepare();
//                    mPlayer.start();
//                    btnPlay.setClickable(false);
//                    btnPause.setClickable(true);
//                    btnStop.setClickable(true);
//                    tvMP3.setText("실행중인 음악 :  " + selectedMP3);
//                    pbMP3.setVisibility(View.VISIBLE);
//                } catch (IOException e) {
//                }
//            }
//        });
//
//        btnPause.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (PAUSED == false) {
//                    mPlayer.pause();
//                    btnPause.setText("이어듣기");
//                    PAUSED = true;
//                    pbMP3.setVisibility(View.INVISIBLE);
//                } else {
//                    mPlayer.start();
//                    PAUSED = false;
//                    btnPause.setText("일시정지");
//                    pbMP3.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        btnPause.setClickable(false);
//
//        btnStop.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                mPlayer.stop();
//                mPlayer.reset();
//                btnPlay.setClickable(true);
//                btnPause.setClickable(false);
//                btnPause.setText("일시정지");
//                btnStop.setClickable(false);
//                tvMP3.setText("실행중인 음악 :  ");
//                pbMP3.setVisibility(View.INVISIBLE);
//            }
//        });
//        btnStop.setClickable(false);
//
//    }
//
//}
