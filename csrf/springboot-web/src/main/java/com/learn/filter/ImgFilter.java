/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.learn.filter;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 图片防盗链
@WebFilter(filterName = "imgFilter", urlPatterns = "/imgs/*")
public class ImgFilter implements Filter {
    @Value("${spring.domain.name}")
    private String domainName;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 1.获取请求头中的来源字段
        HttpServletRequest req = (HttpServletRequest) request;
        String referer = req.getHeader("Referer");
        if (StringUtils.isEmpty(referer)) {
            request.getRequestDispatcher("/imgs/error.png").forward(req, response);
            return;
        }
        // 2.判断请求头中的域名是否和限制的域名一致
        String domainUrl = getDomain(referer);
        System.out.println(domainUrl);
        // 正常情况 黑名单 白名单接口
        if (!domainUrl.equals(domainName)) {
            request.getRequestDispatcher("/imgs/error.png").forward(req, response);
            return;
        }
        // 直接放行图片
        chain.doFilter(req, response);

    }

    /**
     * 获取url对应的域名
     *
     * @param url
     * @return
     */
    public String getDomain(String url) {
        String result = "";
        int j = 0, startIndex = 0, endIndex = 0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '/') {
                j++;
                if (j == 2) {
                    startIndex = i;
                } else if (j == 3) {
                    endIndex = i;
                }
            }

        }
        result = url.substring(startIndex + 1, endIndex);
        return result;
    }


    @Override
    public void destroy() {

    }

}
