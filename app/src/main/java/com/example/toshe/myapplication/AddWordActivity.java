package com.example.toshe.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddWordActivity extends ActionBarActivity {

    EditText textWordEn, textWordBg;
    Button buttSaveWords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        textWordBg = (EditText) findViewById(R.id.textWordBg);

        textWordEn = (EditText) findViewById(R.id.textWordEn);

        buttSaveWords = (Button) findViewById(R.id.buttSaveWord);
        buttSaveWords.setOnClickListener(buttSaveWordLitener);

    }

    private View.OnClickListener buttSaveWordLitener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String u


            Intent intent = new Intent(AddWordActivity.this, AddWordActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_word, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
