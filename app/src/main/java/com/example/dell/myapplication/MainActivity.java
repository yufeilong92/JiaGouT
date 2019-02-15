package com.example.dell.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private void inithttp(){
        HttpHelpr.get_Instance(this).post(
                "", new HashMap<String, Object>(),
                new HttpCallBack<Integer>() {
                    @Override
                    public void onSuccess(Integer objResult) {

                    }

                    @Override
                    public void Error(String msg) {

                    }
                });
    }
}
