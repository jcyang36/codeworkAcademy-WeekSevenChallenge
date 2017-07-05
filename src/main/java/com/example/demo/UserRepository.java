package com.example.demo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 6/29/17.
 */
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);

}