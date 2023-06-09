<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,model.LendModel"%>
<%
ArrayList<LendModel> list = (ArrayList<LendModel>) request.getAttribute("list");
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
		<h1 class="title">貸出一覧</h1>
	</div>
	<div class="content">
		<table class="tabl">
			<th>貸出番号</th>
			<th>書籍番号</th>
			<th>貸出人</th>
			<th>貸出日</th>
			<th>返却日</th>

			<%
			for (LendModel lend : list) {
			%>
			<tr>
				<td><%=lend.getLendNumber()%></td>
				<td><%=lend.getBookNumber()%></td>
				<td><%=lend.getBorrower()%></td>
				<td><%=lend.getStartDate()%></td>
				<%
				if(lend.getRerurnDate() != null){
				%>
				<td><%=lend.getRerurnDate()%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			%>

		</table>
	</div>
	<div>
		<form id="change" method="get" action="BookListServlet" class="box">
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