package com.openobject.restapi.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.openobject.restapi.domain.LoginDTO;
import com.openobject.restapi.domain.ResponseMsg;
import com.openobject.restapi.domain.UserVO;
import com.openobject.restapi.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public UserVO register(@RequestBody UserVO userVO) throws Exception {
		String hashedPw = BCrypt.hashpw(userVO.getPassword(), BCrypt.gensalt());
		userVO.setPassword(hashedPw);
		userService.register(userVO);
		
		return userVO;
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ResponseMsg login(@RequestBody LoginDTO loginDTO, HttpServletRequest request) throws Exception {
		UserVO userVO = userService.login(loginDTO);
		ResponseMsg resMsg = new ResponseMsg();
		
		
		if(userVO == null || !BCrypt.checkpw(loginDTO.getPassword(), userVO.getPassword())) {
			resMsg.setMsg("로그인 실패!");
		}else {
			System.out.println(userVO.getName());
			resMsg.setMsg("로그인 성공!");
			if(userVO != null) {
				request.getSession().setAttribute("login", userVO);	
			}

		}
		
		
		return resMsg;
		 
	
	}
	
	@ResponseBody
	@RequestMapping(value = "/info")
	public Map<String, Object> getUserInfo(HttpServletRequest request) {
		UserVO userVO = (UserVO) request.getSession().getAttribute("login");
		Map<String, Object> userInfo = new HashMap<String, Object>();
		userInfo.put("name", userVO.getName());
		userInfo.put("age", userVO.getAge());
		userInfo.put("phone", userVO.getPhone());
		userInfo.put("address", userVO.getAddress());
		userInfo.put("email", userVO.getEmail());
		return userInfo;
	}
	
	

}
