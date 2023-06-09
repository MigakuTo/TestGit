package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.LendModel;

public class LendDao {
	private Connection con = null; // コネクションオブジェクト
	private PreparedStatement stmt = null; // ステートメントオブジェクト
	private Connect cm; // コネクションマネージャー

	private final String LEND_LIST = "SELECT * FROM Lend";
	private final String SELECT_MAXNUM = "SELECT MAX(LendNumber) FROM Lend";
	private final String INSERT_LEND = "INSERT INTO lend(LendNumber,BookNumber,Borrower,StartDate)VALUES(?,?,?,?)";

	// Connectionの取得
		private void getConnection() throws DAOException {
			if (this.con != null) {
				return;
			}
			cm = new Connect();
			con = cm.getConnection(); // データベースへの接続の取得
		}
	
	/**
	 * 貸出リストを取得するメソッド
	 * 
	 */
	public ArrayList<LendModel> getLendList() {

		ArrayList<LendModel> list = new ArrayList<>();
		try {
			getConnection();
			stmt = con.prepareStatement(LEND_LIST);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				LendModel lend = setLend(rs);
				list.add(lend);
			}

			con.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 最新の貸出番号を取得するメソッド
	 * 
	 */
	public int getMaxNumber() {
		int num = 0;
		try {
			getConnection();
			stmt = con.prepareStatement(SELECT_MAXNUM);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			num = rs.getInt("MAX(LendNumber)");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;
	}

	/**
	 * 貸出率とに追加するメソッド
	 * 
	 */
	public boolean insertLend(LendModel lend) {
		boolean flag = false;
		try {
			getConnection();
			stmt = con.prepareStatement(INSERT_LEND);

			stmt.setInt(1, lend.getLendNumber());
			stmt.setString(2, lend.getBookNumber());
			stmt.setString(3, lend.getBorrower());
			stmt.setTimestamp(4, lend.getStartDate());

			int rs = stmt.executeUpdate();
			if (rs == 1) {
				System.out.println("追加成功");
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * SQLでとってきた値をLendModel型に変換するメソッド
	 * 
	 */
	public LendModel setLend(ResultSet rs) throws SQLException {
    	LendModel lend = new LendModel();
    	
    	lend.setLendNumber(rs.getInt("LendNumber"));
    	lend.setBookNumber(rs.getString("BookNumber"));
    	lend.setBorrower(rs.getString("Borrower"));
    	lend.setStartDate(rs.getTimestamp("StartDate"));
    	lend.setRerurnDate(rs.getTimestamp("RerurnDate"));
		
    	return lend;
    }
}
