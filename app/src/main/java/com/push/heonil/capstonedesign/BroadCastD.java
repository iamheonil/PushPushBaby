package com.push.heonil.capstonedesign;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BroadCastD extends BroadcastReceiver {


    Random rnd; //랜덤클래스로 부터 객체 생성

    public static final String TAG_RESULTS = "result";
    public static final String TAG_ID = "First";
    public static final String TAG_NAME = "Second";
    public static final String ADDRESS = "http://121.163.162.87/plz.php";

    //String first = word.get(sqlList.TAG_ID);
    //String second = word.get(sqlList.TAG_NAME);
    //String BroadCast = word.get(sqlList.TAG_ID) + word.get(sqlList.TAG_NAME);

    String wording = sqlList.TAG_ID + " " + sqlList.TAG_NAME;

    ArrayList<HashMap<String, String>> personList;

// String.valueOf(word)

    public void showNotification(String title, String message) {
    }

    public void onReceive(Context context, Intent intent) {
        Random rnd; //랜덤클래스로 부터 객체 생성

        rnd = new Random();

        String[] word = new String[73];  // String 배열 생성
        word[0] = "fencing　　　펜싱";
        word[1] = "ancient　　　옛날의";
        word[2] = "castle　　　성";
        personList = new ArrayList<HashMap<String, String>>();
        word[3] = "alter　　　바꾸다";
        word[4] = "replace　　　대치시키다/대신하다";
        word[5] = "place　　　위치/장소/위치시키다";
        word[6] = "landlord　　　집주인";
        word[7] = "dryly　　　건조하게/냉담하게";
        word[8] = "visible　　　볼수있는";
        word[9] = "audible　　　들을수있는";
        word[10] = "legible　　　읽을수있는";
        word[11] = "symptom　　　징후/증상";
        word[12] = "newscaster　　　뉴스전달자";
        word[13] = "long　　　긴/우울한";
        word[14] = "technician　　　기술자";
        word[15] = "prominent　　　저명한";
        word[16] = "critic　　　비평가";
        word[17] = "criticize　　　비평하다";
        word[18] = "criticism　　　비평";
        word[19] = "critical　　　비판적인";
        word[20] = "lobby　　　로비/홀";
        word[21] = "rumpled　　　구겨진";
        word[22] = "asusual　　　평시처럼";
        word[23] = "annoyance　　　괴롭히기/성가심";
        word[24] = "annoy　　　성가시게하다";
        word[25] = "acceptation　　　받아들임";
        word[26] = "acceptor　　　어음인수인";
        word[27] = "dental　　　치과의";
        word[28] = "dentist　　　치과의사";
        word[29] = "patient　　　환자/인내력있는";
        word[30] = "patience　　　인내";
        word[31] = "impatient　　　성급한";
        word[32] = "impatience　　　성급/안달";
        word[33] = "treatment　　　치료";
        word[34] = "acknowledge　　　인사에답하다";
        word[35] = "obediently　　　순종적으로";
        word[36] = "obey　　　복종하다";
        word[37] = "obedience　　　복종";
        word[38] = "grade　　　성적/등급/학년";
        word[39] = "bombard　　　폭격하다";
        word[40] = "bomb　　　폭탄";
        word[41] = "pierce　　　관통하다/꿰뚫다";
        word[42] = "solemn　　　엄숙한/심각한";
        word[43] = "pupil　　　학생";
        word[44] = "logic　　　논리학";
        word[45] = "situation　　　위치/장소";
        word[46] = "balance　　　저울/균형";
        word[47] = "splash　　　물등을튀기다";
        word[48] = "yell　　　소리지르다";
        word[49] = "commotion　　　소동/야단법석";
        word[50] = "bank　　　제방/둑/은행";
        word[51] = "draw　　　돈을인출하다";
        word[52] = "drawing　　　그림";
        word[53] = "aunt　　　아주머니/숙모";
        word[54] = "uncle　　　아저씨/삼촌";
        word[55] = "appear　　　출석하다/나타나다";
        word[56] = "appearance　　　출현/외모";
        word[57] = "witness　　　목격자/증인/증거";
        word[58] = "accident　　　우연히일어난일";
        word[59] = "case　　　재판";
        word[60] = "distress　　　곤경/고뇌";
        word[61] = "passer-by　　　통행인";
        word[62] = "passby　　　옆으로지나가다";
        word[63] = "fix　　　수리하다/고정시키다";
        word[64] = "pasture　　　목장";
        word[65] = "meadow　　　목초지/초원";
        word[66] = "fence　　　울타리";
        word[67] = "accept　　　받다";
        word[68] = "acceptable　　　받을수있는";
        word[69] = "acceptance　　　수령";
        word[70] = "religion　　　종교";
        word[71] = "region　　　지역";
        word[72] = "regional　　　지역의";

        for (int i = 0; i < word.length; i++) {
            int random = rnd.nextInt(73);
            showNotification("단어가 도착했습니다!", "" + String.valueOf(word[random]));


            // 알람 시간이 되었을때 onReceive를 호출함
            // NotificationManager 안드로이드 상태바에 메세지를 던지기위한 서비스 불러오고
            NotificationManager notificationmanager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, sqlList.class),
                    PendingIntent.FLAG_UPDATE_CURRENT);
            Notification.Builder builder = new Notification.Builder(context);

            builder.setSmallIcon(android.R.drawable.ic_dialog_info).setTicker("HETT").setWhen(System.currentTimeMillis())
                    .setNumber(1).setContentTitle("단어가 도착 했습니다!").setContentText(String.valueOf(word[random]))
                    .setDefaults(Notification.DEFAULT_VIBRATE).setContentIntent(pendingIntent).setAutoCancel(true);

            notificationmanager.notify(1, builder.build());
        }
    }
}

/*


        public void onClick(View v) {
            String[] word = new String[73];  // String 배열 생성
            word[0] = "fencing　　　펜싱";
            word[1] = "ancient　　　옛날의";
            word[2] = "castle　　　성";
            personList = new ArrayList<HashMap<String, String>>();
            word[3] = "alter　　　바꾸다";
            word[4] = "replace　　　대치시키다/대신하다";
            word[5] = "place　　　위치/장소/위치시키다";
            word[6] = "landlord　　　집주인";
            word[7] = "dryly　　　건조하게/냉담하게";
            word[8] = "visible　　　볼수있는";
            word[9] = "audible　　　들을수있는";
            word[10] = "legible　　　읽을수있는";
            word[11] = "symptom　　　징후/증상";
            word[12] = "newscaster　　　뉴스전달자";
            word[13] = "long　　　긴/우울한";
            word[14] = "technician　　　기술자";
            word[15] = "prominent　　　저명한";
            word[16] = "critic　　　비평가";
            word[17] = "criticize　　　비평하다";
            word[18] = "criticism　　　비평";
            word[19] = "critical　　　비판적인";
            word[20] = "lobby　　　로비/홀";
            word[21] = "rumpled　　　구겨진";
            word[22] = "asusual　　　평시처럼";
            word[23] = "annoyance　　　괴롭히기/성가심";
            word[24] = "annoy　　　성가시게하다";
            word[25] = "acceptation　　　받아들임";
            word[26] = "acceptor　　　어음인수인";
            word[27] = "dental　　　치과의";
            word[28] = "dentist　　　치과의사";
            word[29] = "patient　　　환자/인내력있는";
            word[30] = "patience　　　인내";
            word[31] = "impatient　　　성급한";
            word[32] = "impatience　　　성급/안달";
            word[33] = "treatment　　　치료";
            word[34] = "acknowledge　　　인사에답하다";
            word[35] = "obediently　　　순종적으로";
            word[36] = "obey　　　복종하다";
            word[37] = "obedience　　　복종";
            word[38] = "grade　　　성적/등급/학년";
            word[39] = "bombard　　　폭격하다";
            word[40] = "bomb　　　폭탄";
            word[41] = "pierce　　　관통하다/꿰뚫다";
            word[42] = "solemn　　　엄숙한/심각한";
            word[43] = "pupil　　　학생";
            word[44] = "logic　　　논리학";
            word[45] = "situation　　　위치/장소";
            word[46] = "balance　　　저울/균형";
            word[47] = "splash　　　물등을튀기다";
            word[48] = "yell　　　소리지르다";
            word[49] = "commotion　　　소동/야단법석";
            word[50] = "bank　　　제방/둑/은행";
            word[51] = "draw　　　돈을인출하다";
            word[52] = "drawing　　　그림";
            word[53] = "aunt　　　아주머니/숙모";
            word[54] = "uncle　　　아저씨/삼촌";
            word[55] = "appear　　　출석하다/나타나다";
            word[56] = "appearance　　　출현/외모";
            word[57] = "witness　　　목격자/증인/증거";
            word[58] = "accident　　　우연히일어난일";
            word[59] = "case　　　재판";
            word[60] = "distress　　　곤경/고뇌";
            word[61] = "passer-by　　　통행인";
            word[62] = "passby　　　옆으로지나가다";
            word[63] = "fix　　　수리하다/고정시키다";
            word[64] = "pasture　　　목장";
            word[65] = "meadow　　　목초지/초원";
            word[66] = "fence　　　울타리";
            word[67] = "accept　　　받다";
            word[68] = "acceptable　　　받을수있는";
            word[69] = "acceptance　　　수령";
            word[70] = "religion　　　종교";
            word[71] = "region　　　지역";
            word[72] = "regional　　　지역의";

            for (int i = 0; i < word.length; i++) {
                int random = rnd.nextInt(73);
                showNotification("단어가 도착했습니다!", "" + String.valueOf(word[random]));
            }
        }


 */