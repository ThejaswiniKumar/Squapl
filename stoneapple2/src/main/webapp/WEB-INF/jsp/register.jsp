<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<script type="text/javascript">
function hello(){
var myObj1=document.squapl.username.value;
var myObj2=document.squapl.email.value;
var myObj3=document.squapl.password.value;
var myObj4=document.squapl.confirmpassword.value;
var myObj5=document.squapl.roles.value;

var obj={};
obj["username"]=myObj1;
obj["email"]=myObj2;
obj["password"]=myObj3;
obj["confirmpassword"]=myObj4;
obj["roles"]=myObj5;

var json = JSON.stringify(obj);

alert(json);

return hello;
}
</script>
<script type="text/javascript">
function hai()
{
var x=document.squapl.email.value;
var atpos=x.indexOf("@");
var dotpos=x.lastIndexOf(".");
if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
  {
  alert("Not a valid e-mail address");
  return false;
  }
}
</script>
<script type="text/javascript">s
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


</head>
<body>
<form method = "post" action="/registration" name="squapl">
<div>
Name
<input type="text" name="username" place holder="Username"><br>
</div>
<div></div>
Email 
<input type="text" name="email" placeholder="Email" id="email"><br>
</div>
<div>
Password 
<input type="password" name="password"  id="txtpassword" placeholder="Password" /><br>
</div>
<div>
Confirm Password 
<input type="password" name="confirmpassword" id="txtconfirmfeild"  placeholder="Confirm Password"/><br>
</div>
<div>
Role 
<input type="text" name="roles" placeholder="Role" />
</div>
<div>
<select name=select>
<option value=value1>Select1</option>
<option value=value2>Select2</option>
<option value=value3>Select3</option>
</select>
</div>
<div>
<input type="submit" value="Register" onclick=" hai();Validate();hello();" value="Call2Functions">
</div> 

</form>
</body>
</html>