package com.example.login_register;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_test extends SQLiteOpenHelper {

    public static final String DBNAME="Login.db";

    public SQLite_test(Context context) {
        super(context, "Login.db", null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase myDB) {
    myDB.execSQL("CREATE TABLE account(user VARCHAR(200) primary key, password VARCHAR(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
    myDB.execSQL("drop table if exists account");

    }
    public Boolean insertData(String user, String password){
        SQLiteDatabase myDB =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user",user);
        contentValues.put("password",password);
        long result=myDB.insert("account",null, contentValues);
        if(result == -1) return false;
        else
        return true;
    }
    public Boolean checkuser(String user){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select *from account where user=? ", new String[]{user});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkpassword(String user, String password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select *from account where user=? and password=?",new String[]{user,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
