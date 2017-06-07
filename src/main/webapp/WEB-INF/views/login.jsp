<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
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
			</div>
		</div>
	</section>
	
<div class="container">
    <div class="row">
    <br/><br/><br/><br/>
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h2 class="form-signin-heading">Please sign in</h2>
			 	</div>
			 	
			  	<div class="panel-body">
			  	<c:if test="${not empty error}">
					<div class="alert alert-danger">
						<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
					</div>
				</c:if>
				<div class="col-xs-4 col-xs-offset-4">
			    	<form action="<spring:url value="/postLogin"></spring:url>" method="post" class="form-signin">
  					<sec:csrfInput />
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="User Name" name='userName' type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Password" name='password'  type="password" value="">
			    		</div>
			    		
			    		<input class="btn btn-lg btn-primary btn-block" type="submit" value="Login">
			    	</fieldset>
			      	</form>
			      	</div>
			    </div>
			</div>
		</div>
	</div>
</div>
</body>
