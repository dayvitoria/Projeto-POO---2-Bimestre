/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.poo.projeto.pluspharm.controller;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.misc.BASE64Encoder;
import sun.rmi.runtime.Log;

/**
 *
 * @author dayan
 */
public class Registro {
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
    
    public void cadastrar(Usuario pessoa){
        
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
            
            String query = "INSERT INTO usuario (nome, email, idade, cpf, senha) VALUES (?, ?, ?, ?, ?)";
            
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
            if(ex instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException){
                System.out.println("CPF inválido!");
                
            }
            //System.out.println(ex);
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
            
            String query = "SELECT * FROM usuario WHERE cpf = ?";
            
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
            
            
            stmt.executeQuery();
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            return resultado;
    }
    
    public void atualizar(String cpf, Usuario pessoa){
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
            
            String query = "UPDATE usuario SET nome = ?, email = ?, idade = ? WHERE cpf = ?";
            
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
            System.out.println(ex);
        }
            
    }
    
    public void excluir(String cpf){
        
         try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "DELETE FROM usuario WHERE idusuario = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, cpf);
            
            
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
            
            

    }  
    
    public void alterarSenha(String cpf, String senha){
        try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "UPDATE usuario SET senha = ? WHERE cpf = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            Registro r = new Registro();
            stmt.setString(1, r.criptografa(senha));
            stmt.setString(2, cpf);
       
            
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    
    }
    
    public void data(String nome, int periodo){
        
    try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "UPDATE medicamentos SET data_inicio = CURRENT_DATE(), data_final = DATE_ADD(CURDATE(), INTERVAL ? DAY) WHERE nome = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            Login l = new Login();
            id_c = l.recuperar_id();
            stmt.setString(1, Integer.toString(periodo));
            stmt.setString(2, nome);
       
            
            stmt.executeUpdate();
            
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }
    public void adicionarMedicamento(Medicamento medicamento){
        String nome =  medicamento.getNome();
        String descricao = medicamento.getDescricao();
        int quantidade = medicamento.getQuantidade();
        String categoria = medicamento.getCategoria();
        int periodo = medicamento.getPeriodo();
        int id_c = medicamento.getId_c();
        
        try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "INSERT INTO medicamentos (nome, descricao, quantidade, categoria, periodo, id_usuario) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(query);
            Login l = new Login();
            id_c = l.recuperar_id();
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setString(3, Integer.toString(quantidade));
            stmt.setString(4, categoria);
            stmt.setString(5, Integer.toString(periodo));
            stmt.setString(6, Integer.toString(id_c));
            
            
            
            
            
            stmt.executeUpdate();
            Registro r = new Registro();
            r.data(nome, periodo);
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    
    }
    
    public void confirmarMedicamentoTomado(String nome_medicamento, int id_medicamento){
        
        try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "INSERT INTO superintendenciamed (nome_medicamento, data, hora, confirmacao, id_usuario, id_medicamento) VALUES (?, CURRENT_DATE(), CURRENT_TIME(), ?, ?, ?)";
            
            PreparedStatement stmt = con.prepareStatement(query);
            Login l = new Login();
            id_c = l.recuperar_id();
            stmt.setString(1, nome_medicamento);
            stmt.setString(2, Integer.toString(1));
            stmt.setString(3, Integer.toString(id_c));
            stmt.setString(4, Integer.toString(id_medicamento));
            
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }
    
    public void atualizarMedicamento(int idMedicamento, Medicamento medicamento){
        String nome =  medicamento.getNome();
        String descricao = medicamento.getDescricao();
        int quantidade = medicamento.getQuantidade();
        String categoria = medicamento.getCategoria();
        int periodo = medicamento.getPeriodo();
        
        
        try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "UPDATE medicamentos SET nome = ?, descricao = ?, quantidade = ?, categoria = ?, periodo = ? WHERE idmedicamentos = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            Login l = new Login();
            id_c = l.recuperar_id();
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setString(3, Integer.toString(quantidade));
            stmt.setString(4, categoria);
            stmt.setString(5, Integer.toString(periodo));
            stmt.setString(6, Integer.toString(idMedicamento));
            
            
            
            
            
            stmt.executeUpdate();
            Registro r = new Registro();
            r.data(nome, periodo);
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possível encontrar a classe");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }
    
    
    public void excluirMedicamento(int idMedicamento){
        try {
            // TODO add your handling code here:

            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
            
            String query = "DELETE FROM medicamentos WHERE idmedicamentos = ?";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, Integer.toString(idMedicamento));
            
            
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
    
    }
               
}