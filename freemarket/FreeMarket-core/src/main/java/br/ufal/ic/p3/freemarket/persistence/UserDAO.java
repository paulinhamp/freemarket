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
public class UserDAO extends AbstractDAO<User> {

    private static final UserDAO USER_DAO = new UserDAO();

    public static UserDAO get() {
        return USER_DAO;
    }

    @Override
    public void save(User entity) {
        super.save(entity);
    }

    @Override
    public void update(User entity) {
        super.update(entity);
    }

    @Override
    public void delete(User entity) {
        List<Product> products = ProductDAO.get().findByOwner(entity.getId());
        for (Product product : products) {
            ProductDAO.get().delete(product);
        }
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();

        entity.setActive(false);
        session.update(entity);
        transaction.commit();
        session.close();

    }

    @Override
    public List<User> getAll() {
        String hql = "SELECT * FROM T_USER where active = true;";
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        session.close();
        return users;
    }

    @Override
    public User findById(long id) {
        String hql = "FROM T_USER where id = :id AND active = true";
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery(hql).setParameter("id", id);
        User user = (User) query.uniqueResult();
        session.close();
        return user;
    }
    
    public static void main(String[] args) {
       HibernateUtil.getSessionFactory();
        User user = new User("Ana", "Paula", "ana@mail.com", "87878", "9999", "anna", "123");
        UserDAO.get().save(user);
    }

}
