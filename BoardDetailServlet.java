package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.service.BoardService;
import board.vo.Board;

@WebServlet("/board/boardDetail")
public class BoardDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
		//System.out.println("doget loaded"); 
		try {
			int boardNo = Integer.parseInt(req.getParameter("num"));
			
			 
			
			BoardService service = new BoardService();
			Board detail = service.selectOne(boardNo);
		 
			req.setAttribute("detail", detail);
			
			//new Gson().toJson(detail, resp.getWriter());
			 
			//RequestDispatcher rd = req.getRequestDispatcher(req.getContextPath()+"board/boardDetail");
			//rd.forward(req, resp);
 		
			//resp.sendRedirect(req.getContextPath()+"/board/boardDetail");
			String path = "/WEB-INF/views/board/boardDetail.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
 
}
	
	
	

