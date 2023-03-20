package com.Nestful.ecommerce.repositories;


import com.Nestful.ecommerce.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {



    Payment save(Payment p);


}