package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.PropertyDetail;
import com.model.Quote;
import com.model.User;

/**
 * Servlet implementation class QuoteGenerator
 */
public class QuoteGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuoteGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		PrintWriter pw=response.getWriter();
		RequestDispatcher rd=null;
		 PropertyDetail prop=(PropertyDetail) session.getAttribute("property");
         User user=(User)session.getAttribute("user");
         pw.print(user);
         pw.print(prop);
		/*
		try
		{  pw.print("enterd try");
		   PropertyDetail prop=(PropertyDetail) session.getAttribute("property");
           User user=(User)session.getAttribute("user");
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
		   pw.println(quote);
		   pw.print("ending");
		   rd=request.getRequestDispatcher("quoteDetails.jsp");
			 rd.include(request, response);
		   
		}
		catch(Exception e)
		{
			  rd=request.getRequestDispatcher("detailThird.jsp");
				 rd.include(request, response);
				 pw.println("<span style='color:red'>name fields are mandatory</span>");

		}*/
	}

}
