package com.example.najm.sudoku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by najm on 02/16/2017.
 */
public class Nouveau_jeu extends ActionBarActivity {


    static int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgame);

        Button facile = (Button) findViewById(R.id.facile);
        facile.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(Nouveau_jeu.this, Jeu.class);
                                          setNumber(40);
                                          startActivity(intent);
                                      }


                                  }

        );
        Button moyen = (Button) findViewById(R.id.moyen);
        moyen.setOnClickListener(new View.OnClickListener(){
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent = new Intent(Nouveau_jeu.this,Jeu.class);
                                               setNumber(50);
                                               startActivity(intent);
                                           }


                                       }

        );
        Button difficile = (Button) findViewById(R.id.difficile);
        difficile.setOnClickListener(new View.OnClickListener(){
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent = new Intent(Nouveau_jeu.this,Jeu.class);
                                               setNumber(60);
                                               startActivity(intent);
                                           }


                                       }

        );
    }
    public static int getNumber() {
        return number;
    }
    public static void setNumber(int number) {
        Nouveau_jeu.number = number;
    }
}

