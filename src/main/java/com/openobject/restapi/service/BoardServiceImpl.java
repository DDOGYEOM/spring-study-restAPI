package com.openobject.restapi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openobject.restapi.dao.BoardDAO;
import com.openobject.restapi.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public int getAllBoardCnt() {
		return boardDAO.getAllBoardCnt();
	}

	@Override
	public List<BoardVO> getBoardList(int page) {
		return boardDAO.getBoardList(page);
	}

	@Override
	public BoardVO getBoardDetail(int id) {
		return boardDAO.getBoardDetail(id);
	}

	@Override
	public void writeBoard(BoardVO writeInfo) {
		boardDAO.boardWrite(writeInfo);
	}

	@Override
	public int updateBoard(BoardVO updateInfo) {
		return boardDAO.boardModify(updateInfo);
	}

	@Override
	public int delteBoard(@Param(value = "boardId") int id) {
		 return boardDAO.boardDelete(id);
	}
}
