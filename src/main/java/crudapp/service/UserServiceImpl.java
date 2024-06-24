package crudapp.service;

import org.springframework.stereotype.Service;
import crudapp.model.User;
import crudapp.dao.UserDao;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public Optional<User> getUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void createOrUpdateUser(User user) {
        userDao.merge(user);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteById(id);
    }
}
