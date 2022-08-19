package com.openobject.restapi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.openobject.restapi.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private final String boardMapper = "com.openobject.restapi.mappers.boardMapper";
	
	@Autowired
	public SqlSession sqlSession; 

	@Override
	public int getAllBoardCnt() {
		return sqlSession.selectOne(boardMapper + ".boardCount");
	}
	
	@Override
	public List<BoardVO> getBoardList(int page) {
		return sqlSession.selectList(boardMapper + ".boardAll", page);
	}

	@Override
	public BoardVO getBoardDetail(int boardId) {
		return sqlSession.selectOne(boardMapper + ".boardDetail", boardId);
	}

	@Override
	public int boardWrite(BoardVO writeData) {
		return sqlSession.insert(boardMapper + ".boardWrite", writeData);
	}

	@Override
	public int boardModify(BoardVO updateInfo) {
		return sqlSession.update(boardMapper + ".boardModify", updateInfo);
	}

	@Override
	public int boardDelete(int boardId) {
		return sqlSession.delete(boardMapper + ".boardDelete", boardId);
	}


}
