package com.fitness.userservice.repo;


import com.fitness.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsByEmail(String email);
}
