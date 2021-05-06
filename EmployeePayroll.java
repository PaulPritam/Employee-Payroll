package com.learningBasics;

import java.sql.*;

public class EmployeeJDBC {
    /**
     * Throws two exceptions
     * SQLException: throws error when their is interaction error between database and java
     * ClassNotFoundException: throws error when it can not load the class from the given classpath
     */

    public static void main(String[] args) throws SQLException {

        /**
         * uc1:Establishing and Authenticating connectivity between database and Java program
         */

        String url = "jdbc:mysql://localhost:3306/employee_payroll";
        String username = "root";
        String password = "Pritampaul@1997";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_payroll");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            /**
             * uc2: Retrieving data from database
             */
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString(1)
                                + " " + resultSet.getString(2) + " "
                                + " " + resultSet.getString(3) + " "
                                + " " + resultSet.getString(4) + " "
                                + " " + resultSet.getString(5) + " "
                                + " " + resultSet.getString(6) + " "
                                + " " + resultSet.getString(7) + " "
                                + " " + resultSet.getString(8) + " "
                );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
