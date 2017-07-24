package com.fire.reader.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.fire.reader.R;
import com.fire.reader.adapter.PagerFragmentAdapter;
import com.fire.reader.mvp.presenter.BasePresenter;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/24.
 */

public abstract class BaseTabActivity<V, T extends BasePresenter<V>> extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;

    public PagerFragmentAdapter fragmentAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_tab;
    }

    @Override
    public void initView() {
        fragmentAdapter = new PagerFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(fragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
