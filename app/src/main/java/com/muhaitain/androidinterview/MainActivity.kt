package com.muhaitain.androidinterview

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Start_second_activity.setOnClickListener{
            var intent = Intent()
            var com = ComponentName(
                    this,
                    PropertyAnimActivity::class.java
            )
            intent.component = com
            startActivity(intent)
        }
    }

}
