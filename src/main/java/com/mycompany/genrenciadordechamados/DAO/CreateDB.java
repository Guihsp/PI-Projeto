package com.mycompany.genrenciadordechamados.DAO;

import java.sql.*;

public class CreateDB {
    private static Connection connection;

    public static void criarBancoDB() {

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nome_do_seu_banco",
                    "superadmin",
                    "root");
            if (connection != null) {
                System.out.println("Conexão com o banco de dados estabelecida!");
                // suicid(connection);
                createDatabase(connection);
                useDatabase(connection);
                createUserTable(connection);
                createTaskTable(connection);
                System.out.println("Banco de dados e tabelas criados com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void suicid (Connection connection) throws SQLException{
        String suicidSQL = "DROP DATABASE tasksPlataform";
        try (Statement statement = connection.createStatement()) {
            statement.execute(suicidSQL);
        }
    }

    private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS tasksPlataform";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createDatabaseSQL);
        }
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL = "USE tasksPlataform";
        try (Statement statement = connection.createStatement()) {
            statement.execute(useDatabaseSQL);
        }
    }

    private static void createUserTable(Connection connection) throws SQLException {
        String createUserTableSQL = "CREATE TABLE IF NOT EXISTS User ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "email VARCHAR(255) NOT NULL UNIQUE,"
                + "password VARCHAR(255) NOT NULL,"
                + "typeUser VARCHAR(255) NOT NULL"
                + ")ENGINE=InnoDB";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createUserTableSQL);
        }
    }

    private static void createTaskTable(Connection connection) throws SQLException {
        String createTaskTableSQL = "CREATE TABLE IF NOT EXISTS Task ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "titulo VARCHAR(255),"
                + "descricao TEXT,"
                + "dataCriacao VARCHAR(5),"
                + "dataAtualizacao VARCHAR(5),"
                + "dataConclusao VARCHAR(5),"
                + "status VARCHAR(255),"
                + "tipoDeServico VARCHAR(255),"
                + "departamento VARCHAR(255),"
                + "chat TEXT,"
                + "user_id INT NOT NULL,"
                + "atendente_id INT,"
                + "CONSTRAINT FK_TasksUser FOREIGN KEY (user_id) REFERENCES User(id)"
                + ")";
        try (Statement statement = connection.createStatement()) {
            statement.execute(createTaskTableSQL);
        }
    }
}
