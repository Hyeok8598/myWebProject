<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="${ pageContext.request.contextPath }/login" method="post">
		이메일: <input type="email" name="email" required><br>
		비밀번호: <input type="password" name="password" required><br>
		<button type="submit">로그인</button>
	</form>
</body> 
</html>