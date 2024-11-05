package com.bruk.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    Databasehelper databasehelper;
    RecyclerView definitionListView;
    EditText searchBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Initialize database
        databasehelper = new Databasehelper(this);
        try {
            databasehelper.createDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        databasehelper.openDataBase();

        searchBar = findViewById(R.id.searchBar);
        searchBar.addTextChangedListener(this);
        definitionListView = findViewById(R.id.definitionListView);
        definitionListView.setLayoutManager(new LinearLayoutManager(this));

        // Populate
        String query = "SELECT * FROM dictionary where _id LIKE ?;";
        String[] args = {""+"%"};
        Cursor cursor = databasehelper.getReadableDatabase().rawQuery(query, args);
        ArrayList<Definition> definitions = new ArrayList();
        while (cursor.moveToNext()) {
            Definition d = new Definition();
            d.amharicWord = cursor.getString(2);
            d.englishWord = cursor.getString(0);
            d.englishDefinition = cursor.getString(1);
            definitions.add(d);
        }
        SearchListAdapter adapter = new SearchListAdapter(definitions, this);
        definitionListView.setAdapter(adapter);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String query = "SELECT * FROM dictionary where _id LIKE ?;";
        String[] args = {searchBar.getText().toString()+"%"};
        Cursor cursor = databasehelper.getReadableDatabase().rawQuery(query, args);
        ArrayList<Definition> definitions = new ArrayList();
        while (cursor.moveToNext()) {
            Definition d = new Definition();
            d.amharicWord = cursor.getString(2);
            d.englishWord = cursor.getString(0);
            d.englishDefinition = cursor.getString(1);
            definitions.add(d);
        }
        SearchListAdapter searchListAdapter = (SearchListAdapter) definitionListView.getAdapter();
        searchListAdapter.setDefinitionList(definitions);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

  @Override
    public void onBackPressed()
    {
        Intent myIntent = new Intent(MainActivity.this,landingAct.class);
        startActivity(myIntent);
        finish();

    }
}