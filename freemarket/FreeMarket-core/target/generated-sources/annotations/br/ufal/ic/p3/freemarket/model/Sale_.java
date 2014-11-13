package br.ufal.ic.p3.freemarket.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sale.class)
public abstract class Sale_ {

	public static volatile SingularAttribute<Sale, User> seller;
	public static volatile SingularAttribute<Sale, Date> dateTime;
	public static volatile SingularAttribute<Sale, Float> total;
	public static volatile SingularAttribute<Sale, Long> id;
	public static volatile SingularAttribute<Sale, User> buyer;
	public static volatile ListAttribute<Sale, Product> products;

}

