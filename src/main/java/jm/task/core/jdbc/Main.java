package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Fedor", "Dostoevskiy", (byte) 88);
        userDaoJDBC.saveUser("Nikolay", "Nekrasov", (byte) 55);
        userDaoJDBC.saveUser("Anton", "Chehov", (byte) 88);
        System.out.println(userDaoJDBC.getAllUsers());
        //userDaoJDBC.dropUsersTable();



    }
}
