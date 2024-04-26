package org.example.service;

import org.example.dto.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(Long id);
    List<User> getAllUser();
    User searchUserById(Long id);
    User searchUserByName(String Name);
}
