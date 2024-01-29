import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rumil
 */
public class StaffsDB {
    
    public static boolean validate(String name, String password) {
        boolean status = false;
        try {
            Connection con = MyConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM staffs WHERE BINARY Username = ? AND BINARY Password = ?");
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}
