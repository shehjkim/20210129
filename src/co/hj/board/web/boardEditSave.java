package co.hj.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Command;
import co.hj.board.dao.BoardDAO;
import co.hj.board.vo.BoardVO;

public class boardEditSave implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setbId(Integer.parseInt(request.getParameter("bId")));
		vo.setbContent(request.getParameter("bContent"));
		
		String viewPage="boardList.do";		
		int n = dao.update(vo);
			
		if(n == 0) viewPage = "board/boardEditFail";
				
		return viewPage;
	}

}
