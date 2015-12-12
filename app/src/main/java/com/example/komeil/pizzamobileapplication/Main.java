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
import android.widget.ListView;
import android.widget.Spinner;


public class Main extends AppCompatActivity {


    private ArrayAdapter<String> arrayAdapter ;
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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    public String[] pizzaToppingList(View view){
        Spinner pizzaType= (Spinner) findViewById(R.id.sprWichPizza);
        String pizzaName=String.valueOf(pizzaType.getSelectedItem());
        String[] toppings;

        switch (pizzaName){
            case "Create Your Own":
                toppings= new String[]{"Cheese", "Tomato Sauce"};
                break;
            case "Hawaiian":
                toppings= new String[]{"Cheese", "Tomato Sauce","Ham","Pineapple"};
                break;
            case "Meat Feast":
                toppings= new String[]{"Cheese", "Tomato Sauce","Bacon","Ham","Meat Ball","Pepperoni"};
                break;
            case "Pepperoni":
                toppings= new String[]{"Cheese", "Tomato Sauce", "Pepperoni"};
                break;
            case "Pepperoni Plus":
                toppings= new String[]{"Cheese", "Tomato Sauce","Pepperoni","Mushroom"};
                break;
            case "Mexican":
                toppings= new String[]{"Cheese", "Tomato Sauce", "Beef","Red Onion","Jalapeneo", "Chicken"};
                break;
            case "Chicken Hot":
                toppings= new String[]{"Cheese", "Tomato Sauce","Chicken","Jalapeneo", "Mushroom"};
                break;
            case "Chicken Special":
                toppings= new String[]{"Cheese", "Tomato Sauce","Chicken","Red Onion","Green Pepper","Sweet Corn"};
                break;
            case "BBQ Chicken":
                toppings= new String[]{"Cheese", "BBQ Sauce","Chicken","Red Onion","Green Pepper"};
                break;
            case "Meaty BBQ":
                toppings= new String[]{"Cheese", "BBQ Sauce", "Beef","Red Onion","Mushroom"};
                break;
            default:
                toppings= new String[]{"Cheese", "Tomato Sauce"};
                break;
        }
        return toppings;
    }

    public void addToppingTolist(View view){
        Spinner pizzaTopping= (Spinner) findViewById(R.id.sprToppings);
        ListView lstToppingList= (ListView) findViewById(R.id.lstToppings);

        // getting the selected item from spinner
        String topping=String.valueOf(pizzaTopping.getSelectedItem());

        //


    }
}
