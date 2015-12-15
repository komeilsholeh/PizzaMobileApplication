package com.example.komeil.pizzamobileapplication;

/**
 * Created by Komeil on 14/12/2015.
 */
public class Pizza {

    // Implementation of variables for a pizza
    // pizzaName for the name of pizza, topping in the ingredients of that pizza
    // price10 is the price for 10 inches pizza, price12 for the 12 inches and so on..
    private String pizzaName;
    private String toppings;
    private double price10;
    private double price12;
    private double price15;
    private double price18;

    // array list of the pizzas
    // I already added five pizza to the list.
    public static final Pizza[] pizzas={
        new Pizza("Margherita","Cheese,Tomato Sauce",7,10,14,17),new Pizza("Hawaiian","Cheese,Tomato Sauce,Ham,Pineapple",10,14,17,20),
        new Pizza("Meat Feast","Cheese,Tomato Sauce,Pepperoni,Beef,Ham,Bacon",10,14,17,20),new Pizza("Pepperoni","2x Cheese,Tomato Sauce,2x Pepperoni",10,14,17,20),
            new Pizza("Chicken Special","Cheese,Tomato Sauce,Chicken,Green Pepper,Red Onion,Sweet Corn",10,14,17,20)
    };


    // defining Pizza structure, each pizza include name,toppings,and prices for different sizes
    public Pizza(String pizzaName, String toppings, double price10, double price12, double price15, double price18){
        this.pizzaName=pizzaName;
        this.toppings=toppings;
        this.price10=price10;
        this.price12 = price12;
        this.price15=price15;
        this.price18=price18;
    }

    // setters and getters for each field

    public String getPizzaName() {
        return pizzaName;
    }

    public String getToppings() {
        return toppings;
    }

    public double getPrice10() {
        return price10;
    }

    public double getPrice12() {
        return price12;
    }

    public double getPrice15() {
        return price15;
    }

    public double getPrice18() {
        return price18;
    }

    @Override
    public String toString() {
        return pizzaName;
    }

}
