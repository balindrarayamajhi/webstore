<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 
<title>Customers</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Customers</h1>
				<p>Add customers</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form method="POST" modelAttribute="newCustomer" class="form-horizontal">
			<fieldset>
				<legend>Add new product</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="customerId">CustomerId</label>
					<div class="col-lg-10">
						<form:input id="customerId" path="customerId" type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large" />
					</div>
				</div>
				
				 <div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="Address">Address</label>
					<div class="col-lg-10">
						<form:textarea id="address" path="address" rows="2" />
					</div>
				</div>
				
				 
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" />
					</div>
				</div>
			</fieldset>


		</form:form>
	</section>
</body>
</html>