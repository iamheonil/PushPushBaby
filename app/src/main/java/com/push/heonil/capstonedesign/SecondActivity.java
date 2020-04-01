package com.push.heonil.capstonedesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private TextView textView3;

    Random rnd;
    ArrayList<HashMap<String, String>> personList;

    private TextView tv_result;
    private Button nextWord;

    static public int sendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        new SlidingRootNavBuilder(this)
                .withMenuLayout(R.layout.sliding_root_nav)
                .withToolbarMenuToggle(toolbar)
                .inject();

        final RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton radio2 = (RadioButton) findViewById(R.id.radioButton2);
        final Button sendButton = (Button) findViewById(R.id.remember);

        rnd = new Random(); //랜덤클래스로부터 랜덤 값 받아오는 변수 작성.

        init();

        nextWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] word = new String[73];  // String 배열 생성
                word[0]="fencing\n펜싱";
                word[1]="ancient\n옛날의";
                word[2]="castle\n성";
                personList = new ArrayList<HashMap<String, String>>();
                word[3]="alter\n바꾸다";
                word[4]="replace\n대치시키다/대신하다";
                word[5]="place\n위치/장소/위치시키다";
                word[6]="landlord\n집주인";
                word[7]="dryly\n건조하게/냉담하게";
                word[8]="visible\n볼수있는";
                word[9]="audible\n들을수있는";
                word[10]="legible\n읽을수있는";
                word[11]="symptom\n징후/증상";
                word[12]="newscaster\n뉴스전달자";
                word[13]="long\n긴/우울한";
                word[14]="technician\n기술자";
                word[15]="prominent\n저명한";
                word[16]="critic\n비평가";
                word[17]="criticize\n비평하다";
                word[18]="criticism\n비평";
                word[19]="critical\n비판적인";
                word[20]="lobby\n로비/홀";
                word[21]="rumpled\n구겨진";
                word[22]="asusual\n평시처럼";
                word[23]="annoyance\n괴롭히기/성가심";
                word[24]="annoy\n성가시게하다";
                word[25]="acceptation\n받아들임";
                word[26]="acceptor\n어음인수인";
                word[27]="dental\n치과의";
                word[28]="dentist\n치과의사";
                word[29]="patient\n환자/인내력있는";
                word[30]="patience\n인내";
                word[31]="impatient\n성급한";
                word[32]="impatience\n성급/안달";
                word[33]="treatment\n치료";
                word[34]="acknowledge\n인사에답하다";
                word[35]="obediently\n순종적으로";
                word[36]="obey\n복종하다";
                word[37]="obedience\n복종";
                word[38]="grade\n성적/등급/학년";
                word[39]="bombard\n폭격하다";
                word[40]="bomb\n폭탄";
                word[41]="pierce\n관통하다/꿰뚫다";
                word[42]="solemn\n엄숙한/심각한";
                word[43]="pupil\n학생";
                word[44]="logic\n논리학";
                word[45]="situation\n위치/장소";
                word[46]="balance\n저울/균형";
                word[47]="splash\n물등을튀기다";
                word[48]="yell\n소리지르다";
                word[49]="commotion\n소동/야단법석";
                word[50]="bank\n제방/둑/은행";
                word[51]="draw\n돈을인출하다";
                word[52]="drawing\n그림";
                word[53]="aunt\n아주머니/숙모";
                word[54]="uncle\n아저씨/삼촌";
                word[55]="appear\n출석하다/나타나다";
                word[56]="appearance\n출현/외모";
                word[57]="witness\n목격자/증인/증거";
                word[58]="accident\n우연히일어난일";
                word[59]="case\n재판";
                word[60]="distress\n곤경/고뇌";
                word[61]="passer-by\n통행인";
                word[62]="passby\n옆으로지나가다";
                word[63]="fix\n수리하다/고정시키다";
                word[64]="pasture\n목장";
                word[65]="meadow\n목초지/초원";
                word[66]="fence\n울타리";
                word[67]="accept\n받다";
                word[68]="acceptable\n받을수있는";
                word[69]="acceptance\n수령";
                word[70]="religion\n종교";
                word[71]="region\n지역";
                word[72]="regional\n지역의";

                for (int i = 0; i < word.length; i++) {
                    int random = rnd.nextInt(73);
                    // TextView에 표시한다.
                    tv_result.setText(String.valueOf(word[random]));
                }
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio1.isChecked() == true) {
                    sendData = sendData + 1;
                    Toast.makeText(getApplicationContext(), "좋습니다!\n이 기세로 조금더 노력 하세요!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "괜찮습니다!\n여유를 가지고 조금 더 노력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static int getSendData() {
        return sendData;
    }

    public static void setSendData(int sendData) {
        SecondActivity.sendData = sendData;
    }

    public void init() {
        tv_result = (TextView) findViewById(R.id.textView3);
        nextWord = (Button) findViewById(R.id.nextWord);
    }

    public void showAlarmDialog(View view) {
        TimePickerFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(getSupportFragmentManager(), "timepicker");
    }

    public void onButtonClickMain(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
        finish();
    }

    public void onButtonClick2(View view) {
        Intent intent = new Intent(getApplicationContext(), notificationActivity.class);
        startActivity(intent);
        finish();
    }

    public void onButtonClick4(View view) {
        Intent intent = new Intent(getApplicationContext(), sqlList.class);
        startActivity(intent);
        finish();
    }

    public void onButtonClickCal(View view) {
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(intent);
        finish();
    }

    public void onButtonClicklear(View view)
    {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
        finish();
    }

    public void onButtonClickwatch(View view)
    {
        Intent intent = new Intent(getApplicationContext(), TimeActivity.class);
        startActivity(intent);
        finish();
    }

}