/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufal.ic.p3.freemarket.model;

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
public class Product {
    
    private long id;
    
    private String name;
    private String description;
    private Float price;
    private int quantity;
    
    private User owner;
    
}
