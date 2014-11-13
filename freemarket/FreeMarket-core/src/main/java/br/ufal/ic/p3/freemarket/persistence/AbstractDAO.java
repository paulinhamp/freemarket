/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufal.ic.p3.freemarket.persistence;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author paulinha
 */
public abstract class AbstractDAO<T> {

    protected void save(T entity) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    protected void update(T entity) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
    }

    protected abstract void delete(T entity);

    protected abstract List<T> getAll();

    protected abstract T findById(long id);

}
