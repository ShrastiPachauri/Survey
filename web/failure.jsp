<%-- 
    Document   : failure
    Created on : 5 Jul, 2022, 11:20:54 PM
    Author     : Shrasti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   String userid=(String)session.getAttribute("userid");
   if(userid==null)
   {
       session.invalidate();
       response.sendRedirect("accessdenied.html");
       return;
   }
out.println("failure");















%>
