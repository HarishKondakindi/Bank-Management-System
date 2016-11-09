
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class WthdrawPanel extends javax.swing.JPanel {
     Connection con;
     Statement stmt;
     String user;
    private Double amount;
     private Double bal;
    OptionsFrame2 opf2;

    public WthdrawPanel(Connection C,String s,OptionsFrame2 op) {
        initComponents();
        this.con= C;
        this.user = s;
        this.opf2 = op;
        jtfwithdraw.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfwithdraw = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbok = new javax.swing.JButton();
        jlnobalance = new javax.swing.JLabel();
        jbcancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setText("Enter the amount to be withdrawn");

        jLabel2.setText("Rs.");

        jbok.setText("OK");
        jbok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbokActionPerformed(evt);
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
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfwithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlnobalance, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbok, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbcancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfwithdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jlnobalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbok, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jbcancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbokActionPerformed
        if(!"".equals(jtfwithdraw.getText())){
            try {
                stmt =con.createStatement();
                String query = "SELECT * FROM BANKTABLE WHERE username = '"+user+"'";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                 bal = Double.parseDouble(rs.getString(9));
                }

                this.amount = Double.parseDouble(jtfwithdraw.getText());
                if(bal>=this.amount){
                    jlnobalance.setText("");
                    bal = bal-this.amount;
                    query = "UPDATE BANKTABLE SET balance = '"+bal.toString()+"' WHERE username ='"+user+"'";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(null,"Amount withdrawn : "+this.amount.toString()+"Available Balance : "+bal.toString());
                    this.setVisible(false);
                    
                    opf2.setVisible(true);

                }
                else
                jlnobalance.setText("Insufficient Balance");
            } catch (SQLException ex) {
                Logger.getLogger(OptionsFrame2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            jlnobalance.setText("Please enter the amount");
        }
    }//GEN-LAST:event_jbokActionPerformed

    private void jbcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelActionPerformed
        jtfwithdraw.setText("");
        this.setVisible(false);
          opf2.setVisible(true);
    }//GEN-LAST:event_jbcancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbcancel;
    private javax.swing.JButton jbok;
    private javax.swing.JLabel jlnobalance;
    private javax.swing.JTextField jtfwithdraw;
    // End of variables declaration//GEN-END:variables
}
