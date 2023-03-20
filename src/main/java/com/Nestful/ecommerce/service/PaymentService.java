package com.Nestful.ecommerce.service;

import com.Nestful.ecommerce.models.Payment;
import com.Nestful.ecommerce.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment save(Payment p) {
        return paymentRepository.save(p);
    }

    public Payment findById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment updatePayment(Payment payment) {
        Payment existingPayment = paymentRepository.findById(payment.getId()).orElse(null);
        if(existingPayment == null) {
            return null;
        }
        existingPayment.setTransactionId(payment.getTransactionId());
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setCard_number(payment.getCard_number());
        existingPayment.setExpiration_date_month(payment.getExpiration_date_month());
        existingPayment.setExpiration_date_year(payment.getExpiration_date_year());
        existingPayment.setCvvNumber(payment.getCvvNumber());
        existingPayment.setUser(payment.getUser());
        return paymentRepository.save(existingPayment);
    }

    public boolean deletePayment(int id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if(payment == null) {
            return false;
        }
        paymentRepository.delete(payment);
        return true;
    }


}
