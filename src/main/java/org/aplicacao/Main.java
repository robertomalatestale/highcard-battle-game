package org.aplicacao;

public class Main {
    public static void main(String[] args) throws Exception {
        Match match = new Match();
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Davi");
        match.gameMatch(player1,player2);
    }
}

//TODO Put a printf to tells wich players is current move. Implements game match counter