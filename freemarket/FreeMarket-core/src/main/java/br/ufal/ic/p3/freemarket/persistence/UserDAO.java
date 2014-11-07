/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufal.ic.p3.freemarket.persistence;

import br.ufal.ic.p3.freemarket.model.Product;
import br.ufal.ic.p3.freemarket.model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author paulinha
 */
public class UserDAO implements IDAO<User> {

    @Override
    public void save(User entity) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User entity) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public List<User> findAll() {
        String hql = "SELECT * FROM T_USER;";
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        session.close();

        return users;
    }

    @Override
    public User findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        User user = new User("Ana", "Paula", "ana@mail.com", "87878", "9999", "anna", "123");
        UserDAO dao = new UserDAO();
        dao.save(user);
    }

}
