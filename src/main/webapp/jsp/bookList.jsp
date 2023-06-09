<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,model.BookModel"%>
<%
ArrayList<BookModel> list = (ArrayList<BookModel>) request.getAttribute("list");
%>
<link rel="stylesheet" href="css/list.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧画面</title>
</head>
<body>
	<div id="header">
		<h1 class="title">書籍一覧</h1>
	</div>
	<div class="content">
		<table class="tabl">
			<th>書籍番号</th>
			<th>書籍タイトル</th>
			<th>ジャンル</th>
			<th>著者</th>
			<th>登録日</th>

			<%
			for (BookModel book : list) {
			%>
			<tr>
				<td><%=book.getBookNumber()%></td>
				<td><%=book.getTitle()%></td>
				<td><%=book.getGenre()%></td>
				<td><%=book.getAuthor()%></td>
				<td><%=book.getRegistration()%></td>
			</tr>
			<%
			}
			%>

		</table>
	</div>
	<div>
		<form id="change" method="get" action="LendListServlet" class="box">
			<button class="button-back" type="submit">貸出一覧へ</button>
		</form>
	</div>

	<div>
		<form id="back" method="get" action="MainServlet" class="box">
			<button class="button-back" type="submit">メニューへ戻る</button>
		</form>
	</div>

</body>
</html>