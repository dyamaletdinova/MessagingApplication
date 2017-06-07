 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" 	href="<c:url value="/resource/css/style.css" />" >
<title>Users</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
			<div class="text-right"><h2 >${tagline}</h2></div>
						<img src="<spring:url value="/resource/images/logo3.jpg"  htmlEscape="true" />" alt="Logo"  />
		<h3> Our Trolls</h3>  
				<button class="btn btn-default pull-right" type=button onclick=window.location.href="<spring:url value="/welcome" />">Home</button>
			<a href="<spring:url value="/users/add" />" class="btn btn-default btn-mini pull-right">Add a new one</a>
			</div>
 
 		 	
		</div>
	</section>

	<section class="container">
		<div class="row">
 				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
 						<div class="caption">
							<h3>First Name - ${user.firstName}</h3>
							<h3>Last Name -  ${user.lastName}</h3>
							<p>Email -         ${user.email}</p>
 
						</div>
					</div>
				</div>
 
		</div>
	</section>
</body>
</html>
