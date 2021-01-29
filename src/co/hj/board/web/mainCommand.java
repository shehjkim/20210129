package co.hj.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Command;

public class mainCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {	
		//홈화면 보여준다
		return "main/main";		//->	/WEB-INF/JSP/main/main.jsp로 호출
		//return "main/main.do"; //-> 	viewPagerk 
	}

}
