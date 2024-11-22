import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        // DB URL
        String url = "jdbc:mysql://localhost:3306/students";

        // Credentials
        String username = "root";
        String password = "root";
        String query =  "Select * from employee";

        try {
            Class.forName("com.mysql.jdbc.Driver");            // loaded drivers //
            System.out.println("Drivers loaded Successfully...");
        } catch (ClassNotFoundException e) {
            System.out.println("Catch Message : " + e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, password);  // Connection Establish
            System.out.println("Connected to the Database : " + con);              // 'con' stores the connection ID  eg. com.mysql.cj.jdbc.ConnectionImpl@710f4dc7
            Statement statement = con.createStatement();                          // create statement
            System.out.println("statement : " + statement);                      // 'statement' stores statement ID eg. com.mysql.cj.jdbc.StatementImpl@7bedc48a
            ResultSet rs = statement.executeQuery(query);                       // execute resultSet
            System.out.println("ResultSet Value : " +  rs);                    // com.mysql.cj.jdbc.result.ResultSetImpl@762ef0ea

            while(rs.next()) {
              int id = rs.getInt("id");
              String name = rs.getString("name");
              String job_title = rs.getString("job_title");
              double salary = rs.getDouble("salary");


              System.out.println("===========================");
              System.out.println("ID : " + id);
              System.out.println("name : " + name);
              System.out.println("Job Title : " + job_title);
              System.out.println("Salary : " + salary);
            }
            rs.close();
            System.out.println("Result Set Status : " +  rs);
            statement.close();
            System.out.println("Statement Status : " +  statement);
            con.close();
            System.out.println("Connection Status : " + con);

        } catch (SQLException e) {
            System.err.println("Connection Failed : " + e.getMessage());
        }


    }
}