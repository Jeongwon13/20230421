package board.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import board.service.BoardService;
import board.vo.Board;

@WebServlet("/board/boardList")
public class BoardListServlet extends HttpServlet implements Serializable{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/board/boardList.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			BoardService service = new BoardService();
			
			List<Board> list = service.selectAll();
			
			HttpSession session = req.getSession();
			
			session.setAttribute("list", list);
			
			//req.getRequestDispatcher(req.getContextPath() + "/board/boardList").forward(req, resp);
			
			new Gson().toJson(list, resp.getWriter());
			//resp.sendRedirect(req.getContextPath()+ "/board/boardList");
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}




