
import static java.awt.Color.white;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PinChangePanel extends javax.swing.JPanel {
     Connection con;
     Statement stmt;
     String user;
    private String newpin;
     private String oldpin;
    OptionsFrame2 opf2;
    
    public PinChangePanel(Connection C,String s,OptionsFrame2 op) {
        initComponents();
        this.con= C;
        this.user = s;
        this.opf2 = op;
        jpfoldpin.setText("");
        jlwrongpin.setForeground(white);
        jlwrongpin.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jpfoldpin = new javax.swing.JPasswordField();
        jlnewpin = new javax.swing.JLabel();
        jpfnewpin = new javax.swing.JPasswordField();
        jlwrongpin = new javax.swing.JLabel();
        jbsubmit = new javax.swing.JButton();
        jbcancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Old PIN");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        add(jpfoldpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 100, 24));

        jlnewpin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlnewpin.setForeground(new java.awt.Color(255, 255, 255));
        jlnewpin.setText("Enter New PIN");
        add(jlnewpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 20));
        add(jpfnewpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 100, 24));
        add(jlwrongpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jbsubmit.setText("Submit");
        jbsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsubmitActionPerformed(evt);
            }
        });
        add(jbsubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 80, 30));

        jbcancel.setText("Cancel");
        jbcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcancelActionPerformed(evt);
            }
        });
        add(jbcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 80, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jellyfish_digital_artwork-1366x768.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 390, 320));
    }// </editor-fold>//GEN-END:initComponents

    private void jbsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsubmitActionPerformed
       if(!"".equals(jpfoldpin.getText())){
            try {
                stmt =con.createStatement();
                String query = "SELECT * FROM BANKTABLE WHERE username = '"+user+"'";
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                oldpin  = rs.getString(7);
                }

                this.newpin = jpfnewpin.getText();
                System.out.println("opin "+oldpin);
                if(oldpin.equals(jpfoldpin.getText())){
                    jlwrongpin.setText("");
                  
                    query = "UPDATE BANKTABLE SET pin = '"+newpin+"' WHERE username ='"+user+"'";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(null,"Successfully changed the pin");
                    this.setVisible(false);
                    
                    opf2.setVisible(true);

                }
                else
                jlwrongpin.setText("Incorrect pin");
            } catch (SQLException ex) {
                Logger.getLogger(OptionsFrame2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            jlwrongpin.setText("Please enter the old pin");
        }
    }//GEN-LAST:event_jbsubmitActionPerformed

    private void jbcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcancelActionPerformed
       this.jpfoldpin.setText("");
       this.jpfnewpin.setText("");
       this.setVisible(false);
       opf2.setVisible(true);
    }//GEN-LAST:event_jbcancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbcancel;
    private javax.swing.JButton jbsubmit;
    private javax.swing.JLabel jlnewpin;
    private javax.swing.JLabel jlwrongpin;
    private javax.swing.JPasswordField jpfnewpin;
    private javax.swing.JPasswordField jpfoldpin;
    // End of variables declaration//GEN-END:variables
}
