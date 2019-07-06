package com.lovo.j163web1116.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lovo.j163web1116.bean.UserBean;

/**
 * Servlet Filter implementation class LoginFilter2
 */
@WebFilter("/html/*")
public class LoginFilter2 implements Filter {

    
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		// /j163web1116/html/login
		String uri = request.getRequestURI();
		
		if (uri.contains("login.html")) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = request.getSession();
			
			UserBean userBean =	(UserBean)session.getAttribute("user");
			
			if (userBean != null) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect("login.html");
			}
		}
	}


}
