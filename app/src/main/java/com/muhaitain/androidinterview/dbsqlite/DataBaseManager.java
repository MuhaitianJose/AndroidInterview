package com.muhaitain.androidinterview.dbsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.muhaitain.androidinterview.entity.Person;

/**
 * Created by Muhaitian on 2018/3/9.
 */

public class DataBaseManager {
    private DbHelper mDbHelper;
    private SQLiteDatabase dbRead;
    private SQLiteDatabase dbWrite;

    public DataBaseManager(Context context) {
        mDbHelper = new DbHelper(context);
        dbRead = mDbHelper.getReadableDatabase();
        dbWrite = mDbHelper.getWritableDatabase();
    }

    public void addPerson(Person person){
        dbWrite.beginTransaction();


    }
}
