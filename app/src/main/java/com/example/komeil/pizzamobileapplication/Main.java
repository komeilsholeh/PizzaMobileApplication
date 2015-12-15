package com.example.komeil.pizzamobileapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;


public class Main extends AppCompatActivity {


    private List<Basket> basket = new ArrayList<Basket>();

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st=claculateTotalPrice();
                Snackbar.make(view, st, Snackbar.LENGTH_LONG)
                        .setAction(st, null).show();
            }
        });


        Spinner sprPizza = (Spinner) findViewById(R.id.sprAllPizzaList);
        ArrayAdapter<Pizza> listAdapter= new ArrayAdapter<Pizza>(
                this,android.R.layout.simple_spinner_item,Pizza.pizzas);
        sprPizza.setAdapter(listAdapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Pizza pizza;

    public void addPizzaToBasket(View view) {
        Spinner sprPizza = (Spinner) findViewById(R.id.sprAllPizzaList);
        String selectedPizza = sprPizza.getSelectedItem().toString();
        Pizza apizza=pizza.getSelectedPizza(selectedPizza);


        Spinner sprPizzaSize= (Spinner) findViewById(R.id.sprPizzaSize);
        String pn = sprPizzaSize.getSelectedItem().toString();
        double price=0;
        switch (pn){
            case "18 Inches":
                price= apizza.getPrice18();
                break;
            case "15 Inches":
                price= apizza.getPrice15();
                break;
            case "12 Inches":
                price= apizza.getPrice12();
                break;
            case "10 Inches":
                price= apizza.getPrice10();
                break;
        }
        Basket item=new Basket(selectedPizza, apizza.getToppings(),price);
        basket.add(item);
    }



    private String claculateTotalPrice(){
        double price=0;
        if (basket.size()>0){
            for(int i=0;i< basket.size();i++){
                price=price+basket.get(i).getPrice();
            }
        }
        String total="Total Price £" + String.valueOf(price);
        return total;
    }
}
