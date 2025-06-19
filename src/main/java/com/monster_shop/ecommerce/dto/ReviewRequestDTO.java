package com.monster_shop.ecommerce.dto;

import jakarta.validation.constraints.*;

public class ReviewRequestDTO {

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters")
    private String username;

    @NotNull(message = "Rating cannot be null")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    private double rating;

    @NotBlank(message = "Body cannot be blank")
    @Size(min = 10, max = 500, message = "Body must be between 10 and 500 characters")
    private String body;

    @NotNull(message = "Product ID cannot be null")
    private Long productId;

    public ReviewRequestDTO() {
        // Required for Jackson deserialization
    }

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