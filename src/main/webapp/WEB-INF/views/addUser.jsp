<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" 	href="<c:url value="/resource/css/style.css" />" >
<title>Messanger</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
			<div class="text-right"><h2 >${tagline}</h2></div>
				<img src="<spring:url value="/resource/images/logo3.jpg"  htmlEscape="true" />" alt="Logo"  />
				<p><button class="btn btn-default pull-right" type=button onclick=window.location.href="<spring:url value="/welcome" />">Home</button></p>
			</div>
		</div>
	</section>
	<br/><br/><br/>
	<div class="container">
	
		<form:form  modelAttribute="newUser" class="well form-horizontal"  >
			<fieldset>
				<legend><center><h2><b>Become a Troll</b></h2></center></legend><br>

				<!--<form:errors path="*" cssClass="alert alert-danger" element="div"/>-->

				<div class="form-group">
					<label class="col-md-4 control-label" for="firstName">First Name</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
							<form:input id="firstName" path="firstName" type="text" class="form-control" />
							<form:errors path="firstName" cssClass="text-danger" />
						</div>
					</div>
				</div>


				<div class="form-group">
					<label class="col-md-4 control-label" for="lastName">Last Name</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							<form:input id="lastName" path="lastName" type="text"
								class="form-control" />
							<form:errors path="lastName" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="age">Email</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
							<form:input id="email" path="email" type="text"
								class="form-control" />
							<form:errors path="email" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="userName">Troll Name</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
						<div class="form:input-prepend">
							<form:input id="userName" path="userCredentials.userName" type="text" class="form-control"/>
							<form:errors path="userCredentials.userName" cssClass="text-danger"/>
						</div>
						</div>
					</div>
				</div>
	
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Password</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
						<div class="form:input-prepend">
							<form:password id="password" path="userCredentials.password"  class="form-control"/>
							<form:errors path="userCredentials.password" cssClass="text-danger"/>
						</div>
					</div>
				</div>
				</div>
	
					<div class="form-group">
					<label class="col-md-4 control-label" for="authority">Role</label>
					<div class="col-md-4 inputGroupContainer">
					
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span>
							 <form:select class="form-control" path="userCredentials.authority[0].authority" id="sel1">
								<form:option value="ROLE_USER" >User</form:option>
								<form:option value="ROLE_ADMIN" >Admin</form:option>
								<form:option value="ROLE_READ" >Guest</form:option>
							</form:select>
						</div>
					
					
					
						<br/>
						
					</div>
				</div>
 
 				<form:hidden path="userCredentials.enabled" value="TRUE"  />
 

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</div>
</body>
</html>
