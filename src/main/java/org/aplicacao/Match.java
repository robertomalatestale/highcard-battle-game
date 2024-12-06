package org.aplicacao;

public class Match {
    private int matchNumber = 0;
    private char matchResult;
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
        if (matchNumber == 0){
            player1.fulfillHand(deckId,3);
            player2.fulfillHand(deckId,3);
            matchNumber += 1;
        }
        int matchResult = GameLogic.highCardBattle(player1.playerTurn(deckId),player2.playerTurn(deckId));
        if (matchResult == 1){
            System.out.println(GameLogic.announceWinner(matchResult,player1.getName()));
        } else {
            System.out.println(GameLogic.announceWinner(matchResult,player2.getName()));
        }
    }
}
