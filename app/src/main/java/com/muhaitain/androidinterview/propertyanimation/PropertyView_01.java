package com.muhaitain.androidinterview.propertyanimation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import android.util.AttributeSet;
import android.view.View;

import com.muhaitain.androidinterview.entity.Point;

import java.util.LinkedHashMap;

/**
 * Created by Muhaitian on 2018/3/16.
 */

public class PropertyView_01 extends View {

    private static final float RADIUS = 70f;//
    private Point currentPoint;
    private Paint mPaint;


    public PropertyView_01(Context context) {
        super(context);
    }

    public PropertyView_01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new Point(10, 500);
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);
            Point startPoint = currentPoint;
            Point endPoint = new Point(800, 1500);
            ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
            anim.setDuration(5000);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    currentPoint = (Point) animation.getAnimatedValue();
                    invalidate();
                }
            });
            anim.start();
        } else {
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);
        }
    }
}
