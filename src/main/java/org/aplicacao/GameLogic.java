package org.aplicacao;

import org.aplicacao.dto.DtoCardResponse;

public class GameLogic {
     public static int highCardBattle(DtoCardResponse cardPlayer1, DtoCardResponse cardPlayer2){
        int card1Value = CardValueMapper.getCardValue(cardPlayer1.getValue());
        int card2Value = CardValueMapper.getCardValue(cardPlayer2.getValue());
        if (card1Value>card2Value){
            return 1;
        } else if (card2Value>card1Value){
            return 2;
        } else {
            return 0;          // In case it's a draw
        }
    }
    public static String announceWinner(int matchResult, String nome){
         if (matchResult==1 || matchResult==2){
             return (nome + " wins the match!");
         } else{
             return ("It's a draw!");
         }
    }
}
