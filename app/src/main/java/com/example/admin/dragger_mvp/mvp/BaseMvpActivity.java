package com.example.admin.dragger_mvp.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.admin.dragger_mvp.baseApplication.AppComponent;
import com.example.admin.dragger_mvp.baseApplication.BaseApplication;
import com.example.admin.dragger_mvp.mvp.dialogUtils.SweetAlertUtils;
import com.example.admin.dragger_mvp.utils.ToastUtils;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/4/5.
 */

public abstract class BaseMvpActivity <P extends BasePresenter> extends AppCompatActivity implements BaseView{
    @Inject
    protected  P mPresenter;

    protected Context mContext;
    protected BaseApplication mApplication;

    private Unbinder mUnbinder;
    private SweetAlertUtils dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication= (BaseApplication) getApplication();
        mContext=this;
        setContentView(initView());
        mUnbinder = ButterKnife.bind(this);
        setupActivityComponent(mApplication.getAppComponent());
        mPresenter.attach();
        dialog=SweetAlertUtils.getInstance();
    }

    abstract protected int initView();

    //依赖注入
    protected abstract void setupActivityComponent(AppComponent appComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
        this.mPresenter = null;
        this.mUnbinder = null;
        this.mApplication = null;
        mPresenter.dettach();
    }

    @Override
    public void showProgress(String content) {
        dialog.showDefaultDialog(this,content);
    }

    @Override
    public void dissProgress() {
        dialog.dismissDialog();
    }

    @Override
    public void showToast(String content) {
        ToastUtils.showLongToast(content);
    }


}
