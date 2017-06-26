package com.example.najm.sudoku.Vue.Grille_Sudoku;

import android.content.Context;
import android.view.View;

/**
 * Created by najm on 02/19/2017.
 */
public class Base_Cellule_Sudoku extends View {

    private int valeur;
    private boolean modifiable = true;
    private long valeur2 ;
    private int valeurk;

    public Base_Cellule_Sudoku(Context context) {
        super(context);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
    public void setNonModifiable() {
        this.modifiable = false;
    }

    public void setValeurInitial(int valeur){
        this.valeur = valeur;
        invalidate();
    }
    public long getValeur2() {
                return valeur2;
            }

    public int getValeur() {
        return valeur;
    }
    public int getValeurk(int i) {
        return valeurk;
    }

    public void setValeur(int valeur) {

        if(modifiable)
        this.valeur = valeur;
        invalidate();
    }
    public void setValeur2(long k) {
        if(modifiable)
            this.valeur2 = k;
        invalidate();
    }

    public void setValeurk(int number, int i) {
        if(modifiable)
            this.valeurk = number;
        invalidate();
    }
}
