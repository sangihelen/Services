<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<li><a href="forms/climateService.html">Climate Screen</a></li>

<form:form action="zipcode.check" commandName="climateService" method="post">
Zip Code : <form:input path="zipcode" />
<form:errors path="*" cssClass="errorblock" element="div" />
<input type="submit" value="getClimateDetails" />


</form:form> 
</body>
</html>
