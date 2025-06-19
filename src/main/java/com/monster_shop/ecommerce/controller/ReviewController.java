package com.monster_shop.ecommerce.controller;

import com.monster_shop.ecommerce.dto.ReviewDto;
import com.monster_shop.ecommerce.entity.Product;
import com.monster_shop.ecommerce.entity.Review;
import com.monster_shop.ecommerce.exception.ProductNotFoundException;
import com.monster_shop.ecommerce.service.ReviewService;
import com.monster_shop.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final ProductService productService;

    public ReviewController(ReviewService reviewService, ProductService productService) {
        this.reviewService = reviewService;
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ReviewDto>> getReviewsByProduct(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        List<ReviewDto> reviewDtos = reviews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reviewDtos);
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@Valid @RequestBody ReviewDto reviewDto) {
        try {
            Product product = productService.getProductById(reviewDto.getProductId());
            Review review = convertToEntity(reviewDto, product);
            Review savedReview = reviewService.createReview(review);
            return ResponseEntity.status(HttpStatus.CREATED).body(convertToDto(savedReview));
        } catch (ProductNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    private ReviewDto convertToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setUsername(review.getUsername());
        reviewDto.setRating(review.getRating());
        reviewDto.setBody(review.getBody());
        reviewDto.setProductId(review.getProduct().getId());
        return reviewDto;
    }

    private Review convertToEntity(ReviewDto reviewDto, Product product) {
        Review review = new Review();
        review.setId(reviewDto.getId());
        review.setUsername(reviewDto.getUsername());
        review.setRating(reviewDto.getRating());
        review.setBody(reviewDto.getBody());
        review.setProduct(product);
        return review;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getBindingResult().getAllErrors());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}