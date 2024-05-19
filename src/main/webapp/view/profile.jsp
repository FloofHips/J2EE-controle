<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit profile</title>
<link href="webjars/bootstrap/4.6.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="webjars/font-awesome/4.7.0/css/font-awesome.css"
	rel="stylesheet">
<link href="webjars/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="webjars/font-awesome/4.7.0/css/font-awesome.min-jsf.css"
	rel="stylesheet">
<link href="webjars/font-awesome/4.7.0/css/font-awesome-jsf.css"
	rel="stylesheet">
<link href="webjars/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet">
<link href="webjars/ionicons/2.0.1/css/ionicons.css" rel="stylesheet">
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="common/header.jsp"%>
	<div class="container">
		<h2>Profile</h2>
		<h3>${sessionScope.username}</h3>
		<form action="${pageContext.request.contextPath}/profile.do" method="post">
            <div class="form-group">
                <label for="currentPassword">Current Password</label>
                <input type="password" class="form-control" id="currentPassword" name="currentPassword" required>
            </div>
            <div class="form-group">
                <label for="newPassword">New Password</label>
                <input type="password" class="form-control" id="newPassword" name="newPassword" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm New Password</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
            </div>
            <button type="submit" class="btn btn-primary">Update Password</button>
        </form>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger mt-3">${errorMessage}</div>
        </c:if>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success mt-3">${successMessage}</div>
        </c:if>
	</div>
	<%@include file="common/footer.jsp"%>
</body>
</html>
