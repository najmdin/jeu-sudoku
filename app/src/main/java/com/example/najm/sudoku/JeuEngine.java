package com.example.najm.sudoku;

import android.content.Context;

import com.example.najm.sudoku.Vue.Grille_Sudoku.Grille_jeu;
import static com.example.najm.sudoku.Nouveau_jeu.getNumber;
/**
 * Created by najm on 02/18/2017.
 */
public class JeuEngine {
    private int SelectX = -1,SelectY = -1;
    private static JeuEngine instance;
    private static Grille_jeu grille = null;
    private JeuEngine(){}

    public static JeuEngine getInstance() {
        if(instance == null)
            instance = new JeuEngine();
        return instance;
    }

    public void createGrille(Context context,int k){
        int[][] Sudoku = SudokuGenerateur.getInstance().GenerateurGrille();
        Sudoku = SudokuGenerateur.getInstance().supprimerElements(Sudoku,getNumber());
        grille = new Grille_jeu(context);
        grille.setGrille(Sudoku);
    }

    public static Grille_jeu getGrille() {
        return grille;
    }

    public void setSelectPosition(int x,int y){
        SelectX = x;
        SelectY = y;
    }

    public void setNumber(int number){
        if(SelectX !=-1 &&SelectY !=-1){
            grille.setItem(SelectX,SelectY,number);
        }


    }
}
