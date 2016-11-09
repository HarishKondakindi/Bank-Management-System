import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Login extends javax.swing.JFrame {
    Connection con;
 
    public Login() {
        initComponents();
        jtfusername.setText("");
        jpfpassword.setText("");
       // jpfpassword.setEchoChar(');
    }    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jlusername = new javax.swing.JLabel();
        jtfusername = new javax.swing.JTextField();
        jlpassword = new javax.swing.JLabel();
        jblogin = new javax.swing.JButton();
        jbsignin = new javax.swing.JButton();
        jpfpassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlusername.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlusername.setForeground(new java.awt.Color(255, 255, 255));
        jlusername.setText("User name");
        getContentPane().add(jlusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 46, 105, 37));
        getContentPane().add(jtfusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 52, 232, 28));

        jlpassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlpassword.setForeground(new java.awt.Color(255, 255, 255));
        jlpassword.setText("Password");
        getContentPane().add(jlpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 112, 69, 27));

        jblogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jblogin.setText("Login");
        jblogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbloginActionPerformed(evt);
            }
        });
        getContentPane().add(jblogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 167, -1, -1));

        jbsignin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbsignin.setText("Signin");
        jbsignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsigninActionPerformed(evt);
            }
        });
        getContentPane().add(jbsignin, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 167, -1, -1));

        jpfpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jpfpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 113, 232, 28));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 216, 386, 22));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/feather_drop-1366x768.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void reset(){
        jtfusername.setText("");
        jpfpassword.setText("");
        
    }
    
    
    private void jbloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbloginActionPerformed
       
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/BankData","hari","1234");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM BANKTABLE");
             
             while(rs.next()){
                 if( jtfusername.getText().equals(rs.getString("username")) && jpfpassword.getText().equals(rs.getString("password")) ){
                  //  System.out.println(rs.getString("username")+"    "+jtfusername.getText());
                     flag=1;
                     break;
                 }
                 else{
                    continue; 
                 }
             }
             
             if(flag==1){
             OptionsFrame2 op = new OptionsFrame2(this.jtfusername.getText(),con,this);
             op.setVisible(true);
             this.jtfusername.setText("");
             this.jpfpassword.setText("");
             }
             else{
                 jLabel1.setText("Invalid username or password");
                 flag=0;
             }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbloginActionPerformed

    private void jbsigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsigninActionPerformed
        Signin signup = new Signin(this);
        signup.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbsigninActionPerformed

    private void jpfpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfpasswordActionPerformed
        
    }//GEN-LAST:event_jpfpasswordActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    int flag=0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jblogin;
    private javax.swing.JButton jbsignin;
    private javax.swing.JLabel jlpassword;
    private javax.swing.JLabel jlusername;
    private javax.swing.JPasswordField jpfpassword;
    private javax.swing.JTextField jtfusername;
    // End of variables declaration//GEN-END:variables
}
