package test;

import java.sql.SQLException;

import controller.userController;

public class UserControllerTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        userController.insertUserData("maou",  "mmmmm", "null", 1,"password");
        userController.insertUserData("John Doe",  "jondj@mm.m", "q", 1,"password");
        userController.insertUserData("mom",  "rerw@gag.c", "123-456-7890", 1,"password");


        int userId = 10;
        String userName = "John Doe";
        String userEmail = "<EMAIL>";
        String userPhoneNumber = "123-456-7890";
        int userRole = 1;
        String userPassword = "password1";

        userController.insertUserData(userName, userEmail, userPhoneNumber, userRole, userPassword);


        userController.updateUserData(userId, userName, userEmail, userPhoneNumber, userRole, userPassword);
    }
}