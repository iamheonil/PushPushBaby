package com.push.heonil.capstonedesign;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import static android.R.attr.id;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        new SlidingRootNavBuilder(this)
                .withMenuLayout(R.layout.sliding_root_nav)
                .withToolbarMenuToggle(toolbar)
                .inject();

    }

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
        Intent intent = new Intent(getApplicationContext(), sqlList.class);
        startActivity(intent);
        finish();
    }

    public void onButtonClickwatch(View view)
    {
        Intent intent = new Intent(getApplicationContext(), sqlList.class);
        startActivity(intent);
        finish();
    }
}
