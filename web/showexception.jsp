<%-- 
    Document   : showexception
    Created on : 18 Jun, 2022, 1:10:27 AM
    Author     : Shrasti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Exception ex=(Exception)request.getAttribute("Exception");
System.out.println("wrong in errorjsp");
out.println("Some exception occured"+ex.getMessage());

%>