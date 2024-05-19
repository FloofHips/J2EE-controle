<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Add item</title>
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
		<h2>Add New Article</h2>
		<form action="${pageContext.request.contextPath}/addarticle.do"
			method="POST">
			<div class="form-group">
				<label for="description">Description:</label> <input type="text"
					class="form-control" id="description" name="description" value="${article.description}" required>
			</div>
			<div class="form-group">
				<label for="quantite">Quantité:</label> <input type="number"
					class="form-control" id="quantite" name="quantite" value="${article.quantite}" required>
			</div>
			<div class="form-group">
				<label for="price">Prix:</label> <input type="number"
					class="form-control" id="price" name="price" step="0.01" value="${article.price}" required>
			</div>
			<button type="submit" class="btn btn-primary">Add</button>
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