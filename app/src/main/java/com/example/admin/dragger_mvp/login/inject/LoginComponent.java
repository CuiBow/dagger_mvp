package com.example.admin.dragger_mvp.login.inject;

import com.example.admin.dragger_mvp.baseApplication.AppComponent;
import com.example.admin.dragger_mvp.login.login;
import com.example.admin.dragger_mvp.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Admin on 2017/4/5.
 */
@ActivityScope
@Component(modules = LoginModule.class,dependencies = AppComponent.class)
public interface LoginComponent {
    void inject(login activity);
}
