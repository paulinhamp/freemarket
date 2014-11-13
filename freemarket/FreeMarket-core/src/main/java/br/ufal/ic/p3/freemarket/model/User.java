/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufal.ic.p3.freemarket.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author paulinha
 */
@Data
@Entity
@Table(name = "T_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstname;
    private String lastname;

    private String email;
    private String homePhone;
    private String cellPhone;

    private String login;
    private String password;
    
    private boolean active = true;

    public User() {
    }

    public User(String firstname, String lastname, String email, String homePhone, String cellPhone, String login, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.homePhone = homePhone;
        this.cellPhone = cellPhone;
        this.login = login;
        this.password = password;
    }

}
