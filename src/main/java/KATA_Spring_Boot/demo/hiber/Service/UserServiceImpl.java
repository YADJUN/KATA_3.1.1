package KATA_Spring_Boot.demo.hiber.Service;


import KATA_Spring_Boot.demo.hiber.DAO.UserDAO;

import KATA_Spring_Boot.demo.hiber.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Transactional
    @Override
    public void deleteUserById(int id) {
        userDAO.deleteUserById(id);
    }


    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(int id, User user) {
        userDAO.updateUser(id, user);
    }
}

