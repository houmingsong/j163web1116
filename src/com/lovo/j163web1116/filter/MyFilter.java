package com.lovo.j163web1116.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 字符集编码过滤器
 * 
 * @author Administrator
 *
 */
@WebFilter("/TestFilterServlet")
public class MyFilter implements Filter {
	
	private String charactorEncoding = "UTF-8";
	
	public MyFilter() {
		System.out.println("过滤器被创建了");
	}
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器被初始化了");
		String encode = filterConfig.getInitParameter("characterEncoding");
		
		if (encode != null && encode.length() != 0) {
			this.charactorEncoding = encode;
		}
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		System.out.println("-------执行过滤器里面的代码处理业务------过去");
		
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		response.setContentType("text/html");
		
		response.setCharacterEncoding(charactorEncoding);
		
		//放行请求
		arg2.doFilter(arg0, response);
		
//		System.out.println("-------执行过滤器里面的代码处理业务------回来");
//		
//		arg2.doFilter(arg0, arg1);
	}
	
	@Override
	public void destroy() {
		System.out.println("过滤器被销毁了");
	}

	
}
