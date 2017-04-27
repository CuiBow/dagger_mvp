package com.example.admin.dragger_mvp.rx;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by Admin on 2017/4/5.
 */

public abstract class BaseSubscriber<T> implements Subscriber<T> {

    private Isetting isetting;

    public BaseSubscriber() {
        this(null,null);
    }

    public BaseSubscriber(Isetting isetting, String content) {
        this.isetting = isetting;
        if (isetting!=null)
        {
            isetting.showProgress(content);
        }
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable t) {
        end();
        _onError(ApiConnect.ErrorMessage(t));
    }

    @Override
    public void onComplete() {
        end();
    }


    protected abstract void onSuccess(T t);


    protected void _onError(ErrorResponse error) {

        if (isetting != null&& error.err_msg != null) {
            isetting.showToast(error.err_msg);
        }
    }


    private void end() {
        if (isetting != null) {
            isetting.dissProgress();
        }
    }

   public interface Isetting
    {
        void showProgress(String content);
        void dissProgress();
        void showToast(String content);
    }
}
