/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.poo.projeto.pluspharm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dayan
 */
public class Conexao {
    Connection con;
    
    public Connection getConexao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
         
            
            
            
       
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/+pharm", "root", "");
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
