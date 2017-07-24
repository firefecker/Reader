package com.fire.reader.ui.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.fire.reader.R;
import com.fire.reader.mvp.presenter.BasePresenter;
import com.fire.reader.utils.StatusBarCompat;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/7/24.
 */

public  abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    public T presenter;
    protected int statusBarColor = 0;
    protected View statusBarView = null;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        init();
        ButterKnife.bind(this);
        presenter = initPresenter();
        initView();

    }

    private void init() {
        if (statusBarColor == 0) {
            statusBarView = StatusBarCompat.compat(this, ContextCompat.getColor(this, R.color.colorPrimaryDark));
        } else if (statusBarColor != -1) {
            statusBarView = StatusBarCompat.compat(this, statusBarColor);
        }
        transparent19and20();
        mContext = this;
    }

    private void transparent19and20() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    public abstract T initPresenter();
    public abstract int getLayout();
    public abstract void initView();

    protected void setToolBar(Toolbar toolbar, String title,boolean flag) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        if (flag) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//添加返回图标
            getSupportActionBar().setDisplayShowHomeEnabled(true);//显示应用程序图标
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
    }

    protected void setToolBar(Toolbar toolbar,boolean flag) {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        if (flag) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);//显示应用程序图标
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//添加返回图标
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
    }

}
