package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;

@WebServlet("/board/editForm")
public class EditFormServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			int boardNo = Integer.parseInt(req.getParameter("num"));
			
			BoardService service = new BoardService();
			
			Board detail = service.selectOne(boardNo);
		 
			req.setAttribute("detail", detail);
			
			String path = "/WEB-INF/views/board/editForm.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Board bor = new Board();
		
		int boardNo = Integer.parseInt(req.getParameter("num"));
		String updateTitle = req.getParameter("updateTitle");
		String updateWriter = req.getParameter("updateWriter");
		String updateContent = req.getParameter("updateContent");
		
		
		bor.setNum(boardNo);
		bor.setTitle(updateTitle);
		bor.setWriter(updateWriter);
		bor.setContent(updateContent);
		
				
		try {
			BoardService service = new BoardService();
			
			int result = service.updateBoard(bor);
			
			HttpSession session = req.getSession();
			req.setAttribute("result", result);
		 
			resp.sendRedirect("boardList");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
