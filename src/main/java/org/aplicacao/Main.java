package org.aplicacao;


import org.aplicacao.dto.DtoDeckResponse;
import org.aplicacao.service.APIService;

public class Main {
    public static void main(String[] args){
        DeckOfCards deck = new DeckOfCards();
        Player player1 = new Player("Roberto");
        Player player2 = new Player("Davi");
        Player player3 = new Player("Allan");
        try{
            String deckId = deck.createDeckId();
            player1.fulfillHand(deckId);
            System.out.println(player1.getHand());
            System.out.println(deck.checkRemainingCards(deckId));
            player2.fulfillHand(deckId);
            System.out.println(player2.getHand());
            System.out.println(deck.checkRemainingCards(deckId));
            player3.fulfillHand(deckId);
            System.out.println(player3.getHand());
            System.out.println(deck.checkRemainingCards(deckId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}