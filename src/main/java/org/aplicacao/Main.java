package org.aplicacao;

public class Main {
    public static void main(String[] args) throws Exception {
        Match match = new Match();
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Davi");
        match.fullGame(player1,player2);
    }
}

//TODO Need to correct a bug with discard mechanic