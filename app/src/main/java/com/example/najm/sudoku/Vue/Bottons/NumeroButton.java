package com.example.najm.sudoku.Vue.Bottons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.example.najm.sudoku.JeuEngine;

/**
 * Created by najm on 02/19/2017.
 */
public class NumeroButton extends Button implements View.OnClickListener {


    private int Number;
    public NumeroButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        JeuEngine.getInstance().setNumber(Number);
    }

    public void setNumber(int number) {
        Number = number;
    }
}
