package com.monster_shop.ecommerce.service;

import com.monster_shop.ecommerce.entity.Product;
import com.monster_shop.ecommerce.exception.ProductNotFoundException; // Import the custom exception
import com.monster_shop.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils; // Import StringUtils

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        // Update fields only if they are present in the updatedProduct
        if (StringUtils.hasText(updatedProduct.getName())) {
            product.setName(updatedProduct.getName());
        }
        if (updatedProduct.getPrice() > 0) { // Assuming price should always be positive
            product.setPrice(updatedProduct.getPrice());
        }
        if (StringUtils.hasText(updatedProduct.getImageUrl())) {
            product.setImageUrl(updatedProduct.getImageUrl());
        }
        product.setFeatured(updatedProduct.isFeatured()); // No null check needed for boolean

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}