// Program to define operaions to be performed.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class operations {
    public String url = "jdbc:mysql://localhost:3306/";
    public String username = "root";
    public String password = "VedantPatil5489";

    // Creating Scanner class
    Scanner sc = new Scanner(System.in);

    void initiate() {
        System.out.println("Enter username");
        username = sc.next();
        System.out.println("Enter password");
        password = sc.next();
    }

    void show_data() {
        try {
    
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stm = conn.createStatement();
    
            String query = "USE VED";
            stm.execute(query);
    
            String query1 = "SELECT * FROM STUDENT";
            ResultSet rs = stm.executeQuery(query1);

            System.out.println("Showing data...\n");

            while (rs.next())
            {
                String id = rs.getString("URN_no");
                String firstName = rs.getString("Name");
                String lastName = rs.getString("Course");
                String age = rs.getString("Age");
                String city = rs.getString("City");
                  
                // print the results
                System.out.format("%s, %s, %s, %s, %s\n", id, firstName, lastName, age, city);
                // System.out.println(id + " " + firstName + " " + lastName + " " + age + " " + city);
            }

    
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    void insert_data(String que, String que1, String que2, int a, String b) {
        try {

    
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stm = conn.createStatement();
    
            String query = "USE VED";
            stm.execute(query);

            String query1 = "INSERT INTO STUDENT VALUES( '" + que + "', '" + que1 + "', '" + que2 + "', " + a + ", '" + b + "')";
            System.out.println(query1);
            stm.execute(query1);

            System.out.println("Record Inserted!!");
    
        } catch (Exception SQLIntegrityConstraintViolationException) {
            System.out.println("Primary Key constraint violation...!\nDuplicate entry!!!");
        }
    }

    void del_data(String que) {
        try {
    
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stm = conn.createStatement();
    
            String query = "USE VED";
            stm.execute(query);

            String query1 = "DELETE FROM STUDENT WHERE URN_no = " + que;
            stm.execute(query1);

            System.out.println("Record deleted...!!");
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void update(String var1, String var2, String var3) {
        try {
    
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stm = conn.createStatement();
    
            String query = "USE VED";
            stm.execute(query);

            String query1 = "UPDATE STUDENT SET " + var1 + " = '" + var2 + "' where URN_no = '" + var3 + "';";
            System.out.println(query1);
            stm.execute(query1);

            System.out.println("Update complete!!");
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void estab_connection(){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stm = conn.createStatement();

            System.out.println("Connection established..!");

        } catch (SQLException e) {
            System.out.println("Wrong credentials...!!");
        }   
    }
}
