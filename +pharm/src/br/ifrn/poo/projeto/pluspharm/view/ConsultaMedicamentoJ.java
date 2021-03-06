/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.poo.projeto.pluspharm.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import br.ifrn.poo.projeto.pluspharm.controller.*;
import br.ifrn.poo.projeto.pluspharm.model.Conexao;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author dayan
 */
public class ConsultaMedicamentoJ extends javax.swing.JDialog {

    Conexao conexao = new Conexao();
    /**
     * Creates new form ConsultaMedicamentoJ
     */
    public ConsultaMedicamentoJ(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(205, 201, 201));

        jPanel10.setBackground(new java.awt.Color(205, 201, 201));
        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("ChopinScript", 0, 36)); // NOI18N
        jLabel9.setText("+pharm");

        jLabel2.setFont(new java.awt.Font("ChopinScript", 0, 36)); // NOI18N
        jLabel2.setText("Medicamentos");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGap(0, 127, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(205, 201, 201));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Medicamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idMedicamento", "Nome", "Descrição", "Quantidade", "Categoria", "Data Início", "Data Final"
            }
        ));
        Login l = new Login();
        int id = l.recuperar_id();
        Conexao conexao = new Conexao();
        Connection con = conexao.getConexao();

        try {
            // TODO add your handling code here:

            String query = "SELECT idmedicamentos, med.nome, descricao, quantidade, categoria, DATE_FORMAT(data_inicio, '%d/%m/%y') as data_inicio, DATE_FORMAT(data_final, '%d/%m/%y') as data_final FROM  medicamentos  med JOIN usuario ON id_usuario = idusuario WHERE idusuario = ?";

            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, Integer.toString(id));

            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            model.setNumRows(0);

            while(rs.next()){
                model.addRow(new Object[]{rs.getString("idmedicamentos"), rs.getString("nome"), rs.getString("descricao"), rs.getString("quantidade"), rs.getString("categoria"), rs.getString("data_inicio"), rs.getString("data_final")});

            }
            stmt.executeQuery();

            stmt.close();
            con.close();

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro de SQL");
        }
        jTable1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jTable1ComponentAdded(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton2.setText("Excluir");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Categoria", "Data Início", "Data Final" }));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton3.setText("Filtrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton4.setText("Atualizar");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(37, 37, 37)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
        
    }                                        

 /*   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String index = (String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
        
        Registro r = new Registro();
        r.excluirMedicamento(Integer.parseInt(index));
    }//GEN-LAST:event_jTable1PropertyChange
*/
    private void jTable1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jTable1ComponentAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1ComponentAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String index = (String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
        String nome = (String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1);
        
        int resposta = JOptionPane.showConfirmDialog( null,"Confirmar o medicamento", null,JOptionPane.YES_NO_OPTION);
        if(resposta == 0){
            Registro r = new Registro();
            r.confirmarMedicamentoTomado(nome, Integer.parseInt(index));
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String index = (String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
        
        int resposta = JOptionPane.showConfirmDialog( null,"Confirma a exclusão", null,JOptionPane.YES_NO_OPTION);
        if(resposta == 0){
            Registro r = new Registro();
            r.excluirMedicamento(Integer.parseInt(index));
            dispose();
            ConsultaMedicamentoJ consulta = new ConsultaMedicamentoJ(null, true);
            consulta.setVisible(true);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String categoria;
        Connection con2 = conexao.getConexao();
        if(jComboBox1.getSelectedItem() == "Nome"){
            categoria = "nome";
        }else if(jComboBox1.getSelectedItem() == "Categoria"){
            categoria = "categoria";
        }else if(jComboBox1.getSelectedItem() == "Data Início"){
            categoria = "data_inicio";
        }else{
            categoria = "data_final";
        }
        String query = "", texto = "";
        PreparedStatement stmt;
        try {
            // TODO add your handling code here:
            
            if(categoria == "nome"){
            query = "SELECT idmedicamentos, med.nome, descricao, quantidade, categoria, DATE_FORMAT(data_inicio, '%d/%m/%y') as data_inicio, DATE_FORMAT(data_final, '%d/%m/%y') as data_final FROM  medicamentos  med JOIN usuario ON id_usuario = idusuario WHERE med.nome LIKE ?";   
            texto = "%"+jTextField1.getText()+"%";
            }else if(categoria == "categoria"){
            query = "SELECT idmedicamentos, med.nome, descricao, quantidade, categoria, DATE_FORMAT(data_inicio, '%d/%m/%y') as data_inicio, DATE_FORMAT(data_final, '%d/%m/%y') as data_final FROM  medicamentos  med JOIN usuario ON id_usuario = idusuario WHERE categoria LIKE ?";
            texto = "%"+jTextField1.getText()+"%";
            }else if(categoria == "data_inicio"){
            query = "SELECT idmedicamentos, med.nome, descricao, quantidade, categoria, DATE_FORMAT(data_inicio, '%d/%m/%y') as data_inicio, DATE_FORMAT(data_final, '%d/%m/%y') as data_final FROM  medicamentos  med JOIN usuario ON id_usuario = idusuario WHERE data_inicio = DATE_FORMAT(?, '%d/%m/%y')";
            texto = jTextField1.getText();
            }else if(categoria == "data_final"){
            query = "SELECT idmedicamentos, med.nome, descricao, quantidade, categoria, DATE_FORMAT(data_inicio, '%d/%m/%y') as data_inicio, DATE_FORMAT(data_final, '%d/%m/%y') as data_final FROM  medicamentos  med JOIN usuario ON id_usuario = idusuario WHERE data_final = DATE_FORMAT(?, '%d/%m/%y')";
            texto = jTextField1.getText();
            }
            
            stmt = con2.prepareStatement(query);
            

            stmt.setString(1, texto);
            
            ResultSet rs = stmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            
            model.setNumRows(0);
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("idmedicamentos"), rs.getString("nome"), rs.getString("descricao"), rs.getString("quantidade"), rs.getString("categoria"), rs.getString("data_inicio"), rs.getString("data_final")});
                
            }
            stmt.executeQuery();
            
            stmt.close();
            con2.close();
            
        }catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String index = (String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
        Connection con2 = conexao.getConexao();
        

        String nome = "";
        String descricao = "";
        int quantidade = 0;
        int periodo = 0;
        
try {
            // TODO add your handling code here:
            
            String query = "SELECT nome, descricao, quantidade, periodo FROM  medicamentos  WHERE idmedicamentos =  ?";
            
            PreparedStatement stmt = con2.prepareStatement(query);
            
            stmt.setString(1, index);
            
            ResultSet rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                nome = rs.getString("nome");
                descricao = rs.getString("descricao");
                quantidade = Integer.parseInt(rs.getString("quantidade"));
                periodo = Integer.parseInt(rs.getString("periodo"));
                
                
                
            }
            stmt.executeQuery();
            
            stmt.close();
            con2.close();
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro de SQL");
        }

        AtualizarMedicamentoJ atualizar = new AtualizarMedicamentoJ(null, true);
        atualizar.receber(nome, descricao, quantidade, periodo);
        atualizar.getId(Integer.parseInt(index));
        atualizar.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaMedicamentoJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaMedicamentoJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaMedicamentoJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaMedicamentoJ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultaMedicamentoJ dialog = new ConsultaMedicamentoJ(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
