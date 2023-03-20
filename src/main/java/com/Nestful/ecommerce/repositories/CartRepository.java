package com.Nestful.ecommerce.repositories;

import com.Nestful.ecommerce.models.Cart;
import com.Nestful.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer>{


    Optional<Cart> findByUser(User user);
    Optional<Cart> findAllByUserId(Integer userId);


}

