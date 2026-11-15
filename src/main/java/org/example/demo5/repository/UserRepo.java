package org.example.demo5.repository;

import org.example.demo5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByName(String name);
    User findByEmail(String email);
    User findByPhone(String phone);
}
