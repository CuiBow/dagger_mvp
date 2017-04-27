package com.example.admin.dragger_mvp.baseApplication;

import android.app.Application;

import com.example.admin.dragger_mvp.utils.Utils;

/**
 * Created by Admin on 2017/4/5.
 */

public class BaseApplication extends Application {
    private AppComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        inject();
        Utils.init(this);
    }
    private void inject()
    {
        mAppComponent=DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
