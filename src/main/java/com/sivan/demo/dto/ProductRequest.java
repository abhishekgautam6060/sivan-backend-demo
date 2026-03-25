package com.sivan.demo.dto;


public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private Long categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public ProductRequest(String name, Long categoryId, String imageUrl, double price, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
    }

    public ProductRequest() {
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
