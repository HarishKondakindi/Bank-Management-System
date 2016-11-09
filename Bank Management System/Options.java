
public class Options extends javax.swing.JFrame {
     Login lg2;
     
    public Options(Login lg) {
        this.lg2 = lg;
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbaccountinfo = new javax.swing.JButton();
        jbwithdrawal = new javax.swing.JButton();
        jbpinchange = new javax.swing.JButton();
        jbdeposit = new javax.swing.JButton();
        jbupdateinfo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jblogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbaccountinfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbaccountinfo.setText("Account Info");
        getContentPane().add(jbaccountinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 47, 130, 32));

        jbwithdrawal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbwithdrawal.setText("Withdrawal");
        getContentPane().add(jbwithdrawal, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 97, 130, 32));

        jbpinchange.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbpinchange.setText("PIN Change");
        getContentPane().add(jbpinchange, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 147, 130, 32));

        jbdeposit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbdeposit.setText("Deposit");
        getContentPane().add(jbdeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 197, 130, 31));

        jbupdateinfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbupdateinfo.setText("Update Info");
        getContentPane().add(jbupdateinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 246, 130, 32));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jblogout.setText("Log out");
        jblogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jblogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paper_boats_in_rain-wallpaper-960x540.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jblogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblogoutActionPerformed
       this.dispose();
       lg2.reset();
       lg2.setVisible(true);
    }//GEN-LAST:event_jblogoutActionPerformed

   /* public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Options().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbaccountinfo;
    private javax.swing.JButton jbdeposit;
    private javax.swing.JButton jblogout;
    private javax.swing.JButton jbpinchange;
    private javax.swing.JButton jbupdateinfo;
    private javax.swing.JButton jbwithdrawal;
    // End of variables declaration//GEN-END:variables
}
