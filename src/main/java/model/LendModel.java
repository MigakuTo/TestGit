package model;

import java.sql.Timestamp;

public class LendModel {

	private int lendNumber;
	private String bookNumber;//書籍番号
	private String borrower;//貸出人
	private Timestamp startDate;//貸出日
	private Timestamp rerurnDate;//返却日
	
	public int getLendNumber() {
		return lendNumber;
	}
	public void setLendNumber(int lendNumber) {
		this.lendNumber = lendNumber;
	}
	public String getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBorrower() {
		return borrower;
	}
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getRerurnDate() {
		return rerurnDate;
	}
	public void setRerurnDate(Timestamp rerurnDate) {
		this.rerurnDate = rerurnDate;
	}
	
	
}