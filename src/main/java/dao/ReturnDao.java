package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.LendModel;

public class ReturnDao {
	private Connection con = null; // コネクションオブジェクト
	private PreparedStatement stmt = null; // ステートメントオブジェクト
	private Connect cm; // コネクションマネージャー

	private final String UPDATE_RETURN = "UPDATE lend SET RerurnDate = ? WHERE lend.BookNumber = ? AND lend.Borrower = ? AND lend.RerurnDate IS NULL";

	// Connectionの取得
	private void getConnection() throws DAOException {
		if (this.con != null) {
			return;
		}
		cm = new Connect();
		con = cm.getConnection(); // データベースへの接続の取得
	}

	/**
	 * 返却日を格納するメソッド
	 * 
	 */
	public boolean returnBook(LendModel lend) {
		boolean flag = false;
		try {
			getConnection();
			stmt = con.prepareStatement(UPDATE_RETURN);
			
			stmt.setTimestamp(1, lend.getRerurnDate());
			stmt.setString(2, lend.getBookNumber());
			stmt.setString(3, lend.getBorrower());
			
			int rs = stmt.executeUpdate();
			if (rs == 1) {
				System.out.println("返却成功");
				flag = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
