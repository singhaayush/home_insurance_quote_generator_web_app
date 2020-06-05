<%@page import="org.hibernate.HibernateException"%>
<%@page import="com.model.UserLoginTable"%>
<%@page import="dao.LoginDao"%>
<%@page import="bo.LoginBo"%>

    <%@page import="org.hibernate.query.Query"%>
<%@page import="com.model.Quote"%>
<%@page import="java.util.List"%>
<%@page import="com.model.User"%>
<%@page import="com.model.PropertyDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import=" org.hibernate.Session"%>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="lform" action="">
        <P><B><CENTER><strong>signup details</strong></CENTER></B></P><br><br>
        <label for="email" >Username id</label><br><br>
        <input type="email" id="email" placeholder=" YOUR ID HERE.. " name="email">
       <center> <hr width="90%" ></center><br>
        <label for="password">Enter Password</label><br><br>
        <input type="password" id="password" placeholder="PASSWORD HERE" name="password">
         <center> <hr width="90%" ></center><br>
     
      <input type="submit" name="signup" value="signup">
     
        
        </form>
        <%
        if(request.getParameter("signup")!=null)
        { %>
            <jsp:useBean id="newUser" class="com.model.UserLoginTable" scope="session"></jsp:useBean>
                  
                  <jsp:setProperty property="*" name="newUser"/>
                 <% 
        	try
           {
        	Configuration configuration=new Configuration().configure().addAnnotatedClass(UserLoginTable.class);
		
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory=configuration.buildSessionFactory(builder.build());
			Session sess=factory.openSession();
			Transaction transaction=sess.beginTransaction();
			sess.save(session.getAttribute("newUser"));
			
			transaction.commit();
			sess.close();
			
			factory.close();
			response.sendRedirect("login.jsp");
        }
        catch(HibernateException he)
        {
        	out.print(he.getMessage());
        }
        
          
        }
        %>
</body>
</html>