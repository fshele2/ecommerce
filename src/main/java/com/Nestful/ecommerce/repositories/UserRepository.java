package com.Nestful.ecommerce.repositories;

import com.Nestful.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

   User existsById(int Id);

    @Query(value = "SELECT u from ecommerce.Users u WHERE u.user_id =:user_id, u.first_name, u.last_name, u.email=:email And u.password =:password", nativeQuery = true)
    List<User> findAll (User u);

    User findByUsername(String username);

     User findByPassword(String password);


     Optional<User> findByUsernameAndPassword(String username, String password);


     Optional<User> findByEmailAndPassword(String email, String password);


}