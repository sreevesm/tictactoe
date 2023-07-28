package org.tic.tac.toe;

public class Player {

    private String name;
    private int numWins;
    private boolean turn;
    private String symbol;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumWins() {
        return numWins;
    }

    public void incrementNumWins() {
        this.numWins++;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isTurn() {
        return turn;
    }

    public void toggleTurn() {
        this.turn = !this.turn;
    }
}
