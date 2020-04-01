package com.push.heonil.capstonedesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by chickenNcola on 2017. 6. 25..
 */

public class IntroActivity extends Activity {
    Handler handler;//핸들러 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        handler= new Handler();
        handler.postDelayed(mrun, 3500); // 시간 3.5초 딜레이

    }


    Runnable mrun = new Runnable(){
        @Override
        public void run(){
            Intent MainActivity = new Intent(IntroActivity.this, MainActivity.class); //인텐트 생성(현 액티비티, 새로 실행할 액티비티)
            startActivity(MainActivity);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            // overridePendingTransition : 서서히 사라지는 효과
        }
    };
    //인트로 중에 뒤로가기를 누를 경우 핸들러를 끊어버려 아무일 없게 만드는 부분
    //미 설정시 인트로 중 뒤로가기를 누르면 인트로 후에 홈화면이 나옴.
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        handler.removeCallbacks(mrun);
    }
}