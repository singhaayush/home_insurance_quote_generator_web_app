<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:blue"><center>Home Owner Information</center></h1>
<form action="OwnerDetails" name="secondDetail">
<label for="firstName">First Name</label>
<input type="text" name="firstName" ><br/>
<label for="lastName">Last Name</label>
<input type="text" name="lastName" ><br/>
<label for="dob">Date of Birth</label>
<input type="text" name="dob" placeholder="dd-mm-yyyy"><br/>
<label for="retirmentStatus">Are you retired?</label>
Yes:<input type="radio" name="retirmentStatus" value="yes">
No:<input type="radio" name="retirmentStatus" value="no"><br/>
<label for="socialSecurityNumber">Social Security Number</label>
<input type="number" name="socialSecurityNumber"><br/>
<input type="submit" value="next" name="secondDetail">

</form>




</body>
</html>