/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufal.ic.p3.freemarket.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author paulinha
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sale {
    
    private long id;
    
    private User buyer;
    
    private User seller;
       
    private Float value;
    
    private List<Product> products;
    
}
