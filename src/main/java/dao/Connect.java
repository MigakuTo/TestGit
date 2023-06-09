package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	// URL・ユーザ名・パスワードの設定
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/rezodb";
	private final static String USER = "rezouser";
	private final static String PASSWORD = "rezopass";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					URL // データベース
					, USER // ユーザ
					, PASSWORD // パスワード
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
}