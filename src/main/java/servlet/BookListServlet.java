package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import model.BookModel;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BookModel> list = getList(); 
		System.out.println("到達");
		request.setAttribute("list", list);
		System.out.println(list);
		request.getRequestDispatcher("jsp/bookList.jsp").forward(request, response);
	}
	
	/**
	 * 書籍リストを取得するメソッド
	 * 
	 */
	public ArrayList<BookModel> getList() {
		BookDao bd = new BookDao();
		ArrayList<BookModel> list = bd.getBookList();
		
		return list;
	}

}
