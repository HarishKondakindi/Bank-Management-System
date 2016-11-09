
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class jpdeposit extends javax.swing.JPanel {
     Connection con;
     Statement stmt;
     String user;
    private Double amount;
     private Double bal;
    OptionsFrame2 opf2;
    public jpdeposit(Connection C,String s,OptionsFrame2 op) {
        initComponents();
        this.con= C;
        this.user = s;
        this.opf2 = op;
        jtfdeposit.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfdeposit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbokdeposit = new javax.swing.JButton();
        jldepositerror = new javax.swing.JLabel();
        jbcancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setText("Enter the amount to deposit");

        jLabel2.setText("Rs.");

        jbokdeposit.setText("OK");
        jbokdeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbokdepositActionPerformed(evt);
            }
        });

        jbcancel.setText("Cancel");
        jbcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfdeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jldepositerror, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbokdeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfdeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jldepositerror, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbokdeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbokdepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbokdepositActionPerformed
        if(!"".equals(jtfdeposit.getText())){
            try {
                stmt =con.createStatement();
                String query = "SELECT * FROM BANKTABLE WHERE username = '"+user+"'";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                 bal = Double.parseDouble(rs.getString(9));
                }
                
                amount = Double.parseDouble(jtfdeposit.getText());
                
                    bal = bal+amount;
                    query = "UPDATE BANKTABLE SET balance = '"+bal.toString()+"' WHERE username ='"+user+"'";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(null,"Amount deposited : "+amount.toString()+"Available Balance : "+bal.toString());
                    this.setVisible(false);
                    opf2.setVisible(true);
                
            } catch (SQLException ex) {
                Logger.getLogger(OptionsFrame2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            jldepositerror.setText("Please enter an amount");
        }
    }//GEN-LAST:event_jbokdepositActionPerformed

    private void jbcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelActionPerformed
        jtfdeposit.setText("");
        this.setVisible(false);
        opf2.setVisible(true);
    }//GEN-LAST:event_jbcancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbcancel;
    private javax.swing.JButton jbokdeposit;
    private javax.swing.JLabel jldepositerror;
    private javax.swing.JTextField jtfdeposit;
    // End of variables declaration//GEN-END:variables
}
