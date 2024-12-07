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
    private int discardCount = 1;
    Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public void fulfillHand(String deckId, int quantity) throws Exception {
        this.hand = drawCards(deckId,quantity).getCards();
    }
    public void addCardToHand(DtoCardResponse card) {
        hand.add(card);
    }

    public DtoCardResponse playerTurn(String deckId) throws Exception {
        DtoCardResponse cardPlayed = new DtoCardResponse();
        System.out.println(this.name + "'s turn!\n");
        System.out.println("Choose an option! If you want to play a card choose between 1 to 3.");
        System.out.println("Or if you want to discard one card to draw another from the deck, choose option 4 (only 1 discard per match)");
        for(int i = 0; i<hand.size();i++){
            System.out.println((i+1) + " - " + hand.get(i));
        }
        System.out.println("4 - Discard a card");
        System.out.print("Enter your choice here: ");
        int playerChoice = scanner.nextInt();
        while (playerChoice==4 && discardCount!=1){
            System.out.println("You are out of discards! Choose another option.");
            System.out.print("Enter your choice here: ");
            playerChoice = scanner.nextInt();
        }
        while (playerChoice>4 || playerChoice<=0){
            System.out.println("Invalid value!");
            System.out.print("Enter your choice here: ");
            playerChoice = scanner.nextInt();}
        switch(playerChoice){
            case 1, 2, 3:
                cardPlayed = hand.get(playerChoice-1);
                System.out.println("\n" + this.name + " played the card: " + hand.get(playerChoice-1) + "\n");
                discardCard(hand,(playerChoice));
                DtoCardResponse cardDrawn = new DtoCardResponse();
                List<DtoCardResponse> oneCardDrawn = new ArrayList<>();
                oneCardDrawn = drawCards(deckId,1).getCards();
                cardDrawn = oneCardDrawn.getFirst();
                addCardToHand(cardDrawn);
                break;
            case 4:
                discardCount -= 1;
                System.out.println("Choose an option from 1 to 3 to select which card to discard");
                for(int i = 0; i<hand.size();i++){
                    System.out.println((i+1) + " - " + hand.get(i));
                }
                System.out.print("Choose your card: ");
                playerChoice = scanner.nextInt();
                while (playerChoice>3 || playerChoice<=0){
                    System.out.println("Invalid value!");
                    System.out.print("Enter your choice here: ");
                    playerChoice = scanner.nextInt();
                }
                System.out.println("\nDiscarded card " + hand.get(playerChoice-1) + " from your hand.\n");
                discardCard(hand,(playerChoice));
        }
        return cardPlayed;
    }

    protected void discardCard(List<DtoCardResponse> card, int index){
        card.remove((index-1));
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
