package com.muhaitain.testappone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Muhaitian on 2018/4/9.
 */
public class TestViewGroup extends LinearLayout {

    private static final String TAG = TestViewGroup.class.getCanonicalName();

    public TestViewGroup(Context context) {
        super(context);
    }

    public TestViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentviewWidth = MeasureSpec.getSize(widthMeasureSpec);
        int viewWidth = MeasureSpec.getSize(getMeasuredWidth());
        Log.d(TAG, "onMeasure: parentviewWidth="+parentviewWidth);
        Log.d(TAG, "onMeasure: viewWidth="+viewWidth);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d(TAG, "onLayout: l=" + l + " t=" + t + " r=" + r + " b=" + b);
        View view = getChildAt(0);
        int viewWidth = view.getMeasuredWidthAndState();
        int viewHeight = view.getMeasuredHeightAndState();
        int left = getPaddingLeft();
        view.layout(left, t, left + viewWidth, t + viewHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "onDraw: ");
        super.onDraw(canvas);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent: mm");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent: hh");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: tt");
        return false;
    }
}
