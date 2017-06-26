package com.example.najm.sudoku.Vue.Bottons;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.example.najm.sudoku.R;

/**
 * Created by najm on 02/19/2017.
 */
public class Grille_Button extends GridView{
    public Grille_Button(Context context,AttributeSet attributes) {
        super(context,attributes);

        Grille_Button_Adapter grilleAdapter = new Grille_Button_Adapter(context);
        setAdapter(grilleAdapter);

    }

    class Grille_Button_Adapter extends BaseAdapter{

        private Context context;
        public Grille_Button_Adapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if(v == null ){
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                v = inflater.inflate(R.layout.button,parent,false);

                NumeroButton btn = (NumeroButton)v;
                btn.setId(position);
                if(position != 9) {
                    btn.setText(String.valueOf(position + 1));
                    btn.setNumber(position+1);
                }else {
                    btn.setTextSize(10);
                    btn.setText(String.valueOf("Supp"));
                    btn.setNumber(0);

                }
            return btn;
            }
            return v;
        }
    }

}
