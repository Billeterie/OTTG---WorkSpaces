<%-- 
    Document   : verifyLogin
    Created on : Jun 16, 2015, 12:25:03 PM
    Author     : user
--%>

<%@page import="cm.lal.dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/ionic.min.css" rel="stylesheet"/>
        <title>Verification of Login Credentials</title>
    </head>
    <body>
        <%
            String userName = request.getParameter("username");
            String passWord = request.getParameter("password");
            UserDao userDao = new UserDao();

            out.print("Checking Credentials<br>");
            if (userName == null || passWord == null) {
                out.print("Invalid Credentials. Try Again!!!");
            } else {
                out.print("Be patient " + userName + ". We are currently verifying your Identity");
                boolean value = userDao.verifyIdentity(userName, passWord);
                if (value == true) {
        %>

        <jsp:forward page="dashboard.jsp" />

        <%
        } else {
        %>
        
        <jsp:forward page="loginPge.jsp" />
        
        <%
                }
            }
        %>
    </body>
</html>
