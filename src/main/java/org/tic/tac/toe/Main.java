package org.tic.tac.toe;

import org.example.AnimalEnum;
import org.example.Pet;
import org.example.PetManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter player1 name: ");
        Player p1 = new Player(s.nextLine());
        System.out.println("Enter player1 symbol: ");
        p1.setSymbol(s.nextLine());

        System.out.println("Play against CPU or other player? (1. CPU  2. Player)");
        int ans = Integer.parseInt(s.nextLine());
        Player p2;
        if (ans == 1){
            p2 = new Player("Computer");
            p2.setSymbol("X");
        }
        else {
            System.out.println("Enter player2 name: ");
            p2 = new Player(s.nextLine());
            System.out.println("Enter player2 symbol: ");
            p2.setSymbol(s.nextLine());
        }

        System.out.println(p1.getName() + " vs " + p2.getName());

        TicTacToe ttt = new TicTacToe();
        ttt.initBoard();
        ttt.displayBoard();

        while (p1.getNumWins() < 3 && p2.getNumWins() < 3) {
            while (!ttt.checkBoardFull() && ttt.getWinner() == null) {
                ttt.getMove(p1);
                ttt.displayBoard();

                ttt.checkWinner(p1);
                if (ttt.getWinner() != null || ttt.checkBoardFull()) break;

                if (p2.getName().equals("Computer")) {
                    ttt.getMoveCPU(p2);
                } else {
                    ttt.getMove(p2);
                }
                ttt.displayBoard();

                ttt.checkWinner(p2);
            }
            ttt.initBoard();
            ttt.setWinner(null);// do you wanna commit to github and let me know. can you see this ?
            System.out.println(p1.getName() + " has " + p1.getNumWins() + " wins");
            System.out.println(p2.getName() + " has " + p2.getNumWins() + " wins");
        }

    }












    public static int Fib(int n){
        if (n == 1 || n == 0) return 0;
        if (n == 2) return 1;
        return Fib(n-1) + Fib(n-2);
    }

    public static String toBinary(int x){
        if (x == 0 || x == 1) return Integer.toString(x);
        return toBinary(x/2) + (x % 2);
    }
}