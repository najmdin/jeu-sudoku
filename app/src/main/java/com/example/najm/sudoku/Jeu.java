package com.example.najm.sudoku;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.najm.sudoku.Resolution.Valeurs_possibles;

import java.util.HashSet;

import static com.example.najm.sudoku.Nouveau_jeu.getNumber;

/**
 * Created by najm on 02/16/2017.
 */
public class Jeu extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        JeuEngine.getInstance().createGrille(this, getNumber());
        CheckBox VP = (CheckBox) findViewById(R.id.VP);
                VP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int[][] sudoku = new int[9][9];
                        int x, y;
                        HashSet<Integer> posValues = new HashSet<>();
                        if (((CheckBox) v).isChecked()) {
                            Valeurs_possibles.VP();
                        } else {
                            Valeurs_possibles.VP1();
                        }
                    }
                });
     Button resol = (Button) findViewById(R.id.resol);
        resol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[][] sudoku = new int[9][9];
                for (int x = 0; x < 9; x++) {
                    for (int y = 0; y < 9; y++) {
                        sudoku[x][y] = (int) JeuEngine.getInstance().getGrille().getItem(y, x).getValeur();}}
                 Valeurs_possibles.Resolution(sudoku);
            }
        } );
    }
}




