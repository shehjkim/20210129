package co.hj.board.web;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Command;
import co.hj.board.dao.BoardDAO;
import co.hj.board.vo.BoardVO;

public class boardInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbName(request.getParameter("bName"));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		
		int n = dao.insert(vo);
		String viewPage = null;
	
		
		if( n !=0 ) {
			String message="입력한 내용이 정상 등록되었습니다. ";
			request.setAttribute("mag", message);
			viewPage = "board/boardInsertSuccess";
		}else {
			String message="입력한 내용이 DB에 저장하지 못하였습니다. ";
			request.setAttribute("mag", message);
			viewPage = "board/boardInsertFail";
		}
		
		return viewPage;
	}

}
