package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutil.MySQLConnection;

import exception.BusinessException;
import com.model.*;

public class LoginDao {
	public LoginDao()
	{
		
	}

	public String getUserById(String id) throws BusinessException {
		
		try(Connection connection=MySQLConnection.getConnection()){
			String sql="select password from UserLoginTable where email=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				return resultSet.getString("password");
			}else{
				throw new BusinessException("No User found with id "+id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException(e.getMessage());
		}
		
	}
	
	public int registerUser(String email,String pass) throws BusinessException
	{
		 int c=0;
		try(Connection connection=MySQLConnection.getConnection()){
			String sql="insert into UserLoginTable(email,password) values(?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2, pass);
			c=preparedStatement.executeUpdate();
						
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException(e.getMessage());
		}
		return c;
	}
public List<Quote> getQuoteByEmail(String id) throws BusinessException {
		List<Quote> quote=new ArrayList<>();
		
		try(Connection connection=MySQLConnection.getConnection()){
			String sql="select * from Quote where email=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				Quote temp=new Quote();
				
				temp.setDeductible(resultSet.getString("deductible")+"$");
				temp.setDetachedStructures(resultSet.getString("detachedStructures")+"$");
				temp.setDwellingCoverage(resultSet.getString("dwellingCoverage")+"$");
				temp.setEmail(resultSet.getString("email"));
				temp.setId(resultSet.getLong("id"));
				temp.setLivingExpense(resultSet.getString("livingExpense")+"$");
				temp.setMedicalExpense(resultSet.getString("medicalExpense")+"$");
				temp.setMonthlyPremium(resultSet.getString("monthlyPremium")+"$");
				temp.setPersonalProperty(resultSet.getString("personalProperty")+"$");
				
				quote.add(temp);
				
				
				
			}
			
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException(e.getMessage());
		}
		return quote;
		
	}
	
public String getAllQuotesByEmail() throws BusinessException {
	List<Quote> quote=new ArrayList<>();
    String s ="";
	try(Connection connection=MySQLConnection.getConnection()){
		String sql="select * from Quote";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()){
			Quote temp=new Quote();
			
			s+="<tr><td>"+resultSet.getLong("id")+"</td><td>"
					+resultSet.getString("monthlyPremium")+"$"+"</td><td>"
					+resultSet.getString("dwellingCoverage")+"$"+"</td><td>"
					+resultSet.getString("email")+"</td><td>"
							+resultSet.getString("detachedStructures")+"$"+"</td><td>"
							+resultSet.getString("personalProperty")+"$"+"</td><td>"
							+resultSet.getString("medicalExpense")+"$"+"</td><td></tr>";
							
		
			
			quote.add(temp);
			
			
			
		}
		
		
	} 
	catch (ClassNotFoundException | SQLException e) {
		throw new BusinessException(e.getMessage());
	}
	return s;
	
}
public String getAllPropertiesByEmail() throws BusinessException {
	List<Quote> quote=new ArrayList<>();
    String s ="";
	try(Connection connection=MySQLConnection.getConnection()){
		String sql="select * from PropertyDetailTable";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()){
			Quote temp=new Quote();
			
			s+="<tr><td>"+resultSet.getLong("pid")+"</td><td>"
			+resultSet.getString("email")+"$"+"</td><td>"
			+resultSet.getString("marketValue")+"$"+"</td><td>"
			+resultSet.getString("yearOfOrigin")+"</td><td>"
			+resultSet.getString("squareFootage")+"sq.ft</td><td>"
			
			+resultSet.getString("dwellingStyle")+"$"+"</td><td></tr>";
			
			
			
			
		}
		
		
	} 
	catch (ClassNotFoundException | SQLException e) {
		throw new BusinessException(e.getMessage());
	}
	return s;
	
}


}