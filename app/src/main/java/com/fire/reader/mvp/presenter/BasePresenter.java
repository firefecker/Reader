package com.fire.reader.mvp.presenter;

/**
 * Created by Administrator on 2017/7/24.
 */

public abstract class BasePresenter<T> {
    public T mView;
    public void attach(T view){
        this.mView = view;
    }
    public void dettach(){
        mView = null;
    }

    public BasePresenter(T mView) {
        this.mView = mView;
    }
}
