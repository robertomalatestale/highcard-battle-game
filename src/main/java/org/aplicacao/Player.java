package org.aplicacao;

public class Player {
    private String name;
    private int matchesWon;
    private String[] hand = new String[5];

    public Player(String name) {
        this.name = name;
    }
}
