package com.push.heonil.capstonedesign;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class NotificationPublisher extends BroadcastReceiver {

    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION = "notification";
    public static long NOTIFICATION_DELAY = 60 * 1000;

    ArrayList<HashMap<String, String>> personList = null;

    Context thisContext = null;

    public void onReceive(Context context, Intent intent) {
        thisContext = context;

        if(personList == null) {
            personList = new ArrayList<HashMap<String, String>>();
            getData(sqlList.ADDRESS);
        }
        else
        {
            notification();
        }
    }

    private void notification()
    {
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(personList.size());
        HashMap<String, String> word = personList.get(randomIndex);
        String first = word.get(sqlList.TAG_ID);
        String second = word.get(sqlList.TAG_NAME);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(thisContext)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("알림이 도착 했습니다!")
                        .setContentText(second)
                        .setDefaults(Notification.DEFAULT_SOUND);

        NotificationManager notificationManager = (NotificationManager)thisContext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, mBuilder.build());
    }


    String myJSON;
    JSONArray peoples = null;

    public void getData(String url) {
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                myJSON = result;

                try {
                    JSONObject jsonObj = new JSONObject(myJSON);
                    peoples = jsonObj.getJSONArray(sqlList.TAG_RESULTS);

                    for (int i = 0; i < peoples.length(); i++) {
                        JSONObject c = peoples.getJSONObject(i);
                        String First = c.getString(sqlList.TAG_ID);
                        String Second = c.getString(sqlList.TAG_NAME);

                        HashMap<String, String> persons = new HashMap<String, String>();

                        persons.put(sqlList.TAG_ID, First);
                        persons.put(sqlList.TAG_NAME, Second);

                        personList.add(persons);
                    }

                    notification();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
    }
}
