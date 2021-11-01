package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User getUserByName(String name);
    void updateUser(User user);
    void deleteUserById(Long id);
}