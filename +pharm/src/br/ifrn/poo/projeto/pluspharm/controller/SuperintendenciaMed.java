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
public class SuperintendenciaMed {
    protected String hora;
    protected int periodo;
    protected boolean confirmacao;
    protected Date data_inicio;
    protected Date data_final;

    public String getHora() {
        return hora;
    }

    public int getPeriodo() {
        return periodo;
    }

    public boolean isConfirmacao() {
        return confirmacao;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public Date getData_final() {
        return data_final;
    }
    
    
    
}
