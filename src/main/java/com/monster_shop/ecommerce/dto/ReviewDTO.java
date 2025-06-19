package com.monster_shop.ecommerce.dto;

import jakarta.validation.constraints.*;

public class ReviewDTO {
    private Long id;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters")
    private String username;

    @NotNull(message = "Rating cannot be null")
    @DecimalMin(value = "1.0", message = "Rating must be at least 1.0")
    @DecimalMax(value = "5.0", message = "Rating must be at most 5.0")
    private double rating;

    @NotBlank(message = "Body cannot be blank")
    @Size(min = 10, max = 500, message = "Body must be between 10 and 500 characters")
    private String body;

    public ReviewDTO() {
        // Required for Jackson deserialization
    }

    public ReviewDTO(Long id, String username, double rating, String body) {
        this.id = id;
        this.username = username;
        this.rating = rating;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}