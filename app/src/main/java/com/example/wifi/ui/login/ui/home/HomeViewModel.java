package com.example.wifi.ui.login.ui.home;

import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wifi.R;

import java.util.Timer;
import java.util.TimerTask;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is map fragment");


    }

    public LiveData<String> getText() {
        return mText;
    }
}