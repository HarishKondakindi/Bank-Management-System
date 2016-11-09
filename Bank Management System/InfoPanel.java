
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InfoPanel extends javax.swing.JPanel {
     Connection con;
     Statement stmt;
     String user;
      OptionsFrame2 opf2;

    public InfoPanel(Connection C,String s,OptionsFrame2 op) {
        initComponents();
        jtfname.setEditable(false);
        jtfacnumber.setEditable(false);
        jtfemail.setEditable(false);
        jtfphone.setEditable(false);
        jtfaddress.setEditable(false);
        jtfbalance.setEditable(false);
         this.con= C;
        this.user = s;
        this.opf2 = op;
        /* try {
                stmt =con.createStatement();
                String query = "SELECT * FROM BANKTABLE WHERE username = '"+user+"'";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    jtfname.setText(rs.getString("name"));
                    jtfacnumber.setText(rs.getString("acnumber"));
                    jtfemail.setText(rs.getString("email"));
                    jtfphone.setText(rs.getString("phone"));
                    jtfaddress.setText(rs.getString("address"));
                    jtfbalance.setText(rs.getString("balance"));
                }
                    
            } catch (SQLException ex) {
                Logger.getLogger(OptionsFrame2.class.getName()).log(Level.SEVERE, null, ex);
            }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfname = new javax.swing.JTextField();
        jtfacnumber = new javax.swing.JTextField();
        jtfemail = new javax.swing.JTextField();
        jtfphone = new javax.swing.JTextField();
        jtfaddress = new javax.swing.JTextField();
        jtfbalance = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name           :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 70, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("A/C Number :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email            :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phone          :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 70, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address       :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Balance        :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 214, -1, 20));
        add(jtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 200, 22));
        add(jtfacnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 200, 22));
        add(jtfemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 200, 22));
        add(jtfphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, 22));
        add(jtfaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 190, 22));
        add(jtfbalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 100, 22));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 60, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vertical-lines-abstract-wide-wallpaper.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 330));
    }// </editor-fold>//GEN-END:initComponents

    public void view(){
         try {
                stmt =con.createStatement();
                String query = "SELECT * FROM BANKTABLE WHERE username = '"+user+"'";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    jtfname.setText(rs.getString("name"));
                    jtfacnumber.setText(rs.getString("acnumber"));
                    jtfemail.setText(rs.getString("email"));
                    jtfphone.setText(rs.getString("phone"));
                    jtfaddress.setText(rs.getString("address"));
                    jtfbalance.setText(rs.getString("balance"));
                }
                    
            } catch (SQLException ex) {
                Logger.getLogger(OptionsFrame2.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
       opf2.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jtfacnumber;
    private javax.swing.JTextField jtfaddress;
    private javax.swing.JTextField jtfbalance;
    private javax.swing.JTextField jtfemail;
    private javax.swing.JTextField jtfname;
    private javax.swing.JTextField jtfphone;
    // End of variables declaration//GEN-END:variables
}
