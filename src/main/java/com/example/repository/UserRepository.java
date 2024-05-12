package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameContaining(String name);
    User findByUserName(String username);
    @Query("SELECT u FROM User u WHERE u.name LIKE %:name%")
    List<User> filtrarPorNome(@Param("name") String name);
}
