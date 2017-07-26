package com.fire.reader.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.fire.reader.R;
import com.fire.reader.view.TouchButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/26.
 */

public class TouchActivity extends AppCompatActivity {

    private static final String TAG = TouchActivity.class.getSimpleName();

    @BindView(R.id.btn_touch)
    TouchButton btnTouch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_touch);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_touch)
    public void onViewClicked() {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("TAGTAG",TAG + " --> dispatchTouchEvent() --> ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("TAGTAG",TAG + " --> dispatchTouchEvent() --> ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("TAGTAG",TAG + " --> dispatchTouchEvent() --> ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("TAGTAG",TAG + " --> onTouchEvent() --> ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("TAGTAG",TAG + " --> onTouchEvent() --> ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("TAGTAG",TAG + " --> onTouchEvent() --> ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();

        Log.e("TAGTAG",TAG + " --> onUserInteraction() --> ACTION_DOWN 后调用");
    }

    /**
     *  View 的事件传递是从activity传递到view的
     07-26 16:36:42.480 14167-14167/com.fire.reader E/TAGTAG: TouchActivity --> dispatchTouchEvent() --> ACTION_DOWN
     07-26 16:36:42.480 14167-14167/com.fire.reader E/TAGTAG: TouchButton --> dispatchTouchEvent() --> ACTION_DOWN
     07-26 16:36:42.480 14167-14167/com.fire.reader E/TAGTAG: TouchButton --> onTouchEvent() --> ACTION_DOWN
     07-26 16:36:42.500 14167-14167/com.fire.reader E/TAGTAG: TouchActivity --> dispatchTouchEvent() --> ACTION_MOVE
     07-26 16:36:42.500 14167-14167/com.fire.reader E/TAGTAG: TouchButton --> dispatchTouchEvent() --> ACTION_MOVE
     07-26 16:36:42.500 14167-14167/com.fire.reader E/TAGTAG: TouchButton --> onTouchEvent() --> ACTION_MOVE
     07-26 16:36:42.510 14167-14167/com.fire.reader E/TAGTAG: TouchActivity --> dispatchTouchEvent() --> ACTION_MOVE
     07-26 16:36:42.510 14167-14167/com.fire.reader E/TAGTAG: TouchButton --> dispatchTouchEvent() --> ACTION_MOVE
     07-26 16:36:42.510 14167-14167/com.fire.reader E/TAGTAG: TouchButton --> onTouchEvent() --> ACTION_MOVE
     07-26 16:36:42.530 14167-14167/com.fire.reader E/TAGTAG: TouchActivity --> dispatchTouchEvent() --> ACTION_MOVE
     07-26 16:36:42.530 14167-14167/com.fire.reader E/TAGTAG: TouchButton --> dispatchTouchEvent() --> ACTION_MOVE
     07-26 16:36:42.530 14167-14167/com.fire.reader E/TAGTAG: TouchButton --> onTouchEvent() --> ACTION_MOVE
     07-26 16:36:42.530 14167-14167/com.fire.reader E/TAGTAG: TouchActivity --> dispatchTouchEvent() --> ACTION_UP
     07-26 16:36:42.540 14167-14167/com.fire.reader E/TAGTAG: TouchButton --> dispatchTouchEvent() --> ACTION_UP
     07-26 16:36:42.540 14167-14167/com.fire.reader E/TAGTAG: TouchButton --> onTouchEvent() --> ACTION_UP
     */

}
