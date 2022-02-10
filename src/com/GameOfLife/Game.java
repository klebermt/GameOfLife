package com.GameOfLife;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 13; //numero de celdas
        int [][] gi = new int[n][n]; //primera pantalla
        int [][] gc = new int[n][n]; //segunda pantalla
        int c = 0; //comprobador
        
        //completamos las celulas
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                gi[i][j] = 0;
            }
        }

        //establecemos el estado inicial
        gi[4][6] = 1;
        gi[4][7] = 1;
        gi[5][7] = 1;
        gi[5][8] = 1;
        gi[6][7] = 1;

        int d = 0;
        while (d == 0){
            System.out.println("El juego de la vida");
            //codigo del juego de la vida
            for (int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    //comprobación de los posibles casos
                    if (i == 0 && j == 0){ //esquina lt
                        c = gi[i+1][j] + gi[i][j+1] + gi[i+1][j+1]; //esquina lt
                    } else if (i == 0 && j < n-1 && j > 0) { //top
                        c = gi[i][j-1] + gi[i+1][j-1] + gi[i+1][j] + gi[i+1][j+1] + gi[i][j+1]; //top
                    } else if (i == 0 && j == n-1){ //esquina rt
                        c = gi[i][j-1] + gi[i+1][j-1] + gi[i+1][j]; //esquina rt
                    } else if (j == 0 && i < n-1 && i > 0){ //l
                        c = gi[i-1][j] + gi[i-1][j+1] + gi[i][j+1] + gi[i+1][j+1] + gi[i+1][j]; //l
                    } else if (j == n-1 && i < n-1 && i > 0){ //r
                        c = gi[i-1][j] + gi[i-1][j-1] + gi[i][j-1] + gi[i+1][j-1] + gi[i+1][j]; //r
                    } else if (i == n-1 && j == 0){ //esquina lb
                        c = gi[i-1][j] + gi[i-1][j+1] + gi[i][j+1]; //esquina lb
                    } else if (i == n-1 && j == n-1){//esquina rb
                        c = gi[i-1][j] + gi[i-1][j-1] + gi[i][j-1]; //esquina rb
                    } else if (i == n-1 && j < n-1 && j > 0){ // bottom
                        c = gi[i][j-1] + gi[i-1][j-1] + gi[i-1][j] + gi[i-1][j+1] + gi[i][j+1]; //bottom
                    } else if (i > 0 && i < n-1 & j > 0 && j < n-1){ // center
                        c = gi[i][j-1] + gi[i-1][j-1] + gi[i-1][j] + gi[i-1][j+1] + gi[i][j+1] + gi[i+1][j+1] +gi[i+1][j] + gi[i+1][j-1];
                    }
                    if(gi[i][j] == 0){ //si la celula esta muerta
                        if (c == 3) {
                            gc[i][j] = 1;
                        } else {
                            gc[i][j] = 0;
                        }
                        c = 0;
                        System.out.print("-");
                    } else { //si la celula esta viva
                        if (c == 2 || c == 3){
                            gc[i][j] = 1;
                        } else {
                            gc[i][j] = 0;
                        }
                        c = 0;
                        System.out.print("O");
                    }
                    //System.out.print(gc[i][j]);
                }
                System.out.println();
            }
            //restablecemos las matrices
            for (int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    gi[i][j] = gc[i][j];
                }
            }
            //para acabar el juego
            System.out.println("presione el numero 0 para continuar");
            System.out.println("presione cualquier numero para finalizar");
            d = sc.nextInt();
        }

    }
}
