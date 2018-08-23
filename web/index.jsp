<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <title>码蚁商城后台管理系统</title>
  <link href="../favicon.ico" rel="shortcut icon">
  <link rel="stylesheet" href="css/style.css" type="text/css" />

</head>

<body>
<div id="container">

  <form action="AdminServlet">
    <div class="login">
      码蚁商城后台管理系统
      <!--  <span style="color:red">用户名密码错</span> -->
      <%
        if (response.getHeader("login_error")!=null){
          out.write("<span style=\"color:red;font-size:10px;\">用户名密码错</span>");
        }
      %>
    </div>
    <div class="username-text">用户名:</div>
    <div class="password-text">密码:</div>
    <div class="username-field">
      <input type="text" name="username" />
    </div>
    <div class="password-field">
      <input type="password" name="password" />
    </div>
    <input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住用户名</label>

    <div class="forgot-usr-pwd"></div>
    <input type="submit" name="submit" value="GO" />
  </form>
</div>

</body>
</html>

