package org.aplicacao;

import org.aplicacao.service.APIService;

public class DeckOfCards extends APIService {
    protected String deckId;
    private int remaining;

    public String getDeckId() {
        return deckId;
    }

    protected String createDeckId() throws Exception {
        this.deckId = createDeck();
        return this.deckId;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
