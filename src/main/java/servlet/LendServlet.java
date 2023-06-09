package servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.LendDao;
import model.LendModel;

/**
 * Servlet implementation class LendServlet
 */
@WebServlet("/LendServlet")
public class LendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("jsp/lend.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String bookNumber = request.getParameter("bookNumber");
		String borrower = request.getParameter("borrower");
		
		request.setAttribute("errorMessage","入力情報が間違っています");

		if (cheak(bookNumber)) {
			//成功
			String url = lend(bookNumber,borrower);
			request.getRequestDispatcher(url).forward(request, response);
		}else {
			//失敗
			request.getRequestDispatcher("jsp/lend.jsp").forward(request, response);
		}
		
	}
	/**
	 * 貸出するメソッド
	 * 
	 */
	public String lend(String bookNumber,String borrower) {
		LendModel lend = new LendModel();
		LendDao ld = new LendDao();
		//貸出番号取得
		int lendNumber = getNewLendNumber();
		//タイムスタンプ取得
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		lend.setLendNumber(lendNumber);
		lend.setBookNumber(bookNumber);
		lend.setBorrower(borrower);
		lend.setStartDate(timestamp);
		
		boolean flag = ld.insertLend(lend);
		String url = "jsp/lend.jsp";
		if(flag) {
			url = "jsp/main.jsp";
		}
		
		return url;
	}

	/**
	 * 貸出番号を取得するメソッド
	 * 
	 */
	public int getNewLendNumber() {
		int newNumber = 0;
		LendDao ld = new LendDao();
		newNumber = ld.getMaxNumber() + 1;
		return newNumber;
	}
	
	/**
	 * 書籍が存在するか確認するメソッド
	 * 
	 */
	public boolean cheak(String bookNumber) {
		Boolean result = false;
		BookDao bd = new BookDao();

		if (bd.cheakBook(bookNumber) != 0) {
			result = true;
		}

		return result;
	}
}
