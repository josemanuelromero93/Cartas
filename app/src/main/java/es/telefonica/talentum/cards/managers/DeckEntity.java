package es.telefonica.talentum.cards.managers;

import com.google.gson.annotations.SerializedName;

public class DeckEntity {

    @SerializedName("remaining") private int esperando;
    @SerializedName("success") private boolean correcto;
    @SerializedName("deck_id") private String deck_id;
    @SerializedName("shuffled") private boolean shuffled;

    public int getEsperando() {
        return esperando;
    }

    public void setEsperando(int esperando) {
        this.esperando = esperando;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }
}
