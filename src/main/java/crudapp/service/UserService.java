package crudapp.service;

import crudapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void createOrUpdateUser(User user);

    void deleteUser(Long id);

}