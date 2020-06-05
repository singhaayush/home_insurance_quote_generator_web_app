<%@page import="exception.BusinessException"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.model.Quote"%>
<%@page import="java.util.List"%>
<%@page import="dao.LoginDao"%>
<%@page import="com.model.User"%>
<%@page import="com.model.PropertyDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import=" org.hibernate.Session"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>admin</h1>

<%
try
{   
	out.print("<center><Table style='border-style:solid'><tr><th>pid</th>><th>email</th><th>market value</th><th>Year of Origin</th><th>Square foot area </th><th>dwelling Style</th><tr>"+new LoginDao().getAllPropertiesByEmail()+"</tr></Table></center>");
  out.print("<center><Table style='border-style:solid'><tr><th>Quoteid</th><th>monthlyPremium</th><th>dwellingCoverage</th><th>email id </th><th>detachedStructures</th><th>personalProperty</th><th>medicalExpense </th></tr><tr>"+new LoginDao().getAllQuotesByEmail()+"</tr></Table></center>");

	
}
catch(Exception e)
{
	
}
%>
</body>
</html>