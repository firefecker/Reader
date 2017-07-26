package com.fire.reader.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;


/**
 * Created by Administrator on 2017/7/26.
 */

public class TouchButton extends Button {

    private static final String TAG = TouchButton.class.getSimpleName();


    public TouchButton(Context context) {
        super(context);
    }

    public TouchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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

}
