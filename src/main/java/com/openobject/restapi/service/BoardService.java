package com.openobject.restapi.service;

import java.util.List;

import com.openobject.restapi.domain.BoardVO;



public interface BoardService {
	public int getAllBoardCnt();

	public List<BoardVO> getBoardList(int page);

	public BoardVO getBoardDetail(int id);

	public void writeBoard(BoardVO writeInfo);

	public int updateBoard(BoardVO updateInfo);

	public int delteBoard(int id);
}
