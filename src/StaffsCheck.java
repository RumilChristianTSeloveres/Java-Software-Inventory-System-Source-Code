
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rumil
 */
public class StaffsCheck {
    
    public static int save(String firstName, String middleName, String lastName, String mobileNumber, String email, String address, String username, String password, String Photo) {
    int status = 0;
    
    // Check if any of the required fields are blank
    if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() || mobileNumber.isEmpty() || email.isEmpty() || address.isEmpty() || username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Missing Information", "Information", JOptionPane.INFORMATION_MESSAGE);
        return status;
    }

    try {
        Connection con = MyConnection.getConnection();

        // Check if a record with the same refID already exists (case-insensitive)
        PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM staffs WHERE UPPER(Username) = ?");
        checkStatement.setString(1, username.toUpperCase());
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);

        if (count == 0) {
            // No record exists with the same refID, proceed with insertion
            PreparedStatement ps = con.prepareStatement("INSERT INTO staffs(FirstName, MiddleName, LastName, MobileNumber, Email, Address, Username, Password, Photo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, firstName);
            ps.setString(2, middleName);
            ps.setString(3, lastName);
            ps.setString(4, mobileNumber);
            ps.setString(5, email);
            ps.setString(6, address);
            ps.setString(7, username);
            ps.setString(8, password);
            InputStream img = new FileInputStream(Photo);
            ps.setBlob(9, img);

            status = ps.executeUpdate();
        } else {
            // A record with the same refID already exists
            JOptionPane.showMessageDialog(null, "Staffs Username Already Exists.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        con.close();
    }
    catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while saving the record.", "Error", JOptionPane.ERROR_MESSAGE);
    } 
    catch (FileNotFoundException ex) {
        Logger.getLogger(StaffsCheck.class.getName()).log(Level.SEVERE, null, ex);
    }
    return status;
    }
}
