<%-- 
    Document   : loginresponse
    Created on : 22 Jun, 2022, 12:08:11 PM
    Author     : Shrasti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
   String userid=(String)request.getAttribute("userid"); 
String result=(String)request.getAttribute("result"); 

if(userid==null)
{
    out.println("userid is null");
}
if(result==null)
{
    out.println("result is null");
}



    if(userid!=null&&result!=null)
    {
        HttpSession sess=request.getSession();
        sess.setAttribute("userid", userid);
        if(result.equalsIgnoreCase("Admin"))
        {
        String url="AdminControllerServlet;jsessionid="+session.getId();
        out.println(url);
        }
        else
        {
        String url="VotingControllerServlet;jsessionid="+session.getId();
        out.println(url);
        }
    }
    else
    {
        out.println("error");
    }

%>