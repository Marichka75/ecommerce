package com.monster_shop.ecommerce.service;

import com.monster_shop.ecommerce.entity.Review;
import com.monster_shop.ecommerce.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }
}

