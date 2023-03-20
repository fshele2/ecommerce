package com.Nestful.ecommerce.models;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotEmpty//now this column has a not null constraint
    private String first_name;

    @Column
    @NotEmpty//now this column has a not null constraint
    private String last_name;

    @Column(nullable = false)
    @Email
    @NotEmpty(message = "Field cannot be empty")
    private String email;
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Field cannot be empty")
    @Size(min = 6, max = 30, message = "Length of input must between 6 and 30")
    private String username;

    @Column(nullable = false)
    @NotEmpty(message = "Field cannot be empty")
    @Size(min = 8, max = 14, message = "Length of input must between 8 adn 14")
    private String password;
    @Column(nullable = false)
    @NotEmpty(message = "Field cannot be empty")
    private String shipping_address;
    @Column(nullable = false)
    @NotEmpty(message = "Field cannot be empty")
    private String billing_address;

    @OneToMany(mappedBy = "user")
    private List<Order> order;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Payment> payment;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Cart> cart;


}

