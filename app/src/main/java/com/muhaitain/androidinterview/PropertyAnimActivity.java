package com.muhaitain.androidinterview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Muhaitian on 2018/3/12.
 */

public class PropertyAnimActivity extends AppCompatActivity {

    private static final String TAG = PropertyAnimActivity.class.getSimpleName();
    private HandlerA handlerA;
    private HandlerB handlerB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_property_anim);
        test_property_anim_ofint();
        objectAnimator_test();
        testHandler();
    }

    private void testHandler(){
        handlerA = new HandlerA();
        handlerB = new HandlerB();
//        Log.d(TAG, "testHandler: handlerA.sendEmptyMessage(123)");
//        handlerA.sendEmptyMessage(123);
//        Log.d(TAG, "testHandler: handlerB.sendEmptyMessage(123)");
//        handlerB.sendEmptyMessage(234);
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
    }

    class HandlerA extends Handler{
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessageA: what="+msg.what);
            super.handleMessage(msg);
        }
    }
    class HandlerB extends Handler{
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessageB: what="+msg.what);
            super.handleMessage(msg);
        }
    }

    /**
     * // ValueAnimator采用<animator> 标签
     * <animator xmlns:android="http://schemas.android.com/apk/res/android"
     * android:valueFrom="0" // 初始值
     * android:valueTo="100" // 结束值
     * android:valueType="intType" // 变化值类型 ：floatType & intType
     * android:duration="3000" // 动画持续时间（ms），必须设置，动画才有效果
     * android:startOffset ="1000" // 动画延迟开始时间（ms）
     * android:fillBefore = “true” // 动画播放完后，视图是否会停留在动画开始的状态，默认为true
     * android:fillAfter = “false” // 动画播放完后，视图是否会停留在动画结束的状态，优先于fillBefore值，默认为false
     * android:fillEnabled= “true” // 是否应用fillBefore值，对fillAfter值无影响，默认为true
     * android:repeatMode= “restart” // 选择重复播放动画模式，restart代表正序重放，reverse代表倒序回放，默认为restart|
     * android:repeatCount = “0” // 重放次数（所以动画的播放次数=重放次数+1），为infinite时无限重复
     * android:interpolator = @[package:]anim/interpolator_resource /> // 插值器，即影响动画的播放速度,下面会详细讲
     */
    private void test_property_anim_ofint() {
        final Button button = findViewById(R.id.bt_value_animator_ofint);
        //设置属性数值初始值&结束值
        ValueAnimator valueAnimator = ValueAnimator.ofInt(button.getLayoutParams().width, (int) (400 * 3.5));
        // 初始值 = 当前按钮的宽度，此处在xml文件中设置为(400*3.5)
        // 结束值 = (500*3.5)
        // ValueAnimator.ofInt()内置了整型估值器,直接采用默认的.不需要设置
        // 即默认设置了如何从初始值(400*3.5) 过渡到 结束值(500*3.5)

        //设置动画的播放各种属性
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int width = (int) animation.getAnimatedValue();
//                Log.d(TAG, "onAnimationUpdate: width=" + width);
                button.getLayoutParams().width = width;
                button.requestLayout();
            }
        });

        valueAnimator.start();
    }

    private void objectAnimator_test() {
        Button alphaButton = findViewById(R.id.bt_ObjectAnimator_alpha);
        ObjectAnimator animator_alpha = ObjectAnimator.ofFloat(alphaButton, "alpha", 1f, 0f, 1f);
        animator_alpha.setDuration(5000);
        animator_alpha.setRepeatCount(ValueAnimator.INFINITE);
        animator_alpha.start();

        Button rotationButton = findViewById(R.id.bt_ObjectAnimator_rotation);
        ObjectAnimator animator_rotation = ObjectAnimator.ofFloat(rotationButton, "rotation", 0f, 360f);
        animator_rotation.setDuration(5000);
        animator_rotation.setRepeatCount(ValueAnimator.INFINITE);
        animator_rotation.start();

        Button scaleXButton = findViewById(R.id.bt_ObjectAnimator_scaleX);
        ObjectAnimator animator_scaleX = ObjectAnimator.ofFloat(scaleXButton, "scaleX", 1f, 3f, 1f);
        animator_scaleX.setDuration(5000);
        animator_scaleX.setRepeatCount(ValueAnimator.INFINITE);
        animator_scaleX.start();

        Button translationXButton = findViewById(R.id.bt_ObjectAnimator_translationX);
        float curTranslationX = translationXButton.getTranslationX();
        ObjectAnimator animator_translationX = ObjectAnimator.ofFloat(translationXButton, "translationX", curTranslationX, 300f, curTranslationX);
        animator_translationX.setDuration(5000);
        animator_translationX.setRepeatCount(ValueAnimator.INFINITE);
        animator_translationX.start();
    }

}
