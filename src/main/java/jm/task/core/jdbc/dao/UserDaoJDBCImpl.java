//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    //String order = "select * from my_table_test";
//
//
//        PreparedStatement preparedStatement = null;
//
//    {
//        try {
//            PreparedStatement preparedStatement = Util.connektor().prepareStatement(INSERT_NEW);
//            //statement = Util.getConnection().createStatement();
//            //ResultSet resultSet = statement.executeQuery(order);
//        } catch (SQLException throwables) {
//                throwables.printStackTrace();
//        }
//    }
//
//        public UserDaoJDBCImpl() {
//
//        }
//
//
//        public void createUsersTable() {
//            try ( Statement statement = Util.connektor().createStatement())  {
//                statement.execute("CREATE TABLE IF NOT EXISTS users(id int primary key auto_increment, name varchar(40), lastName varchar(40), age int );");
//                System.out.println("Table is created");
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        public void dropUsersTable() {
//            try (Statement statement = Util.connektor().createStatement()) {
//                statement.execute("DROP TABLE IF EXISTS users");
//                System.out.println("Table is deleted");
//            }catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void saveUser(String name, String lastName, byte age) {
//            final String INSERT_NEW = "INSERT INTO users (name, lastname, age) VALUES (?,?,?)";
//            try (PreparedStatement preparedStatement = Util.connektor().prepareStatement(INSERT_NEW)){
//                preparedStatement.setString(1, name);
//                preparedStatement.setString(2, lastName);
//                preparedStatement.setByte(3, age);
//                preparedStatement.execute();
//                System.out.println("User named "+ name+" added in table");
//
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//
//        public void removeUserById(long id) {
//            try (PreparedStatement preparedStatement = Util.connektor().prepareStatement("DELETE FROM users WHERE id = ?")) {
//                preparedStatement.setLong(1,id);
//                preparedStatement.execute();
//                System.out.println("Success in deleting users by id");
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public List<User> getAllUsers() {
//            List<User> usersList = new ArrayList<>();
//            String order = "select * from  users";
//            try (Statement statement = Util.connektor().createStatement(); ResultSet resultSet = statement.executeQuery(order)){
//                while (resultSet.next()) {
//                    User user = new User();
//                    user.setId(resultSet.getLong("id"));
//                    user.setName(resultSet.getString("name"));
//                    user.setLastName(resultSet.getString("lastName"));
//                    user.setAge(resultSet.getByte("age"));
//                    usersList.add(user);
//                }
//
//            }catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return usersList;
//        }
//
//        public void cleanUsersTable() {
//            Connection connection = null;
//            Statement statement=null;
//
//            try /*(PreparedStatement preparedStatement = Util.connektor().prepareStatement("DELETE * FROM  users"))*/
//{
//        //    preparedStatement.execute();
//            connection = Util.connektor();
//            statement = connection.createStatement();
//            statement.execute("DELETE FROM  users");
//            System.out.println("Table is cleaned at all");
//
//        //    System.out.println("Table is cleaned");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//                statement.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//
//        }
//
//    }
//    }
//}
