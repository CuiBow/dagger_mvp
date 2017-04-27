package com.example.admin.dragger_mvp.login;

import com.example.admin.dragger_mvp.mvp.BaseModel;
import com.example.admin.dragger_mvp.mvp.BasePresenter;
import com.example.admin.dragger_mvp.mvp.BaseView;
import com.example.admin.dragger_mvp.mvp.IModel;

import io.reactivex.Flowable;


/**
 * Created by Admin on 2017/4/5.
 */

public interface loginContract {
    interface View extends BaseView
    {
        void initData(String msg);

    }
    abstract class Presenter extends BasePresenter<View,Model>
    {
        abstract void login(String mobile, String password);
    }

    interface Model extends IModel {

        Flowable<String> login(String mobile, String password);
    }
}
