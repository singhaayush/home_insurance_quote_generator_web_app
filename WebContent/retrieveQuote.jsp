<%@page import="exception.BusinessException"%>
<%@page import="org.hibernate.query.Query"%>
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
<%
try
{
	LoginDao obj=new LoginDao();
	
	String email=((User)session.getAttribute("user")).getEmail();
	          List<Quote> quote=obj.getQuoteByEmail(email);
	          System.out.print(quote.size());
		
		for(Quote q:quote)
		{
		 out.print("<center><Table style='border-style:solid'><tr><th>Quoteid</th><th>monthlyPremium</th><th>dwellingCoverage</th><th>detachedStructures</th><th>personalProperty</th><th>medicalExpense </th></tr><tr>"+q+"</tr></Table></center>");
		}
		
//=120.084$ =213600.0$ =21360.0$ =128160.0$$$   
}
catch(Exception e)
{
	out.print("nothing to show"+e.getMessage());
}


%>
</body>
</html>