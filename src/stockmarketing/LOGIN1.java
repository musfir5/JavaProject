/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarketing;

import static java.lang.System.exit;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class LOGIN1 extends javax.swing.JFrame {

    /**
     * Creates new form LOGIN1
     */
    public LOGIN1() {
        initComponents();
    }
    Connection con;
    PreparedStatement pst;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtusername1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtpass1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 383, 0, 0);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 51));
        jLabel6.setText("Username");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(270, 80, 100, 22);

        txtusername1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusername1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtusername1);
        txtusername1.setBounds(390, 80, 151, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 51));
        jLabel7.setText("Password");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(270, 160, 90, 22);

        txtpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpass1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtpass1);
        txtpass1.setBounds(390, 160, 151, 20);

        jLabel8.setFont(new java.awt.Font("Viner Hand ITC", 3, 18)); // NOI18N
        jLabel8.setText("WELCOME TO MM MOTORS");
        jLabel8.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jLabel8);
        jLabel8.setBounds(160, 20, 250, 22);

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton4.setText("Sign Up");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(270, 290, 107, 20);

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jButton3.setText("Login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(420, 290, 107, 25);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\dell\\Pictures\\exit3.jpg")); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 153), null, null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(580, 0, 30, 37);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stockmarketing/loginimage.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 615, 383);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtusername1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusername1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusername1ActionPerformed

    private void txtpass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpass1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        signup s = new signup();
        s.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            String username =txtusername1.getText().toString();
            String pass= txtpass1.getText().toString();
            
            // TODO add your handling code here:
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","");
            String sql= "select * from login where uname=? AND pass=?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,username);
            pst.setString(2,pass);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){

                informations info=new informations();
                info.setVisible(true);
                this.hide();
            }else{

                JOptionPane.showMessageDialog(this,"Username and Password do not match");
                txtusername1.setText("");
                txtpass1.setText("");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LOGIN1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LOGIN1.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // JOptionPane.showMessageDialog(this,"Thank you . Visit Again");
        int dialogResult = JOptionPane.showConfirmDialog(this,"Do you want to delete","Warning",JOptionPane.YES_NO_OPTION);

        exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LOGIN1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtpass1;
    private javax.swing.JTextField txtusername1;
    // End of variables declaration//GEN-END:variables
}
