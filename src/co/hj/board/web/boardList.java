package co.hj.board.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Command;
import co.hj.board.dao.BoardDAO;
import co.hj.board.vo.BoardVO;

public class boardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시판 리스트가져옴
		
		BoardDAO dao = new BoardDAO();
		
		ArrayList <BoardVO> list = new ArrayList<BoardVO>();
		
		list = dao.selectList();
		
		request.setAttribute("list", list);
		
		return "board/boardList";
	}

}
