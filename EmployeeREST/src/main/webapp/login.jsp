<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Form</title>
 <style media="screen">
*:before,
*:after{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}
body{background:#222A3B;
}
.background{
    width: 430px;
    height: 520px;
    position: absolute;
    transform: translate(-50%,-50%);
    left: 50%;
    top: 50%;
}

form{
    height: 700px;
    width: 1100px;
    background-color: rgba(255,255,255,0.15);
    position: absolute;
    transform: translate(-50%,-50%);
    top: 50%;
    left: 50%;
    border-radius: 30px;
    backdrop-filter: blur(15px);
    border: 2px solid rgba(255,255,255,0.1);
    box-shadow: 0 0 40px rgba(8,7,16,0.6);
    padding: 10px 40px 5px 20px;
}
form *{
    font-family: 'Poppins',sans-serif;
    color: #ffffff;
    letter-spacing: 0.5px;
    outline: none;
    border: none;
}
form h3{
    font-size: 32px;
    font-weight: 100;
    line-height: 42px;
    text-align: center;
    margin-left: 350px;
    
}
form h4{
  font-size: 15px;
  font-weight: 50;
    line-height: 42px;
  text-align: center;
  margin-left: 300px;
padding-bottom: 40px;
color: rgba(255, 255, 255, 0.627);
}

label{
    display: block;
    margin-top: 30px;
    font-size: 20px;
    font-weight: 200;
    margin-left: 550px;
}
input{
    display: block;
    height: 50px;
    width: 50%;
    background-color: rgba(255,255,255,0.07);
    border-radius: 10px;
    padding: 0 10px;
    margin-top: 8px;
    font-size: 14px;
    font-weight: 300;
    margin-left: 550px;
}
::placeholder{
    color: #e5e5e5;
}
.register{ display: block;
    margin-top: 10px;
    font-size: 18px;
   
    font-weight: 50;
    color:#A7C7E7;
    margin-left: 900px;
}

button{
    margin-top: 10px;
    width: 50%;
    background-color: #222A3B;
    color: #ffffff;
    padding: 10px 0;
    font-size: 20px;
    font-weight: 700;
    border-radius: 10px;
    cursor: pointer;
    border-radius: 30px;
    margin-left: 550px;
}


   </style>
</head>
<body>
    <form action ="LoginServlet" method="post"  class="register-form"
							id="login-form">
        <h3>Hello, Welcome Back!</h3>
		
		<h4>To continue please enter your details.</h4>
	

        <label for="username">User Name</label>
        <input type="text" placeholder="Email or Phone" id="username" name="username">

        <label for="password">Password: </label>
        <input type="password" placeholder="Password" id="password" name="password">
<!-- <a href="registration.jsp" class="signup-image-link">Create an
							account</a> -->
		<a href="forgotPassword.jsp" class="register"> Forget Password? </a>
		<a href="employeeregister.jsp" class="register"> Create an Account</a>
		<a href="UpdateUser.jsp" class="register"> Update Your Profile</a>
        <button type="Submit" value="Log In">Sign In</button>
		
    </form>
</body>
</html>