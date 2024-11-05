package com.bruk.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.widget.TextView;

public class DefinitionActivity extends AppCompatActivity {

    private Definition definition;
    private TextView amharicWord;
    private TextView englishWord;
    private TextView definitionView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);
        definition = getIntent().getParcelableExtra("definition");
        definitionView = findViewById(R.id.definition);
        amharicWord = findViewById(R.id.amharicWord);
        englishWord = findViewById(R.id.englishWord);


        definitionView.setText(definition.englishDefinition);
        amharicWord.setText(definition.amharicWord);
        englishWord.setText(definition.englishWord);
    }


}