package com.example.toshe.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public static void alaba(){

    }
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
       ContentValues contentValues = new ContentValues();
       contentValues.put(WordsList.AddNewWord.WORD_EN,word_en);
       contentValues.put(WordsList.AddNewWord.WORD_BG,word_bg);
       db.insert(WordsList.AddNewWord.TABLE_NAME,null,contentValues);
       Log.e("DATABASE_OPERATIONS","One row insert...");
   }

    public Cursor getWords(SQLiteDatabase db){
        Cursor cursor;
        String [] projections = {WordsList.AddNewWord.WORD_EN, WordsList.AddNewWord.WORD_BG};
        cursor = db.query(WordsList.AddNewWord.TABLE_NAME, projections,null,null,null,null,null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
