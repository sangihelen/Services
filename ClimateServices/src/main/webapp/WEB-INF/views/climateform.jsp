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




<table align="center">
<tr><td>
<h1>
	Enter the ZipCode details to get the Climate Details!
</h1>
</td></tr>
<tr><td>
<form:form action="zipcode.check" commandName="climateService" method="post">
<form:errors path="*" cssClass="error" element="div" />
Zip Code : <form:input path="zipcode" /><input type="submit" value="getClimateDetails" />


</form:form> 
</td></tr></table>
</body>
</html>
