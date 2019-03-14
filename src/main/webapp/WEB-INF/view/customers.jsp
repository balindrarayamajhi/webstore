<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>customers</title>
</head>
<body>


<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Customers</h1>
			<p>All Listed Customers</p>
			</div>

		</div>
	</section>

	<section class="container">
		<div class="row">

			<c:forEach items="${customers}" var="customer">
				<div class="col-sm-4 col-md-3">
					<div class="thumbnail">
						<div class="caption">
							
							<h3>${customer.name}</h3>
							<p>${customer.address}</p>
							<p>Number of orders made :${customer.noOfOrdersMade}</p>
							
							
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

	</section>


</body>
</html>

