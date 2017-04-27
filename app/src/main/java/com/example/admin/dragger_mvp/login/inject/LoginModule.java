package com.example.admin.dragger_mvp.login.inject;

import com.example.admin.dragger_mvp.login.loginContract;
import com.example.admin.dragger_mvp.login.loginModel;
import com.example.admin.dragger_mvp.login.loginPresenter;
import com.example.admin.dragger_mvp.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 2017/4/5.
 */
@Module
public class LoginModule {

    private loginContract.View mView;

    public LoginModule(loginContract.View mView) {
        this.mView = mView;
    }

    @ActivityScope
    @Provides
    loginContract.Model provideModel(loginModel model) {
        return model;
    }

    @ActivityScope
    @Provides
    loginContract.View provideView() {
        return this.mView;
    }


    @ActivityScope
    @Provides
    loginContract.Presenter providePresenter(loginPresenter presenter) {
        return presenter;
    }
}
