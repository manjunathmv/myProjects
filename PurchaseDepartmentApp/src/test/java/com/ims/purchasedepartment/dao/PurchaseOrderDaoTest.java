package com.ims.purchasedepartment.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.assertj.core.api.AbstractIterableSizeAssert;
import org.assertj.core.api.ListAssert;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.ims.purchasedepartment.entites.PurchaseOrder;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class PurchaseOrderDaoTest {
	
	@Autowired
	private PurchaseOrderDao purchaseOrderDao;
	private AbstractIterableSizeAssert<ListAssert<PurchaseOrder>, List<? extends PurchaseOrder>, PurchaseOrder, ObjectAssert<PurchaseOrder>> greaterThan;
	
	
	@Test
	@Rollback(false)
	public void savePurchaseOrder() {	
		PurchaseOrder order= new PurchaseOrder();
		
		order.setName("Bolts");
		order.setDescription("bolts for wheel chairs");
		order.setPrice(500.00);
		order.setQuantity(300);
		order.setType("components");
		PurchaseOrder savedPurchaseOrder=purchaseOrderDao.save(order);
		assertNotNull(savedPurchaseOrder);
		
	}
	@Test
	public void getAllPurchaseOrder() {	
		
		List<PurchaseOrder> listorder=purchaseOrderDao.findAll();
		greaterThan = assertThat(listorder).size().isGreaterThan(0);
	}
	
	  @Test 
	  public void getPurchaseOrderByID() {
	  PurchaseOrder order=purchaseOrderDao.getOne(2); 
	  assertNotNull(order); }
	  
	  @Test  
	  @Rollback(false)
	  public void updatePurchaseOrder() { 
	  PurchaseOrder orderdetails= new PurchaseOrder();
	  orderdetails.getPurchaseId();
	  String orderName="Screws";
	  orderdetails.setQuantity(5000);	  
	  purchaseOrderDao.save(orderdetails);
	//  assertThat(orderdetails.getName().equalsIgnoreCase(orderName)); 
	  }
	  
	  @Test
	  @Rollback(false)
		public void cancelPurchaseOrder() {	
			Integer purchaseId=2;
			 boolean isExistAfterDelete =purchaseOrderDao.findById(purchaseId).isPresent();
			 purchaseOrderDao.deleteById(purchaseId);
			 boolean notExistAfterDelete=purchaseOrderDao.findById(purchaseId).isPresent();
			 assertTrue(isExistAfterDelete);
			 assertFalse(notExistAfterDelete);
		}
		
	 
}
