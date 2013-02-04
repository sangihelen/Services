<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Climate Details</title>
</head>
<body>

	<table align="center">
	</br></br></br>
	<h2> Climate Details</h2>
	<tr><td>City :</td><td>
	 <c:out value="${displayLocation.city}" /></td></tr>
	 <tr><td>State :</td><td>
	 <c:out value="${displayLocation.state}" /></td></tr>
	 <tr><td>Country :</td><td>
	 <c:out value="${displayLocation.country}" /></td></tr>
	 <tr><td>ZipCode :</td><td>
	 <c:out value="${displayLocation.zipCode}" /></td></tr>
	 <tr><td>Temp F :</td><td>
	 <c:out value="${displayLocation.temp_f}" /></td></tr>
	 <tr><td>Temp C :</td><td>
	 <c:out value="${displayLocation.temp_c}" /></td></tr>
	 
	</table>

<li><a href="climateform.check">Back to  Zip Code Screen</a></li>


</body>
</html>