/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufal.ic.p3.freemarket.persistence;

import br.ufal.ic.p3.freemarket.model.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author paulinha
 */
public class ProductDAO extends AbstractDAO<Product> {

    private static final ProductDAO PRODUCT_DAO = new ProductDAO();

    public static ProductDAO get() {
        return PRODUCT_DAO;
    }

    @Override
    public void save(Product entity) {
        super.save(entity);
    }

    @Override
    public void update(Product entity) {
        super.update(entity);
    }

    @Override
    public void delete(Product entity) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        entity.setActive(false);
        session.update(entity);
        transaction.commit();
        session.close();

    }

    @Override
    public List<Product> getAll() {
        String hql = "SELECT * FROM T_USER where active = true;";
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery(hql);
        List<Product> products = query.list();
        session.close();
        return products;
    }

    @Override
    public Product findById(long id) {
        String hql = "FROM T_PRODUCT where id = :id AND active = true";
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery(hql).setParameter("id", id);
        Product product = (Product) query.uniqueResult();
        session.close();
        return product;
    }

    public List<Product> findByOwner(long id) {
        String hql = "FROM T_PRODUCT where owner_id = :id";
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery(hql).setParameter("id", id);
        List<Product> products = query.list();
        session.close();
        return products;
    }

}
