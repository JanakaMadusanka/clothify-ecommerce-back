package org.example.service;

import org.example.dto.User;

public interface UserService {
    void addUser(User user);
    boolean deleteUser(Long id);
}
