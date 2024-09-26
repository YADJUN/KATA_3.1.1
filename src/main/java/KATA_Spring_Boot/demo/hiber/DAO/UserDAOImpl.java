package KATA_Spring_Boot.demo.hiber.DAO;


import KATA_Spring_Boot.demo.hiber.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getUsers() {
        return em.createQuery("select user from User user", User.class)
                .getResultList();
    }

    @Transactional
    @Override
    public void deleteUserById(int id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        User userToUpdate = getUserById(id);
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setColor(user.getColor());
        userToUpdate.setAge(user.getAge());
    }
}
