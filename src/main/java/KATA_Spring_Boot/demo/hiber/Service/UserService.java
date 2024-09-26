package KATA_Spring_Boot.demo.hiber.Service;

import KATA_Spring_Boot.demo.hiber.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    void addUser(User user);

    List<User> getUsers();

    void deleteUserById(int id);

    User getUserById(int id);

    void updateUser(int id, User user);
}

