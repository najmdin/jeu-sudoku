package com.example.najm.sudoku.Vue.Grille_Sudoku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.najm.sudoku.JeuEngine;

/**
 * Created by najm on 02/18/2017.
 */
public class SudokuGrille extends GridView {
    private final Context context;

    static int x;
    static int y;
    public SudokuGrille(final Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        SudokuGrilleAdapter GrilleAdapter = new SudokuGrilleAdapter(context);
        setAdapter(GrilleAdapter);
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 x = position%9;
                y = position/9;
                JeuEngine.getInstance().setSelectPosition(x,y);
                Toast.makeText(context,"Select item x="+x+" y= "+y,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    class SudokuGrilleAdapter extends BaseAdapter {


                    private Context context;

                    public SudokuGrilleAdapter(Context context) {
                    this.context = context;
                }

                    @Override
            public int getCount() {
                    return 81;
                }

                    @Override
            public Object getItem(int position) {
                    return null;
                }

                    @Override
            public long getItemId(int position) {
                    return 0;
                }

                   @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                  return JeuEngine.getInstance().getGrille().getItem(position);
                }
        }
}
