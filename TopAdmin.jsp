<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ page import="model.User"%>
<%
	if (request.getAttribute("User") == null) {
		response.sendRedirect("LoginAdmin.jsp");
		return;
	}

	User user = (User) request.getAttribute("User");
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
会議室予約システム　管理者サイト
<hr>
<p>
ようこそ「<%=user.getName() %>」さん！！！
</p><p>
あなたは<font color="red">管理者</font>です。
</p>
<hr>
<font size="4">&copy;</font>H28 Software Enginnering All Right Reserved.
<hr>
</center>
</body>
</html>