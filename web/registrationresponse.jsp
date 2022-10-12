<%-- 
    Document   : registrationresponse
    Created on : 18 Jun, 2022, 1:02:14 AM
    Author     : Shrasti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
boolean result=(boolean)request.getAttribute("result");
boolean userfound=(boolean)request.getAttribute("userfound");

if(userfound==true)
{
    out.println("uap");
}
else if(result==true)
{
    out.println("success");
}
else
out.println("error");
%>