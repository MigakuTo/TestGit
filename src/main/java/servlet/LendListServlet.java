package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LendDao;
import model.LendModel;

/**
 * Servlet implementation class LendListServlet
 */
@WebServlet("/LendListServlet")
public class LendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<LendModel> list = getList(); 
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("jsp/lendList.jsp").forward(request, response);
	}
	
	/**
	 * 貸出リストを取得するメソッド
	 * 
	 */
	public ArrayList<LendModel> getList() {
		LendDao ld = new LendDao();
		ArrayList<LendModel> list = ld.getLendList();
		
		return list;
	}

}
