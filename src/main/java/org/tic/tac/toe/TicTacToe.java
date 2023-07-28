package org.tic.tac.toe;

import java.util.*;

public class TicTacToe {

    private String[][] boardMoves = new String[3][3];

    private Player winner;

    public TicTacToe(){

    }
    public void initBoard(){
        for(int i = 0; i < boardMoves.length; i++){
            for(int j = 0; j < boardMoves[i].length; j++){
                boardMoves[i][j] = "-";
            }
        }
    }
    public Player getWinner() {
        return winner;
    }
    public void setWinner(Player p){
        this.winner = p;
    }

    public void checkWinner(Player player){
        String symbol = player.getSymbol();
        int[][][] wins = {{{0,0}, {0,1}, {0,2}}, {{1,0}, {1,1}, {1,2}}, {{2,0}, {2,1}, {2,2}},
                {{0,0}, {1,0}, {2,0}}, {{0,1}, {1,1}, {2,1}}, {{0,2}, {1,2}, {2,2}},
                {{0,0}, {1,1}, {2,2}}, {{0,2}, {1,1}, {2,0}}};

        for (int[][] solution : wins){
            if (boardMoves[solution[0][0]][solution[0][1]] == player.getSymbol() && boardMoves[solution[0][0]][solution[0][1]] == boardMoves[solution[1][0]][solution[1][1]] && boardMoves[solution[0][0]][solution[0][1]] == boardMoves[solution[2][0]][solution[2][1]]){
                System.out.println("winner: " + player.getName());
                setWinner(player);
                player.incrementNumWins();
                return;
            }
        }
    }
    public boolean checkBoardFull(){
        for(int i = 0; i < boardMoves.length; i++){
            for(int j = 0; j < boardMoves[i].length; j++){
                if(boardMoves[i][j].equals("-")){
                    return false;
                }
            }
        }
        return true;
    }
    public void getMove(Player p){
        System.out.println(p.getName() + "'s move: ");
        System.out.println("Enter row number first, then column number");
        int[] move = new int[2];
        Scanner s = new Scanner(System.in);
        while(true){
            try{
                move[0] = Integer.parseInt(s.nextLine());
                move[1] = Integer.parseInt(s.nextLine());
                if (checkValidMove(move)) break;
                System.out.println("Move was invalid, please try again - first row then column");
            }catch(Exception e){
                System.out.println("Input type was invalid, make sure it's an int!");
            }
        }
        boardMoves[move[0]][move[1]] = p.getSymbol();
    }
    public void getMoveCPU(Player p){
        System.out.println(p.getName() + "'s move: ");
        int[][] moves = {{0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
        List<int[]> posMoves = new ArrayList(Arrays.asList(moves));
        int num;
        Random rand = new Random();
        while(true){
            num = rand.nextInt(posMoves.size());
            if (checkValidMove(posMoves.get(num))) break;
            posMoves.remove(num);
//            System.out.println("Move was invalid, please try again - first row then column");
        }
        boardMoves[posMoves.get(num)[0]][posMoves.get(num)[1]] = p.getSymbol();
    }
    public boolean checkValidMove(int[] pos){
        if(boardMoves[pos[0]][pos[1]].equals("-")){
            return true;
        }
        return false;
    }

    public void displayBoard(){
        for(int i = 0; i < boardMoves.length; i++){
            for(int j = 0; j < boardMoves[i].length; j++){
                System.out.print(boardMoves[i][j] + " ");
            }
            System.out.println();
        }
    }

}
