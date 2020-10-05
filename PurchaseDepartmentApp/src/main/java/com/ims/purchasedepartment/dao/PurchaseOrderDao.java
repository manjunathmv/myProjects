package com.ims.purchasedepartment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ims.purchasedepartment.entites.PurchaseOrder;



/**

* PurchaseOrderDao this Repository  Class this we have In built  methods  JPA repository Class for CRUD operation
* or materials
* 
* @author   Manjunath M V
* @version 1.0
* @since   2020-09-07
*/
@Repository
public interface PurchaseOrderDao extends  JpaRepository<PurchaseOrder, Integer> {
	
}
