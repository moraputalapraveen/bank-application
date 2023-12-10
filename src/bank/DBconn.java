package bank;
import java.sql.*;

public class DBconn {

    static String url = "jdbc:mysql://localhost/bank"; 
    static final String user = "root";
    static final String pass = "";
   

    public static Connection Dbconn() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            
            System.out.print("connet");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("error in db");
            e.printStackTrace();
        }
        return con; 
    }

    
}
