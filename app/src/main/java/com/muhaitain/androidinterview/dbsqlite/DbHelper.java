package com.muhaitain.androidinterview.dbsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Muhaitian on 2018/3/9.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG = DbHelper.class.getSimpleName();
    private static final String DATA_BASE_NAME = "Demo.db";
    private static final int DATA_BASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE = "create table if not exists " + TestTable.TABLE_NAME + "(" + TestTable._ID + " integer primary key autoincrement, "
            + TestTable.COL_NAME + " varchar, "
            + TestTable.COL_AGE + " integer, "
            + TestTable.COL_INFO + " text)";

    private static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS" + TestTable.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: oldVersion=" + oldVersion + " | newVersion=" + newVersion);
        db.execSQL(SQL_DELETE_TABLE);

        onCreate(db);
    }

    public class TestTable implements BaseColumns {
        public static final String TABLE_NAME = "person_info";
        public static final String COL_NAME = "name";
        public static final String COL_AGE = "age";
        public static final String COL_INFO = "info";
    }


}
