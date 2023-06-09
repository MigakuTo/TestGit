<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/lend.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>貸出画面</title>
</head>
<body>
	<div id="header">
		<h1 class="title">貸出画面</h1>
	</div>
	<br>
	<div class="message">${errorMessage}</div>
	<div class="content">
		<form class="for" method="post" action="LendServlet">
			<div class="inp">
				書籍番号：<input class="inp-box" type="text" name="bookNumber" required>
			</div>
			<br>
			<div class="inp">
				お名前：<input class="inp-box" type="text" name="borrower" required>
			</div>
			<br> <input class="subm" type="submit" value="決定">
		</form>
	</div>
	<div>
		<form id="back" method="get" action="MainServlet" class="box">
			<button class="button-back" type="submit">メニューへ戻る</button>
		</form>
	</div>
</body>
</html>