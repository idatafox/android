package com.idatafox.sqlitedemosecond;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jakelee on 15-4-19.
 */
public class Message {

    public static void message(Context context,String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
