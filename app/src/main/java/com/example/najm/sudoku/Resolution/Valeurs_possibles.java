package com.example.najm.sudoku.Resolution;
import com.example.najm.sudoku.JeuEngine;

import java.util.ArrayList;
import java.util.HashSet;

import static com.example.najm.sudoku.Resolution.Backtrack.maine;
import static com.example.najm.sudoku.Resolution.Backtrack.nbr;

/**
 * Created by najm on 04/11/2017.
 */
public class Valeurs_possibles {

    static int N = 9;


    static  ArrayList<HashSet<Integer>> ValDansLigne;

    static  ArrayList<HashSet<Integer>> ValDansCol;

    static  ArrayList<HashSet<Integer>> ValDansReg;



    static int[][] gride =  new int[9][9];
    /*static int[][] grille () {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                gride[x][y] = (int) JeuEngine.getInstance().getGrille().getItem(y, x).getValeur();
            }
        }
        return gride;
    }
*/
    static void printgride(int gride[][]) {
        for (int ligne = 0; ligne < N; ligne++) {
            for (int col = 0; col < N; col++)
                System.out.print(gride[ligne][col]+"|");
            System.out.println();
        }
    }

    static class Cellule {

        int ligne, col;

        public Cellule(int ligne, int col) {
            super();
            this.ligne = ligne;
            this.col = col;
        }
    };


    public static final int SIZE = 9;

    //valeurs des regions
    private static final int REGION1 = 0;
    private static final int REGION2 = 1;
    private static final int REGION3 = 2;
    private static final int REGION4 = 3;
    private static final int REGION5 = 4;
    private static final int REGION6 = 5;
    private static final int REGION7 = 6;
    private static final int REGION8 = 7;
    private static final int REGION9 = 8;




    static HashSet<Integer> posValues = new HashSet<>();

    public static int getReg(int x, int y) {
        if (x < 3) {
            if (y < 3) return REGION1;
            else if (y < 6) return REGION2;
            else return REGION3;
        }
        if (x < 6) {
            if (y < 3) return REGION4;
            else if (y < 6) return REGION5;
            else return REGION6;
        }
        else {
            if (x < 9 && y<3) return REGION7;
            else if (x<9 && y < 6) return REGION8;
            else return REGION9;
        }
    }

    public static void RechercherTousLesCandidats(int[][] easygride) {
// TODO Auto-generated method stub
        int x, y;
        int[][] tmp = easygride;
        boolean cont = false;
        boolean finished = false;
        for (x = 0; x < SIZE; x++) {
            for (y = 0; y < SIZE; y++) {
                posValues = getPosValues(x, y, easygride); // On recherche les coups possible de la cellule.
                if (posValues.size() == 1 && easygride[x][y] == 0) {
                    cont = true;
                   /* System.out.println(x + "," + y + ":" + posValues);*/
                    String k = posValues.toString().replaceAll("\\[", "");
                    String j = k.replaceAll("\\]", "");
                    JeuEngine.getInstance().getGrille().getItem(y, x).setValeur(Integer.parseInt(j));
                }
            }
        }
        for (x = 0; x < SIZE && !finished; x++) {
            for (y = 0; y < SIZE && !finished; y++) {
                posValues = getPosValues(x, y, easygride); // On recherche les coups possible de la cellule.
                if (posValues.size() == 2 && easygride[x][y] == 0 && cont == false) {
            /*si on n'a pas de cellule avec 1 candidat possible c-à-d que la cellule a au plus deux candidats possible*/
                    JeuEngine.getInstance().getGrille().getItem(y, x).setValeur(maine(easygride, x, y));
                    //renvoie une valeur de la case qui possède le moins de candidat possible
                    finished = true;
                    break;

                }
            }
        }
            for (x = 0; x < SIZE && !finished; x++) {
                for (y = 0; y < SIZE && !finished; y++) {
                    posValues = getPosValues(x, y, easygride); // On recherche les coups possible de la cellule.
                    if (posValues.size() == 3 && easygride[x][y] == 0 && cont == false) {
            /*si on n'a pas de cellule avec 1 candidat possible c-à-d que la cellule a au plus deux candidats possible*/
                        JeuEngine.getInstance().getGrille().getItem(y, x).setValeur(maine(easygride, x, y));
                        //renvoie une valeur de la case qui possède le moins de candidat possible
                        finished = true;
                        break;

                    }
                }
        }
    }


     public static void Resolution(int[][] easygride) {
// TODO Auto-generated method stub
        int  x, y  ;
        boolean finished = false;
        for(x=0;x<SIZE && !finished;x++){
            for ( y= 0;y<SIZE && !finished;y++){
                posValues = getPosValues(x, y,easygride); // On recherche les coups possible de la cellule.
                if(easygride[x][y]==0) {
                    RechercherTousLesCandidats(easygride);
                    finished = true;
                    break;
                }
                             }
            }
    }

public static void VP() {
    int[][] sudoku = new int[9][9];
    int[][]tmp = new int[9][9];
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            sudoku[i][j] = (int) JeuEngine.getInstance().getGrille().getItem(j, i).getValeur();
        }
    }
    tmp =sudoku;
    for (int x = 0; x < 9; x++) {
        for (int y = 0; y < 9; y++) {
            if (sudoku[x][y] == 0) {
                posValues = getPosValues(x, y, sudoku);
                Integer[] arr = (Integer[]) posValues.toArray(new Integer[posValues.size()]);
                String k = "";
                for (int i = 0; i < arr.length; i++)
                    k += arr[i];
                JeuEngine.getInstance().getGrille().getItem2(y, x).setValeur2(Long.parseLong(k));

            }
        }
    }

    System.out.println("----------------------"+nbr(tmp, 0, 0));

}

    public static void VP1(){
        int[][] sudoku = new int[9][9];
        for (int x = 0; x < 9; x++) {
        for (int y = 0; y < 9; y++) {
            sudoku[x][y] = (int) JeuEngine.getInstance().getGrille().getItem(y, x).getValeur();
            if (sudoku[x][y] == 0)
            JeuEngine.getInstance().getGrille().getItem2(y, x).setValeur2(0);
        }
    }
    }

    public static HashSet<Integer> getPosValues(int x, int y, int[][] sudoku) {

        for (int i = 1; i <= SIZE; i++)
        {posValues.add(i);}

        posValues.removeAll(getValDansLigne(sudoku).get(x));
        posValues.removeAll(getValDansCol(sudoku).get(y));
        posValues.removeAll(getValDansReg(sudoku).get(getReg(x,y)));
        return posValues;
    }

    public static ArrayList<HashSet<Integer>> getValDansLigne(int[][] easygride) {
        ValDansLigne = new ArrayList<HashSet<Integer>>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            ValDansLigne.add(new HashSet<Integer>());}

        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(easygride[i][j]!=0)
                    ValDansLigne.get(i).add(easygride[i][j]);
            }
        }

        return ValDansLigne;
    }
    public static ArrayList<HashSet<Integer>> getValDansCol(int[][] easygride) {
        ValDansCol = new ArrayList<HashSet<Integer>>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            ValDansCol.add(new HashSet<Integer>());}

        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(easygride[i][j]!=0)
                    ValDansCol.get(j).add(easygride[i][j]);
            }
        }
        return ValDansCol;
    }

    public static ArrayList<HashSet<Integer>> getValDansReg(int[][] easygride) {
        ValDansReg = new ArrayList<HashSet<Integer>>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            ValDansReg.add(new HashSet<Integer>());}

        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                switch (i)
                {
                    case 0:
                        for(int l=0;l<3;l++){
                            for(int c=0;c<3;c++){
                                if(easygride[l][c]!=0)
                                    ValDansReg.get(0).add(easygride[l][c]);
                            }
                        }
                        break;
                    case 1:
                        for(int l=0;l<3;l++){
                            for(int c=3;c<6;c++){
                                if(easygride[l][c]!=0)
                                    ValDansReg.get(1).add(easygride[l][c]);
                            }
                        };
                        break;
                    case 2:
                        for(int l=0;l<3;l++){
                            for(int c=6;c<SIZE;c++){
                                if(easygride[l][c]!=0)
                                    ValDansReg.get(2).add(easygride[l][c]);
                            }
                        };
                        break;
                    case 3 :
                        for(int l=3;l<6;l++){
                            for(int c=0;c<3;c++){
                                if(easygride[l][c]!=0)
                                    ValDansReg.get(3).add(easygride[l][c]);
                            }
                        }
                        break;
                    case 4 :
                        for(int l=3;l<6;l++){
                            for(int c=3;c<6;c++){
                                if(easygride[l][c]!=0)
                                    ValDansReg.get(4).add(easygride[l][c]);
                            }
                        }
                        break;
                    case 5 :
                        for(int l=3;l<6;l++){
                            for(int c=6;c<SIZE;c++){
                                if(easygride[l][c]!=0)
                                    ValDansReg.get(5).add(easygride[l][c]);
                            }
                        }
                        break;
                    case 6 :
                        for(int l=6;l<SIZE;l++){
                            for(int c=0;c<3;c++){
                                if(easygride[l][c]!=0)
                                    ValDansReg.get(6).add(easygride[l][c]);
                            }
                        }
                        break;
                    case 7 :
                        for(int l=6;l<SIZE;l++){
                            for(int c=3;c<6;c++){
                                if(easygride[l][c]!=0)
                                    ValDansReg.get(7).add(easygride[l][c]);
                            }
                        }
                        break;
                    case 8 :
                        for(int l=6;l<SIZE;l++){
                            for(int c=6;c<SIZE;c++){
                                if(easygride[l][c]!=0)
                                    ValDansReg.get(8).add(easygride[l][c]);
                            }
                        }
                        break;
                    default:
                        System.out.println("Il faut davantage travailler.");
                }
            }
        }
        return ValDansReg;
    }

}





