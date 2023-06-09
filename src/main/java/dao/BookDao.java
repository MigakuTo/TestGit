package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BookModel;

/**
 * @author user
 *
 */
public class BookDao {
	
	private Connection con = null;  // コネクションオブジェクト
    private PreparedStatement stmt = null;  // ステートメントオブジェクト
    private Connect cm; // コネクションマネージャー
 
    private final String BOOK_LIST = "SELECT * FROM Book";
    private final String CHEAK_BOOK = "SELECT * FROM Book WHERE book.BookNumber = ?";
    
    // Connectionの取得
    private void getConnection() throws DAOException{
        if ( this.con != null ){ return;    }
        cm = new Connect();
        con = cm.getConnection(); // データベースへの接続の取得
    }
    
    /**
	 * 書籍リストを取得するメソッド
	 * 
	 */
    public ArrayList<BookModel> getBookList(){
    	
    	ArrayList<BookModel> list = new ArrayList<>();
    	try{
    		getConnection();
    		stmt = con.prepareStatement(BOOK_LIST);
    		ResultSet rs = stmt.executeQuery();
    		
    		while(rs.next()) {
    			BookModel book = setBook(rs);
    			list.add(book);
    		}
    		
    		con.close();
    		stmt.close();
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return list;
    }
    
    /**
	 * 書籍が存在するか確認するメソッド
	 * 
	 */
    public int cheakBook(String bookNumber) {
    	int result = 1;
    	try {
    		getConnection();
    		stmt = con.prepareStatement(CHEAK_BOOK);
    		stmt.setString(1, bookNumber);
    		ResultSet rs = stmt.executeQuery();
    		
    		if(!rs.next()) {
    			result = 0;
    		}
		} catch (Exception e) {
			System.out.println(e);
		}
    	
		return result;
    }
    
    /**
	 * SQLでとってきた値をBookModel型に変換するメソッド
	 * 
	 */
    public BookModel setBook(ResultSet rs) throws SQLException {
    	BookModel book = new BookModel();
    	
    	book.setBookNumber(rs.getString("BookNumber"));
		book.setTitle(rs.getString("Title"));
		book.setGenre(rs.getString("Genre"));
		book.setAuthor(rs.getString("Author"));
		book.setRegistration(rs.getString("Registration"));
		
    	return book;
    }
}