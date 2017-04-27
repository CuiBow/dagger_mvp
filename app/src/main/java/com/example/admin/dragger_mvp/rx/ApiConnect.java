package com.example.admin.dragger_mvp.rx;

import android.content.Context;

import com.example.admin.dragger_mvp.R;
import com.example.admin.dragger_mvp.rx.viewException.ViewNullException;
import com.example.admin.dragger_mvp.utils.Utils;
import com.google.gson.JsonSyntaxException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by Admin on 2017/4/5.
 */

public class ApiConnect {

    public static ErrorResponse ErrorMessage(Throwable e)
    {
        ErrorResponse res = null;
        String errorMsg = "";
        String errorNo = "";
        Context context= Utils.getContext();
        if (context!=null)
        {
            if (e instanceof HttpException) {
                HttpException he = (HttpException) e;
                errorMsg = context.getString(R.string.api_error_connect);
                errorNo = String.valueOf(he.code());
            } else if (e instanceof UnknownHostException) {
                errorMsg = context.getString(R.string.api_error_connect);
                errorNo = e.getLocalizedMessage();
            } else if (e instanceof SocketTimeoutException) {
                errorMsg = context.getString(R.string.api_error_connect);
                errorNo = e.getLocalizedMessage();
            } else if (e instanceof ConnectException) {
                errorMsg = context.getString(R.string.api_error_connect);
                errorNo = e.getLocalizedMessage();
            } else if (e instanceof IOException) {
                errorMsg = context.getString(R.string.api_error_connect);
                errorNo = e.getLocalizedMessage();
            } else if (e instanceof IllegalStateException) {
                errorMsg = context.getString(R.string.api_error_state);
                errorNo = e.getLocalizedMessage();
            } else if (e instanceof JsonSyntaxException) {
                errorMsg = context.getString(R.string.api_error_json);
                errorNo = e.getLocalizedMessage();
            }else if (e instanceof ViewNullException) {
                errorNo = e.getLocalizedMessage();
            } else {
                errorMsg = e.getMessage();
                errorNo = e.getLocalizedMessage();
            }

        }else {
            errorNo = e.getLocalizedMessage();
        }
        if (!errorMsg.isEmpty()) {
            if (errorMsg != null) {
                res.err_msg = errorMsg;
            }
            if (errorNo != null) {
                res.err_no = errorNo;
            }
        }
        return  res;

    }
}
