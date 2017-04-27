package com.example.admin.dragger_mvp.mvp.dialogUtils;

import android.app.Activity;
import android.graphics.Color;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Admin on 2017/3/21.
 */

public class SweetAlertUtils {
    private static SweetAlertUtils instance = null;
    private static SweetAlertDialog dialog;
    private sweetAlertInterface alertInterface;
    public void setAlertInterface(sweetAlertInterface alertInterface) {
        this.alertInterface = alertInterface;
    }

    /* 私有构造方法，防止被实例化 */
    private SweetAlertUtils() {
    }
    /* 静态工程方法，创建实例 */
    public static SweetAlertUtils getInstance() {
        if (instance == null) {
            instance = new SweetAlertUtils();
        }
        return instance;
    }
    //默认弹窗
    public void showDefaultDialog(Activity activity,String content)
    {
        dialog=new SweetAlertDialog(activity);
        dialog.changeAlertType(SweetAlertDialog.PROGRESS_TYPE);
        dialog.getProgressHelper().setBarColor(Color.parseColor("#2f76d4"));
        dialog.setTitleText(content);
        dialog.setCancelable(false);
        dialog.show();
    }
    //成功弹窗
    public void showSuccessDialog(Activity activity,String  title, final Object content)
    {
        dialog=new SweetAlertDialog(activity);
        dialog.changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
        dialog.setCancelable(false);
        dialog.setTitleText(title)
                .setConfirmText("确定")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        alertInterface.showSweetAlertView(content);
                    }
                }).show();

    }
    //失败弹窗
    public void showErrorDialog(Activity activity,String  title, final Object content)
    {
        dialog=new SweetAlertDialog(activity);
        dialog.changeAlertType(SweetAlertDialog.ERROR_TYPE);
        dialog.setCancelable(false);
        dialog.setTitleText(title)
                .setConfirmText("确定")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        alertInterface.showSweetAlertView(content);
                    }
                }).show();
    }

    //取消弹窗
    public void dismissDialog()
    {
        dialog.cancel();
        dialog.dismiss();
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return instance;
    }
    public interface  sweetAlertInterface
    {
        void showSweetAlertView(Object data);
    }
}
