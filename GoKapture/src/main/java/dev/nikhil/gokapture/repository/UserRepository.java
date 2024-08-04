package dev.nikhil.gokapture.repository;


import dev.nikhil.gokapture.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
