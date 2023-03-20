package com.Nestful.ecommerce.controllers;

import com.Nestful.ecommerce.models.Cart;
import com.Nestful.ecommerce.models.User;
import com.Nestful.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private  CartService cartService;




    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Integer userId) {
        Optional<Cart> cartOptional = cartService.getCartByUserId(userId);
        if (cartOptional.isPresent()) {
            return ResponseEntity.ok(cartOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
