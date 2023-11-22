package com.mycompany.genrenciadordechamados.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.genrenciadordechamados.Model.ChamadoModel;

public class ChamadoDAO {
    private Connection connection;

    public ChamadoDAO() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nome_do_seu_banco",
                    "superadmin",
                    "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ChamadoModel getChamadoById(int id) throws SQLException {
        String sql = "SELECT * FROM Task WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ChamadoModel chamado = new ChamadoModel();
                    chamado.setId(rs.getInt("id"));
                    chamado.setTitulo(rs.getString("titulo"));
                    chamado.setDescricao(rs.getString("descricao"));
                    chamado.setDataCriacao(rs.getString("dataCriacao"));
                    chamado.setDataAtualizacao(rs.getString("dataAtualizacao"));
                    chamado.setDataConclusao(rs.getString("dataConclusao"));
                    chamado.setStatus(rs.getString("status"));
                    chamado.setTipoDeServico(rs.getString("tipoDeServico"));
                    chamado.setDepartamento(rs.getString("departamento"));
                    chamado.setChat(rs.getString("chat"));
                    chamado.setUser_id(rs.getInt("user_id"));
                    chamado.setAtendente_id(rs.getInt("atendente_id"));
                    return chamado;
                }
            }
        }
        return null;
    }

    public List<ChamadoModel> getChamadosbyStatus(String status) throws SQLException{
        String sql = "SELECT * FROM Task WHERE status = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, status);
            try (ResultSet rs = ps.executeQuery()) {
                List<ChamadoModel> chamados = new ArrayList<>();
                while (rs.next()) {
                    ChamadoModel chamado = new ChamadoModel();
                    chamado.setId(rs.getInt("id"));
                    chamado.setTitulo(rs.getString("titulo"));
                    chamado.setDescricao(rs.getString("descricao"));
                    chamado.setDataCriacao(rs.getString("dataCriacao"));
                    chamado.setDataAtualizacao(rs.getString("dataAtualizacao"));
                    chamado.setDataConclusao(rs.getString("dataConclusao"));
                    chamado.setStatus(rs.getString("status"));
                    chamado.setTipoDeServico(rs.getString("tipoDeServico"));
                    chamado.setDepartamento(rs.getString("departamento"));
                    chamado.setChat(rs.getString("chat"));
                    chamado.setUser_id(rs.getInt("user_id"));
                    chamado.setAtendente_id(rs.getInt("atendente_id"));
                    chamados.add(chamado);
                }
                return chamados;
            }
        }
    }

    public List<ChamadoModel> getChamadosByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM Task WHERE user_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                List<ChamadoModel> chamados = new ArrayList<>();
                while (rs.next()) {
                    ChamadoModel chamado = new ChamadoModel();
                    chamado.setId(rs.getInt("id"));
                    chamado.setTitulo(rs.getString("titulo"));
                    chamado.setDescricao(rs.getString("descricao"));
                    chamado.setDataCriacao(rs.getString("dataCriacao"));
                    chamado.setDataAtualizacao(rs.getString("dataAtualizacao"));
                    chamado.setDataConclusao(rs.getString("dataConclusao"));
                    chamado.setStatus(rs.getString("status"));
                    chamado.setTipoDeServico(rs.getString("tipoDeServico"));
                    chamado.setDepartamento(rs.getString("departamento"));
                    chamado.setChat(rs.getString("chat"));
                    chamado.setUser_id(rs.getInt("user_id"));
                    chamado.setAtendente_id(rs.getInt("atendente_id"));
                    chamados.add(chamado);
                }
                return chamados;
            }
        }
    }

    public ChamadoModel createChamado(ChamadoModel chamado) throws SQLException {
        String sql = "INSERT INTO Task (titulo, descricao, dataCriacao, dataAtualizacao, dataConclusao, status, tipoDeServico, departamento, chat, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, chamado.getTitulo());
            ps.setString(2, chamado.getDescricao());
            ps.setString(3, chamado.getDataCriacao());
            ps.setString(4, chamado.getDataAtualizacao());
            ps.setString(5, chamado.getDataConclusao());
            ps.setString(6, chamado.getStatus());
            ps.setString(7, chamado.getTipoDeServico());
            ps.setString(8, chamado.getDepartamento());
            ps.setString(9, chamado.getChat());
            ps.setInt(10, chamado.getUser_id());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir chamado, nenhum registro afetado.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    chamado.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao inserir chamado, nenhum ID obtido.");
                }
            }
        }
        return chamado;
    }

    public boolean updateChamado(ChamadoModel chamado) throws SQLException {
        String sql = "UPDATE Task SET titulo=?, descricao=?, dataCriacao=?, dataAtualizacao=?, dataConclusao=?, status=?, tipoDeServico=?, departamento=?, chat=?, user_id=?, atendente_id=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, chamado.getTitulo());
            ps.setString(2, chamado.getDescricao());
            ps.setString(3, chamado.getDataCriacao());
            ps.setString(4, chamado.getDataAtualizacao());
            ps.setString(5, chamado.getDataConclusao());
            ps.setString(6, chamado.getStatus());
            ps.setString(7, chamado.getTipoDeServico());
            ps.setString(8, chamado.getDepartamento());
            ps.setString(9, chamado.getChat());
            ps.setInt(10, chamado.getUser_id());
            ps.setInt(11, chamado.getAtendente_id());
            ps.setInt(12, chamado.getId());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean deleteChamado(int id) throws SQLException {
        String sql = "DELETE FROM Task WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }

    public List<ChamadoModel> getAllChamados() throws SQLException {
        String sql = "SELECT * FROM Task";
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            List<ChamadoModel> chamados = new ArrayList<>();
            while (rs.next()) {
                ChamadoModel chamado = new ChamadoModel();
                chamado.setId(rs.getInt("id"));
                chamado.setTitulo(rs.getString("titulo"));
                chamado.setDescricao(rs.getString("descricao"));
                chamado.setDataCriacao(rs.getString("dataCriacao"));
                chamado.setDataAtualizacao(rs.getString("dataAtualizacao"));
                chamado.setDataConclusao(rs.getString("dataConclusao"));
                chamado.setStatus(rs.getString("status"));
                chamado.setTipoDeServico(rs.getString("tipoDeServico"));
                chamado.setDepartamento(rs.getString("departamento"));
                chamado.setChat(rs.getString("chat"));
                chamado.setUser_id(rs.getInt("user_id"));
                chamado.setAtendente_id(rs.getInt("atendente_id"));

                chamados.add(chamado);
            }
            return chamados;
        }
    }

}
