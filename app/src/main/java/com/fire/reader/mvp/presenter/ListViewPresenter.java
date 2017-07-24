package com.fire.reader.mvp.presenter;

import android.os.Handler;

import com.fire.reader.callback.OnRequestListener;
import com.fire.reader.mvp.contact.IRequestData;
import com.fire.reader.mvp.contact.RequestData;
import com.fire.reader.mvp.view.IListView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/17.
 */

public class ListViewPresenter extends BasePresenter<IListView> {
    private IRequestData mRequestBiz;
    private Handler mHandler;

    public ListViewPresenter(IListView iListView) {
        super(iListView);
        mRequestBiz = new RequestData();
        mHandler = new Handler();
    }

    public void updateList() {
        if (mView == null) {
            return;
        }
        mView.showLoading();
        mRequestBiz.requestForData(new OnRequestListener() {
            @Override
            public void onSuccess(final List<String> data) {
                //在子线程中请求数据，所以要在 main 线程中更新 UI
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mView == null) {
                            return;
                        }
                        mView.hideLoading();
                        mView.setListItem(data);
                    }
                });
            }

            @Override
            public void onFailed() {
                //这里也是子线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mView == null) {
                            return;
                        }
                        mView.hideLoading();
                        mView.showMessage("请求失败");
                    }
                });
            }
        });
    }

    public void onItemClick(int position) {
        if (mView == null) {
            return;
        }
        mView.showMessage("点击了item" + (position + 1));
    }
}
