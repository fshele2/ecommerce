package com.Nestful.ecommerce.repositories;

import com.Nestful.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    Optional<Product> findByCategory(String category);
    Optional <Product> findByName(String name);

    Optional<Product> findByBrand(String brand);

    List<Product> findByPriceLessThan(double price);

    List<Product> findByPriceGreaterThan(double price);


}
