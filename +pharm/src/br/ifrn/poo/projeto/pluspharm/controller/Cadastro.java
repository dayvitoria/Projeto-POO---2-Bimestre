/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.poo.projeto.pluspharm.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author dayan
 */
public class Cadastro {
    int id_c;
    
    public String criptografa(String senha){
		try{
		 MessageDigest digest = MessageDigest.getInstance("MD5");
		               digest.update(senha.getBytes());
		 BASE64Encoder encoder = new BASE64Encoder();
		        return encoder.encode(digest.digest());
		}catch(NoSuchAlgorithmException ns){
			ns.printStackTrace();
		}
		return senha;
	}
    
    public void cadastrar(Pessoa pessoa){
        
        String nome =  pessoa.getNome();
        String email = pessoa.getEmail();
        String idade = pessoa.getIdade();
        String cpf = pessoa.getCpf();
        String senha = criptografa(pessoa.getSenha());
        
        try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "INSERT INTO cadastro (nome, email, idade, cpf, senha) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, idade);
            stmt.setString(4, cpf);
            stmt.setString(5, senha);
            
            
            
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL");
        }
    
    }
    
    
    public String[] consultar(String cpf){
        String[] resultado = new String[3];
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
            
            String query = "SELECT * FROM cadastro WHERE cpf = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                resultado[0] = rs.getString("nome");
                resultado[1] = rs.getString("email");
                resultado[2] = rs.getString("idade");
            
            }
            
            
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
            System.out.println("Ocorreu um erro de SQL");
        }
            return resultado;
    }
    
    public void atualizar(String cpf, Pessoa pessoa){
        String nome = pessoa.getNome();
        String email = pessoa.getEmail();
        String idade = pessoa.getIdade();
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
            
            String query = "UPDATE cadastro SET nome = ?, email = ?, idade = ? WHERE cpf = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, idade);
            stmt.setString(4, cpf);
            
            
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL");
        }
            
    }
    
    public boolean excluir(String cpf){
        boolean retorno = false;
         try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "DELETE FROM cadastro WHERE cpf = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, cpf);
            
            
      /*      String nome = rs.getString("nome");
            String email = rs.getString("email");
            String idade = rs.getString("idade");
            
            object[0] = nome;
            object[1] = email;
            object[2] = idade;*/
            
            
            if(stmt.executeUpdate() == 1){
                retorno = true;
            }
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL");
        }
            
            return retorno;

    }  
    
    public void adicionarMedicamento(Medicamento medicamento){
        String nome =  medicamento.getNome();
        String descricao = medicamento.getDescricao();
        String quantidade = medicamento.getQuantidade();
        String categoria = medicamento.getCategoria();
        int id_c = medicamento.getId_c();
        
        try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "INSERT INTO medicamentos (nome, descricao, quantidade, categoria, id_c) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(query);
            Login l = new Login();
            id_c = l.recuperar_id();
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setString(3, quantidade);
            stmt.setString(4, categoria);
            stmt.setString(5, Integer.toString(id_c));
            
            
            
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL");
        }
    
    
    }
               
}