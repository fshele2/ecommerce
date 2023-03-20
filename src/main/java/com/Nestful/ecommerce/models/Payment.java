package com.Nestful.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;


@Entity
@Table(name="payment_information", schema="ecom")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String transactionId;

    @NotEmpty
    @Column(nullable = false)
    private double amount;

    @Column(nullable = false, unique = true)
    @NotEmpty
    @Size(min = 8, max = 16, message = "Length of input must be 16")
    private String card_number;

    @Column(nullable = false)
    @NotEmpty
    @Min(1)
    @Max(12)
    @Size(min = 2, max = 2, message = "Length of input must be 2")
    private String expiration_date_month;

    @Column(nullable = false)
    @NotEmpty
    @Min(23)
    @Max(27)
    @Size(min = 2, max = 2, message = "Length of input must be 2")
    private int expiration_date_year;

    @Column(nullable = false, name = "CSV")
    @NotEmpty
    @Size(min = 3, max = 4, message = "Length of input must be between 3 and 4")
    private String cvvNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;


    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "payment_order",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Order order;

}
