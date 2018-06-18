package br.ifsp.codeLibrary.utilities;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
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

@ManagedBean
@WebFilter (servletNames={"Faces Servlet"})
public class Autentication implements Filter {
	private boolean autentication;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req= (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		if(session.getAttribute("usuario") != null || 
				req.getRequestURI().endsWith("login.xhtml") || 
				req.getRequestURI().endsWith("register.xhtml") ||
				req.getRequestURI().endsWith("home.xhtml")) {
			
			autentication = true;		
			chain.doFilter(request, response);	
		}else{
			autentication = false;
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("login.xhtml");			
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getAutentication() {
		return autentication;
	}
	public void setAutentication(boolean autentication) {
		this.autentication = autentication;
	}
}