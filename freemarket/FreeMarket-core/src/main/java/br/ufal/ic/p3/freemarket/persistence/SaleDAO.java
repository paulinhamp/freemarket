/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufal.ic.p3.freemarket.persistence;

import br.ufal.ic.p3.freemarket.model.Sale;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author paulinha
 */
public class SaleDAO extends AbstractDAO<Sale> {

    @Override
    public void save(Sale entity) {
        super.save(entity);
    }

    @Override
    public void update(Sale entity) {
        super.update(entity);
    }

    @Override
    protected void delete(Sale entity) {
    }

    @Override
    protected List<Sale> getAll() {
        String hql = "SELECT * FROM T_SALE;";
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery(hql);
        List<Sale> sales = query.list();
        session.close();
        return sales;
    }

    @Override
    protected Sale findById(long id) {
        String hql = "SELECT * FROM T_SALE where id = :id;";
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery(hql).setParameter("id", id);
        Sale sale = (Sale) query.uniqueResult();
        session.close();
        return sale;
    }

}
