package com.macy.dto;

import java.io.Serializable;

public class OrderStatus implements Serializable{

	private FulFillmentOrder orderXml;
	private OrderJsonDto order;
	private String status;
	private String message;

	public OrderStatus() {
	}

	public OrderStatus(OrderJsonDto order, String status, String message) {
		super();
		this.order = order;
		this.status = status;
		this.message = message;
	}
	
	public OrderStatus(FulFillmentOrder orderXml, String status, String message) {
		super();
		this.orderXml = orderXml;
		this.status = status;
		this.message = message;
	}

	
	public FulFillmentOrder getOrderXml() {
		return orderXml;
	}

	public void setOrderXml(FulFillmentOrder orderXml) {
		this.orderXml = orderXml;
	}

	public OrderJsonDto getOrder() {
		return order;
	}

	public void setOrder(OrderJsonDto order) {
		this.order = order;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OrderStatus [order=" + order + ", status=" + status + ", message=" + message + "]";
	}

}
