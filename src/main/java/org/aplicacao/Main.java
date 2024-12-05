package org.aplicacao;

public class Main {
    public static void main(String[] args) throws Exception {
        DeckOfCards deck = new DeckOfCards();
        Player player1 = new Player("Roberto");
        String deckId = deck.createDeckId();
        player1.fulfillHand(deckId,3);
        player1.playerTurn(deckId);
        player1.playerTurn(deckId);
        player1.playerTurn(deckId);
    }
}

//TODO Começar a pensar na lógica do jogo agora, qual carta vence qual