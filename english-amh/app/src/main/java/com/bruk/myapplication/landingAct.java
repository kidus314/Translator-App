package com.bruk.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class landingAct extends AppCompatActivity {

   private Button button1;
    private Button button2;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landingpage);

        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),MainActivity.class);
                startActivity(myIntent);
           finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),Aboutdevs.class);
                startActivity(myIntent);
                finish();
            }
        });

    }




    @Override
    public void onBackPressed()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(  landingAct.this);


        builder.setMessage("Do you want to exit ?");


        builder.setTitle("Alert /ማንቂያ");


        builder.setCancelable(false);


        builder.setPositiveButton(
                "Yes/አዎ",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {


                        finish();
                    }
                });


        builder.setNegativeButton(
                "No,/አይ",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {


                        dialog.cancel();
                    }
                });


        AlertDialog alertDialog = builder.create();


        alertDialog.show();
    }
}