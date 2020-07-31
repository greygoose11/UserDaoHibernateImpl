package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    String url = "jdbc:mysql://localhost:3306/db_1_1_3";
    String username = "root";
    String password = "Sentyabr@#11";
    /*public void setUrl(String url) {
        this.url = url;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }*/
    public Connection setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver hvjlkhlk;lln");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
        //java -classpath c:\Java\mysql-connector-java-8.0.11.jar;c:\Java Program
       /* try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Connection succesfull!");
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }*/
    }

