package com.company;

import java.util.Scanner;

public class Main {
    public static final char SIZE = 3;
    public static final char EMPTY = '-';
    public static final char ZERO = '0';
    public static final char KRESTIK = 'X';
    public static boolean isKrestikTurn = true;

    public static void main(String[] args) {
	char [][] field = new char[SIZE][SIZE];
    for(int i = 0; i < SIZE;i++) {
        for (int j = 0 ; j < SIZE; j++) {
            field[i][j] = EMPTY;
        }
    }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printField(field);
            System.out.println("Игра началась)");
            System.out.println("Ходят " + (isKrestikTurn ? "Крестики" : "Нолики"));

            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;


            field[row][col] = isKrestikTurn ? KRESTIK : ZERO;

            if (playersWin(field, isKrestikTurn ? KRESTIK : ZERO)) {
                System.out.println("Победили" + (isKrestikTurn ? "Крестики" : "Нолики"));
                printField(field);
                break;
            } else {
                isKrestikTurn = !isKrestikTurn;
            }
        }


    }


    public static boolean playersWin(char[][]field , char playyer) {
        if (field [0][1] == playyer && field[0][2] == playyer && field[0][3] == playyer) {
            return true;
        }
        if (field [1][0] == playyer && field[1][1] == playyer && field[1][2] == playyer) {
            return true;
        }
        if (field [2][0] == playyer && field[2][1] == playyer && field[2][2] == playyer) {
            return true;
        }
        if (field [0][0] == playyer && field[1][0] == playyer && field[2][0] == playyer) {
            return true;
        }
        if (field [0][1] == playyer && field[1][1] == playyer && field[2][1] == playyer) {
            return true;
        }
        if (field [0][2] == playyer && field[1][2] == playyer && field[2][2] == playyer) {
            return true;
        }
        if (field [0][0] == playyer && field[1][1] == playyer && field[2][2] == playyer) {
            return true;
        }if (field [0][1] == playyer && field[1][1] == playyer && field[2][2] == playyer) {
            return true;
        }if (field [0][2] == playyer && field[1][1] == playyer && field[2][0] == playyer) {
            return true;
        }
        return false;
    }
    public static void printField ( char [][] field) {
        for ( char [] row :field) {
            for ( char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
