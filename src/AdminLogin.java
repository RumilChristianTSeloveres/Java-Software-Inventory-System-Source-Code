import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rumil
 */
public class AdminLogin extends javax.swing.JFrame {

    public AdminLogin() {
        initComponents();
        scaleIcon();
    }
    
    public void scaleIcon(){
        ImageIcon loginLogo = new ImageIcon(getClass().getResource("/Picture/Admin.png"));
        Image img = loginLogo.getImage();
        Image imgScale = img.getScaledInstance(jLabelAdminLogo.getWidth(),jLabelAdminLogo.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon loginLogoScaled = new ImageIcon(imgScale);
        jLabelAdminLogo.setIcon(loginLogoScaled);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelAdminLogo = new javax.swing.JLabel();
        jlblClose = new javax.swing.JLabel();
        jlblMinimize = new javax.swing.JLabel();
        jtxtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jCheckBox_ShowPassword = new javax.swing.JCheckBox();
        jbtnReset = new javax.swing.JButton();
        jbtnSignIn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jlblRegister = new javax.swing.JLabel();
        jBtnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 0));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(65, 105, 225));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sign In");

        jLabelAdminLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/Admin.png"))); // NOI18N
        jLabelAdminLogo.setText("jLabel4");

        jlblClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblClose.setText("X");
        jlblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblCloseMouseClicked(evt);
            }
        });

        jlblMinimize.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMinimize.setText("-");
        jlblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblMinimizeMouseClicked(evt);
            }
        });

        jLabel2.setText("Username: ");

        jLabel3.setText("Password: ");

        jCheckBox_ShowPassword.setText("Show password");
        jCheckBox_ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_ShowPasswordActionPerformed(evt);
            }
        });

        jbtnReset.setBackground(new java.awt.Color(255, 0, 0));
        jbtnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnReset.setForeground(new java.awt.Color(255, 255, 255));
        jbtnReset.setText("Cancel");
        jbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetActionPerformed(evt);
            }
        });

        jbtnSignIn.setBackground(new java.awt.Color(0, 0, 255));
        jbtnSignIn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnSignIn.setForeground(new java.awt.Color(255, 255, 255));
        jbtnSignIn.setText("Sign In");
        jbtnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSignInActionPerformed(evt);
            }
        });

        jLabel5.setText("Not Register?");

        jlblRegister.setText("Click here to register...");
        jlblRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblRegisterMouseClicked(evt);
            }
        });

        jBtnBack.setBackground(new java.awt.Color(135, 206, 235));
        jBtnBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnBack.setText("Back");
        jBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBtnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(151, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelAdminLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)))
                .addComponent(jlblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(4, 4, 4)
                                    .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(4, 4, 4)
                                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbtnSignIn)
                                        .addGap(28, 28, 28)
                                        .addComponent(jbtnReset))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel5)
                                        .addGap(6, 6, 6)
                                        .addComponent(jlblRegister)))
                                .addGap(22, 22, 22)))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox_ShowPassword)
                        .addGap(55, 55, 55))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblMinimize)
                        .addComponent(jlblClose))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAdminLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jCheckBox_ShowPassword)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnSignIn)
                    .addComponent(jbtnReset))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jlblRegister))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    boolean passwordVisible = false;
    private void jCheckBox_ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_ShowPasswordActionPerformed

        if (passwordVisible) {
            jPassword.setEchoChar('*');
            passwordVisible = false;
            jCheckBox_ShowPassword.setText("Show Password");
        } else {
            jPassword.setEchoChar((char) 0);
            passwordVisible = true;
            jCheckBox_ShowPassword.setText("Hide Password");
        }
    }//GEN-LAST:event_jCheckBox_ShowPasswordActionPerformed

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed

        try{
            jtxtUsername.setText("");
            jPassword.setText("");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error, cannot process!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnResetActionPerformed

    private void jbtnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSignInActionPerformed

        try{
            String Name= jtxtUsername.getText();
            String Password= String.valueOf(jPassword.getPassword());
            if(AdminDB.validate(Name,Password)){
                AdminDashboard adminDash = new AdminDashboard();
                adminDash.setVisible(true);
                adminDash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
                JOptionPane.showMessageDialog(this, "Login successfully!");
            }
            else{
                JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Admin Username or Password is Incorrect, nothing in database","Login Error!", JOptionPane.ERROR_MESSAGE);
                jtxtUsername.setText("");
		jPassword.setText("");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error, cannot process!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnSignInActionPerformed

    private void jlblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblRegisterMouseClicked
 
        try{
            AdminRegister admForm = new AdminRegister();
            admForm.setVisible(true);
            admForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error, cannot process!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jlblRegisterMouseClicked

    private void jlblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblMinimizeMouseClicked

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jlblMinimizeMouseClicked

    private void jlblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblCloseMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jlblCloseMouseClicked

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed

        try{
            LandingPage landP = new LandingPage();
            landP.setVisible(true);
            landP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error, cannot process!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnBackActionPerformed

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBack;
    private javax.swing.JCheckBox jCheckBox_ShowPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAdminLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnSignIn;
    private javax.swing.JLabel jlblClose;
    private javax.swing.JLabel jlblMinimize;
    private javax.swing.JLabel jlblRegister;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables
}
