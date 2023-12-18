package app;

import java.sql.*;
import db.mysqlcon;

public class userController {


    private static int userId, userRole;
    private static String userName, userEmail, userPassword, userPhoneNumber;
    
    public static void main(String[] args) throws ClassNotFoundException {
        GetAllUserData();
    }

    public static void GetAllUserData() throws ClassNotFoundException {
        String query = "SELECT * FROM tbl_users";


        try(ResultSet data = mysqlcon.getQuery(query) ){


            while (data.next()) {
                userId = data.getInt(1);
                userName = data.getString(2);
                userEmail = data.getString(3);
                userPhoneNumber = data.getString(4);
                userRole = data.getInt(5);
                userPassword = data.getString(6);

                System.out.println(userId + userName);
            }
            
        } catch (SQLException e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        }
    }




}
