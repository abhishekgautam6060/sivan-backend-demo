package com.sivan.demo.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sivan.demo.entity.Order;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProductDto {

    private String name;
    private Double price;
    private int quantity;
    private String image;

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

// Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
