package com.example.najm.sudoku.Vue.Grille_Sudoku;

import android.content.Context;

import com.example.najm.sudoku.JeuEngine;
import com.example.najm.sudoku.Resolution.Backtrack;

/**
 * Created by najm on 02/19/2017.
 */
public class Grille_jeu {

    private static  Cellule_Sudoku[][] Sudoku = new Cellule_Sudoku[9][9];

    public Grille_jeu(Context context) {
        for(int x = 0;x < 9; x++ ){
            for(int y = 0;y < 9; y++ ){
                Sudoku[x][y] = new Cellule_Sudoku(context);
            }
        }
    }

    public static  Cellule_Sudoku[][] getGrille() {
        return Sudoku;
    }

    public void setGrille(int[][] grille) {
        for(int x = 0;x < 9; x++ ){
            for(int y = 0;y < 9; y++ ){
                Sudoku[x][y].setValeurInitial(grille[x][y]);
                if(grille[x][y] !=0)
                    Sudoku[x][y].setNonModifiable();
            }
        }
    }

    public Cellule_Sudoku getItem(int x,int y){
        return Sudoku[x][y];
    }

    public Cellule_Sudoku getItem2(int x,int y){
                return Sudoku[x][y];
            }

    public Cellule_Sudoku getItem(int position){
        int x = position%9;
        int y = position/9;
        return Sudoku[x][y];
    }

    public void setItem(int X, int Y, int number) {
        Sudoku[X][Y].setValeur(number);
        int[][]tmp = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tmp[i][j] = (int) JeuEngine.getInstance().getGrille().getItem(j, i).getValeur();
            }
        }
        if(!Backtrack.estValide(tmp, 0)){
            Sudoku[X][Y].setValeur(0);
        Sudoku[X][Y].setValeurk(number,0);}
        if(number==0){
            Sudoku[X][Y].setValeur(0);
            Sudoku[X][Y].setValeurk(0,0);
        }
    }
// Toast.makeText(context, "faux", Toast.LENGTH_SHORT).show();    }

    public void setItem2(int X, int Y, long number) {
        Sudoku[X][Y].setValeur2(number);}
}
