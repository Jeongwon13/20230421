package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;

@WebServlet("/board/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 int boardNo = Integer.parseInt(req.getParameter("num"));
		 
		 try {
			 BoardService service = new BoardService();
			 
			 int result = service.deleteBoard(boardNo);
			 
			 HttpSession session = req.getSession();
			 
			 session.setAttribute("result", result);
			 
			 resp.sendRedirect("boardList");
			 
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
	 
	 }
 
		
	 
}
