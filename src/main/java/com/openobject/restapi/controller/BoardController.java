package com.openobject.restapi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.openobject.restapi.domain.BoardVO;
import com.openobject.restapi.domain.ResponseMsg;
import com.openobject.restapi.pagination.Pagination;
import com.openobject.restapi.service.BoardService;
 
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	Boolean isPgnInit = false;

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public List<BoardVO> goBoardPage(@RequestParam(defaultValue = "1") int page, HttpServletRequest request) {
		System.out.println(request.getSession().getAttribute("login"));
		
		int totalBoardCnt = boardService.getAllBoardCnt();
		Pagination pagination = new Pagination(totalBoardCnt, page);

		List<BoardVO> boardList = boardService.getBoardList(pagination.getStartIndex());
		
		System.out.println(boardList.get(0).getPostDate().toString());

		return boardList;
	}

	@ResponseBody
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public BoardVO goBoardDetail(Model model, HttpServletRequest request) {
		BoardVO bDetail = new BoardVO();
		bDetail = boardService.getBoardDetail(Integer.parseInt(request.getParameter("id")));

		return bDetail;
	}


	@ResponseBody
	@RequestMapping(value="/write", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BoardVO boardWrite(@RequestBody BoardVO writeData) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		writeData.setPostDate(now.format(formatter));
		boardService.writeBoard(writeData);
 
		return writeData;
	}


	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST )
	public ResponseMsg boardUpdate(@RequestBody BoardVO updateInfo) {
			int isUpdate = boardService.updateBoard(updateInfo);
			ResponseMsg resMsg = new ResponseMsg();
			
			if(isUpdate == 0) {
				resMsg.setMsg("게시글 수정하는데 문제가 발생하였습니다.");
			}else {
				resMsg.setMsg("수정 완료");
			}
			
			
			return resMsg;
	}

	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseMsg boardDelete(HttpServletRequest request) {
		int isDelete = boardService.delteBoard(Integer.parseInt(request.getParameter("id")));
		ResponseMsg resMsg = new ResponseMsg();
		
		if(isDelete == 0) {
			resMsg.setMsg("존재하지 않는 게시글입니다.");
		}else {
			resMsg.setMsg("삭제 완료");
		}
		
		

		return resMsg;
	}

}
