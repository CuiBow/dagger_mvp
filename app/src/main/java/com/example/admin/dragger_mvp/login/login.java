package com.example.admin.dragger_mvp.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.dragger_mvp.R;
import com.example.admin.dragger_mvp.baseApplication.AppComponent;
import com.example.admin.dragger_mvp.login.inject.DaggerLoginComponent;
import com.example.admin.dragger_mvp.login.inject.LoginModule;
import com.example.admin.dragger_mvp.mvp.BaseMvpActivity;
import com.example.admin.dragger_mvp.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

public class login extends BaseMvpActivity<loginPresenter> implements  loginContract.View{
    @BindViews({R.id.userName,R.id.password})
    List<EditText> edt;
    @BindView(R.id.login)
    Button login;

    @Override
    protected int initView() {
        return R.layout.activity_login;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerLoginComponent
                .builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initData(String msg) {
        ToastUtils.showLongToast(msg);
    }
    @OnClick(R.id.login)
    public void onClick(View view)
    {
        String username=edt.get(0).getText().toString();
        String password=edt.get(1).getText().toString();
        if (!username.equals("")&&!password.equals(""))
        {
            mPresenter.login(username,password);
        }else
        {
            ToastUtils.showShortToast("请输入用户名或密码");
        }

    }
}
