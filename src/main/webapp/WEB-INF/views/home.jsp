<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    
    <!-- JavaScript 연결 -->
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
	
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<!-- 네비게이션 바 -->
	<nav class="navbar">
		<div class="logo">
			<a href="home.jsp">myWeb</a>
		</div>
		
		<div>
			<a href="login.jsp">Login</a>
			<a href="singup.jsp" class="sign-btn">Sign-up</a>
		</div>
	</nav>
	
	<!-- 왼쪽 사이드 토글 메뉴바 -->
	<div class="sliderbar">
		<div class="toggle-header" onmouseenter="showMenu()" onmouseleave="hideMenu()">📂 Menu</div>
		<ul id="submenu" class="hidden">
			<li><a href="#">자유게시판</a></li>
			<li><a href="#">공지</a></li>
		</ul>
	</div>
	
	<!-- Hero Section (메인 화면) -->
    <section class="hero">
        <img src="${pageContext.request.contextPath}/images/welcome.png" alt="Welcome" class="welcome-image">
    </section>

    <h1>Welcome to Spring MVC</h1>
    <p>${message}</p>
    
    <a href="${ pageContext.request.contextPath }/nonexistent-page">404 페이지 테스트</a>
    <a href="${ pageContext.request.contextPath }/login">로그인</a>
	
	<script>
		function showMenu() {
			document.getElementById('submenu').classList.remove('hidden');
		}
		
		function hideMenu() {
			document.getElementById('submenu').classList.add('hidden');
		}
	</script>
</body>
</html>