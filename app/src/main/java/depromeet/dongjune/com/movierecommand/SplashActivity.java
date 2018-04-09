package depromeet.dongjune.com.movierecommand;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import depromeet.dongjune.com.movierecommand.controller.LoginActivity;
import depromeet.dongjune.com.movierecommand.controller.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* 메뉴액티비티를 실행하고 로딩화면을 죽인다.*/
                Intent intent;
                if (firstCheck()) {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                }
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, 2500);
    }

    private boolean firstCheck() {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        return sp.getBoolean("first_check", false);
    }

}
