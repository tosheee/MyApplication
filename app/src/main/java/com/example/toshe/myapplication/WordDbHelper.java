package com.example.toshe.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by toshe on 4.11.2015 г..
 */
public class WordDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "WORDS.DB";
    private static final int DATABASE_VERSION = 1;

    public static final String CREATE_QUERY =
    "CREATE TABLE "+ WordsList.AddNewWord.TABLE_NAME+"("+ WordsList.AddNewWord.WORD_EN+" TEXT,"+ WordsList.AddNewWord.WORD_BG+" TEXT);";


    public WordDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE_OPERATIONS", "Database created / opened...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_QUERY);
        Log.e("DATABASE_OPERATIONS","Table created...");
    }

   public void RecordWord(String word_en, String word_bg, SQLiteDatabase db){

   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
