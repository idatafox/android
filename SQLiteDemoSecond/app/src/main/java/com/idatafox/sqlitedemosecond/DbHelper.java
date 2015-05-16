package com.idatafox.sqlitedemosecond;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jakelee on 15-4-19.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="DEMODB.db";
    private static final String TABLE_NAME="employee";
    private static final int  DATABASE_VERSION=1;
    private static final String UID="_id";
    private static final String NAME="Name";
    private static final String create_table="create table "+TABLE_NAME+" ("+UID+" integer primary key autoincrement,"+NAME+" VARCHAR(255));";
    private static final String drop_table="DROP TABLE IF EXISTS "+TABLE_NAME;
    private  Context context;
    public DbHelper(Context context)
    {
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
        Message.message(context, "DbHelper.newDbHelper!!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Message.message(context, "DbHelper.8888");
        try {
            db.execSQL(create_table);
            Message.message(context,"DbHelper.onCreate");
        } catch (SQLException e) {
             Message.message(context,""+e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL(drop_table);
            onCreate(db);
            Message.message(context,"DbHelper.onUpgrade");
        } catch (SQLException e) {
            Message.message(context,""+e);
        }


    }
}
