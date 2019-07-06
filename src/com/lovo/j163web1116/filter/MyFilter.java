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
 * �ַ������������
 * 
 * @author Administrator
 *
 */
@WebFilter("/TestFilterServlet")
public class MyFilter implements Filter {
	
	private String charactorEncoding = "UTF-8";
	
	public MyFilter() {
		System.out.println("��������������");
	}
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("����������ʼ����");
		String encode = filterConfig.getInitParameter("characterEncoding");
		
		if (encode != null && encode.length() != 0) {
			this.charactorEncoding = encode;
		}
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		System.out.println("-------ִ�й���������Ĵ��봦��ҵ��------��ȥ");
		
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		response.setContentType("text/html");
		
		response.setCharacterEncoding(charactorEncoding);
		
		//��������
		arg2.doFilter(arg0, response);
		
//		System.out.println("-------ִ�й���������Ĵ��봦��ҵ��------����");
//		
//		arg2.doFilter(arg0, arg1);
	}
	
	@Override
	public void destroy() {
		System.out.println("��������������");
	}

	
}
