/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.learn.filter;

import com.learn.httprequest.XssHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "xssFilter", urlPatterns = "/*")
public class XssFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 程序防止XSS攻击原理
		// 1. 使用过滤器拦截所有参数
		HttpServletRequest req = (HttpServletRequest) request;
		// 2.重新getParameter方法
		XssHttpServletRequestWrapper xssHttpServletRequestWrapper = new XssHttpServletRequestWrapper(req);
		// 放行程序，继续往下执行
		chain.doFilter(xssHttpServletRequestWrapper, response);
	}

	@Override
	public void destroy() {

	}

}
