// File to handle connection of program to the database
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {

    
    public void estab_connection(){
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "VedantPatil5489";

            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stm = conn.createStatement();

            System.out.println("Connection established..!");

            // String query = "create database ved";
            // boolean b = stm.execute(query);
            // System.out.println(b);

        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
    public static void main(String[] args) {
        // Loading driver(.jar file)
        
        // Getting connection to sql using driver

    }
}
