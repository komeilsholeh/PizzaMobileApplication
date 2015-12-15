package com.example.komeil.pizzamobileapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Komeil on 15/12/2015.
 */
public class BasketActivity {

    private List<Basket> basket = new ArrayList<Basket>();

    public void addToBasket(String pizzaSize,String pizzaName) {
        Pizza apizza= getSelectedPizza(pizzaName);
        double price=0;
        switch (pizzaSize){
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
        Basket item=new Basket(pizzaSize+" "+pizzaName, apizza.getToppings(),price);
        basket.add(item);
    }

    public Pizza getSelectedPizza(String pizzaName){
        Pizza selectedpizza=Pizza.pizzas[0];
        for(int i=0;i < Pizza.pizzas.length; i++) {
            if(pizzaName.equals(Pizza.pizzas[i].getPizzaName())){
                selectedpizza=Pizza.pizzas[i];
            }
        }
        return selectedpizza;
    }

    public String claculateTotalPrice(){
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
