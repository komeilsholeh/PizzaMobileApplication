package com.example.komeil.pizzamobileapplication;

import android.app.ListActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komeil on 15/12/2015.
 */
public class BasketActivity extends ListActivity {

    private List<Basket> basket = new ArrayList<Basket>();
    private List<String> basketList = new ArrayList<String>();

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // listView= (ListView) findViewById(R.id.lstBasket);

        ListView lstbasket = getListView();
        ArrayAdapter<Basket> lstAdapter = new ArrayAdapter<Basket>(
                this,
                android.R.layout.simple_list_item_1, basket);
        lstbasket.setAdapter(lstAdapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void addToBasket(String pizzaSize, String pizzaName) {
        Pizza apizza = getSelectedPizza(pizzaName);
        double price = 0;
        switch (pizzaSize) {
            case "18 Inches":
                price = apizza.getPrice18();
                break;
            case "15 Inches":
                price = apizza.getPrice15();
                break;
            case "12 Inches":
                price = apizza.getPrice12();
                break;
            case "10 Inches":
                price = apizza.getPrice10();
                break;
        }
        Basket item = new Basket(pizzaSize + " " + pizzaName, apizza.getToppings(), price);
        basket.add(item);
        basketList.add(pizzaSize + " " + pizzaName +" £"+ String.valueOf(price));
    }

    public Pizza getSelectedPizza(String pizzaName) {
        Pizza selectedpizza = Pizza.pizzas[0];
        for (int i = 0; i < Pizza.pizzas.length; i++) {
            if (pizzaName.equals(Pizza.pizzas[i].getPizzaName())) {
                selectedpizza = Pizza.pizzas[i];
            }
        }
        return selectedpizza;
    }

    public String claculateTotalPrice() {
        double price = 0;
        if (basket.size() > 0) {
            for (int i = 0; i < basket.size(); i++) {
                price = price + basket.get(i).getPrice();
            }
        }
        String total = "Total Price £" + String.valueOf(price);
        return total;
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Basket Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.komeil.pizzamobileapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Basket Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.komeil.pizzamobileapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public List<String> getBasketList() {
        return basketList;
    }
}
