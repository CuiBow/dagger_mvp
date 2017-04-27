package com.example.admin.dragger_mvp.login;

import com.example.admin.dragger_mvp.rx.BaseSubscriber;
import com.example.admin.dragger_mvp.scope.ActivityScope;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Admin on 2017/4/5.
 */
@ActivityScope
public class loginPresenter extends loginContract.Presenter  {
    @Inject
    loginPresenter() {

    }

    @Override
    protected void onStart() {
        
    }

    @Override
    void login(String mobile, String password) {
        mModel.login(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<String>(getViewOrEmpty(),"登录中..") {
                    @Override
                    protected void onSuccess(String s) {
                        if (s.equals("true"))
                        {
                            getmView().initData("登录成功!");
                        }else
                        {
                            getmView().initData("登录失败!");
                        }
                    }
                });
    }
}
