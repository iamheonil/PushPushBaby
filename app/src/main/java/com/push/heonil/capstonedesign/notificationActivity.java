package com.push.heonil.capstonedesign;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.lang.String;
import static java.util.Collections.shuffle;

/**
 * Created by HEONIL on 2018-04-11.
 * ID -> button5

 */


public class notificationActivity extends AppCompatActivity {

    Random rnd; //랜덤클래스로 부터 객체 생성
    String myJSON;


    public void showAlarmDialog(View view)
    {
        TimePickerFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(getSupportFragmentManager(), "timepicker");
    }

    public void onButtonClickMain(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void onButtonClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
        finish();
    }

    public void onButtonClick2(View view)
    {
        Intent intent = new Intent(getApplicationContext(), notificationActivity.class);
        startActivity(intent);
        finish();
    }


    public void onButtonClick4(View view)
    {
        Intent intent = new Intent(getApplicationContext(), sqlList.class);
        startActivity(intent);
        finish();
    }

    public void onButtonClickCal(View view)
    {
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

    private static final String TAG_RESULTS = "result";
    private static final String TAG_NAME = "main";
    private static final String TAG_ADD = "sub";

    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;

    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        new SlidingRootNavBuilder(this)
                .withMenuLayout(R.layout.sliding_root_nav)
                .withToolbarMenuToggle(toolbar)
                .inject();

        rnd = new Random(); //랜덤클래스로부터 랜덤 값 받아오는 변수 작성.
        Button notification = (Button) findViewById(R.id.button5);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] word = new String[73];  // String 배열 생성
                word[0]="fencing　　　펜싱";
                word[1]="ancient　　　옛날의";
                word[2]="castle　　　성";
                personList = new ArrayList<HashMap<String, String>>();
                word[3]="alter　　　바꾸다";
                word[4]="replace　　　대치시키다/대신하다";
                word[5]="place　　　위치/장소/위치시키다";
                word[6]="landlord　　　집주인";
                word[7]="dryly　　　건조하게/냉담하게";
                word[8]="visible　　　볼수있는";
                word[9]="audible　　　들을수있는";
                word[10]="legible　　　읽을수있는";
                word[11]="symptom　　　징후/증상";
                word[12]="newscaster　　　뉴스전달자";
                word[13]="long　　　긴/우울한";
                word[14]="technician　　　기술자";
                word[15]="prominent　　　저명한";
                word[16]="critic　　　비평가";
                word[17]="criticize　　　비평하다";
                word[18]="criticism　　　비평";
                word[19]="critical　　　비판적인";
                word[20]="lobby　　　로비/홀";
                word[21]="rumpled　　　구겨진";
                word[22]="asusual　　　평시처럼";
                word[23]="annoyance　　　괴롭히기/성가심";
                word[24]="annoy　　　성가시게하다";
                word[25]="acceptation　　　받아들임";
                word[26]="acceptor　　　어음인수인";
                word[27]="dental　　　치과의";
                word[28]="dentist　　　치과의사";
                word[29]="patient　　　환자/인내력있는";
                word[30]="patience　　　인내";
                word[31]="impatient　　　성급한";
                word[32]="impatience　　　성급/안달";
                word[33]="treatment　　　치료";
                word[34]="acknowledge　　　인사에답하다";
                word[35]="obediently　　　순종적으로";
                word[36]="obey　　　복종하다";
                word[37]="obedience　　　복종";
                word[38]="grade　　　성적/등급/학년";
                word[39]="bombard　　　폭격하다";
                word[40]="bomb　　　폭탄";
                word[41]="pierce　　　관통하다/꿰뚫다";
                word[42]="solemn　　　엄숙한/심각한";
                word[43]="pupil　　　학생";
                word[44]="logic　　　논리학";
                word[45]="situation　　　위치/장소";
                word[46]="balance　　　저울/균형";
                word[47]="splash　　　물등을튀기다";
                word[48]="yell　　　소리지르다";
                word[49]="commotion　　　소동/야단법석";
                word[50]="bank　　　제방/둑/은행";
                word[51]="draw　　　돈을인출하다";
                word[52]="drawing　　　그림";
                word[53]="aunt　　　아주머니/숙모";
                word[54]="uncle　　　아저씨/삼촌";
                word[55]="appear　　　출석하다/나타나다";
                word[56]="appearance　　　출현/외모";
                word[57]="witness　　　목격자/증인/증거";
                word[58]="accident　　　우연히일어난일";
                word[59]="case　　　재판";
                word[60]="distress　　　곤경/고뇌";
                word[61]="passer-by　　　통행인";
                word[62]="passby　　　옆으로지나가다";
                word[63]="fix　　　수리하다/고정시키다";
                word[64]="pasture　　　목장";
                word[65]="meadow　　　목초지/초원";
                word[66]="fence　　　울타리";
                word[67]="accept　　　받다";
                word[68]="acceptable　　　받을수있는";
                word[69]="acceptance　　　수령";
                word[70]="religion　　　종교";
                word[71]="region　　　지역";
                word[72]="regional　　　지역의";

                for(int i=0 ; i < word.length; i++) {
                    int random = rnd.nextInt(73);
                    showNotification("단어가 도착했습니다!", "" +String.valueOf(word[random]));
                }
            }
        });
    }


public void showNotification(String title, String message){
        Intent notifyIntent = new Intent(this, MainActivity.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, new Intent[]
                {notifyIntent}, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new Notification.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();

        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(2, notification);
    }
}

