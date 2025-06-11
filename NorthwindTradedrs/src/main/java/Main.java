import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public class Main {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //first load mysql driver
     //   String url = "jdbc:mysql://localhost:3306/northwind";
      //  String username = "root";
      //  String password = "yearup";

//database connection details
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "Passwerd";
        Class.forName("com.mysql.cj.jdbc.Driver");

        //try with resources automaticallt closes these resources at the end of the try block
        try {
            //1. Establish a connection to the data base
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/northwind", username, password);
            //2. ceate a PreparedStatement
            PreparedStatement = connection.prepareStatement("SELECT * FROM products");
            //3. Execute a query and get a ResultSet to iterate over the results
            ResultSet results = statement.executeQuery();
            //4. Loop through each row in the result set
            while(result.next()) {
                // Get the product Name from the current row
                String productName = results.getString("ProductName");
                System.out.println(productName);

                //Get the Units on order( note: not currently used, just printing for practice)
                String UnitsOnOrder = results.getString("UnitsOnOrder");
                System.out.println("Units on Order: " + UnitsOnOrder);
            }
// 3. Close the connection------- do i need to close right now??
            //connection.close();
        }
        catch (SQLException e) {
            System.out.println("Hey, this exception happened: " + e.getMessage());
        }
    }
}
