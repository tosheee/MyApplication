package com.example.toshe.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class WordListActivity extends ActionBarActivity {
    ListView listWord;
    SQLiteDatabase sqLiteDatabase;
    WordDbHelper wordDbHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list_layout);
        listWord = (ListView)findViewById(R.id.list_item);
        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.row_layout);
        wordDbHelper = new WordDbHelper(getApplicationContext());
        listWord.setAdapter(listDataAdapter);

        sqLiteDatabase = wordDbHelper.getReadableDatabase();
        cursor = wordDbHelper.getWords(sqLiteDatabase);
        if(cursor.moveToFirst()){
            do{
                String wordEn, wordBg;
                wordEn = cursor.getString(0);
                wordBg = cursor.getString(1);
                DataProvider dataProvider = new DataProvider(wordEn, wordBg);
                listDataAdapter.add(dataProvider);
            }while(cursor.moveToNext());
        }
    }

}
