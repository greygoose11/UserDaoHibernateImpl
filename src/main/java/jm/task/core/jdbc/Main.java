package jm.task.core.jdbc;

import com.mysql.jdbc.Driver;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    /*
    private static final String URL = "jdbc:mysql://localhost:3306/my_db_test?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Sentyabr@#11";


     */
    public static void main(String[] args)  {
        Util util = new Util();
        String order = "select * from my_table_test";
        try {
            Statement statement = util.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(order);
             while (resultSet.next()) {
                 User user = new User();

                 user.setId(resultSet.getLong("id"));
                 user.setName(resultSet.getString("name"));
                 user.setLastName(resultSet.getString("lastName"));
                 user.getAge(resultSet.getByte("age"));
                 //System.out.println(id + " " + name + " " + lastName);
                 System.out.println(user);
             }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //    Util.Connektor();

        // реализуйте алгоритм здесь
        /*


        Connection connection;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.printf("Соединение закрыто");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось загрузить драйвер");
        }finally {

        }

         */



    }
}
