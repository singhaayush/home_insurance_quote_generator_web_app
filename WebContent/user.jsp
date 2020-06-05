<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <a href="detailFirst.jsp">create Quote</a><br/>
 <a href="retrieveQuote.jsp">Retrieve Quote</a><br/>
 <a href="detailFirst.jsp">Buy policy</a><br/>
 <%
 
 out.print(session.getAttribute("user")); 
 %>
</body>
</html>