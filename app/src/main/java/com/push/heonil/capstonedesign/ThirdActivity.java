package com.push.heonil.capstonedesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.push.heonil.capstonedesign.SecondActivity.getSendData;
import static com.push.heonil.capstonedesign.SecondActivity.setSendData;


public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        new SlidingRootNavBuilder(this)
                .withMenuLayout(R.layout.sliding_root_nav)
                .withToolbarMenuToggle(toolbar)
                .inject();

        TextView textView = (TextView) findViewById(R.id.ressult);
        textView.setText(Integer.toString(getSendData()) + "개");

        TextView timeView = (TextView) findViewById(R.id.timeView);
        timeView.setText(" " + timeNow() + " " + "기준 외운 단어의 수는" + " : ");

        }

        public String timeNow() {
        SimpleDateFormat formatter
                = new SimpleDateFormat("MM월 dd일", Locale.KOREA);
        Date date = new Date();
        String currentDate = formatter.format(date);

        return currentDate;
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

    public void onButtonClickwatch(View view)
    {
        Intent intent = new Intent(getApplicationContext(), TimeActivity.class);
        startActivity(intent);
        finish();
    }



}
