<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script src="/WEB-INF/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <link href="/WEB-INF/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/WEB_INF/bootstrap-3.3.7/css/bootstrap-theme.min.css" rel="stylesheet" /> -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Products</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>All the available products in our store</p>

			</div>

		</div>
	</section>

	<section class="container">
		<div class="row">

			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
						<img src="<c:url value="/img/${product.productId}.jpg"> </c:url>" alt="image" style = "width:100%;height:150px; margin-bottom:15px"/>
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p>$${product.unitPrice}</p>
							<p>Available ${product.unitsInStock} units in stock</p>
							
							
							<p>
								<a
									href=" <spring:url value="/market/product?id=${product.productId}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

	</section>
</body>
</html>

