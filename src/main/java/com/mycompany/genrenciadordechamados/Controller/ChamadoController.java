package com.mycompany.genrenciadordechamados.Controller;

import com.mycompany.genrenciadordechamados.DAO.ChamadoDAO;
import com.mycompany.genrenciadordechamados.Model.ChamadoModel;

import java.sql.SQLException;
import java.util.List;

public class ChamadoController {

    private final ChamadoDAO chamadoDAO;

    public ChamadoController() {
        this.chamadoDAO = new ChamadoDAO();
    }

    public ChamadoModel createChamado(ChamadoModel chamado) {
        try {
            return chamadoDAO.createChamado(chamado);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ChamadoModel> getAllChamados() {
        try {
            return chamadoDAO.getAllChamados();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ChamadoModel getChamadoById(int id) {
        try {
            return chamadoDAO.getChamadoById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ChamadoModel> getChamadoByStatus(String status) {
        try {
            System.out.println(status);
            return chamadoDAO.getChamadosbyStatus(status);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ChamadoModel> getChamadosByUserId(int userId) {
        try {
            return chamadoDAO.getChamadosByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateChamado(ChamadoModel chamado) {
        try {
            return chamadoDAO.updateChamado(chamado);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteChamado(int id) {
        try {
            return chamadoDAO.deleteChamado(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
