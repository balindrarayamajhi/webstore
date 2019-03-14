<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Products</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger">There is no product found with
					the Product id ${invalidProductId}</h1>

			</div>

		</div>
	</section>

	<section>

		<div class="container">
			<p>${url}</p>
			<p>${exception}</p>
		</div>

		<div class="container">
			<p>
				<a href="<spring:url value="/market/products" />"
					class="btn btn-primary"> <span
					class="glyphicon-hand-left glyphicon"> </span> products
				</a>
			</p>

		</div>

	</section>
</body>

</html>