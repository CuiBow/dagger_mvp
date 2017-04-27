package com.example.admin.dragger_mvp.login;

import android.util.Log;

import com.example.admin.dragger_mvp.mvp.BaseModel;
import com.example.admin.dragger_mvp.scope.ActivityScope;

import javax.inject.Inject;

import io.reactivex.Flowable;


/**
 * Created by Admin on 2017/4/5.
 */
@ActivityScope
public class loginModel extends BaseModel implements loginContract.Model {

    @Inject
    loginModel() {

    }


    @Override
    public Flowable<String> login(String mobile, String password) {

        if (mobile.equals("admin")&&password.equals("123"))
        {
            return  Flowable.just("true");
        }else
        {
            return  Flowable.just("false");
        }


    }
}
