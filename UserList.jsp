<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="model.User"%>
<%@ page import="java.util.LinkedList"%>
<%
	if (request.getAttribute("Users") == null) {
		response.sendRedirect("Login.jsp");
		return;
	}

	LinkedList<User> users = (LinkedList<User>) request.getAttribute("Users");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title id="title">Top</title>
</head>
<body>
<center>
<hr>
会議室予約システム　管理者サイト
<hr>

<p>
あなたは<font color="red">管理者</font>です。
</p>

<p>
ユーザー一覧
</p>

<table border=1>
<tr>
<td>ユーザ名</td>
<td>Email</td>
<td>ユーザタイプ</td>
</tr>
<% for(User user :users){ %>
<tr>
<td><%= user.getName() %></td>
<td><%= user.getEmail() %></td>
<td><% if(user.getUserType()==1) out.println("管理者"); %></td>
</tr>
<% } %>
</table>
</form>


<hr>
<font size="4">&copy;</font>H28 Software Enginnering All Right Reserved.
<hr>
</center>
</body>
</html>