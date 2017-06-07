<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resource/css/style.css" />">
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
<title>Welcome</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
			<div class="text-right"><h2 >${tagline}</h2></div>
				<img
					src="<spring:url value="/resource/images/logo3.jpg"  htmlEscape="true" />"
					alt="Logo" />
				<!-- <h1>${greeting}</h1> -->
				


			</div>

			<div class="container">
				<c:choose>
					<c:when test="${empty user}">
						<a href="<spring:url value='/login' />"
							class="btn btn-default pull-right"> Login</a>
					</c:when>
					<c:otherwise>
					<a href="<spring:url value='/logout' />"
							class="btn btn-default pull-right"> Logout</a>
						<c:choose>
							<c:when
								test="${user.userCredentials.authority[0].authority eq 'ROLE_ADMIN'}">
								<a href="<spring:url value="/users/add" />"
									class="btn btn-default pull-right">Add Trolls</a>								
							</c:when>
						</c:choose>
						
					</c:otherwise>
				</c:choose>
				<a href="<spring:url value='/users' />" class="btn btn-default pull-right">&nbsp;
					<span class="glyphicon-hand-left glyphicon"></span> Checkout trolls.
				</a>
			</div>
			<div class="pull-left">
				<h3>${SpecialBlurb}</h3>
			</div>

		</div>
		<c:choose>
			<c:when test="${!empty user}">

				<div class="span4 offset4">
					<br /> <br />
					<div id="wrapper">
						<div id="menu">
							<p class="welcome">
								Welcome, ${user.firstName}! <b></b>
							</p>
							<p class="logout">
								<a id="exit" href="<spring:url value='/logout' />">Exit Chat</a>
							</p>
							<div style="clear: both"></div>
						</div>
						<div id="chatbox">
				
									<c:forEach items="${messages}" var="m_message">
										<c:choose>
										<c:when test="${user.id == m_message.sender.id}">
											${user.firstName} @ ${m_message.receiver}:  ${m_message.message} <br/>
										</c:when>
										</c:choose>
										<c:otherwise>
											${m_message.sender} @ ${user.firstName}:   ${m_message.message} <br/>
										</c:otherwise>
									</c:forEach>
					
						</div>
						<form id="msgtext" name="message" modelAttribute="newMessage"
							action="<spring:url value="/sendMsgMq"></spring:url>" method="post"
							class="form-signin">
							<sec:csrfInput />
							<fieldset>
							
								<div class="form-group">
									<div class="checkbox">

										<c:forEach items="${users}" var="m_user">
											<c:choose>
												<c:when test="${user.id != m_user.id}">
													<label> <input name="receiverids" type="checkbox" data-id="${user.id}"
														value="${m_user.id}" />${m_user.firstName}
													</label><br>
													
												</c:when>
											</c:choose>
										</c:forEach>

									</div>
									
									<div class="form-group">
										<label for="InputMessage">Message</label>
										<div class="input-group">
											<!-- nput name="usermsg" type="text" id="usermsg" size="63" />
											<input name="message" type="text" class="form:input-large"/> -->
											<textarea name="message" class="form-control" style="margin: 0px; width: 892px; height: 54px;" required></textarea>
											<!-- <span class="input-group-addon"><i
											class="glyphicon glyphicon-ok form-control-feedback"></i></span>-->
										</div>
									</div>
								</div>
								<input type="hidden" name="sender.id" value="${user.id}" />

								<!--<form:hidden id="sender" path="${user.id}"/>		-->
								<input class="btn btn-lg btn-primary" name="submitmsg"
									type="submit" id="submitmsg" value="Send" /> <br />
								<br />
								<br />
							</fieldset>
						</form>

					</div>
					<br />
					<br />
					<br />
				</div>
			</c:when>
		</c:choose>
	</section>


</body>
</html>
