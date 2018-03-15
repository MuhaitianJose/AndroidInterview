package com.muhaitain.interviewconclusion;

import android.graphics.BitmapFactory;
import android.util.Log;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Muhaitian on 11/03/2018.
 */

public class JavaCodeTest {
    private static final String TAG = JavaCodeTest.class.getSimpleName();

    public static void integerTest() {
        Integer a = new Integer(128);
        Integer b = new Integer(128);
        Integer c = 127;
        Integer d = 127;

        Log.d(TAG, "integerTest: a==b：" + (a == b));
        Log.d(TAG, "integerTest: c==d：" + (c == d));

    }
    HashMap
    public static void stringTest(){
        String str="muhaitian";
        String str1="muhaitian";
        String str2=new String("wangkang");
        String str3=new String("wangkang");
        Log.d(TAG, "stringTest: str==str1: "+(str==str1));
        Log.d(TAG, "stringTest: str1==str2: "+(str2==str3));
    }
    class A{
        private Date mDate;

        public Date getDate() {
            return mDate;
        }

        public void setDate(Date mDate) {
            this.mDate = mDate;
        }
    }
}
