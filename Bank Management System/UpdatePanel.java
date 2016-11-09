
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UpdatePanel extends javax.swing.JPanel {
     Connection con;
     Statement stmt;
     String user;
      OptionsFrame2 opf2;
    
    public UpdatePanel(Connection C,String s,OptionsFrame2 op) {
        initComponents();
        this.con= C;
        this.user = s;
        this.opf2 = op;
         try {
                stmt =con.createStatement();
                String query = "SELECT * FROM BANKTABLE WHERE username = '"+user+"'";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    jtfusername.setText(rs.getString("username"));
                    jtfemail.setText(rs.getString("email"));
                    jtfphone.setText(rs.getString("phone"));
                    jtfaddress.setText(rs.getString("address"));
                }
                    
            } catch (SQLException ex) {
                Logger.getLogger(OptionsFrame2.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlusername = new javax.swing.JLabel();
        jlemail = new javax.swing.JLabel();
        jlphone = new javax.swing.JLabel();
        jladdress = new javax.swing.JLabel();
        jtfusername = new javax.swing.JTextField();
        jtfemail = new javax.swing.JTextField();
        jtfphone = new javax.swing.JTextField();
        jtfaddress = new javax.swing.JTextField();
        jbupdate = new javax.swing.JButton();
        jbcancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlusername.setForeground(new java.awt.Color(255, 255, 255));
        jlusername.setText("Username");
        add(jlusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jlemail.setForeground(new java.awt.Color(255, 255, 255));
        jlemail.setText("Email");
        add(jlemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, -1));

        jlphone.setForeground(new java.awt.Color(255, 255, 255));
        jlphone.setText("Phone");
        add(jlphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 50, -1));

        jladdress.setForeground(new java.awt.Color(255, 255, 255));
        jladdress.setText("Address");
        add(jladdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));
        add(jtfusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 150, 25));
        add(jtfemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 150, 25));
        add(jtfphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 130, 25));
        add(jtfaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 200, 25));

        jbupdate.setText("Update");
        jbupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbupdateActionPerformed(evt);
            }
        });
        add(jbupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 80, 30));

        jbcancel.setText("Cancel");
        jbcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelActionPerformed(evt);
            }
        });
        add(jbcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 80, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/5d3e3891-136e-47fc-bb59-a67d761e2b56_5.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 320));
    }// </editor-fold>//GEN-END:initComponents

    private void jbupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbupdateActionPerformed
         try {
             String  query = "UPDATE BANKTABLE SET username = '"+jtfusername.getText()+"',email = '"+jtfemail.getText()+"',phone = '"+jtfphone.getText()+"',address = '"+jtfaddress.getText()+"' WHERE username ='"+user+"'";
             stmt.execute(query);
            JOptionPane.showMessageDialog(null,"Info updated Successfully");
             this.setVisible(false);
             opf2.setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(UpdatePanel.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jbupdateActionPerformed

    private void jbcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelActionPerformed
                    
                    this.setVisible(false);
                    opf2.setVisible(true);
    }//GEN-LAST:event_jbcancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbcancel;
    private javax.swing.JButton jbupdate;
    private javax.swing.JLabel jladdress;
    private javax.swing.JLabel jlemail;
    private javax.swing.JLabel jlphone;
    private javax.swing.JLabel jlusername;
    private javax.swing.JTextField jtfaddress;
    private javax.swing.JTextField jtfemail;
    private javax.swing.JTextField jtfphone;
    private javax.swing.JTextField jtfusername;
    // End of variables declaration//GEN-END:variables
}
