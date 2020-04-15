package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context) {
        super(context, "COVID-19 Patients DB", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql = "create table PatientTable(";
        sql+="id integer primary key autoincrement, ";
        sql+="name text, date text, ";
        sql+="result text";
        db.execSQL(sql);
    }

    public void insert(String patientName, String date, String result) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into PatientTable values(";
        sql+="null, '"+patientName+"', '"+date+"'";
        sql+=",'"+result+"')";
        db.execSQL(sql);
        db.close();
    }

    public ArrayList<String> getPatients() {
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from PatientTable";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            String name = cursor.getString(1);
            list.add(name);
        }
        db.close();
        return list;
    }

    public String[] get(String name1) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from PatientTable where name = '"+name1+"'";
        Cursor cursor = db.rawQuery(sql, null);
        String[] entry = new String[3];
        if (cursor.moveToFirst()) {
            String name = cursor.getString(1);
            String date = cursor.getString(2);
            String result = cursor.getString(3);
            entry[0]=name1;
            entry[1]=date;
            entry[2]=result;
        }
        db.close();
        return entry;
    }

    public ArrayList<String> getAll() {
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from PatientTable";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            String name = cursor.getString(1);
            String date = cursor.getString(2);
            String result = cursor.getString(3);
            list.add(name);
            list.add(date);
            list.add(result);
        }
        db.close();
        return list;
    }

    public String[] grab(String patientName) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from PatientTable where name = '"+patientName+"'";
        Cursor cursor = db.rawQuery(sql, null);
        String[] entry = new String[10000000];
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            String date = cursor.getString(2);
            String result = cursor.getString(3);
            entry[0]=name;
            entry[1]=date;
            entry[2]=result;
        }
        db.close();
        return entry;
    }

    public void delete(String patientName) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "delete from PatientTable where name = '"+patientName+"'";
        db.execSQL(sql);
        db.close();
    }

    public void updateByTitle(String name, String date, String result) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "update PatientTable set result = '"+result+"'";
        sql+= "where name = '"+name+"'";
        sql+="where date = '"+date+"'";
        db.execSQL(sql);
        db.close();
    }




    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
