/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.learn.httprequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	private HttpServletRequest request;

	/**
	 * @param request
	 */
	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		// 获取之前的参数
		String olValue = super.getParameter(name);
		System.out.print("原来参数:" + olValue);
		if (!StringUtils.isEmpty(olValue)) {
			// 将特殊字符转换成html展示 // 3.使用(StringEscapeUtils.escapeHtml(name)转换特殊参数
			olValue = StringEscapeUtils.escapeHtml(olValue);
			System.out.println("转换后" + olValue);
		}
		System.out.println();
		return olValue;
	}

}
