package com.example.myquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//Code for result UI alert box after submitting
public class RA extends AppCompatActivity {
    private AlertDialog.Builder alertdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        final Button startBtn5=findViewById(R.id.button3);

        startBtn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //alert box code
                alertdialog   = new AlertDialog.Builder(RA.this);
                alertdialog.setTitle("That was an Excellent Match");
                alertdialog.setMessage("Do you want to play it again?");
                //when this is given it will return to main_activity file
                alertdialog.setPositiveButton("Play_again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(RA.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                //it will end the app
                alertdialog.setNegativeButton("Session_end", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                });
                alertdialog.show();
            }
        });

    }
    public void openDialog(){
        DC dialogClass = new DC();
        dialogClass.show(getSupportFragmentManager(), "show");
    }

}

