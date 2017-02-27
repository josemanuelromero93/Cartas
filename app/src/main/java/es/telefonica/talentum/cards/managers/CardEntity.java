package es.telefonica.talentum.cards.managers;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import es.telefonica.talentum.cards.model.Card;

public class CardEntity {


    @SerializedName("cards") private List<Card> card;
    @SerializedName("remaining") private int remaining;

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }
}
