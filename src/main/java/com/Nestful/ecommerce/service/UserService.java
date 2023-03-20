package com.Nestful.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Nestful.ecommerce.exceptions.InvalidCredentialsException;
import com.Nestful.ecommerce.models.User;
import com.Nestful.ecommerce.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public Optional<User> getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User registerUser(User u) {

        return  userRepository.save(u);

//        return userRepo.getByUsername(u.getUsername());
    }

    public User getByUsernameAndPassword(String username, String password) {
        User u = userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidCredentialsException::new);

        if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
            return u;
        }

        throw new InvalidCredentialsException();
    }

    public User getByEmailAndPassword(String email, String password) {
        User u = userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(InvalidCredentialsException::new);

        if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
            return u;
        }

        throw new InvalidCredentialsException();
    }

}