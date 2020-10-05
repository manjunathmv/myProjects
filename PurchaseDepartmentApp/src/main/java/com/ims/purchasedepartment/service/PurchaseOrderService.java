package com.ims.purchasedepartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**

* PurchaseOrderServiceImpl  this Service Implementation Class PlaceOrder,UpdatePlaceOrder,getPlaceOrder,getAllPlaceOrders,updatePlaceOrder f
* or materials
* 
* @author   Manjunath M V
* @version 1.0
* @since   2020-09-07
*/



import org.springframework.stereotype.Service;

import com.ims.purchasedepartment.dao.PurchaseOrderDao;
import com.ims.purchasedepartment.entites.PurchaseOrder;



@Service
public class PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderDao purchaseOrderDao;
	
	
	public PurchaseOrder placeOrder(PurchaseOrder order) {
		return purchaseOrderDao.save(order);
	} 
	
	
	public PurchaseOrder getPlaceOrder(int orderId) {
		return purchaseOrderDao.findById(orderId).orElseThrow();
	}

	
	public List<PurchaseOrder> getAllPlaceOrders() {
		return purchaseOrderDao.findAll() ;
	}


	
	public PurchaseOrder updatePlaceOrder(PurchaseOrder order) {
		PurchaseOrder oldPuchaseOrder= purchaseOrderDao.findById(order.getPurchaseId()).orElseThrow();
		oldPuchaseOrder.setName(order.getName());
		oldPuchaseOrder.setDescription(order.getDescription());
		oldPuchaseOrder.setPrice(order.getPrice());
		oldPuchaseOrder.setType(order.getType());
		oldPuchaseOrder.setQuantity(order.getQuantity());
		return purchaseOrderDao.save(oldPuchaseOrder);
	}



	public boolean cancelPlaceOrder(int orderId) {
		 purchaseOrderDao.deleteById(orderId);
		 return true;
	}


	

}
