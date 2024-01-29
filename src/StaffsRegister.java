

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Rumil
 */
public class StaffsRegister extends javax.swing.JFrame {

    String imgpath;
    
    public StaffsRegister() {
        initComponents();
        scaleIcon();
    }
    
    private void ClearText(){
        jtxtFirstName.setText("");
        jtxtMiddleName.setText("");
        jtxtLastName.setText("");
        jtxtMobileNumber.setText("");
        jtxtEmail.setText("");
        jtxtAddress.setText("");
        jtxtUsername.setText("");
        jPassword.setText("");
        jLabel10.setText(null);
    }
    
    public void scaleIcon(){        
        ImageIcon loginLogo1 = new ImageIcon(getClass().getResource("/Picture/Goodwell1-removebg-preview.png"));
        Image img1 = loginLogo1.getImage();
        Image imgScale1 = img1.getScaledInstance(jlblGoodwell1.getWidth(),jlblGoodwell1.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon loginLogoScaled1 = new ImageIcon(imgScale1);
        jlblGoodwell1.setIcon(loginLogoScaled1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlblClose = new javax.swing.JLabel();
        jlblMinimize = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlblGoodwell1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblFirstName = new javax.swing.JLabel();
        jlblMiddleName = new javax.swing.JLabel();
        jlblLastName = new javax.swing.JLabel();
        jlblMobileNumber = new javax.swing.JLabel();
        jlblEmail = new javax.swing.JLabel();
        jlblUsername = new javax.swing.JLabel();
        jtxtFirstName = new javax.swing.JTextField();
        jtxtMiddleName = new javax.swing.JTextField();
        jtxtLastName = new javax.swing.JTextField();
        jtxtMobileNumber = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jtxtUsername = new javax.swing.JTextField();
        jlblPassword = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jbtnRegister = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jlblAlreadyRegister = new javax.swing.JLabel();
        jBtnBack = new javax.swing.JButton();
        jtxtAddress = new javax.swing.JTextField();
        jlblEmail1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jBtnInsert1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Register");

        jlblClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblClose.setForeground(new java.awt.Color(255, 255, 255));
        jlblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblClose.setText("X");
        jlblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblCloseMouseClicked(evt);
            }
        });

        jlblMinimize.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jlblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblMinimize.setText("-");
        jlblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblMinimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(82, 82, 82)
                .addComponent(jlblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblClose)
                    .addComponent(jlblMinimize))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(135, 206, 235));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Goodwell");

        jlblGoodwell1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/Goodwell1-removebg-preview.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Unlock a world of possibilities - Register with");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("aspirations come to life. Your details, our");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Goodwell Ink Refill Station and let your printing");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("commitment to exceptional service.");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Inventory Management System");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlblGoodwell1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jlblGoodwell1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        jlblFirstName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblFirstName.setText("First Name: ");

        jlblMiddleName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblMiddleName.setText("Middle Name: ");

        jlblLastName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblLastName.setText("Last Name: ");

        jlblMobileNumber.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblMobileNumber.setText("Mobile Number: ");

        jlblEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblEmail.setText("Email: ");

        jlblUsername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblUsername.setText("Username: ");

        jtxtFirstName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jtxtMiddleName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jtxtLastName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jtxtMobileNumber.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jtxtEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jtxtUsername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jlblPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblPassword.setText("Password: ");

        jPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jbtnRegister.setBackground(new java.awt.Color(0, 0, 255));
        jbtnRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnRegister.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRegister.setText("Register");
        jbtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegisterActionPerformed(evt);
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

        jlblAlreadyRegister.setText("Already have an Account...");
        jlblAlreadyRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblAlreadyRegister.setDoubleBuffered(true);
        jlblAlreadyRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblAlreadyRegisterMouseClicked(evt);
            }
        });

        jBtnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtnBack.setText("Back");
        jBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBackActionPerformed(evt);
            }
        });

        jtxtAddress.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jlblEmail1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblEmail1.setText("Address:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Add Picture");

        jBtnInsert1.setBackground(new java.awt.Color(0, 255, 51));
        jBtnInsert1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jBtnInsert1.setText("Browse");
        jBtnInsert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInsert1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlblMiddleName)
                                        .addGap(32, 32, 32)
                                        .addComponent(jtxtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlblLastName)
                                        .addGap(46, 46, 46)
                                        .addComponent(jtxtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlblMobileNumber)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtxtMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlblEmail)
                                        .addGap(77, 77, 77)
                                        .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlblPassword)
                                        .addGap(56, 56, 56)
                                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlblUsername)
                                            .addComponent(jlblEmail1))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jbtnRegister)
                                                .addGap(28, 28, 28)
                                                .addComponent(jbtnReset))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(jlblAlreadyRegister)))
                                        .addGap(27, 27, 27))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlblFirstName)
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jBtnInsert1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtxtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jBtnBack))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jBtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnInsert1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblFirstName))
                    .addComponent(jtxtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblMiddleName))
                    .addComponent(jtxtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblLastName))
                    .addComponent(jtxtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlblMobileNumber))
                    .addComponent(jtxtMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jlblEmail))
                    .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jlblEmail1))
                    .addComponent(jtxtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlblUsername))
                    .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblPassword))
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnRegister)
                    .addComponent(jbtnReset))
                .addGap(6, 6, 6)
                .addComponent(jlblAlreadyRegister)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblCloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jlblCloseMouseClicked

    private void jlblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jlblMinimizeMouseClicked

    private void jbtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegisterActionPerformed
        // TODO add your handling code here:
        String fname = jtxtFirstName.getText();
        String mname = jtxtMiddleName.getText();
        String lname = jtxtLastName.getText();
        String num = jtxtMobileNumber.getText();
        String email = jtxtEmail.getText();
        String address = jtxtAddress.getText();
        String username = jtxtUsername.getText();
        String pass = String.valueOf(jPassword.getPassword());
            
        int i = 0;
        i += StaffsCheck.save(fname, mname, lname, num, email, address, username, pass, imgpath);
        
        if (i > 0) {
            JOptionPane.showMessageDialog(null, "New User was added successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            ClearText();
        }
    }//GEN-LAST:event_jbtnRegisterActionPerformed

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
        // TODO add your handling code here:
        try{
            ClearText();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error, cannot process!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnResetActionPerformed

    private void jlblAlreadyRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblAlreadyRegisterMouseClicked
        // TODO add your handling code here:
        try{
            StaffsLogin staffsLog = new StaffsLogin();
            staffsLog.setVisible(true);
            staffsLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error, cannot process!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jlblAlreadyRegisterMouseClicked

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed
        // TODO add your handling code here:
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

    public ImageIcon ResizePhoto(String ImagePath, byte[] pic){
        ImageIcon MyImage = null;
        if(ImagePath != null){
            MyImage = new ImageIcon(ImagePath);
        }
        else{
            MyImage = new ImageIcon(pic);
        }
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    private void jBtnInsert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInsert1ActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(file);
        
        if (result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jLabel10.setIcon(ResizePhoto(path, null));
            imgpath = path;
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(this, "No File Selected");
        }
    }//GEN-LAST:event_jBtnInsert1ActionPerformed

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
            java.util.logging.Logger.getLogger(StaffsRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffsRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffsRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffsRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffsRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBack;
    private javax.swing.JButton jBtnInsert1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JButton jbtnRegister;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JLabel jlblAlreadyRegister;
    private javax.swing.JLabel jlblClose;
    private javax.swing.JLabel jlblEmail;
    private javax.swing.JLabel jlblEmail1;
    private javax.swing.JLabel jlblFirstName;
    private javax.swing.JLabel jlblGoodwell1;
    private javax.swing.JLabel jlblLastName;
    private javax.swing.JLabel jlblMiddleName;
    private javax.swing.JLabel jlblMinimize;
    private javax.swing.JLabel jlblMobileNumber;
    private javax.swing.JLabel jlblPassword;
    private javax.swing.JLabel jlblUsername;
    private javax.swing.JTextField jtxtAddress;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtFirstName;
    private javax.swing.JTextField jtxtLastName;
    private javax.swing.JTextField jtxtMiddleName;
    private javax.swing.JTextField jtxtMobileNumber;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables
}
