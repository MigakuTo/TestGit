<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/menu.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
	<div id="header">
		<h1 class="title">メニュー画面</h1>
	</div>

	<div class="flex menu">
		<form method="get" action="BookListServlet" class="box">
			<button class="button" type="submit">一覧表示</button>
		</form>
		<form method="get" action="LendServlet" class="box">
			<button class="button" type="submit">貸出</button>
		</form>
		<form method="get" action="ReturnServlet" class="box">
			<button class="button" type="submit">返却</button>
		</form>
	</div>

</body>
</html>