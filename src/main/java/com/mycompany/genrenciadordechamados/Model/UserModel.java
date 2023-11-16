package com.mycompany.genrenciadordechamados.Model;

import java.util.List;

public class UserModel {
    private int id;
    private String name;
    private String email;
    private String password;
    private String typeUser;
    private List<ChamadoModel> chamados; 

    public UserModel(int id, String name, String email, String password, String typeUser, List<ChamadoModel> chamados) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
        this.chamados = chamados;
    }
    public UserModel(int id, String name, String email, String password, String typeUser) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
    }

    public UserModel(String name, String email, String password, String typeUser) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
    }

    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public List<ChamadoModel> getChamados() {
        return chamados;
    }

    public void setChamados(List<ChamadoModel> chamados) {
        this.chamados = chamados;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", typeUser='" + typeUser + '\'' +
                ", chamados=" + chamados +
                '}';
    }
}
