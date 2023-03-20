package com.Nestful.ecommerce.repositories;


import com.Nestful.ecommerce.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Order>findByUser_Id(int userId);

    List<Order>findByStatus(String status);

    Optional<Order>findByUser_IdAndStatus(int userId, String status);

}