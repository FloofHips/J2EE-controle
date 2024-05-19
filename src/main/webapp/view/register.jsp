<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="authcontainer">
		<div class="wrapper fadeInDown">
			<div id="formContent">
				<div class="fadeIn first">
					<img src="${pageContext.request.contextPath}/static/images/register.PNG" id="icon" alt="User Icon" />
				</div>
				<p>
					<font color="red">${AccountExists}</font>
				</p>
				<!-- Register Form -->
				<form action="${pageContext.request.contextPath}/register.do" method="post">
					<input type="text" id="login" class="fadeIn second" name="username" placeholder="Username" required>
					<input type="text" id="password" class="fadeIn third" name="password" placeholder="Password" required>
					<input type="text" id="confirmpassword" class="fadeIn third" name="confirmpassword" placeholder="Confirm Password" required>
					<input type="submit" class="fadeIn fourth" value="Register">
				</form>
				<div id="formFooter">
					<a class="underlineHover" href="${pageContext.request.contextPath}/login.do">Already have an account?</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
