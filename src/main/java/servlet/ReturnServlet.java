package servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReturnDao;
import model.LendModel;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("jsp/return.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String bookNumber = request.getParameter("bookNumber");
		String borrower = request.getParameter("borrower");
		request.setAttribute("errorMessage","入力情報が間違っています");
		String url = returnBook(bookNumber,borrower);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	/**
	 * 返却するメソッド
	 * 
	 */
	public String returnBook(String bookNumber,String borrower) {
		LendModel lend = new LendModel();
		ReturnDao rd = new ReturnDao();
		
		lend.setRerurnDate(new Timestamp(System.currentTimeMillis()));
		lend.setBookNumber(bookNumber);
		lend.setBorrower(borrower);
		
		boolean flag = rd.returnBook(lend);
		String url = "jsp/return.jsp";
		if(flag) {
			url = "jsp/main.jsp";
		}
		
		return url;
	}
	

}
