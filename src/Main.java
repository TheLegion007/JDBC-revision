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
        String query1 =  "SELECT * from employee";
        String query2 = "INSERT INTO employee(id,name,job_title,salary) VALUES(4, 'Rahul', 'React Developer', 39000.0);";

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

            int rowsEffected = statement.executeUpdate(query2);                // executeUpdate for data insertion , executeQuery for data retrieval
            if(rowsEffected > 0) {
                System.out.println("Insert SuccessFull ::  " + rowsEffected + " row(s) effected ." );
            }else {
                System.out.println("Insertion Failed !!!");
            }

            statement.close();
            System.out.println("Statement Status : " +  statement);
            con.close();
            System.out.println("Connection Status : " + con);

        } catch (SQLException e) {
            System.err.println("Connection Failed : " + e.getMessage());
        }


    }
}