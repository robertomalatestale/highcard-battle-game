package org.aplicacao;

public class Match {
    private int matchNumber = 0;
    private int player1MatchesWon;
    private int player2MatchesWon;
    private DeckOfCards deck = new DeckOfCards();
    private String deckId;
    {
        try {
            deckId = deck.createDeckId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void gameMatch(Player player1, Player player2) throws Exception {
        System.out.println("MATCH " + (matchNumber+1));
        if (matchNumber == 0){
            player1.fulfillHand(deckId,3);
            player2.fulfillHand(deckId,3);
        }
        matchNumber += 1;
        int matchResult = GameLogic.highCardBattle(player1.playerTurn(deckId),player2.playerTurn(deckId));
        if (matchResult == 1){
            this.player1MatchesWon +=1;
            System.out.println(GameLogic.announceWinner(matchResult,player1.getName()));
        } else if (matchResult == 2){
            this.player2MatchesWon +=1;
            System.out.println(GameLogic.announceWinner(matchResult,player2.getName()));
        }else {
            System.out.println(GameLogic.announceWinner(matchResult,player2.getName()));
        }
    }

    public void fullGame(Player player1, Player player2) throws Exception {
        gameMatch(player1,player2);
        gameMatch(player1,player2);
        if (GameLogic.verifyWinner(player1.getName(),this.player1MatchesWon)){
            System.out.println("GAME RESULT: " + player1.getName() + " " + this.player1MatchesWon + " - " + this.player2MatchesWon + " " + player2.getName());
        } else if (GameLogic.verifyWinner(player2.getName(),this.player2MatchesWon)){
            System.out.println("GAME RESULT: " + player1.getName() + " " + this.player1MatchesWon + " - " + this.player2MatchesWon + " " + player2.getName());
        } else {
            gameMatch(player1,player2);
            if (GameLogic.verifyWinner(player1.getName(),this.player1MatchesWon)){
                System.out.println("GAME RESULT: " + player1.getName() + " " + this.player1MatchesWon + " - " + this.player2MatchesWon + " " + player2.getName());
            } else if (GameLogic.verifyWinner(player2.getName(),this.player2MatchesWon)){
                System.out.println("GAME RESULT: " + player1.getName() + " " + this.player1MatchesWon + " - " + this.player2MatchesWon + " " + player2.getName());
            }
        }
        if (this.player1MatchesWon == this.player2MatchesWon){
            System.out.println("\nTHE GAME WAS A DRAW!");
            System.out.println("GAME RESULT: " + player1.getName() + " " + this.player1MatchesWon + " - " + this.player2MatchesWon + " " + player2.getName());
        }
    }
}
