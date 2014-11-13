/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufal.ic.p3.freemarket.facade;

import br.ufal.ic.p3.freemarket.model.User;
import br.ufal.ic.p3.freemarket.persistence.HibernateUtil;
import br.ufal.ic.p3.freemarket.persistence.UserDAO;

/**
 *
 * @author paulinha
 */
public class Facade {

    public void createUser(String firstname, String lastname, String email,
            String homePhone, String cellPhone, String login, String password) {
        User user = new User(firstname, lastname, email, homePhone, cellPhone, login, password);
        UserDAO.get().save(user);
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.createUser("Ana", "Paula", "ana@paula.com", "888", "999", "ana", "123");
    }
    
}
