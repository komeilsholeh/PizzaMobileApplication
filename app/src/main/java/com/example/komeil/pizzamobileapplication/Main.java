package com.example.komeil.pizzamobileapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class Main extends AppCompatActivity {

    private GoogleApiClient client;

    // implementing an instance of BasketActivity
    private BasketActivity basket=new BasketActivity();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // adding a toolbar with application name to the main layout
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // adding an information button to main layout which is showing the total basket price in a popup
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st=basket.claculateTotalPrice();
                Snackbar.make(view, st, Snackbar.LENGTH_LONG)
                        .setAction(st, null).show();
            }
        });

        // adding all the pizza in the lizt in pizza class to a spinner in mail layout
        Spinner sprPizza = (Spinner) findViewById(R.id.sprAllPizzaList);
        ArrayAdapter<Pizza> listAdapter= new ArrayAdapter<Pizza>(
                this,android.R.layout.simple_spinner_item,Pizza.pizzas);
        sprPizza.setAdapter(listAdapter);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /* addPizzaToBasket getting selected pizza and selected size from spinners and sent it to
     add to basket function to basket activity class.
     also it is adding a new added item to the listview on the main layout*/

    public void addPizzaToBasket(View view) {
        Spinner sprSelPizza = (Spinner) findViewById(R.id.sprAllPizzaList);
        String selectedPizza = sprSelPizza.getSelectedItem().toString();
        Spinner sprPizzaSize= (Spinner) findViewById(R.id.sprPizzaSize);
        String pizzasize = sprPizzaSize.getSelectedItem().toString();
        basket.addToBasket(pizzasize, selectedPizza);
        Toast.makeText(getApplicationContext(), "Added To Basket", Toast.LENGTH_LONG).show();
        ListView listBasket=(ListView) findViewById(R.id.lstBasket);
        ArrayAdapter<String> lstAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,basket.getBasketList());
        listBasket.setAdapter(lstAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

        @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
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
                "Main Page", // TODO: Define a title for the content shown.
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

}
