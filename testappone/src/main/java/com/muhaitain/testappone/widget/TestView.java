package com.muhaitain.testappone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Muhaitian on 2018/4/9.
 */
public class TestView extends View {
    private static final String TAG = TestView.class.getCanonicalName();

    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent: ");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: ");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "onDraw: ");
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int parentviewWidth = MeasureSpec.getSize(widthMeasureSpec);
        int viewWidth = MeasureSpec.getSize(getMeasuredWidth());
        Log.d(TAG, "onMeasure: parentviewWidth="+parentviewWidth);
        Log.d(TAG, "onMeasure: viewWidth="+viewWidth);
    }
}
