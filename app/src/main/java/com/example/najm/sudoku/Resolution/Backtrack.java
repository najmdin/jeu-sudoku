package com.example.najm.sudoku.Resolution;

/**
 * Created by najm on 04/11/2017.
 */

    public class Backtrack {

                    private static int nb =0;

        static boolean absentSurLigne(int k, int[][] grille, int i)
        {
            for (int j=0; j < 9; j++)
                if (grille[i][j] == k)
                    return false;
            return true;
        }

        static boolean absentSurColonne(int k, int[][] grille, int j)
        {
            for (int i=0; i < 9; i++)
                if (grille[i][j] == k)
                    return false;
            return true;
        }

        static boolean absentSurBloc(int k, int[][] grille, int i, int j)
        {
            int _i = i-(i%3), _j = j-(j%3);  // ou encore : _i = 3*(i/3), _j = 3*(j/3);
            for (i=_i; i < _i+3; i++)
                for (j=_j; j < _j+3; j++)
                    if (grille[i][j] == k)
                        return false;
            return true;
        }
        public static boolean estValide(int[][] grille, int position)
        {    nb++;
            if (position == 9*9)
                return true;

            int i = position/9, j = position%9;

            if (grille[i][j] != 0){

                return estValide(grille, position+1);}

            for (int k=1; k <= 9; k++)
            {
                if (absentSurLigne(k,grille,i) && absentSurColonne(k,grille,j) && absentSurBloc(k,grille,i,j))
                {
                    grille[i][j] = k;

                    if ( estValide (grille, position+1) )
                        return true;
                }
            }
            grille[i][j] = 0;

            return false;
        }

                          public   static int maine(int[][] gri, int x, int y) {

                              estValide(gri, 0);
                                    return gri[x][y];

                                }
    public   static int nbr(int[][] gri, int x, int y) {
        nb=0;
        estValide(gri, 0);

        System.out.print("le nbr est "+nb);

        return nb;

    }





            }


