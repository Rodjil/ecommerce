package db;


import java.sql.*;


public class mysqlcon {


    private static String MYSQL_JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static String MYSQL_DB_URL = "jdbc:mysql://localhost:3306/ecom-db";
    private static String MYSQL_DB_USER = "root";
    private static String MYSQL_DB_USER_PASSWORD = "121212";
    private static String SQL_QUERY = "SELECT DATABASE() FROM DUAL";

    public static void connect() {
            
        try(Connection connection = DriverManager.getConnection(MYSQL_DB_URL,MYSQL_DB_USER,MYSQL_DB_USER_PASSWORD)) {


            // CARA TAMBAH DRIVER MYSQL : 
            // VSCODE : ctrl + shift + p > java classpath > tambah jar driver
            // NETBEANS : lupa
            Class.forName(MYSQL_JDBC_DRIVER_CLASS); 
            Statement statement =connection.createStatement(); 
            
            
            ResultSet resultSet = statement.executeQuery(SQL_QUERY); 

            while(resultSet.next())  {
                if (resultSet.getString(1).equals("ecom-db") ) {
                    System.out.println("Database Connected...");
                } 
            }     
                
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver class not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error occured while executing query: ");

            e.printStackTrace();
        } 
    }

}
