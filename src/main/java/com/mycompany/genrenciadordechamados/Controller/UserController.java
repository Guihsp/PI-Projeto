package com.mycompany.genrenciadordechamados.Controller;

import com.mycompany.genrenciadordechamados.DAO.UserDAO;
import com.mycompany.genrenciadordechamados.Model.UserModel;
import java.sql.SQLException;
import java.util.List;

public class UserController {

    private final UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public UserModel createUser(UserModel user) {
        try {
            return userDAO.createUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserModel> getAllUsers() {
        try {
            return userDAO.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserModel getUserById(int id) {
        try {
            return userDAO.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateUser(UserModel user) {
        try {
            return userDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int id) {
        try {
            return userDAO.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean loginUser(String email, String senha) {
        try {
            UserModel user = userDAO.getUserByEmail(email);
            if (user != null) {
                if (userDAO.verifyPassword(senha, user.getPassword())) {
                    return true;
                }
            }
    
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

