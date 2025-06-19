package com.monster_shop.ecommerce.controller;

import com.monster_shop.ecommerce.entity.Review;
import com.monster_shop.ecommerce.entity.Product;
import com.monster_shop.ecommerce.service.ReviewService;
import com.monster_shop.ecommerce.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final ProductRepository productRepository;

    public ReviewController(ReviewService reviewService, ProductRepository productRepository) {
        this.reviewService = reviewService;
        this.productRepository = productRepository;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<Review>> getReviewsByProduct(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Product product = productRepository.findById(review.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        review.setProduct(product);
        Review savedReview = reviewService.createReview(review);
        return ResponseEntity.status(201).body(savedReview);
    }
}
