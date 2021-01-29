package co.hj.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.hj.board.common.Command;

public class boardInsertSuccess implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return"board/boardInsertSuccess";
	}

}
