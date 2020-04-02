package com.studio21.service;

import com.studio21.model.User;
import com.studio21.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
