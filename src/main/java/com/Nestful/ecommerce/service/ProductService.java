package com.Nestful.ecommerce.service;

import com.Nestful.ecommerce.models.Product;
import com.Nestful.ecommerce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Optional<Product> findByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    public List<Product> findByPriceLessThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public List<Product> findByPriceGreaterThan(double price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
