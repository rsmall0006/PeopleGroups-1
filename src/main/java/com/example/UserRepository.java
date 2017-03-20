package com.example;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Eric on 3/17/17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}