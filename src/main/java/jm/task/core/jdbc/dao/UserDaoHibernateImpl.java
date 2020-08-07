package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
//import utils.HibernateSessionFactoryUtil;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Util ut = new Util();
        Transaction tx = null;
        try (Session session = ut.getSessionFactory().openSession())  {
            tx = session.beginTransaction();
            Query query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS users(id int primary key , name varchar(40), lastName varchar(40), age int );").addEntity(User.class);
            query.executeUpdate();
            session.getTransaction().commit();
//            session.close();

            System.out.println("Table is created");

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @Override
    public void dropUsersTable() {
        Util ut = new Util();
//        Transaction tx = null;
        try ( Session session = ut.getSessionFactory().openSession())  {
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
//            query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("Table is deleted");

        } catch (Exception e) {
            System.out.println("Таблица не была удалена");
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age ) {
        Util ut = new Util();
        User user = new User(name, lastName, age);
        Transaction tx = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            /*Transaction*/ tx = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
//            session.close();
            System.out.println("User named "+ name+" added in table");
        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
            System.out.println("Ошибочка");
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {
        User user = new User();
        Util ut = new Util();
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("delete User where id = :userId").setParameter("userId", id).executeUpdate();
//            query.setParameter("userId", id);
//            query.executeUpdate();
            session.getTransaction().commit();
//            session.close();
            System.out.println("объект был удален по id");

        } catch (Exception e) {
            System.out.println("Object was not deleted by id");
        }
    }

    @Override
    public List<User> getAllUsers() {
        Util ut = new Util();
        List<User> userList = new ArrayList<>();
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
             userList =(List<User>) session.createQuery("From " + User.class.getSimpleName()).list();
            session.getTransaction().commit();
            System.out.println("Список объектов получен");
//            for (Iterator<User> it = userList.iterator(); it.hasNext();) {
//                User user = (User) it.next();
//                System.out.println(user.toString());
//            }
        } catch (Exception e) {
            System.out.println("Список объектов небыл получен");
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Util ut = new Util();
        try (Session session = Util.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
//            query.setParameter("userId", id);
//            query.executeUpdate();
            session.getTransaction().commit();
//            session.close();
            System.out.println("Table is cleaned");

        } catch (Exception e) {
            System.out.println("Table was not cleaned");
            e.printStackTrace();
        }
    }
}
