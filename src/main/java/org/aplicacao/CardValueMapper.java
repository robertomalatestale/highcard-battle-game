package org.aplicacao;

import java.util.HashMap;
import java.util.Map;

public class CardValueMapper {
    private static final Map<String, Integer> cardValues = new HashMap<>();

    static{
        cardValues.put("ACE", 14);
        cardValues.put("KING", 13);
        cardValues.put("QUEEN", 12);
        cardValues.put("JACK", 11);
        cardValues.put("10", 10);
        cardValues.put("9", 9);
        cardValues.put("8", 8);
        cardValues.put("7", 7);
        cardValues.put("6", 6);
        cardValues.put("5", 5);
        cardValues.put("4", 4);
        cardValues.put("3", 3);
        cardValues.put("2", 2);
    }

    public static int getCardValue(String cardName){
        return cardValues.getOrDefault(cardName, -1);
    }
    }
