package com.example.wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wifi.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** 跳转到登录界面 */
    public void jumpToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
    }
    /** 跳转到用户设置界面 */
    public void jumpToUserSet(View view) {
        Intent intent = new Intent(this, LoginActivity.class);

        startActivity(intent);
    }
}