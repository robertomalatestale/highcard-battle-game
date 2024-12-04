package org.aplicacao;

import org.aplicacao.dto.DtoCardResponse;
import org.aplicacao.service.APIService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends APIService {
    private String name;
    private int matchesWon;
    private List<DtoCardResponse> hand = new ArrayList<>();
    static private int discardCount;
    Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public void fulfillHand(String deckId) throws Exception {
        this.hand = drawCards(deckId,3).getCards();
    }

    public void playerTurn(){
        System.out.println("Choose a option, if you want to play a card choose between 1 to 3.");
        System.out.println("Or if you want to discard one card to draw another from the deck, choose option 4 (only 1 discard per match)");
        for(int i = 0; i<hand.size();i++){
            System.out.println((i+1) + " - " + hand.get(i));
        }
        System.out.println("4 - Discard a card.");
        System.out.print("Enter your choice here: ");
        int playerChoice = scanner.nextInt();
        while (playerChoice>4 || playerChoice<=0){
            System.out.println("Invalid value!");
            System.out.print("Enter your choice here: ");
            playerChoice = scanner.nextInt();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public List<DtoCardResponse> getHand() {
        return hand;
    }

    public void setHand(List<DtoCardResponse> hand) {
        this.hand = hand;
    }
}
