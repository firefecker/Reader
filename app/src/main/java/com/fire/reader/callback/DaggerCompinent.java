package com.fire.reader.callback;

import com.fire.reader.module.DaggerModule;
import com.fire.reader.ui.activity.DaggerActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/7/25.
 */
@Component(modules=DaggerModule.class)
public interface DaggerCompinent {
    void inject(DaggerActivity daggerActivity);
}
