package controller;

import db.mysqlcon;
import java.sql.*;

public class productController {
    private static int productId, productTokoId, productHarga;
    private static String productName, productDesc;
    
    public static void main(String[] args) throws ClassNotFoundException {
        GetAllUserData();
        System.out.println("\"");
    }

    public static void GetAllUserData() throws ClassNotFoundException {
        String query = "SELECT * FROM tbl_users";


        try(ResultSet data = mysqlcon.getQuery(query) ){


            while (data.next()) {
                productId = data.getInt(1);
                productName = data.getString(2);
                productDesc = data.getString(3);
                productTokoId = data.getInt(4);
                productHarga = data.getInt(5);

            }
            
        } catch (SQLException e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertProductData(String userName, String userEmail, String userPhoneNumber, int userRole, String userPassword) throws ClassNotFoundException, SQLException {
        userPhoneNumber = (userPhoneNumber != "" || userPhoneNumber != null) ? userPhoneNumber : null;
        String query = "INSERT INTO tbl_users (user_id , user_name, user_email, user_phone_number, user_role, user_password) VALUES " + "(" + 0 + ",\"" + userName + "\",\"" + userEmail + "\",\"" + userPhoneNumber + "\"," + userRole + ",\"" + userPassword + "\");";
        mysqlcon.initQuery(query);
    }

    public static void updateProductData(int userId, String userName, String userEmail, String userPhoneNumber, int userRole, String userPassword) throws ClassNotFoundException, SQLException {
        userPhoneNumber = (userPhoneNumber!= "" || userPhoneNumber!= null)? userPhoneNumber : null;
        String query = "UPDATE tbl_users SET user_name=\"" + userName + "\", user_email=\"" + userEmail + "\", user_phone_number=\"" + userPhoneNumber + "\", user_role=" + userRole + ", user_password=\"" + userPassword + "\" WHERE user_id=" + userId + ";";
        mysqlcon.initQuery(query);
    }

    public static void deleteProductData(int userId) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM tbl_users WHERE user_id=" + userId + ";";
        mysqlcon.initQuery(query);
    }

}
