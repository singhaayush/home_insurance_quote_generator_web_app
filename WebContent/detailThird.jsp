<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import=" org.hibernate.Session"%>
<%@page import="com.model.User"%>
<%@page import="com.model.PropertyDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:blue"><center>Property Details</center></h1>
<form action="quoteDetails.jsp">
<label for="dwellingStyle">Dwelling Style:</label>
<select name="dwellingStyle" >
			 <option>1 story</option>
			 <option>1.5 story</option>
			 <option>2 story</option>
			 <option>2.5 story</option>
			 <option>3 story</option>
			 
		 </select><br/>
<label for="marketValue">market Value</label>
<input type="text" name="marketValue" value="<%="$"%>"><br/>
<label for="yearOfOrigin">year when house was build </label>
<input type="text" name="yearOfOrigin"><br/>
<label for=" squareFootage">Square foot</label>
<input type="number" name="squareFootage" >
<label for="roofMaterial">Roof material</label>
<select name="roofMaterial" >
			 <option>Concrete</option>
			 <option>Clay</option>
			 <option>Rubber</option>
			  <option>Steel</option>
			 <option>Tin</option>
			 <option>Wood</option>
			
		 </select><br/>
		 <label for="typeOfGarage">Type of garage</label>
		 <select name="typeOfGarage" >
			 <option>Attached</option>
			 <option>Detached</option>
			 <option>Basement</option>
			  <option>None</option>
			
		 </select><br/>
		  <label for="numberFullBath">Number of full bath</label>
		 <select name="numberFullBath" >
			 <option>1</option>
			 <option>2</option>
			 <option>3</option>
			  <option>more</option>
			
		 </select><br/>
		   <label for="numberHalfBath">Number of half bath</label>
		 <select name="numberHalfBath" >
			 <option>1</option>
			 <option>2</option>
			 <option>3</option>
			  <option>more</option>
			
		 </select><br/>
		 <label for="swimmingPoolAvailability;">Do you have a swimming pool?</label>
		 Yes:<input type="radio" name="swimmingPoolAvailability" value="yes">
         No:<input type="radio" name="swimmingPoolAvailability" value="no"><br/>
		 
<input type="submit" name=thirdDetail value="next">
</form>

<%
if(request.getParameter("thirdDetail")!=null)
{
	%>
           <jsp:useBean id="property" class="com.model.PropertyDetail" scope="session"></jsp:useBean>
                  <jsp:setProperty property="*" name="property"/>
                 
                <%  
                 
                PropertyDetail obj=(PropertyDetail)session.getAttribute("property");
                obj.setApplicant((User)session.getAttribute("user"));
                try
                {
                    Configuration configuration=new Configuration().configure()
                    		.addAnnotatedClass(PropertyDetail.class);
                    StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                    SessionFactory factory=configuration.buildSessionFactory(builder.build());
                    Session ses=factory.openSession();
                    Transaction transaction=ses.beginTransaction();
                    ses.save(session.getAttribute("property"));
                   // ses.save(session.getAttribute("user"));
                    transaction.commit();
            		ses.close();
            		
            		factory.close();
            		 out.print(obj);
            		
            		
                }
                catch(Exception e)
                {
                	out.print("<span style='color:red'>"+e.getMessage()+"</span>");
                	%> 
                	<jsp:include page="detailThird.jsp"></jsp:include>
                	<%
                }
               
  
}

%>
</body>
</html>