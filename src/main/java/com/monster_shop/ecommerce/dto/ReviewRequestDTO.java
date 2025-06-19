package com.monster_shop.ecommerce.dto;

public class ReviewRequestDTO {
    private String username;
    private double rating;
    private String body;
    private Long productId;

    public ReviewRequestDTO(String username, double rating, String body, Long productId) {
        this.username = username;
        this.rating = rating;
        this.body = body;
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}

