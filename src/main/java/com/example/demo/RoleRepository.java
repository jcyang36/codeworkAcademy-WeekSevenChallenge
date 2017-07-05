package com.example.demo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by student on 6/23/17.
 */
public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findByRole(String role);
}


