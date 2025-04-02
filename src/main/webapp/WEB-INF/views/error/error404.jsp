<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>페이지를 찾을 수 없습니다</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; padding: 50px; }
        h1 { font-size: 50px; color: red; }
        p { font-size: 18px; }
        a { color: blue; text-decoration: none; }
    </style>
</head>
<body>
    <h1>404 Not Found</h1>
    <p>죄송합니다. 요청하신 페이지를 찾을 수 없습니다.</p>
    <a href="${ pageContext.request.contextPath }/">홈으로 이동</a>
</body>
</html>