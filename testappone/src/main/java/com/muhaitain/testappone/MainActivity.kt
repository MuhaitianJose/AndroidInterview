package com.muhaitain.testappone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        testViewGroup.setOnClickListener(View.OnClickListener {
//            Log.d("MainActivity","kkkk")
//        })
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.d("MainActivity","dispatchTouchEvent: ")
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d("MainActivity","onTouchEvent: ")
        return super.onTouchEvent(event)
    }
}
