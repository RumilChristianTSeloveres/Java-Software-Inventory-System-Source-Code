
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
public class AdminCheck {
    
    public static int save(String firstName, String lastName, String email, String username, String password, String Photo) {
    int status = 0;
    
    // Check if any of the required fields are blank
    if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Missing Information", "Information", JOptionPane.INFORMATION_MESSAGE);
        return status;
    }

    try {
        Connection con = MyConnection.getConnection();

        // Check if a record with the same refID already exists (case-insensitive)
        PreparedStatement checkStatement = con.prepareStatement("SELECT COUNT(*) FROM admins WHERE UPPER(Username) = ?");
        checkStatement.setString(1, username.toUpperCase());
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);

        if (count == 0) {
            // No record exists with the same refID, proceed with insertion
            PreparedStatement ps = con.prepareStatement("INSERT INTO admins(FirstName, LastName, Email, Username, Password, Photo) VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.setString(5, password);
            InputStream img = new FileInputStream(Photo);
            ps.setBlob(6, img);

            status = ps.executeUpdate();
        } else {
            // A record with the same refID already exists
            JOptionPane.showMessageDialog(null, "Admin Username Already Exists.", "Error", JOptionPane.ERROR_MESSAGE);
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
