/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.genrenciadordechamados;

import com.mycompany.genrenciadordechamados.DAO.CreateDB;
import com.mycompany.genrenciadordechamados.DAO.UserDAO;
import com.mycompany.genrenciadordechamados.Model.UserModel;
import com.mycompany.genrenciadordechamados.View.TelaLoginUsuario;

import java.sql.SQLException;

import com.mycompany.genrenciadordechamados.Controller.UserController;

/**
 *
 * @author Guilh
 */
public class GenrenciadorDeChamados {

    /**
     * @param args the command line arguments
     * @throws SQLException
     */

    static void createAdmin() throws SQLException {
        UserController usercontroller = new UserController();
        UserModel adminUser = new UserModel();
        adminUser.setName("admin");
        adminUser.setEmail("admin@admin.com");
        adminUser.setPassword("admin");
        adminUser.setTypeUser("admin");
        usercontroller.createUser(adminUser);
    }

    public static void main(String[] args) throws SQLException {
        CreateDB.criarBancoDB();
        UserDAO user = new UserDAO();
        UserModel admin = user.getUserByEmail("admin@admin.com");
        if (admin == null) {
            createAdmin();
        }
        TelaLoginUsuario telaLoginUsuario = new TelaLoginUsuario();
        telaLoginUsuario.setVisible(true);
    }

}
