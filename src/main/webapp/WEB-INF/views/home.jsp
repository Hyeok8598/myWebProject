<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC</title>
</head>
<body>
    <h1>Welcome to Spring MVC</h1>
    <p>${message}</p>
    
    <a href="${ pageContext.request.contextPath }/nonexistent-page">404 페이지 테스트</a>
    <a href="${ pageContext.request.contextPath }/login">로그인</a>
</body>
</html>