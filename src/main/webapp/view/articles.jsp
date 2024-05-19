<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<div class="container">
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Actions</th>
				<th scope="col">Id</th>
				<th scope="col">Description</th>
				<th scope="col">Quantité</th>
				<th scope="col">Prix</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${articles}" var="article">
				<tr>
					<th><a
						href="${pageContext.request.contextPath}/editArticle.do?id=${article.id}"
						class="btn btn-primary btn-sm"> <i class="fas fa-pen"></i>
					</a> <a href="#" onclick="confirmDelete(${article.id})"
						class="btn btn-danger btn-sm"> <i class="fas fa-trash"></i>
					</a></th>
					<th scope="row">${article.id}</th>
					<td>${article.description}</td>
					<td>${article.quantite}</td>
					<td>${article.price}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="text-center">
		<a href="${pageContext.request.contextPath}/addarticle.do"
			class="btn btn-success">New Article +</a>
	</div>
</div>

<script>
    function confirmDelete(articleId) {
        if (confirm('Are you sure you want to delete this article?')) {
            window.location.href = "${pageContext.request.contextPath}/deleteArticle.do?id=" + articleId;
        }
    }
</script>