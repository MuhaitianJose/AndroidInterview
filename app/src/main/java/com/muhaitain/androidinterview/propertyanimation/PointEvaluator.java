package com.muhaitain.androidinterview.propertyanimation;

import android.animation.TypeEvaluator;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.muhaitain.androidinterview.entity.Point;

/**
 * Created by Muhaitian on 2018/3/16.
 */

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction*(endPoint.getX()-startPoint.getX());
        float y = startPoint.getY() + fraction*(endPoint.getY()-startPoint.getY());
        Point point = new Point(x,y);
        return point;
    }
}
