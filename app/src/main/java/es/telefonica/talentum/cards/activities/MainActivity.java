package es.telefonica.talentum.cards.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.telefonica.talentum.cards.managers.CardApiManager;
import es.telefonica.talentum.cards.managers.DeckApiManager;
import es.telefonica.talentum.cards.model.Card;
import es.telefonica.talentum.cards.model.Deck;
import es.telefonica.talentum.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private String id;
    @BindView(R.id.texto)
    TextView texto;
    @BindView(R.id.carta)
    ImageView imagenCarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DeckApiManager apiManager = new DeckApiManager();
        apiManager.setOnNewDeckListener(new DeckApiManager.DeckApiManagerNewDeckListener() {
            @Override
            public void onNewDeck(Deck deck) {
                id = deck.getId();
                texto.setText("Quedan " + deck.getRemaining() + " cartas");


            }
        });

        apiManager.newDeck(this);

        imagenCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CardApiManager cardApiManager =new CardApiManager();
                cardApiManager.setOnNewCardListener(new CardApiManager.CardApiManagerNewCardListener() {
                    @Override
                    public void onNewCard(Card card) {
                        Log.d("Carta",card.getImage());
                        Picasso.with(getBaseContext()).load(card.getImage()).into(imagenCarta);
                        texto.setText("Quedan " + card.getRemains() + " cartas");
                    }
                });
                cardApiManager.newCard(v.getContext(), id);
            }
        });



    }


}
