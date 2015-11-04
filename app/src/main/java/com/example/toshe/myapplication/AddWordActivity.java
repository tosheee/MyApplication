package com.example.toshe.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AddWordActivity extends ActionBarActivity {

    EditText textWordEn, textWordBg;
    Button buttSaveWords, buttReturMenu, buttViewWords;
    TextView textLabelBg, textLabelEn;
    WordDb wordDb = new WordDb(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        textWordBg = (EditText) findViewById(R.id.textWordBg);
        textWordEn = (EditText) findViewById(R.id.textWordEn);

        buttSaveWords = (Button) findViewById(R.id.buttSaveWords);
        buttSaveWords.setOnClickListener(buttSaveWordLitener);

        buttReturMenu = (Button) findViewById(R.id.buttReturnMenu);
        buttReturMenu.setOnClickListener(buttReturMenuLitener);


        textLabelBg = (TextView) findViewById(R.id.textLabelBg);
        textLabelEn = (TextView) findViewById(R.id.textLabelEn);
        }

    private View.OnClickListener buttSaveWordLitener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String wordEn = textWordEn.getText().toString();
            String wordBg = textWordBg.getText().toString();
            if(wordEn.isEmpty()) {
                textLabelEn.setText("Моля, попълнете полет");
            }else if(wordBg.isEmpty()){
            textLabelBg.setText("Моля, попълнете полето");
            }else
            wordDb.createRecord(wordEn, wordBg);
            Intent intent = new Intent(AddWordActivity.this, AddWordActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener buttReturMenuLitener = new View.OnClickListener(){
       public void onClick(View v){
         Intent intent = new Intent(AddWordActivity.this, MainActivity.class);
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
