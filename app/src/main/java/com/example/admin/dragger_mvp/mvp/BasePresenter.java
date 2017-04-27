package com.example.admin.dragger_mvp.mvp;

import com.example.admin.dragger_mvp.rx.viewException.ViewNullException;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

/**
 * Created by Admin on 2017/4/5.
 */

public abstract class  BasePresenter <V extends BaseView,M extends IModel>{
    @Inject
    V mView;

    @Inject
    protected M mModel;

    private WeakReference<V> myView;

    public void attach(){
        myView=new WeakReference<V>(mView);
        onStart();
    }

    public void dettach(){
        if (myView!=null)
        {
            myView.clear();
            myView=null;
        }
    }

    public V getmView ()throws ViewNullException
    {
        if (isViewBind())
        {
            return myView.get();
        }else
        {
            throw new ViewNullException("View is NUll");
        }
    }

    protected abstract void onStart();

    public boolean isViewBind()
    {
        return  myView!=null ?true:false;
    }
    public V getViewOrEmpty() {
        return this.myView.get() == null ? null : this.myView.get();
    }
}
