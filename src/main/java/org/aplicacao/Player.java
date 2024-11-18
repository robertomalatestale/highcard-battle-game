package org.aplicacao;

import org.aplicacao.dto.DtoCardResponse;
import org.aplicacao.service.APIService;

import java.util.ArrayList;
import java.util.List;

public class Player extends APIService {
    private String name;
    private int matchesWon;
    private List<DtoCardResponse> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void fulfillHand(String deckId) throws Exception {
        this.hand = fulfillPlayerHand(deckId).getCards();
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
