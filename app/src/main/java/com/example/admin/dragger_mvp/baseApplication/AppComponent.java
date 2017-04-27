package com.example.admin.dragger_mvp.baseApplication;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Admin on 2017/4/5.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Application application();

}
