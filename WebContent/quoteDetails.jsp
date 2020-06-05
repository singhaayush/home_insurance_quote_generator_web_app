<%@page import="com.model.Quote"%>
<%@page import="com.model.User"%>
<%@page import="com.model.PropertyDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import=" org.hibernate.Session"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:green">Quote is generated as..</h1>

<%
if(request.getParameter("thirdDetail")!=null)
{	
%>
<jsp:useBean id="property" class="com.model.PropertyDetail" scope="session"></jsp:useBean>
       <jsp:setProperty property="*" name="property"/>
      
     <%  
     PropertyDetail prop=(PropertyDetail) session.getAttribute("property");
     User user=(User)session.getAttribute("user");
try
{  out.print("enterd try");
   prop.setEmail(user.getEmail());
   Quote quote=new Quote();
   float marketValue=Float.parseFloat(prop.getMarketValue().substring(1));
   String residenceType=user.getResidenceType();
   float monthlyPremium=(5*marketValue)/1000;
   if(residenceType.equals("family home"))
   {
	   monthlyPremium+=0.005*monthlyPremium;
   }
   else  if(residenceType.equals("condo")||residenceType.equals("Duplex")||residenceType.equals("Apartment"))
   {
	   monthlyPremium+=0.0006*monthlyPremium;
   }
   else 
   {
	   monthlyPremium+=0.0007*monthlyPremium;  
   }
   
   quote.setMonthlyPremium(Float.toString(monthlyPremium));
   
   //*****************************************************************
   float dwellingCoverage=Float.parseFloat(prop.getSquareFootage())*120;
   int year=Integer.parseInt(prop.getYearOfOrigin());
   if((2019-year)<5)
   {
	   dwellingCoverage= (float) (0.9*dwellingCoverage);
   }
   else
	   if((2019-year)<10)
	   {
		   dwellingCoverage= (float) (0.8*dwellingCoverage);
	   }
	   else if((2019-year)<20)
	   {
		   dwellingCoverage= (float) (0.7*dwellingCoverage);
	   }
	   else if((2019-year)>20)
	   {
		   dwellingCoverage= (float) (0.5*dwellingCoverage);
	   }
   dwellingCoverage+=0.5*marketValue;
 
  
   quote.setDwellingCoverage(Float.toString(dwellingCoverage));
   
   quote.setDetachedStructures(Float.toString((float) (dwellingCoverage*0.1)));
   quote.setPersonalProperty(Float.toString((float) (dwellingCoverage*0.6)));
   quote.setMedicalExpense("5000$");
   quote.setLivingExpense(Float.toString((float) (dwellingCoverage*0.6)));
   quote.setDeductible(Float.toString((float) (marketValue*0.01)));
   
	 out.print("<Table style='border-style:solid'><tr><th>Quoteid</th><th>monthlyPremium</th><th>dwellingCoverage</th><th>detachedStructures</th><th>personalProperty</th><th>medicalExpense </th></tr><tr>"+quote+"</tr></Table>");

   quote.setEmail(user.getEmail());
   out.print("*********************");
   
   
   //*******************************************************Quote Table creation here*******************
   
    Configuration configuration=new Configuration().configure()
                    		.addAnnotatedClass(Quote.class).addAnnotatedClass(PropertyDetail.class);
                    StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                    SessionFactory factory=configuration.buildSessionFactory(builder.build());
                    Session ses=factory.openSession();
                    Transaction transaction=ses.beginTransaction();
                    ses.save(quote);
                    ses.save(session.getAttribute("property"));
                    transaction.commit();
            		ses.close();
            		
            		factory.close();
            		
   
}
catch(Exception e)
{
	    
		 out.println(user);
		 out.println(prop);
		 out.println("<span style='color:red'>exception occured"+e.getMessage()+"</span>");

}

}
%>

</body>
</html>