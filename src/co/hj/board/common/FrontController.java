package co.hj.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.web.boardDelete;
import co.hj.board.web.boardEditFail;
import co.hj.board.web.boardEditForm;
import co.hj.board.web.boardEditSave;
import co.hj.board.web.boardInsert;
import co.hj.board.web.boardInsertForm;
import co.hj.board.web.boardInsertSuccess;
import co.hj.board.web.boardList;
import co.hj.board.web.boardView;
import co.hj.board.web.mainCommand;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController() {
        super();

    }


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map.put("/main.do", new mainCommand());
		map.put("/boardList.do", new boardList()); //게시판 리스트 가져옴
		map.put("/boardView.do", new boardView()); //게시글 상세보기
		map.put("/boardInsertForm.do", new boardInsertForm()); //새글쓰기
		map.put("/boardInsert.do", new boardInsert()); // 새글쓴 후 등록
		map.put("/boardInsertSuccess.do", new boardInsertSuccess());// 새글 정상 등록
		map.put("/boardEditForm.do", new boardEditForm()); //수정하기
		map.put("/boardEditSave.do", new boardEditSave()); // 수정 후 등록		
		map.put("/boardDelete.do", new boardDelete()); // 삭제
		map.put("/boardEditFail.do", new boardEditFail()); //삭제실패
	}

	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String contexPath = request.getContextPath();
		String uri=request.getRequestURI();
		String path =uri.substring(contexPath.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" +viewPage +  ".jsp";
						//viewpage가 .do가 아니면 jsp로 열어라
	//	if(viewPage.endsWith(".jsp")) viewPage = "/WEB-INF/jsp/" + viewPage;		// view resolve? 
						//뷰 페이지에서 endsWith가 ~.jsp로 끝나면 뷰페이지 앞에 "/WEB-INF/jsp/" 붙여주기 ==> jsp를 web-inf 밑에할때만!
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
