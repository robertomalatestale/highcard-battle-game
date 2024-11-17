package org.aplicacao;


import org.aplicacao.dto.DtoDeckResponse;
import org.aplicacao.service.APIService;

public class Main {
    public static void main(String[] args){
        try{
            APIService api = new APIService();
            String deckId = api.createDeck();
            System.out.println("Deck created with the ID: " + deckId);
            System.out.println("Let's draw 5 cards");
            DtoDeckResponse response = api.fulfillPlayerHand(deckId);
            response.getCards().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}