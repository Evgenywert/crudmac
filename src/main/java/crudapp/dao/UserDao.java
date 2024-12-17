package crudapp.dao;

import crudapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> findAll();
    Optional<User> findById(Long id);
    void save(User user);
    void deleteById(Long id);
    void merge(User user);
}