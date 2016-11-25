<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title id="title">Login</title>
</head>

<form method="POST" action="LoginAdminServlet" >
<center>
<hr>
会議室予約システム　管理者サイト
<hr>
<table>
<tr>
<td>ログイン名</td>
<td><input type="text" Name="LoginName" /></td>
</tr>
<tr>
<td>パスワード</td>
<td><input type="pass" name="PassWord" /></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="ログイン" />
</td>
</tr>
</table>
</form>
<hr>
<font size="4">&copy;</font> H28 Software Enginnering All Right Reserved.
<hr>
</center>

<body>
</body>
</html>