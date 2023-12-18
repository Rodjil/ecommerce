package controller;

import java.sql.*;
import db.mysqlcon;

public class userController {


    private static int userId, userRole;
    private static String userName, userEmail, userPassword, userPhoneNumber;
    
    public static void main(String[] args) throws ClassNotFoundException {
        GetAllUserData();
        System.out.println("\"");
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

    public static void insertUserData(String userName, String userEmail, String userPhoneNumber, int userRole, String userPassword) throws ClassNotFoundException, SQLException {
        userPhoneNumber = (userPhoneNumber != "" || userPhoneNumber != null) ? userPhoneNumber : null;
        String query = "INSERT INTO tbl_users (user_id , user_name, user_email, user_phone_number, user_role, user_password) VALUES " + "(" + 0 + ",\"" + userName + "\",\"" + userEmail + "\",\"" + userPhoneNumber + "\"," + userRole + ",\"" + userPassword + "\");";
        mysqlcon.initQuery(query);
    }

    public static void updateUserData(int userId, String userName, String userEmail, String userPhoneNumber, int userRole, String userPassword) throws ClassNotFoundException, SQLException {
        userPhoneNumber = (userPhoneNumber!= "" || userPhoneNumber!= null)? userPhoneNumber : null;
        String query = "UPDATE tbl_users SET user_name=\"" + userName + "\", user_email=\"" + userEmail + "\", user_phone_number=\"" + userPhoneNumber + "\", user_role=" + userRole + ", user_password=\"" + userPassword + "\" WHERE user_id=" + userId + ";";
        mysqlcon.initQuery(query);
    }

    public static void deleteUserData(int userId) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM tbl_users WHERE user_id=" + userId + ";";
        mysqlcon.initQuery(query);
    }


    // PR : Login Logic

    // PR : Register Logic

    





}


