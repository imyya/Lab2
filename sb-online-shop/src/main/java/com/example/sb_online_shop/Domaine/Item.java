package com.example.sb_online_shop.Domaine;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;

@Entity(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private int quantity;
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public Item(){};
    public Item(int quantity, double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }


    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public double getPrice(){
        return this.price;
    }

    public void setOrder(Order order){
        this.order=order;
    }

    public Order getOrder(){
        return this.order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    



    



    
}
