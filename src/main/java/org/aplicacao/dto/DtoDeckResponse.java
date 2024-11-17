package org.aplicacao.dto;

import java.util.List;

public class DtoDeckResponse {
    private boolean success;
    private String deck_id;
    private int remaining;
    private boolean shuffled;
    private List<DtoCardResponse> cards;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }

    public List<DtoCardResponse> getCards() {
        return cards;
    }

    public void setCards(List<DtoCardResponse> cards) {
        this.cards = cards;
    }
}
