<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
	
	<!-- Hero Section (메인 화면) -->
    <section class="hero">
        <img src="${pageContext.request.contextPath}/images/welcome.png" alt="Welcome" class="welcome-image">
    </section>
<!-- 
    <h1>Welcome to Spring MVC</h1>
    <p>${message}</p>
-->
</body>
</html>