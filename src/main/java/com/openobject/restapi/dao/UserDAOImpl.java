package com.openobject.restapi.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openobject.restapi.domain.LoginDTO;
import com.openobject.restapi.domain.UserVO;


@Repository
public class UserDAOImpl implements UserDAO {
	private static final String USERMAPPER = "com.openobject.restapi.mappers.userMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void register(UserVO userVO) throws Exception {
		sqlSession.insert(USERMAPPER + ".register", userVO);
		
	}
	
	@Override
	public UserVO login(LoginDTO loginDTO) throws Exception {
		return sqlSession.selectOne(USERMAPPER + ".login", loginDTO);
	}
	
	
}
