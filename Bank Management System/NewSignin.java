
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class NewSignin extends javax.swing.JFrame {
     Login lg1;
     Signin sn1;
    String jtfname;
    public NewSignin(Login lg,Signin sn,String name) {
        this.lg1=lg;
        this.sn1=sn;
        this.jtfname = name;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jlusername = new javax.swing.JLabel();
        jlpassword = new javax.swing.JLabel();
        jtfusername = new javax.swing.JTextField();
        jpfpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jpfcnfpassword = new javax.swing.JPasswordField();
        jbsubmit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jlerrormsg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlusername.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlusername.setForeground(new java.awt.Color(255, 255, 255));
        jlusername.setText("Username");
        getContentPane().add(jlusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 80, 20));

        jlpassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlpassword.setForeground(new java.awt.Color(255, 255, 255));
        jlpassword.setText("Password");
        getContentPane().add(jlpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 100, 20));
        getContentPane().add(jtfusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 220, 26));
        getContentPane().add(jpfpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 220, 26));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirm Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 160, 20));
        getContentPane().add(jpfcnfpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 220, 26));

        jbsubmit.setBackground(new java.awt.Color(204, 255, 255));
        jbsubmit.setText("Submit");
        jbsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsubmitActionPerformed(evt);
            }
        });
        getContentPane().add(jbsubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 80, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 210, -1));

        jlerrormsg.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jlerrormsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 250, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sunset.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsubmitActionPerformed
         if(!"".equals(jtfusername.getText()) && !"".equals(jpfpassword.getText()) && !"".equals(jpfcnfpassword.getText()) ){
            try {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/BankData","hari","1234");
                Statement stmt = con.createStatement();
                
              String query = "UPDATE BANKTABLE SET username ='"+jtfusername.getText()+"',password='"+jpfcnfpassword.getText()+"' WHERE NAME ='"+this.jtfname+"'";
              stmt.execute(query);
          // JOptionPane.showMessageDialog(this,"Eggs are not supposed to be green.","A plain message",JOptionPane.PLAIN_MESSAGE);
              this.dispose();
           //   sn1.setVisible(true);
              sn1.dispose();
              lg1.setVisible(true);
              
            } catch (SQLException ex) {
                Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
           jlerrormsg.setText("No field should be empty");
        }
    }//GEN-LAST:event_jbsubmitActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSignin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewSignin().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbsubmit;
    private javax.swing.JLabel jlerrormsg;
    private javax.swing.JLabel jlpassword;
    private javax.swing.JLabel jlusername;
    private javax.swing.JPasswordField jpfcnfpassword;
    private javax.swing.JPasswordField jpfpassword;
    private javax.swing.JTextField jtfusername;
    // End of variables declaration//GEN-END:variables
}
