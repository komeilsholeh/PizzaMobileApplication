package com.example.komeil.pizzamobileapplication;

/**
 * Created by Komeil on 15/12/2015.
 */
public class SideOrders {
    private String sideName;
    private String description;
    private double price;


    public static final SideOrders[] pizzas={
            new SideOrders("Potato Wedges"," ",2.50),new SideOrders("Chips"," ",1.50),
            new SideOrders("Onion Rings"," ",3),new SideOrders("Chicken Dippers","breaded chicken breast ",3)
    };

    public SideOrders(String pizzaName, String toppings, double price){
        this.sideName=pizzaName;
        this.description=toppings;
        this.price=price;
    }

    public String getSideName() {
        return sideName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
