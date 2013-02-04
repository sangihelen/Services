<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>


<title>Home</title>
</head>
<body>
<h1>
	Hello  GOOD MONRNING ! 
</h1>

<P>  The time on the server is <%=new Date()%>. </P>
<li><a href="climateform.check">Click Here to Check Climate by Zip Code</a></li>


</body>
</html>
