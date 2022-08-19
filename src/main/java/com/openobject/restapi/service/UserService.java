package com.openobject.restapi.service;

import com.openobject.restapi.domain.LoginDTO;
import com.openobject.restapi.domain.UserVO;

public interface UserService {
	
	// 회원 가입 처리
	public void register(UserVO userVO) throws Exception;
	
	// 로그인 처리
	public UserVO login(LoginDTO loginDTO) throws Exception;
}
