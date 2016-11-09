
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class OptionsFrame2 extends javax.swing.JFrame {
    Double amount = 0.0;
    Connection con;
    Statement stmt;
    String user;
   jpdeposit jpdep;
   WthdrawPanel jpwithdraw;
   PinChangePanel jppinchange;
   UpdatePanel jpupdate ;
   InfoPanel jpinfo;
   Login lg1;

    public OptionsFrame2(String s,Connection C,Login lg) {
        
        initComponents();
        jLabel1.setText("");
        this.con = C;
        this.user  =s;
        this.lg1 = lg;
        this.setLayout(new CardLayout());
         jpwithdraw = new WthdrawPanel(con,user,this);
         jpdep = new jpdeposit(con,user,this);
         jppinchange = new PinChangePanel(con,user,this);
         jpupdate = new UpdatePanel(con,user,this);
          jpinfo = new InfoPanel(con,user,this);
         jpdep.setVisible(false);
         jpwithdraw.setVisible(false);
         this.add(jpwithdraw);
         this.add(jpdep);
         this.add(jppinchange);
         this.add(jpupdate);
         this.add(jpinfo);
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        joptions = new javax.swing.JPanel();
        jbinfo = new javax.swing.JButton();
        jbwithdraw = new javax.swing.JButton();
        jbdeposit = new javax.swing.JButton();
        jbchangepin = new javax.swing.JButton();
        jbupdate = new javax.swing.JButton();
        jblogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thor_2_the_dark_world-1920x1080.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        joptions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbinfo.setText("Account Info");
        jbinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbinfoActionPerformed(evt);
            }
        });
        joptions.add(jbinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 120, 30));

        jbwithdraw.setText("Withdraw");
        jbwithdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbwithdrawActionPerformed(evt);
            }
        });
        joptions.add(jbwithdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 120, 30));

        jbdeposit.setText("Deposit");
        jbdeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbdepositActionPerformed(evt);
            }
        });
        joptions.add(jbdeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 120, 30));

        jbchangepin.setText("Change PIN");
        jbchangepin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbchangepinActionPerformed(evt);
            }
        });
        joptions.add(jbchangepin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 120, 30));

        jbupdate.setText("Update Info");
        jbupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbupdateActionPerformed(evt);
            }
        });
        joptions.add(jbupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 120, 30));

        jblogout.setText(" Log Out");
        jblogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblogoutActionPerformed(evt);
            }
        });
        joptions.add(jblogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 243, 90, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/samsung_phones_brand_rocks_form_style_26188_1366x768.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        joptions.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 310));

        getContentPane().add(joptions, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbwithdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbwithdrawActionPerformed
        joptions.setVisible(false);
        jpwithdraw.setVisible(true);
        
        

    }//GEN-LAST:event_jbwithdrawActionPerformed

    private void jbdepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbdepositActionPerformed
          joptions.setVisible(false);
        jpdep.setVisible(true);
    }//GEN-LAST:event_jbdepositActionPerformed

    private void jbchangepinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbchangepinActionPerformed
        
        joptions.setVisible(false);
        jppinchange.setVisible(true);
    }//GEN-LAST:event_jbchangepinActionPerformed

    private void jbupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbupdateActionPerformed
        joptions.setVisible(false);
        jpupdate.setVisible(true);
    }//GEN-LAST:event_jbupdateActionPerformed

    private void jbinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbinfoActionPerformed
        joptions.setVisible(false);
        jpinfo.view();
        jpinfo.setVisible(true);
    }//GEN-LAST:event_jbinfoActionPerformed

    private void jblogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblogoutActionPerformed
        try {
            con.close();
             this.dispose();
             
             lg1.setVisible(true);
        
        } catch (SQLException ex) {
            Logger.getLogger(OptionsFrame2.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }//GEN-LAST:event_jblogoutActionPerformed

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
            java.util.logging.Logger.getLogger(OptionsFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionsFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionsFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionsFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionsFrame2().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbchangepin;
    private javax.swing.JButton jbdeposit;
    private javax.swing.JButton jbinfo;
    private javax.swing.JButton jblogout;
    private javax.swing.JButton jbupdate;
    private javax.swing.JButton jbwithdraw;
    private javax.swing.JPanel joptions;
    // End of variables declaration//GEN-END:variables
}
