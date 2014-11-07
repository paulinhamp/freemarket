/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufal.ic.p3.freemarket.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author paulinha
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "T_SALE")
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User buyer;
    @ManyToOne
    private User seller;

    private Float total;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;

    @OneToMany
    @JoinTable(
            name="T_PRODUCT_SALE",
            joinColumns = @JoinColumn( name="sale_id"),
            inverseJoinColumns = @JoinColumn( name="product_id")
    )
    private List<Product> products;

    public Sale() {
    }

}
