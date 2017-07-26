package com.fire.reader.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fire.reader.R;
import com.fire.reader.callback.DaggerCompinent;
import com.fire.reader.callback.DaggerDaggerCompinent;
import com.fire.reader.entity.Cloth;
import com.fire.reader.entity.Shoe;
import com.fire.reader.module.DaggerModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/25.
 */

public class DaggerActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;

    //第一种方式
    @Inject
    Cloth cloth;

    //第二种方式，两者使用场景不同
    @Inject
    Shoe shoe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        ButterKnife.bind(this);

        DaggerCompinent build = DaggerDaggerCompinent.builder().daggerModule(new DaggerModule()).build();
        build.inject(this);

        tv.setText("我现在有" + cloth + "和" + shoe.toString());
    }
}
