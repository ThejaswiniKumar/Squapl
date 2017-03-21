<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<form method = "post" action="/registration">
<div>
Name
<input type="text" name="username" place holder="Username"><br>
</div>
<div></div>
Email 
<input type="text" name="email" placeholder="Email"/><br>
</div>
<div>
Password 
<input type="password" name="password"  id="txtpassword" placeholder="Password" /><br>
</div>
<div>
Confirm Password 
<input type="password" name="confirmpassword" id="txtconfirmfeild"  placeholder="Confirm Password"/><br>
</div>
<div class=roles>
<div class="drop-down content">
Role 
<input type="text" name="roles" placeholder="Role" />
<button class="dropbtn"></button><br>
</div>

<div>
<input type="submit" value="Register">
</div> 

</form>
<script type="text/javascript">
function Validate(){
	var password=document.getElementById("txtpassword").value;
	var confirmpassword=document.getElementById("txtconfirmfeild").value;
	if (password!=confirmpassword){
		alert("Passwords do not match");
		return false;
		}
	return true;
}
</script>

</body>
</html>