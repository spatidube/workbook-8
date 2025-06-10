import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //load mysql driver
        String url = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "yearup";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            // 1. open a connection to the database
// use the database URL to point to the correct database
            Connection connection;
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/northwind", username, password);
// create statement
// the statement is tied to the open connection
            Statement statement = connection.createStatement();
// define your query
            String query = "SELECT * FROM products ";
// 2. Execute your query
            ResultSet results = statement.executeQuery(query);
// process the results
            while (results.next()) {
                String productName = results.getString("ProductName");
                System.out.println(productName);
                String UnitsOnOrder = results.getString("UnitsOnOrder");
            }
// 3. Close the connection
            connection.close();
        }
        catch (SQLException e) {
            System.out.println("Hey, this exception happened: " + e);
        }
    }
    //load the MySQL Driver


}
