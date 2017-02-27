package es.telefonica.talentum.cards.model;


import com.google.gson.annotations.SerializedName;

public class Card {

    public enum Suit{
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS
    }

    @SerializedName("suit") private String suit;
    @SerializedName("image") private String image;
    @SerializedName("value") private String value;
    @SerializedName("remaining") private int remains;
    @SerializedName("code") private String id;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRemains() {
        return remains;
    }

    public void setRemains(int remains) {
        this.remains = remains;
    }
}
