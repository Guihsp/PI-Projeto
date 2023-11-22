package com.mycompany.genrenciadordechamados.Model;
public class ChamadoModel {
    private int id;
    private String titulo;
    private String descricao;
    private String dataCriacao;
    private String dataAtualizacao;
    private String dataConclusao;
    private String status;
    private String tipoDeServico;
    private String departamento;
    private String chat;
    private int user_id;
    private int atendente_id;

    public ChamadoModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoDeServico() {
        return tipoDeServico;
    }

    public void setTipoDeServico(String tipoDeServico) {
        this.tipoDeServico = tipoDeServico;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAtendente_id() {
        return atendente_id;
    }

    public void setAtendente_id(int atendente_id) {
        this.atendente_id = atendente_id;
    }

    @Override
    public String toString() {
        return "ChamadoModel{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", dataConclusao=" + dataConclusao +
                ", status='" + status + '\'' +
                ", tipoDeServico='" + tipoDeServico + '\'' +
                ", departamento='" + departamento + '\'' +
                ", chat='" + chat + '\'' +
                ", user_id=" + user_id +
                ", atendente_id=" + atendente_id +
                '}';
    }
}

