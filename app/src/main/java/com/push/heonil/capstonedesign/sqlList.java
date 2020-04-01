package com.push.heonil.capstonedesign;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TimePicker;
import android.widget.Toast;

import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class sqlList extends AppCompatActivity implements View.OnClickListener {

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
        Intent intent = new Intent(getApplicationContext(), TimeActivity.class);
        startActivity(intent);
        finish();
    }


    String myJSON;

    public static final String TAG_RESULTS = "result";
    public static final String TAG_ID = "First";
    public static final String TAG_NAME = "Second";

    public static final String ADDRESS = "http://121.163.162.87/plz.php";

    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> personList;

    ListView list;

    private static int ONE_MINUTE = 5626;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqllist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        new SlidingRootNavBuilder(this)
                .withMenuLayout(R.layout.sliding_root_nav)
                .withToolbarMenuToggle(toolbar)
                .inject();

        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(this);

        list = findViewById(R.id.ListView);
        personList = new ArrayList<HashMap<String, String>>();
        getData(ADDRESS);

        new AlarmHATT(getApplicationContext()).Alarm();
    }

    public int Allhour, Allminute;

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        public static int set_hour,set_minute;
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            final int Allhour = c.get(Calendar.HOUR_OF_DAY);
            final int Allminute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, Allhour, Allminute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hour, int minute) {
            set_hour= hour;
            set_minute=minute;

            Toast.makeText(getActivity(), set_hour + "시" + minute + "분에 알림을 보내드리겠습니다.", Toast.LENGTH_LONG).show();
        }
    }


    public class AlarmHATT {
        int alarmplus = 0;
        public Context context;

        public AlarmHATT(Context context) {
            this.context = context;

        }

        public void Alarm() {


            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(sqlList.this, BroadCastD.class);

            PendingIntent sender = PendingIntent.getBroadcast(sqlList.this, alarmplus, intent, 0);

            //Toast.makeText(getApplicationContext(),"AlarmHATT 예약수 - " + alarmplus ,Toast.LENGTH_SHORT).show();

            Calendar calendar = Calendar.getInstance(); //알람시간 calendar에 set해주기

            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),
                    TimePickerFragment.set_hour, TimePickerFragment.set_minute, 0);

            //알람 예약
            am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);

            // Toast.makeText(getApplicationContext(),"AlarmHATT 예약수 - " + alarmplus++ ,Toast.LENGTH_SHORT).show();
        }
    }


    protected void showList() {
        try {
            Log.d("D3", "쇼리스트실행");
            //JSONObject jsonObj = new JSONObject(myJSON);
            JSONArray jsonObj = new JSONArray(myJSON);

            // peoples = jsonObj.getJSONArray(0);
            peoples = jsonObj;
            Log.d("D3", "쇼리스트실행 2");

            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                Log.d("D3", "포문 실행1");
                String First = c.getString(TAG_ID);
                Log.d("D3", "포문 실행1.1");
                String Second = c.getString(TAG_NAME);
                Log.d("D3", "포문 실행2");

                Log.d("D3", "first : " + First + " 세컨드 : " + Second);

                HashMap<String, String> persons = new HashMap<String, String>();

                persons.put(TAG_ID, First);
                persons.put(TAG_NAME, Second);


                personList.add(persons);
            }

            ListAdapter adapter = new SimpleAdapter(
                    sqlList.this, personList, R.layout.list_item,
                    new String[]{TAG_ID, TAG_NAME},
                    new int[]{R.id.First, R.id.Second}
            );

            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsStrting = sw.toString();
            Log.d("D3", "리스트 에러 : " + exceptionAsStrting);
        }

    }

    public void getData(String url) {
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                Log.d("D3", "1");
                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    Log.d("D3", "2.1");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    Log.d("D3", "2.2");
                    StringBuilder sb = new StringBuilder();
                    Log.d("D3", "2.3");
                    bufferedReader = new BufferedReader(new InputStreamReader
                            (con.getInputStream()));
                    Log.d("D3", "2.4");
                    Log.d("D3", "3 " + bufferedReader.readLine());

                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                        Log.d("D3", "데이터 :" + json);
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    StringWriter sw = new StringWriter();
                    e.printStackTrace(new PrintWriter(sw));
                    String exceptionAsStrting = sw.toString();
                    Log.d("D3", "에러 : " + exceptionAsStrting);
                    return null;
                }


            }

            @Override
            protected void onPostExecute(String result) {
                myJSON = result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
    }

    boolean toggle = false;

    @Override
    public void onClick(View view) {



        switch (view.getId()) {
            case R.id.button:

                if(toggle)
                {
                    toggle = false;
                    Toast.makeText(this, "알람이 종료됩니다", Toast.LENGTH_SHORT).show();
                    Intent notificationIntent = new Intent(this, NotificationPublisher.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                    alarmManager.cancel(pendingIntent);
                }
                else
                {
                    toggle = true;
                    Toast.makeText(this, "알람이 시작됩니다", Toast.LENGTH_SHORT).show();
                    Intent notificationIntent = new Intent(this, NotificationPublisher.class);
                    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                    alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + NotificationPublisher.NOTIFICATION_DELAY, NotificationPublisher.NOTIFICATION_DELAY, pendingIntent);
                }

                break;

        }

    }
}