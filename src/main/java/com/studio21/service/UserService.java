package com.studio21.service;

import com.studio21.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);

    Optional<User> findById(int userId);

    void deleteById(Integer userId);

    List<User> findAll();
}
