package com.openobject.restapi.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN = "login";
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		System.out.println(modelAndView);
//		HttpSession httpSession = request.getSession();
//		ModelMap modelMap = modelAndView.getModelMap();
//		Object userVO = modelMap.get("user");
//		System.out.println(userVO);
//		
//		if(userVO != null) {
//			httpSession.setAttribute(LOGIN, userVO);	
//		}
//	}
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession httpSession = request.getSession();
		
		if(httpSession.getAttribute(LOGIN) != null) {
			System.out.println("?????????");
			httpSession.removeAttribute(LOGIN);
		}
		return true ;
	}
}
