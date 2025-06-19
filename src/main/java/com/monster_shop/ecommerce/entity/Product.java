package com.monster_shop.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
    @Column(nullable = false)
    private double price;

    @NotBlank(message = "Image URL cannot be blank")
    @URL(message = "Image URL must be a valid URL")
    @Column(name = "image_url")
    private String imageUrl;

    @DecimalMin(value = "0.0", message = "Rating must be greater than or equal to 0.0")
    @DecimalMax(value = "5.0", message = "Rating must be less than or equal to 5.0")
    private double rating;

    @Min(value = 0, message = "Review count must be greater than or equal to 0")
    @Column(name = "review_count")
    private int reviewCount;

    private boolean featured;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    public Product() {}

    public Product(String name, double price, String imageUrl, boolean featured) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.featured = featured;
        this.rating = 0.0;
        this.reviewCount = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}