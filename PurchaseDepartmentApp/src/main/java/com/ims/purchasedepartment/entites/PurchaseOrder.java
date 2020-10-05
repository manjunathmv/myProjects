package com.ims.purchasedepartment.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**

* PurchaseOrder this Entity Class,  name of the tablename is purchase , Column name   is Puchaseid,name,type,description,quantity,price
* or materialsiavl
* 
* @author   Manjunath M V
* @version 1.0
* @since   2020-09-07
*/

@Entity
@Table(name= "purchase")
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseId;

	private String name;
	
	private String type;

	private String description;
	
	private int quantity;

	private double price;
	
	//No- Args Constructor
	public PurchaseOrder() {
		
	}

	 /**
	   * This method is used to getPurchaseId	   
	   * @return int This returns purchaseId .
	   */
	public int getPurchaseId() {
		return purchaseId;
	}

	
	 /**
	   * This method is used to setPurchaseId	   
	   * @param purchaseId This is the parameter .
	   */
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}


	 /**
	   * This method is used to getType	   
	   * @return String This returns type .
	   */
	public String getType() {
		return type;
	}


	 /**
	   * This method is used to setType	   
	   * @param type This is the parameter .
	   */	
	public void setType(String type) {
		this.type = type;
	}

	 /**
	   * This method is used to getQuantity	   
	   * @return int This returns quantity .
	   */
	public int getQuantity() {
		return quantity;
	}

	 /**
	   * This method is used to setQuantity	   
	   * @param quantity This is the parameter .
	   */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	 /**
	   * This method is used to getName	   
	   * @return String This returns name .
	   */
	public String getName() {
		return name;
	}
	 /**
	   * This method is used to setName	   
	   * @param name This is the parameter .
	   */
	public void setName(String name) {
		this.name = name;
	}
	 /**
	   * This method is used to getDescription	   
	   * @return String This returns description .
	   */
	public String getDescription() {
		return description;
	}
	 /**
	   * This method is used to setPurchaseId	   
	   * @param description This is the parameter .
	   */
	public void setDescription(String description) {
		this.description = description;
	}
	 /**
	   * This method is used to getPrice	   
	   * @return double This returns price .
	   */
	public double getPrice() {
		return price;
	}
	
	 /**
	   * This method is used to setPrice	   
	   * @param price This is the parameter .
	   */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	

}
