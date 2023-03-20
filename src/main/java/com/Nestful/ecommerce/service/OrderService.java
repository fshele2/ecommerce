package com.Nestful.ecommerce.service;

import com.Nestful.ecommerce.models.Order;
import com.Nestful.ecommerce.repositories.OrderRepository;
import com.Nestful.ecommerce.exceptions.OrderDoesNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderDoesNotExistException("Order not found with id " + orderId));
    }

    public Order getOrdersByUser(int userId) {
        return orderRepository.findByUser_Id(userId)
                .orElseThrow(() -> new OrderDoesNotExistException("Order not found for " + userId));
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public Order getOrderByUserAndStatus(int userId, String status) {
        return orderRepository.findByUser_IdAndStatus(userId, status)
                .orElseThrow(() -> new OrderDoesNotExistException());
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

}