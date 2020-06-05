package bo;

import dao.LoginDao;
import exception.BusinessException;

public class LoginBo {
	
	private LoginDao login; 
	private LoginDao getLoginDao()
	{
		if(login==null)
		{
			login=new LoginDao();
		}
		return login;
	}
	public String isValidUser(String email,String pass) throws BusinessException
	{
		return getLoginDao().getUserById(email);
	}
    public String registerUser(String email,String pass) throws BusinessException
    {   String s="failure";
    	if(pass.length()<4)
    	{
    		s="pass word must be greater than 4 letters..";
    	}
    	else
    	{
    		int c=getLoginDao().registerUser(email,pass);
    		if(c!=0)
    		{
    			s="user created";
    		}
    	}
    	return s;
    }
}
