package com.ims.purchasedepartment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.purchasedepartment.entites.PurchaseOrder;
import com.ims.purchasedepartment.service.PurchaseOrderService;

/**

* PurchaseOrderController  this ControllerClass,we have methods  PlaceOrder,UpdatePlaceOrder,getPlaceOrder,getAllPlaceOrders,updatePlaceOrder f
* or materials
* 
* @author   Manjunath M V
* @version 1.0
* @since   2020-09-07
*/
@RestController
@RequestMapping(path = "/api")
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	   /**
	   * This method is used to PlaceOrder	   
	   * @param order This is the parameter to PrchaseOrder object in this method
	   * @return PurchaseOrder This returns purchaseOrder Object.
	   */
	@PostMapping("/placeOrder")
	public PurchaseOrder placeOrder(@RequestBody PurchaseOrder order) {	
		return purchaseOrderService.placeOrder(order);
	}
	 /**
	   * This method is used to getPlaceOrder	   
	   * @param orderId This is the parameter to int in this method
	   * @return PurchaseOrder This returns purchaseOrder Object.
	   */
	
	@GetMapping("/getPlaceOrder/{orderId}")
	public PurchaseOrder getPlaceOrder(@PathVariable int orderId) {
		return purchaseOrderService.getPlaceOrder(orderId);
	}
	 /**
	   * This method is used to getAllPlaceOrders	   
	   * @return  List of PurchaseOrderThis returns all the  purchaseOrders information .
	   */
	
	@GetMapping("/getAllPlaceOrders")
	public List<PurchaseOrder> getAllPlaceOrders() {
		return purchaseOrderService.getAllPlaceOrders();
	}
	
	 /**
	   * This method is used to updatePlaceOrder	   
	   * @param order This is the parameter to PrchaseOrder object  in this method
	   * @return PurchaseOrder This returns purchaseOrder Object.
	   */
	@PutMapping("/updatePlaceOrder")
	public PurchaseOrder updatePlaceOrder(@RequestBody PurchaseOrder order) {
		return purchaseOrderService.updatePlaceOrder(order);
		}

	
	 /**
	   * This method is used to cancelPlaceOrder	   
	   * @param orderId This is the parameter to int  in this method
	   * @return boolean This returns value
	   */
	@DeleteMapping("/cancelPlaceOrder/{orderId}")
	public boolean cancelPlaceOrder(@PathVariable int orderId) {
		return purchaseOrderService.cancelPlaceOrder(orderId);
		}

}