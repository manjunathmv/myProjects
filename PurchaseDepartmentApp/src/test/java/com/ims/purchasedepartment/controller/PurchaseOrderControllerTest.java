package com.ims.purchasedepartment.controller;


import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ims.purchasedepartment.controller.PurchaseOrderController;
import com.ims.purchasedepartment.entites.PurchaseOrder;
import com.ims.purchasedepartment.service.PurchaseOrderService;


@WebMvcTest(PurchaseOrderController.class)
public class PurchaseOrderControllerTest { 
	
	@Autowired
	private MockMvc mokmvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private PurchaseOrderService pOrderService;
	

	@Test	
	public void  placeOrder() throws JsonProcessingException, Exception {
		PurchaseOrder order= new PurchaseOrder();
		order.setName("wheels");
		order.setDescription(" wheels for chairs");
		order.setPrice(500.00);
		order.setQuantity(300);
		order.setType("components");
		PurchaseOrder savedPurchaseOrder=pOrderService.placeOrder(order);
	    Mockito.when(pOrderService.placeOrder(order)).thenReturn(savedPurchaseOrder);
		String url="/api/placeOrder";
		mokmvc.perform(post(url)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(order))
				.with(csrf())
		).andExpect(status().isOk());
//		.andExpect(content().string("1"));
				
		
		
		
	}
	
	
	
	@Test	
	public void  getAllplaceOrders() throws Exception {	
		PurchaseOrder order= new PurchaseOrder();
		order.setPurchaseId(1);
		order.setName("wheels");
		order.setDescription(" wheels for chairs");
		order.setPrice(500.00);
		order.setQuantity(300);
		order.setType("components");
		PurchaseOrder secondOrder= new PurchaseOrder();
		secondOrder.setPurchaseId(2);
		secondOrder.setName("Rubber");
		secondOrder.setDescription(" rubber for chairs");
		secondOrder.setPrice(3500.00);
		secondOrder.setQuantity(100);
		secondOrder.setType("rawmaterial");
		List<PurchaseOrder> orderList= new ArrayList<PurchaseOrder>();
		orderList.add(order);
		orderList.add(secondOrder);
	
	     Mockito.when(pOrderService.getAllPlaceOrders()).thenReturn(orderList);
		String url="/api/getAllPlaceOrders";
		mokmvc.perform(get(url)).andExpect(status().isOk());		
		
	}
	
	

	
	@Test	
	public void  getPlaceOrder() throws Exception {	
		PurchaseOrder order= new PurchaseOrder();
		order.setPurchaseId(1);
		order.setName("wheels");
		order.setDescription(" wheels for chairs");
		order.setPrice(500.00);
		order.setQuantity(300);
		order.setType("components");

	     Mockito.when(pOrderService.getPlaceOrder(1)).thenReturn(order);
		String url="/api/getPlaceOrder/1";
		mokmvc.perform(get(url)).andExpect(status().isOk());		
		
	}
	
	

	@Test	
	public void  cancelPlaceOrder() throws Exception {	
	    Integer purchaseId=3;

		String url="/api/cancelPlaceOrder/3";
		mokmvc.perform(delete(url)).andExpect(status().isOk());
		Mockito.verify(pOrderService, times(1)).cancelPlaceOrder(purchaseId);
		
		
	}

}