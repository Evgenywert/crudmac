package crudapp.dao;

import crudapp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
//Метод flush() используется, чтобы принудительно записать в целевой поток данные, которые
// могут кэшироваться в текущем потоке.

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();

    }

    @Override
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);

        entityManager.remove(user);
    }


    @Override
    public void merge(User user) {
        entityManager.merge(user);
        entityManager.flush();

    }
}
