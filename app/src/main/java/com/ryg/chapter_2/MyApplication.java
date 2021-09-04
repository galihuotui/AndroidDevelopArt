package com.ryg.chapter_2;

import android.app.Application;
import android.util.Log;

import com.ryg.chapter_2.binderpool.BinderPool;
import com.ryg.chapter_2.utils.MyUtils;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
//        String processName = MyUtils.getProcessName(getApplicationContext(),
//                Process.myPid());
        String processName = "";
        Log.d(TAG, "application start, process name:" + processName);
        new Thread(new Runnable() {

            @Override
            public void run() {
                doWorkInBackground();
            }
        }).start();
    }

    private void doWorkInBackground() {
        // init binder pool
        BinderPool.getInsance(getApplicationContext());
    }
}
