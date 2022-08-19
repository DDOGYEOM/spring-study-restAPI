package com.openobject.restapi.commons.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AuthIntercepter extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(AuthIntercepter.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession httpSession = request.getSession();
		
		if(httpSession.getAttribute("login") == null) {
			logger.info("current user is not logged");
			
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			PrintWriter w = response.getWriter();
			w.write("{\"msg\":\"로그인 되지 않았습니다.\"}");
			w.flush();
			w.close();
			return false;
		}
		return true;
	}

}
