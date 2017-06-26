package com.example.najm.sudoku.Vue.Grille_Sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.Toast;

/**
 * Created by najm on 02/18/2017.
 */
public class Cellule_Sudoku extends Base_Cellule_Sudoku{


    private Paint mPaint;


    public Cellule_Sudoku(Context context) {
        super(context);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        onDrawNumber(canvas);
        onDrawLines(canvas);
    }

    protected void onDrawNumber(Canvas canvas) {

        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);
        Rect Bounds = new Rect();
        mPaint.getTextBounds(String.valueOf(getValeur()), 0, String.valueOf(getValeur()).length(), Bounds);

        if(getValeur()!=0){
            mPaint.setColor(Color.BLACK);
                        canvas.drawText(String.valueOf(getValeur()), (getWidth() - Bounds.width()) / 2, (getHeight() + Bounds.height()) / 2, mPaint);

        }

        if(getValeur2()!=0){
                        mPaint.setColor(Color.GREEN);
                        canvas.drawText(String.valueOf(getValeur2()), (getWidth() - Bounds.width()) / 4, (getHeight() + Bounds.height()) / 4, mPaint);
                    }
        if(getValeurk(0)!=0){
            mPaint.setColor(Color.RED);
             canvas.drawText(String.valueOf(getValeurk(0)), (getWidth() - Bounds.width()) / 2, (getHeight() + Bounds.height()) / 2, mPaint);
            Toast.makeText(getContext(), "non valide nombre", Toast.LENGTH_SHORT).show();
        }

    }


    private void onDrawLines(Canvas canvas) {
    mPaint.setColor(Color.GREEN);
    mPaint.setStrokeWidth(3);
    mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
    }


}
