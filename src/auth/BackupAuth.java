package auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class BackupAuth {
   
        private static Connection mysqlconfig;
        public static Connection configDB()throws SQLException{
            try {
                String url, user, pass;
                url = "jdbc:mysql://localhost/toko";
                user = "root";
                pass = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlconfig = DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Database tidak terhubung");
            }
            return mysqlconfig;
        }
}
