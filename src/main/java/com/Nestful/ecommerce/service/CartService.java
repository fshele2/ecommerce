package com.Nestful.ecommerce.service;

import com.Nestful.ecommerce.models.Cart;
import com.Nestful.ecommerce.models.User;
import com.Nestful.ecommerce.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart save(Cart cart) {return cartRepository.save(cart);
    }

    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }



    public Optional<Cart> getCartByUserId(Integer userId) {
        return cartRepository.findAllByUserId(userId);
    }


}
