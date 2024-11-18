package org.aplicacao.service;

import com.google.gson.Gson;
import org.aplicacao.dto.DtoDeckResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIService {
    private final HttpClient httpClient;
    private final Gson gson;

    public APIService() {
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }
    //Asks API to create a new deck
    public String createDeck() throws Exception{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        DtoDeckResponse deckResponse = gson.fromJson(response.body(), DtoDeckResponse.class);

        return deckResponse.getDeck_id();
    }
    //Fulfilling the hand of the player with 5 cards coming from the created deck
    public DtoDeckResponse fulfillPlayerHand (String deckId) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=5"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), DtoDeckResponse.class);
    }
    //Method to check remaining cards in deck
    public int checkRemainingCards(String deckId) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=0"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        DtoDeckResponse deckResponse = gson.fromJson(response.body(), DtoDeckResponse.class);
        return deckResponse.getRemaining();
    }
}
