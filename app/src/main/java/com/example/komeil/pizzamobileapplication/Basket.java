package com.example.komeil.pizzamobileapplication;

/**
 * Created by Komeil on 15/12/2015.
 */
public class Basket {
    private String order;
    private String description;
    private double price;

    public Basket(String order,String description,double price){
        this.order=order;
        this.description=description;
        this.price=price;
    }

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
}
