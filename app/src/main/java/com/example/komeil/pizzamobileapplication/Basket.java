package com.example.komeil.pizzamobileapplication;

/**
 * Created by Komeil on 15/12/2015.
 */
public class Basket {

    // implementation of variables for each item in the basket
    private String order;  // name of item
    private String description; // description of each item
    private double price; // price of the item

    // implementing the basket object
    public Basket(String order,String description,double price){
        this.order=order;
        this.description=description;
        this.price=price;
    }

    // implementation of setters and getters for the object.

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return order + " £" + price;
    }
}
