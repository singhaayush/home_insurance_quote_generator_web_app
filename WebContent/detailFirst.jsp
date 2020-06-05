<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:blue"><center>Location Details</center></h1>
<form action="">
<label for="residenceType">Residence Type:</label>
<select name="residenceType" >
			 <option>family home</option>
			 <option>condo</option>
			 <option>Town house</option>
			 <option>Row house</option>
			 <option>Duplex</option>
			 <option>Apartment</option>
		 </select><br/>
<label for="adress">Adrees Line 1</label>
<input type="text" name="adress"><br/>
<label for="city">City</label>
<input type="text" name="city"><br/>
<label for="zip">Pin Code</label>
<input type="number" name="zip"></br>
<label for="residenceUse">Residence Type:</label>
<select name="residenceUse" >
			 <option>Primary</option>
			 <option>Secondary</option>
			 <option>Rental</option>
			
		 </select><br/>
		 
<input type="submit" name=firstDetail value="next">
</form>
<%
if(request.getParameter("firstDetail")!=null)
{
	%>
   <jsp:useBean id="user" class="com.model.User" scope="session"></jsp:useBean>
                  <jsp:setProperty property="*" name="user"/>
                  <jsp:forward page="detailSecond.jsp"/>
   <%
   out.print(user);
}

%>

</body>
</html>