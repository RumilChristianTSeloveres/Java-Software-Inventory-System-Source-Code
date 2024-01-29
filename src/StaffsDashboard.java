
import java.awt.Image;
import java.awt.print.PrinterException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rumil
 */
public class StaffsDashboard extends javax.swing.JFrame {

    Connection Con = null;
    PreparedStatement pst = null;
    ResultSet Rs = null;
    Statement St = null;
    private TableRowSorter<DefaultTableModel> sorter;
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter1;
    private DefaultTableModel model1;
    int key = 0;
    int key1 = 0;
    String imgpath;
    String formattedDate;
    
    private static final String SELECT_SALES_BY_DATE = "SELECT SUM(Amount) FROM sells WHERE DAY(Date) = ?";
    private static final String SELECT_SALES_BY_MONTH = "SELECT SUM(Amount) FROM sells WHERE MONTH(Date) = ?";
    private static final String SELECT_SALES_BY_YEAR = "SELECT SUM(Amount) FROM sells WHERE YEAR(Date) = ?";
    
    /**
     * Creates new form StaffsDashboard
     */
    
    private void ClearText(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        JTextBill.setText(null);
        jLabel10.setIcon(null);
        i = 0;
    }    

public void displayTable() {

    try {
        Connection con = MyConnection.getConnection();
        java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM products");
        ResultSet rs = ps.executeQuery();

        // Create a DefaultTableModel to hold the data
        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model based on the table structure
        model.addColumn("ID");
        model.addColumn("ProductCode");
        model.addColumn("ProductName");
        //model.addColumn("Description");
        model.addColumn("Quantity");
        //model.addColumn("CostPrice");
        model.addColumn("SellingPrice");
        //model.addColumn("Brand");
        //model.addColumn("Photo");
        //model.addColumn("CompatiblePrinters");
        //model.addColumn("Remarks");

        // Add rows to the model with the retrieved data
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            row.add(rs.getInt("ID")); // Add the ID column
            row.add(rs.getString("ProductCode"));
            row.add(rs.getString("ProductName"));
            //row.add(rs.getString("Description"));
            row.add(rs.getString("Quantity"));
            //row.add(rs.getString("CostPrice"));
            row.add(rs.getString("SellingPrice"));
            //row.add(rs.getString("Brand"));
            //row.add(rs.getString("Photo"));
            //row.add(rs.getString("CompatiblePrinters"));
            //row.add(rs.getString("Remarks"));

            model.addRow(row);
        }

        // Set the model to the table
        jTable1.setModel(model);

        // Create a TableRowSorter and apply it to the table
        sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

        // Sort the table by "Last Name" column in ascending order
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);

        con.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
}

    public void displayTable1() {

    try {
        Connection con = MyConnection.getConnection();
        java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM customers");
        ResultSet rs = ps.executeQuery();

        // Create a DefaultTableModel to hold the data
        DefaultTableModel model1 = new DefaultTableModel();

        // Add columns to the model based on the table structure
        model1.addColumn("ID");
        model1.addColumn("CustomerCode");
        model1.addColumn("FullName");
        model1.addColumn("Location");
        model1.addColumn("Contact");

        // Add rows to the model with the retrieved data
        while (rs.next()) {
            Vector<Object> row1 = new Vector<>();
            row1.add(rs.getInt("ID")); // Add the ID column
            row1.add(rs.getString("CustomerCode"));
            row1.add(rs.getString("FullName"));
            row1.add(rs.getString("Location"));
            row1.add(rs.getString("Contact"));

            model1.addRow(row1);
        }

        // Set the model to the table
        jTable2.setModel(model1);

        // Create a TableRowSorter and apply it to the table
        sorter1 = new TableRowSorter<>(model1);
        jTable2.setRowSorter(sorter1);

        // Sort the table by "Last Name" column in ascending order
        ArrayList<RowSorter.SortKey> sortKeys1 = new ArrayList<>();
        sortKeys1.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
        sorter1.setSortKeys(sortKeys1);

        con.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
}

    private void filterTable() {
        String searchText = searchTextField.getText();
        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText); // Case-insensitive search
        sorter.setRowFilter(rowFilter);
    }
    
    private void filterTable1() {
        String searchText1 = searchTextField1.getText();
        RowFilter<DefaultTableModel, Object> rowFilter1 = RowFilter.regexFilter("(?i)" + searchText1); // Case-insensitive search
        sorter1.setRowFilter(rowFilter1);
    }

    public StaffsDashboard() {
        initComponents();
        ShowDate();
        displayTable();
        displayTable1();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }
        });
        
        searchTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable1();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable1();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable1();
            }
        });
    }
    
    private void GetItemPhoto(){
        ResultSet rs;
        try{
            PreparedStatement ps;
            String query = "select Photo from products where id="+key;
            ps = MyConnection.getConnection().prepareStatement(query);
            rs = ps.executeQuery(query); 
            
            if (rs.next()){
                jLabel10.setIcon(ResizePhoto(null, rs.getBytes("Photo")));
            }
        }
        catch (SQLException ex) {
                Logger.getLogger(StaffsRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
    
    private void ShowDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        jLabel11.setText(s.format(d));
    }

    private void CountBills(){
        try{
            PreparedStatement ps;
            String query = "SELECT Max(id) FROM `sells`";
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.executeQuery(query);
        }
        catch (SQLException ex) {
            Logger.getLogger(StaffsRegister.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error, cannot process!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void InsertBill(){
        try (Connection connection = MyConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO sells (SellerName, Date, Amount) VALUES (?, ?, ?)")){
            CountBills();
//            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagementdb", "root", "");
//            String query = "INSERT INTO `sells`(`SellerName`, `Date`, `Amount`) VALUES (?, ?, ?)";
//            PreparedStatement ps = Con.prepareStatement(query);
            
            Date currentDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = sdf.format(currentDate);

            ps.setString(1, "Seller: ");
            ps.setString(2, formattedDate);
            ps.setInt(3, GrdTotal);
            int row = ps.executeUpdate();
            
            if (row > 0){
                
                JOptionPane.showMessageDialog(null, "Bill Was Added Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Bill Not Added Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(StaffsRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // it is used to update the products quantity in database every print the items to customer
    private void UpdateQty(){
        try{
            int newQty = AvailQty - Integer.valueOf(jTextField3.getText());
            PreparedStatement ps;
            String query = "UPDATE products SET Quantity=? WHERE id=?";
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setInt(1, newQty);
            ps.setInt(2, key);
            
            if (ps.executeUpdate() == 1) {
                displayTable();
                displayTable1();
                JOptionPane.showMessageDialog(null, "Item Added", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (SQLException ex) {
                Logger.getLogger(StaffsRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void InsertCustomers(){
        String customerCode = jTextField9.getText();
        String fullName = jTextField10.getText();
        String location = jTextField8.getText();
        String contact = jTextField7.getText();
        String content = JTextBill.getText();

        PreparedStatement ps;
        String query = "INSERT INTO `customers`(`CustomerCode`, `FullName`, `Location`, `Contact`, `Date`, `Content`) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);

            ps.setString(1, customerCode);
            ps.setString(2, fullName);
            ps.setString(3, location);
            ps.setString(4, contact);
            ps.setString(5, formattedDate);
            ps.setString(6, content);

            if (ps.executeUpdate() > 0){
                displayTable();
                displayTable1();
                JOptionPane.showMessageDialog(null, "New Customer was added successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Customer was not added!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(StaffsRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void displaySalesStatistics() {
        // Compute sales for the current day
        double salesPerDay = computeSales(SELECT_SALES_BY_DATE, getCurrentDay());
        // Compute sales for the current month
        double salesPerMonth = computeSales(SELECT_SALES_BY_MONTH, getCurrentMonth());
        // Compute sales for the current year
        double salesPerYear = computeSales(SELECT_SALES_BY_YEAR, getCurrentYear());
        
    }

    private double computeSales(String query, int timeValue) {
        double totalSales = 0;

        try (Connection connection = MyConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, timeValue);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    totalSales = resultSet.getDouble(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalSales;
    }

    private int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    private int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1; // Months are zero-based
    }

    private int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
    
    private static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jBtnClear = new javax.swing.JButton();
        jBtnInsert = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTextBill = new javax.swing.JTextArea();
        jBtnPrint = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        searchTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jBtnClear1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(135, 206, 235));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Product Code:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Product Name:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Quantity:");

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Item's Stock");

        jBtnClear.setBackground(new java.awt.Color(255, 0, 0));
        jBtnClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jBtnClear.setText("Clear");
        jBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClearActionPerformed(evt);
            }
        });

        jBtnInsert.setBackground(new java.awt.Color(0, 255, 51));
        jBtnInsert.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jBtnInsert.setText("Add To Bill");
        jBtnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInsertActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setPreferredSize(new java.awt.Dimension(8, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("SEARCH:");

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 0, 255));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("REFRESH");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Date");

        JTextBill.setColumns(20);
        JTextBill.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        JTextBill.setRows(5);
        jScrollPane2.setViewportView(JTextBill);

        jBtnPrint.setBackground(new java.awt.Color(0, 255, 51));
        jBtnPrint.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jBtnPrint.setText("Print");
        jBtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPrintActionPerformed(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Selling Price:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Bill");

        jTextField7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jTextField8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Location:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Contact:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Full Name:");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Customer Code:");

        jTextField9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Customer Details:");

        searchTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextField1ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setText("SEARCH:");

        jTable2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("CUSTOMERS");

        jTextField10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jBtnClear1.setBackground(new java.awt.Color(255, 0, 0));
        jBtnClear1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jBtnClear1.setText("Clear");
        jBtnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClear1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Total: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton7))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField4)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jBtnInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnClear)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(searchTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(83, 83, 83)))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnClear1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING))))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jBtnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(73, 73, 73)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jBtnInsert)
                                    .addComponent(jBtnClear))
                                .addGap(8, 8, 8)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(searchTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnClear1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem5.setText("Log-out");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
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
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    int AvailQty;
    int i = 0;
    int GrdTotal = 0;
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int MyIndex = jTable1.getSelectedRow();
        key = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        jTextField1.setText(model.getValueAt(MyIndex, 1).toString());
        jTextField2.setText(model.getValueAt(MyIndex, 2).toString());
        jTextField4.setText(model.getValueAt(MyIndex, 4).toString());
        AvailQty = Integer.valueOf(model.getValueAt(MyIndex, 3).toString());
        GetItemPhoto();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClearActionPerformed
        // TODO add your handling code here:
        try{
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jLabel10.setIcon(null);
            i = 0;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Error, cannot process!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnClearActionPerformed

    private void jBtnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInsertActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int MyIndex = jTable1.getSelectedRow();
        
        if (MyIndex == -1 || jTextField1.getText().isEmpty()||jTextField2.getText().isEmpty()||jTextField3.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Missing Information, Please Select the Item's First", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (AvailQty < Integer.valueOf(jTextField3.getText())){
            JOptionPane.showMessageDialog(this, "Not Enough In Stock", "Information", JOptionPane.ERROR_MESSAGE);
        }
        else{
            i++;
            //ProdTot = Uprice * Integer.valueOf(jTextField3.getText());
            GrdTotal = GrdTotal + Integer.valueOf(jTextField3.getText()) * Integer.valueOf(jTextField4.getText());
            if (i == 1){
                JTextBill.setText(JTextBill.getText() + "                 GOODWELL INK REFILL STATION SHOP\n" 
                                                      + "                        LOWER 2ND FLOOR\n" 
                                                      + "                           BQ MALL\n" 
                                                      + "                   TAGBILARAN CITY, 6300 BOHOL\n"
                                                      + "------------------------------------------------------------------\n"
                                                      + "Customer Code: " + jTextField9.getText() + "\n" 
                                                      + "Customer Name: " + jTextField10.getText() + "\n"
                                                      + "Customer Address: " + jTextField7.getText() + "\n"
                                                      + "------------------------------------------------------------------\n"
                                                      + "\t\t\t\t\t" + "Date: " + jLabel11.getText() + "\n"
                                                      + "Item no.  CODE   PRODUCT NAME   QUANTITY  PRICE  TOTAL\n"
                                                      + " " + i + "      " + jTextField1.getText() + "  " + jTextField2.getText() + "       " + jTextField3.getText() + "      " + jTextField4.getText() + "       " + Integer.valueOf(jTextField3.getText()) * Integer.valueOf(jTextField4.getText()) + "\n");
                                    }
            else{
                JTextBill.setText(JTextBill.getText() + " " + i + "      " + jTextField1.getText() + "  " + jTextField2.getText() + "       " + jTextField3.getText() + "      " + jTextField4.getText() + "       " + Integer.valueOf(jTextField3.getText()) * Integer.valueOf(jTextField4.getText()) + "\n");
            }
            
            Date currentDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = sdf.format(currentDate);
            jLabel5.setText("Total: " + GrdTotal);
            UpdateQty();
        }
    }//GEN-LAST:event_jBtnInsertActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        StaffsDashboard staffsDash = new StaffsDashboard();
        dispose();
        staffsDash.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jBtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPrintActionPerformed
        // TODO add your handling code here:
        try{
            if (jTextField9.getText().isEmpty() || jTextField10.getText().isEmpty() || jTextField8.getText().isEmpty() || jTextField7.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Customer Details Empty, Please Add (or) Click Customer Table\n\n"
                        + "If Customer not Present in Table,\n\n" + "Add Customer Details First", "Information", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JTextBill.print();
                InsertCustomers();
                InsertBill();
                ClearText();
                jTextField9.setText("");
                jTextField10.setText("");
                jTextField8.setText("");
                jTextField7.setText("");
                jLabel5.setText("Total: ");
                displaySalesStatistics();
            }
            //GrdTotal = 0;
        }
        catch (PrinterException e){
            JOptionPane.showMessageDialog(this, "Cannot Print", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnPrintActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void searchTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextField1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int MyIndex = jTable2.getSelectedRow();
        key1 = Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        jTextField9.setText(model.getValueAt(MyIndex, 1).toString());
        jTextField10.setText(model.getValueAt(MyIndex, 2).toString());
        jTextField8.setText(model.getValueAt(MyIndex, 3).toString());
        jTextField7.setText(model.getValueAt(MyIndex, 4).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void jBtnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClear1ActionPerformed
        // TODO add your handling code here:
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField8.setText("");
        jTextField7.setText("");
    }//GEN-LAST:event_jBtnClear1ActionPerformed

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
            java.util.logging.Logger.getLogger(StaffsDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffsDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffsDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffsDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffsDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTextBill;
    private javax.swing.JButton jBtnClear;
    private javax.swing.JButton jBtnClear1;
    private javax.swing.JButton jBtnInsert;
    private javax.swing.JButton jBtnPrint;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTextField searchTextField1;
    // End of variables declaration//GEN-END:variables
}
