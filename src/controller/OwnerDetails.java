package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.model.PropertyDetail;
import com.model.User;

/**
 * Servlet implementation class OwnerDetails
 */
public class OwnerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnerDetails() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		RequestDispatcher rd=null;
		HttpSession session=request.getSession(false);
		PrintWriter pw=response.getWriter();
		User obj=(User) session.getAttribute("user");
		if(obj!=null);
		{   try
		     {
			   String firstName=request.getParameter("firstName");
			   String lastName=request.getParameter("lastName");
			   if(firstName!=null&&lastName!=null)
			   {
				        obj.setFirstName(firstName);
					    obj.setLastName(lastName);
					   
			   }
			   else
			   {
				      rd=request.getRequestDispatcher("detailSecond.jsp");
					 rd.include(request, response);
					 pw.println("<span style='color:red'>name fields are mandatory</span>");
			   }
			
			String date=request.getParameter("dob");
			String[]x=date.split("-",3);
			 int _date =Integer.parseInt(x[0]);
			 int _month =Integer.parseInt(x[1]);
			 int _year =Integer.parseInt(x[2]);
			 if((_date>=1&&_date<=31)&&(_month>=1&&_month<=12)&&(_year>=1900&&_year<=2001))
			 {
				 obj.setDob(date);
				
			 }
			 else
			 {
				 rd=request.getRequestDispatcher("detailSecond.jsp");
				 rd.include(request, response);
				 pw.println("<span style='color:red'>date is invalid</span>");
			 }
			 
			 
			obj.setRetirmentStatus(request.getParameter("retirmentStatus"));
			String ssn=request.getParameter("socialSecurityNumber");
			if(ssn.length()==9)
			{
				try
				{
					int x1=Integer.parseInt(ssn);
					obj.setSocialSecurityNumber(ssn);
				}
				catch(Exception e)
				{
					rd=request.getRequestDispatcher("detailSecond.jsp");
					 rd.include(request, response);
					 pw.println("<span style='color:red'>enter 9 digit valid security  no.</span>");
					 pw.print(obj);
				}
			}
			else
			{
				 rd=request.getRequestDispatcher("detailSecond.jsp");
				 rd.include(request, response);
				 pw.println("<span style='color:red'>enter 9 digit valid security no.</span>");
			}
			 //*****************************************
			
			 try
             {
                 Configuration configuration=new Configuration().configure()
                 		.addAnnotatedClass(User.class);
                 StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                 SessionFactory factory=configuration.buildSessionFactory(builder.build());
                 Session ses=factory.openSession();
                 Transaction transaction=ses.beginTransaction();
                 
                 ses.save(session.getAttribute("user"));
                 transaction.commit();
         		ses.close();
         		
         		factory.close();
         		rd=request.getRequestDispatcher("detailThird.jsp");
   		        rd.forward(request, response);
         		
             }
             catch(Exception e)
             {
            	 rd=request.getRequestDispatcher("detailSecond.jsp");
    			 rd.include(request, response);
    			 pw.println("<span style='color:red'>"+e.getMessage()+"</span>");
    			 pw.print(obj);
             }
			 
			 
		     }
		 catch(Exception e)
		    {
			 rd=request.getRequestDispatcher("detailSecond.jsp");
			 rd.include(request, response);
			 pw.println("<span style='color:red'>"+e.getMessage()+"</span>");
			 pw.print(obj);
		     }
		    

		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
