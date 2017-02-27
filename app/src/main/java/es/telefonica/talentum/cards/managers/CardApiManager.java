package es.telefonica.talentum.cards.managers;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;

import es.telefonica.talentum.cards.model.Card;
import es.telefonica.talentum.cards.managers.CardEntity;


public class CardApiManager {

    public interface CardApiManagerNewCardListener{

        public void onNewCard(Card card);
    }

    private CardApiManager.CardApiManagerNewCardListener listener;

    public void setOnNewCardListener(CardApiManager.CardApiManagerNewCardListener listener){
        this.listener = listener;
    }

    public void newCard(Context context, String id) {
        RequestQueue queue = Volley.newRequestQueue(context);

        String URL = "https://deckofcardsapi.com/api/deck/"+id+"/draw/?count=1";

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //al ok
                Log.d("RESPONSE", response);
                parseJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Houston, tenemos un problema.
                Log.e("HORROR", "Conection went to shit to the tracks");
            }
        });

        queue.add(request);
    }

    private void parseJson(String response) {
        Gson gson = new GsonBuilder().create();
        Reader reader = new StringReader(response);

        CardEntity cardEntity = gson.fromJson(reader,CardEntity.class);

        Card card = cardEntity.getCard().get(0);
        card.setRemains(cardEntity.getRemaining());


        if (listener != null);{
            listener.onNewCard(card);
        }
    }
    
}
