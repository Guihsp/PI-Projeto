package com.mycompany.genrenciadordechamados.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.mycompany.genrenciadordechamados.Model.ChamadoModel;
import com.mycompany.genrenciadordechamados.Model.UserModel;

public class UserDAO {

    private Connection connection;

    public UserDAO() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nome_do_seu_banco",
                    "superadmin",
                    "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserModel getUserByIdWithChamados(int id) throws SQLException {
        String sql = "SELECT c.id AS chamado_id, c.titulo, c.descricao, c.dataCriacao, c.dataAtualizacao, c.dataConclusao, c.status, c.tipoDeServico, c.departamento, c.chat, c.atendente_id "
                +
                "FROM Task c " +
                "WHERE c.user_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                UserModel user = new UserModel();
                user.setId(id);

                while (rs.next()) {
                    ChamadoModel chamado = new ChamadoModel();
                    chamado.setId(rs.getInt("chamado_id"));
                    chamado.setTitulo(rs.getString("titulo"));
                    chamado.setDescricao(rs.getString("descricao"));
                    chamado.setDataCriacao(rs.getString("dataCriacao"));
                    chamado.setDataAtualizacao(rs.getString("dataAtualizacao"));
                    chamado.setDataConclusao(rs.getString("dataConclusao"));
                    chamado.setStatus(rs.getString("status"));
                    chamado.setTipoDeServico(rs.getString("tipoDeServico"));
                    chamado.setDepartamento(rs.getString("departamento"));
                    chamado.setChat(rs.getString("chat"));
                    chamado.setAtendente_id(rs.getInt("atendente_id"));

                    user.getChamados().add(chamado);
                }

                return user;
            }
        }
    }

    public List<UserModel> getAllUsers() throws SQLException {
        String sql = "SELECT id, name, email, password, typeUser FROM User";
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            List<UserModel> users = new ArrayList<>();
            while (rs.next()) {
                UserModel user = new UserModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("typeUser"));
                users.add(user);
            }
            return users;
        }
    }

    public UserModel createUser(UserModel user) throws SQLException {
        String hashedPassword = hashPassword(user.getPassword());
        String sql = "INSERT INTO User (name, email, password, typeUser) VALUES (?, ?, ?, ?)";

        System.out.println(user.getTypeUser());
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, hashedPassword);
            ps.setString(4, user.getTypeUser());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Rethrow the exception after logging/handling appropriately
        }

        return user;
    }

    public boolean updateUser(UserModel user) throws SQLException {
        String sql = "UPDATE User SET name = ?, email = ?, password = ?, typeUser = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getTypeUser());
            ps.setInt(5, user.getId());

            int affectedRows = ps.executeUpdate();

            return affectedRows > 0;
        }
    }

    public UserModel getUserByEmail(String email) throws SQLException {
        String sql = "SELECT id, name, email, password, typeUser FROM User WHERE email = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("email ========================>" + email);
                if (rs.next()) {
                    UserModel user = new UserModel(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("typeUser"));
                    return user;
                } else {
                    return null;
                }
            }
        }
    }

    public UserModel getUserById(int id) throws SQLException {
        String sql = "SELECT id, name, email, password, typeUser FROM User WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UserModel user = new UserModel(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("typeUser"));
                    return user;
                } else {
                    return null;
                }
            }
        }
    }

    public boolean deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM User WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();

            return affectedRows > 0;
        }
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(5));
    }

    public boolean verifyPassword(String inputPassword, String hashedPassword) {
        return BCrypt.checkpw(inputPassword, hashedPassword);
    }
}
