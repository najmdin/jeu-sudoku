package com.example.najm.sudoku;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by najm on 02/18/2017.
 */
public class SudokuGenerateur {
    private static SudokuGenerateur instance ;
    private ArrayList<ArrayList<Integer>> Available = new ArrayList<ArrayList<Integer>>();
    private Random rand = new Random();

    private SudokuGenerateur(){

    }
    public static SudokuGenerateur getInstance(){
     if(instance == null){
         instance = new SudokuGenerateur();
     }
      return instance;
    }

    public int[][] GenerateurGrille(){
        int[] solutionArray = {1,2,3,4,5,6,7,8,9};
        shuffleArray(solutionArray);
        int k=0;
        int fillCount =1;
        int N=3;
        int[][] Sudoku =new int[N*N][N*N];
        for(int i=0;i<solutionArray.length;i++){
            Sudoku[0][i]= solutionArray[i];}
        k=k+3;
        for (int i=1;i<N*N;i++){
            if(i==3||i==6){
                k++;}
            if(i==4||i==7)
                k--;
            for(int j=0;j<N*N;j++){
                if(k>=9){
                    k=0;
                    Sudoku[i][j]=Sudoku[i-1][k];
                    k++;
                }else{
                    Sudoku[i][j]=Sudoku[i-1][k];
                    k++;
                }
            }
        }
        return  Sudoku;
    }

    static void shuffleArray(int[] array)
    {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private void ClearGrille(int[][] Sudoku){
        Available.clear();

        for(int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                Sudoku[i][j] = -1;
            }
        }

        for(int j = 0; j<81; j++){
            Available.add(new ArrayList<Integer>());
            for(int i = 1; i<=9; i++){
            Available.get(j).add(i);
            }
        }
    }


    public int[][] supprimerElements(int[][] Sudoku,int k){
        int count = 0;
        int[][] two = new int[9][9];

        while(count <k) {
            /*if(count ==0)
            two = Sudoku;
            if (count == k - 1) {
                if (!Backtrack.estValide(two, 0)) {
                    Sudoku = GenerateurGrille();
                    count = -1;
                }
            }*/
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);
            if (Sudoku[x][y] != 0) {
                Sudoku[x][y] = 0;
                two[x][y] = 0;
            }
            count++;
        }
     return Sudoku;
    }




}

