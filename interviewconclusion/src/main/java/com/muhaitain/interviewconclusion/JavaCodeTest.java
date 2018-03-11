package com.muhaitain.interviewconclusion;

import android.graphics.BitmapFactory;
import android.util.Log;

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

    public static void stringTest(){
        String str="muhaitian";
        String str1="muhaitian";
        String str2=new String("wangkang");
        String str3=new String("wangkang");
        Log.d(TAG, "stringTest: str==str1: "+(str==str1));
        Log.d(TAG, "stringTest: str1==str2: "+(str2==str3));
    }
}
