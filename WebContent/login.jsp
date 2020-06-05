<%@page import="bo.LoginBo"%>
<%@page import="dao.LoginDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="signup.jsp">Signup now...</a>
 <form name="lform" action="">
        <P><B><CENTER><strong>login details</strong></CENTER></B></P><br><br>
        <label for="email" >Username id</label><br><br>
        <input type="email" id="email" placeholder=" YOUR ID HERE.. " name="email" value="<%="sayush839@gmail.com"%>">
       <center> <hr width="90%" ></center><br>
        <label for="password">Enter Password</label><br><br>
        <input type="password" id="password" placeholder="PASSWORD HERE" name="password" value="<%="Ayush@123"%>">
         <center> <hr width="90%" ></center><br>
     
      <input type="submit" name="loginu" value="login as user">
       <input type="submit" value="login as admin" name="logina">
        
        </form>
        <%  
          String email=request.getParameter("email");
        		String password=request.getParameter("password");
        		
          if(request.getParameter("loginu")!=null)
          {   
        	  LoginBo obj=new LoginBo();
              try
              {    String pass=obj.isValidUser(email, password);
            	  if(pass.equals(password))
                  { %>
             	 
             	 <jsp:useBean id="user" class="com.model.User" scope="session"></jsp:useBean>
                  <jsp:setProperty property="*" name="user"/>
                  <jsp:forward page="user.jsp"></jsp:forward>
             	 <%}
                  else
                  { %>
                  <jsp:forward page="signup.jsp"></jsp:forward>
                  <%
                  }  
              }
              catch(Exception e)
              {
            	  out.print("<span style='color:red'>"+e.getMessage()+"</span>"); 
            	 response.sendRedirect("signup.jsp");
              }
             
        	
          }
           if(request.getParameter("logina")!=null)
          {
        	  %>
        	   <jsp:forward page="admin.jsp"></jsp:forward>
        	   <%
          }
         %>
</body>
</html>