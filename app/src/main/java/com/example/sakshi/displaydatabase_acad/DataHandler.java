package com.example.sakshi.displaydatabase_acad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.example.sakshi.displaydatabase_acad.R.id.last;

/**
 * Created by sakshi on 9/9/2017.
 */

public class DataHandler extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME="DataBase";        //create database name
    public static  final String TABLE_NAME="EmployeeData";       //create table name
    public static  final String KEY_FIRST="First_name";                  //col2
    public static final String KEY_lAST="Last_name";
    public static final String KEY_ID ="id" ;
    private Context context;
    public static  final int DATABASE_VERSON=1;             //optional
    public DataHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSON);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(Id INTEGER PRIMARY KEY AUTOINCREMENT, First_name TEXT , Last_name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);

    }
    public boolean insert_Data(String first,String last)
    {
        SQLiteDatabase db=getWritableDatabase();            //to write data into the table
        ContentValues values=new ContentValues();
        Data data = new Data();
        values.put(KEY_FIRST,first);             //putting the values into ContentValue
        values.put(KEY_lAST,last);
        values.put(KEY_ID,data.getId());
        long res=db.insert(TABLE_NAME,null,values);     //Create a temp variable
        if(res==-1)
        {
            return  false;      //if data is not inserted return false
        }
        else
        {
            return  true;           //else return true
        }
    }
    public ArrayList<Data> getAlldata(){

        ArrayList<Data> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from "+TABLE_NAME+" order by id";
        Cursor cursor = db.rawQuery(query,null);
        Data data = null;
        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                data = new Data();
                data.setFirst_name(cursor.getString(1));
                data.setLast_name(cursor.getString(2));
                data.setId(cursor.getString(0));
                list.add(data);

            }while(cursor.moveToNext());
        }
        return list;
    }
}
