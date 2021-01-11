package com.k3518049.alam.repository;

import com.k3518049.alam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select user from User user where user.username = :username and user.password = :password")
    Optional<User> findSelectedUser(String username, String password);
}
