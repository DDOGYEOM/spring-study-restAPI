package com.openobject.restapi.dao;

import java.util.List;

import com.openobject.restapi.domain.BoardVO;

public interface BoardDAO {
	public List<BoardVO> getBoardList(int page);
	public BoardVO getBoardDetail(int boardId);
	public int boardWrite(BoardVO writeData);
	public int boardModify(BoardVO updateInfo);
	public int boardDelete(int boardId);
	public int getAllBoardCnt();
}
