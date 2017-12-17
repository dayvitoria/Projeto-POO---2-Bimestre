/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.poo.projeto.pluspharm.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dayan
 */
public class Login {
    int id_c;
    
    public boolean autenticar(String cpf, String senha){
        boolean retorno = false;
        Registro c = new Registro();
        String senhac = c.criptografa(senha);
        String login = "";
        try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "UPDATE usuario SET logado = ? WHERE cpf = ? and senha = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, "1");
            stmt.setString(2, cpf);
            stmt.setString(3, senhac);
            
           // ResultSet rs = stmt.executeQuery();
            
          /*  while(rs.next()){
                login = rs.getString("cpf");
            }*/
            
            
            
            
            
      /*      String nome = rs.getString("nome");
            String email = rs.getString("email");
            String idade = rs.getString("idade");
            
            object[0] = nome;
            object[1] = email;
            object[2] = idade;*/
            
            
            stmt.executeUpdate();
            if(stmt.executeUpdate()== 1){
                retorno = true;
            }
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            
        return retorno;
    }
    
    public void sair(){
         try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "UPDATE usuario SET logado = ? WHERE logado = '1'";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, "0");
            
           // ResultSet rs = stmt.executeQuery();
            
          /*  while(rs.next()){
                login = rs.getString("cpf");
            }*/
            
            
            
            
            
      /*      String nome = rs.getString("nome");
            String email = rs.getString("email");
            String idade = rs.getString("idade");
            
            object[0] = nome;
            object[1] = email;
            object[2] = idade;*/
            
            
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            
      //  return "Deu certo!";
    
    
    }
    
    public int recuperar_id(){
        int id_usuario = 0;
        /* 
        String nome =  pessoa.getNome();
        String email = pessoa.getEmail();
        String idade = pessoa.getIdade();
        String cpf = pessoa.getCpf();
        String senha = pessoa.getSenha();*/
    try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "SELECT idusuario FROM usuario WHERE logado = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, "1");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                id_usuario = Integer.parseInt(rs.getString("idusuario"));
            
            }
            
            
      /*      String nome = rs.getString("nome");
            String email = rs.getString("email");
            String idade = rs.getString("idade");
            
            object[0] = nome;
            object[1] = email;
            object[2] = idade;*/
            
            
            stmt.executeQuery();
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return id_usuario;
    
    }
    
    public String recuperarNome(){
        String nome = "";
        
        /* 
        String nome =  pessoa.getNome();
        String email = pessoa.getEmail();
        String idade = pessoa.getIdade();
        String cpf = pessoa.getCpf();
        String senha = pessoa.getSenha();*/
    try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "SELECT nome FROM usuario WHERE logado = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, "1");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                nome = rs.getString("nome");
            
            }
            
            
      /*      String nome = rs.getString("nome");
            String email = rs.getString("email");
            String idade = rs.getString("idade");
            
            object[0] = nome;
            object[1] = email;
            object[2] = idade;*/
            
            
            stmt.executeQuery();
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return nome;
    
    }
    
    public String recuperarCpf(){
        String cpf = "";
        
        try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "SELECT cpf FROM usuario WHERE logado = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, "1");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                cpf = rs.getString("cpf");
            
            }
            
            
      /*      String nome = rs.getString("nome");
            String email = rs.getString("email");
            String idade = rs.getString("idade");
            
            object[0] = nome;
            object[1] = email;
            object[2] = idade;*/
            
            
            stmt.executeQuery();
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            
        
        return cpf;
    
    
    }
    
}
