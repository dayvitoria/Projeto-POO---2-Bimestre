/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.poo.projeto.pluspharm.controller;


import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author dayan
 */
public class SuperintendenciaMed {
    
    protected String nome_medicamento;
    protected Time hora;
    protected int periodo;
    protected boolean confirmacao;
    protected Date data;

    public String getNome_medicamento() {
        return nome_medicamento;
    }
    
    public Time getHora() {
        return hora;
    }

    public int getPeriodo() {
        return periodo;
    }

    public boolean isConfirmacao() {
        return confirmacao;
    }

    public Date getData() {
        return data;
    }
    
    
    
}
