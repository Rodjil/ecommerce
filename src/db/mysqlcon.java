package db;


import java.sql.*;


public class mysqlcon {
    public static void main(String arg[]) throws ClassNotFoundException{
        try{
            Connection conn = null;

            String MySqlUser ="root", MySqlPassword = "121212";
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ecom-db", 
                MySqlUser, 
                MySqlPassword);

            Statement query;
            query = conn.createStatement();
            ResultSet rs;
            rs = query.executeQuery(
                "select * from user"
            );
            int userId;
            String userName;

            while (rs.next()) {
                userId = rs.getInt("user_id");
                userName = rs.getString("user_name");
                System.out.println("User :" + userId + "\n"+ "Name :" + userName);
                rs.close();
                query.close();
                conn.close();
            }



        }catch (SQLException e) {
            System.out.println(e);
        }
    }
}
