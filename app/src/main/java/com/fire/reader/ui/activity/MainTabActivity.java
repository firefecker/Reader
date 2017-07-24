package com.fire.reader.ui.activity;

import com.fire.reader.mvp.presenter.BasePresenter;
import com.fire.reader.mvp.presenter.IMainTabPresenter;
import com.fire.reader.mvp.view.IMainTabView;
import com.fire.reader.ui.fragment.BookShelfFragment;

/**
 * Created by Administrator on 2017/7/24.
 */

public class MainTabActivity extends BaseTabActivity<IMainTabView,IMainTabPresenter> implements IMainTabView {

    private BookShelfFragment fragment1;
    private BookShelfFragment fragment2;
    private BookShelfFragment fragment3;

    @Override
    public BasePresenter initPresenter() {
        return new IMainTabPresenter(this);
    }

    @Override
    public void initView() {
        super.initView();
        setToolBar(toolbar,"Reader",false);
        fragment1 = new BookShelfFragment();
        fragment2 = new BookShelfFragment();
        fragment3 = new BookShelfFragment();
        fragmentAdapter.addFragment(fragment1,"书架");
        fragmentAdapter.addFragment(fragment2,"社区");
        fragmentAdapter.addFragment(fragment3,"发现");
        fragmentAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
