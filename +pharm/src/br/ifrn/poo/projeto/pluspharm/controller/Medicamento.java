/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.poo.projeto.pluspharm.controller;

import java.sql.Date;

/**
 *
 * @author dayan
 */
public class Medicamento {
    protected String nome;
    protected String descricao;
    protected int quantidade;
    protected String categoria;
    protected Date data_inicio;
    protected Date data_final;
    protected int periodo;
    protected int id_c;

    
    public Medicamento(){
    }

    public Medicamento(String nome, String descricao, int quantidade, String categoria, int periodo) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.periodo = periodo;
        
    }
    
    

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    
}
