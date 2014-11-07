/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufal.ic.p3.freemarket.persistence;

import java.util.List;

/**
 *
 * @author paulinha
 * @param <T>
 */
public interface IDAO<T> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> findAll();

    T findById(int id);
}