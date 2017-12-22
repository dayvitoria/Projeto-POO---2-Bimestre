/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.poo.projeto.pluspharm.view;
import br.ifrn.poo.projeto.pluspharm.controller.*;
/**
 *
 * @author dayan
 */
public class Main {
    public static void main(String[] args) {
        
        
        Login l = new Login();
        int id = l.recuperar_id();
        if(id != 0){
            PrincipalJFrame principal = new PrincipalJFrame();
            principal.setVisible(true);
        }else{
            MenuPrincipal mp = new MenuPrincipal();
            mp.setVisible(true);
        }
        /*PrincipalJFrame princ = new PrincipalJFrame();
        princ.setVisible(true);*/
    }
    
    
    
    
}
