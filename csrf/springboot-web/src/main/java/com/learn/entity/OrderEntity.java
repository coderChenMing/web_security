/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.learn.entity;

public class OrderEntity {

	private int id;
	private String orderName;
	private String orderDes;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the orderName
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * @param orderName
	 *            the orderName to set
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	/**
	 * @return the orderDes
	 */
	public String getOrderDes() {
		return orderDes;
	}

	/**
	 * @param orderDes
	 *            the orderDes to set
	 */
	public void setOrderDes(String orderDes) {
		this.orderDes = orderDes;
	}

}
