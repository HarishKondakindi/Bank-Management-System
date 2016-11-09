
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Signin extends javax.swing.JFrame {
     Login lg1;
     private int flag =0;
    public Signin(Login lg) {
        this.lg1=lg;
        initComponents();
        jtfname.setText("");
        jtfacnumber.setText("");
        jtfemail.setText("");
        jtfphone.setText("");
        jpfpin.setText("");
        jtfaddress.setText("");
        this.setVisible(true);
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlname = new javax.swing.JLabel();
        jlacnumber = new javax.swing.JLabel();
        jlemail = new javax.swing.JLabel();
        jlphonenumber = new javax.swing.JLabel();
        jlpin = new javax.swing.JLabel();
        jladdress = new javax.swing.JLabel();
        jbsubmit = new javax.swing.JButton();
        jtfname = new javax.swing.JTextField();
        jtfacnumber = new javax.swing.JTextField();
        jtfemail = new javax.swing.JTextField();
        jtfphone = new javax.swing.JTextField();
        jtfaddress = new javax.swing.JTextField();
        jpfpin = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jlerror = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlerrormsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlname.setForeground(new java.awt.Color(255, 255, 255));
        jlname.setText("Name");
        getContentPane().add(jlname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, 102, -1));

        jlacnumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlacnumber.setForeground(new java.awt.Color(255, 255, 255));
        jlacnumber.setText("Account Number");
        getContentPane().add(jlacnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, -1, -1));

        jlemail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlemail.setForeground(new java.awt.Color(255, 255, 255));
        jlemail.setText("Email");
        getContentPane().add(jlemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, 102, 23));

        jlphonenumber.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlphonenumber.setForeground(new java.awt.Color(255, 255, 255));
        jlphonenumber.setText("Phone number");
        getContentPane().add(jlphonenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 145, 102, 26));

        jlpin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlpin.setForeground(new java.awt.Color(255, 255, 255));
        jlpin.setText("PIN");
        getContentPane().add(jlpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 189, 102, -1));

        jladdress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jladdress.setForeground(new java.awt.Color(255, 255, 255));
        jladdress.setText("Address");
        getContentPane().add(jladdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 225, 102, -1));

        jbsubmit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbsubmit.setText("Submit");
        jbsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsubmitActionPerformed(evt);
            }
        });
        getContentPane().add(jbsubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, -1));
        getContentPane().add(jtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 27, 255, 26));
        getContentPane().add(jtfacnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 60, 255, 26));
        getContentPane().add(jtfemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 101, 255, 26));
        getContentPane().add(jtfphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 145, 173, 26));
        getContentPane().add(jtfaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 214, 255, 26));
        getContentPane().add(jpfpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 177, 67, 26));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 264, 224, -1));
        getContentPane().add(jlerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 258, 240, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bicycle-1366x768.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 370));

        jlerrormsg.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(jlerrormsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 270, 259, 24));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsubmitActionPerformed
        if(!"".equals(jtfname.getText()) && !"".equals(jtfacnumber.getText()) && !"".equals(jtfemail.getText()) && !"".equals(jtfphone.getText()) && !"".equals(jpfpin.getText()) && jpfpin.getText().length()<=4 && !"".equals(jtfaddress.getText())){
            try {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/BankData","hari","1234");
                Statement stmt = con.createStatement();
                
                 ResultSet rs = stmt.executeQuery("SELECT * FROM BANKTABLE");
                 while(rs.next()){
                     if(rs.getString("acnumber").equals(jtfacnumber.getText())){
                         flag=1;
                         break;
                     }
                 }
                 
                 if(flag==0){
                
            //  String query = "DELETE FROM BANKTABLE WHERE NAME = 'Harish'";
                   String query = "INSERT INTO BANKTABLE (name,acnumber,email,phone,pin,address) VALUES ('"+jtfname.getText()+"','"+jtfacnumber.getText()+"','"+jtfemail.getText()+"','"+jtfphone.getText()+"','"+jpfpin.getText()+"','"+jtfaddress.getText()+"')";
                   stmt.execute(query);
                   NewSignin newsign = new NewSignin(this.lg1,this,this.jtfname.getText());
                   newsign.setVisible(true);
                 }
                 else{
                     jlerrormsg.setText("Account number alreadyexists");
                 }
              
            } catch (SQLException ex) {
                Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            jlerrormsg.setText("No field should be empty");
        }
    }//GEN-LAST:event_jbsubmitActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signin(Login lg).setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbsubmit;
    private javax.swing.JLabel jlacnumber;
    private javax.swing.JLabel jladdress;
    private javax.swing.JLabel jlemail;
    private javax.swing.JLabel jlerror;
    private javax.swing.JLabel jlerrormsg;
    private javax.swing.JLabel jlname;
    private javax.swing.JLabel jlphonenumber;
    private javax.swing.JLabel jlpin;
    private javax.swing.JPasswordField jpfpin;
    private javax.swing.JTextField jtfacnumber;
    private javax.swing.JTextField jtfaddress;
    private javax.swing.JTextField jtfemail;
    private javax.swing.JTextField jtfname;
    private javax.swing.JTextField jtfphone;
    // End of variables declaration//GEN-END:variables
}
