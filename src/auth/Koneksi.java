package auth;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import src.PopUpMessages;


public class Koneksi {
   
        private static Connection mysqlconfig;
        public static Connection configDB()throws SQLException{
            try {
           
                FileInputStream fstream;
                fstream = new FileInputStream("konfigurasi.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String url1 = br.readLine().substring(6);
                String database1 = br.readLine().substring(11);
                String port1 = br.readLine().substring(7);
                String user1 = br.readLine().substring(7);
                String pw1 = br.readLine().substring(11);

                String url, port, database, user, pass;
    
                url = "jdbc:mysql://"+url1+":"+port1+"/"+database1;
                user = user1;
                
                if(pw1.equals("null")){
                    pass = "";
      
                } else {
                    pass = pw1;
                }
   
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlconfig = DriverManager.getConnection(url, user, pass);
                br.close();
            } catch (Exception e) {
                new PopUpMessages(null, true, "Informasi", "Database tidak terhubung!", 2).setVisible(true);
            }
            return mysqlconfig;
        }
}
