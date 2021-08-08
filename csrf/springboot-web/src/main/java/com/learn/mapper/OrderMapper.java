/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.learn.mapper;

import org.apache.ibatis.annotations.Insert;

import com.learn.entity.OrderEntity;

public interface OrderMapper {
	@Insert("insert order_info values (null,#{orderName},#{orderDes})")
	public int addOrder(OrderEntity OrderEntity);
}
