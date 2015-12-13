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


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
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

    public String[] pizzaToppingList(String pizzaName) {
        String[] toppings;

        switch (pizzaName) {
            case "Margherita":
                toppings = new String[]{"Cheese", "Tomato Sauce"};
                break;
            case "Hawaiian":
                toppings = new String[]{"Cheese", "Tomato Sauce", "Ham", "Pineapple"};
                break;
            case "Meat Feast":
                toppings = new String[]{"Cheese", "Tomato Sauce", "Bacon", "Ham", "Meat Ball", "Pepperoni"};
                break;
            case "Pepperoni":
                toppings = new String[]{"Cheese", "Tomato Sauce", "Pepperoni"};
                break;
            case "Pepperoni Plus":
                toppings = new String[]{"Cheese", "Tomato Sauce", "Pepperoni", "Mushroom"};
                break;
            case "Mexican":
                toppings = new String[]{"Cheese", "Tomato Sauce", "Beef", "Red Onion", "Jalapeneo", "Chicken"};
                break;
            case "Chicken Hot":
                toppings = new String[]{"Cheese", "Tomato Sauce", "Chicken", "Jalapeneo", "Mushroom"};
                break;
            case "Chicken Special":
                toppings = new String[]{"Cheese", "Tomato Sauce", "Chicken", "Red Onion", "Green Pepper", "Sweet Corn"};
                break;
            case "BBQ Chicken":
                toppings = new String[]{"Cheese", "BBQ Sauce", "Chicken", "Red Onion", "Green Pepper"};
                break;
            case "Meaty BBQ":
                toppings = new String[]{"Cheese", "BBQ Sauce", "Beef", "Red Onion", "Mushroom"};
                break;
            default:
                toppings = new String[]{"Cheese", "Tomato Sauce"};
                break;
        }
        return toppings;
    }
    private List<String> list = new ArrayList<>();

    public void addToppingToList(View view) {
        Spinner topping= (Spinner) findViewById(R.id.sprAllToppings);
        String selectedTopping=String.valueOf(topping.getSelectedItem());

        list.add(selectedTopping);
       // getting the selected item from spinner
        Spinner sprPizzaToppings = (Spinner) findViewById(R.id.sprSelectedPizzaToppins);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprPizzaToppings.setAdapter(arrayAdapter);

        //
    }

    public void addPizzaToppingToList(View view) {
        Spinner sprPizza = (Spinner) findViewById(R.id.sprAllPizzaList);
        String selectedPizza = sprPizza.getSelectedItem().toString();

        String[] toppings = pizzaToppingList(selectedPizza);

        for (int i = 0; i < toppings.length; i++) {
            list.add(toppings[i].toString());
        }

        Spinner sprToppingList = (Spinner) findViewById(R.id.sprSelectedPizzaToppins);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprToppingList.setAdapter(arrayAdapter);
    }

    public void removeToppingFromList(View view){
        Spinner sprPizzaTopping = (Spinner) findViewById(R.id.sprSelectedPizzaToppins);
        String topping=sprPizzaTopping.getSelectedItem().toString();
        for(int i=0; i < list.size();i++){
            String tp=list.get(i);
            if(topping.equals(tp)){
                list.remove(i);
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sprPizzaTopping.setAdapter(arrayAdapter);
    }

    private String claculateTotalPrice(){
        Spinner sprSelectedPizza= (Spinner) findViewById(R.id.sprSelectedPizzaToppins);
        String total="Please Select Your Pizza";
        if (sprSelectedPizza.getCount()>0){
            String pn = sprSelectedPizza.getSelectedItem().toString();
            Spinner sprPizzaSize= (Spinner) findViewById(R.id.sprPizzaSize);
            int price=0;
            switch (pn){
                case "18 Inches":
                    price=19;
                    break;
                case "15 Inches":
                    price=16;
                    break;
                case "12 Inches":
                    price=14;
                    break;
                case "9 Inches":
                    price=10;
                    break;
                case "7 Inches":
                    price=5;
                    break;
            }
            if (sprSelectedPizza.getCount()>6){
                int ext=sprSelectedPizza.getCount()-6;
                price=price+ext;
            }
            total="Total Price £" + String.valueOf(price);
        }
        return total;
    }
}
