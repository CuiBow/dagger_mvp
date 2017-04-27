package com.example.admin.dragger_mvp.baseApplication;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 2017/4/5.
 */
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(BaseApplication mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }
}
