<%-- 
    Document   : adminshowcandidate
    Created on : 6 Jul, 2022, 4:02:51 PM
    Author     : Shrasti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.json.JSONObject"%>
<%@page import="evoting.dto.CandidateDetails"%>
<%@page import="java.util.ArrayList"%>
<%
     String userid=(String)session.getAttribute("userid");
    if(userid==null)
            {
                response.sendRedirect("accessdenied.html");
                return;
            }    
    
    
    String result=(String)request.getAttribute("result");
    StringBuffer displayBlock=new StringBuffer();
    
    
    if(result!=null && result.equalsIgnoreCase("candidatelist"))
    {
        ArrayList<String> candidateId=(ArrayList<String>)request.getAttribute("candidateid");
         // write the code
         
         displayBlock.append("<option>Choose Id</option>");//so that by default no id is selected 
         
         for(String c: candidateId)
         {
             
             displayBlock.append("<option value='"+c+"'>"+c+"</option>");
             
         }
         JSONObject json=new JSONObject();
         json.put("cid",displayBlock.toString());
         out.println(json);
         System.out.println("in admin show candidate");
System.out.println(displayBlock);
         
        
    }
    else if(result!=null && result.equals("details"))
    {
         CandidateDetails candidate = (CandidateDetails) request.getAttribute("candidate");
        String img = "<img src='data:image/png;base64," + candidate.getSymbol() + "'style='width:300px;height:200px;'/>";

        displayBlock.append("<table>" + "<tr><th>User Id:</th><td>" + candidate.getUserId() + "</td></tr>" + "<tr><th>Candidate Name:</th><td>" + candidate.getCname() + "</td></tr>"
                + "<tr><th>City:</th><td>" + candidate.getCity() + "</td></tr>"
                + "<tr><th>Party:</th><td>" + candidate.getParty() + "</td></tr>"
                + "<tr><th>Symbol:</th><td id='image'>"+img+"</td></tr>"
                + "</table>");
        System.out.println(displayBlock);
        JSONObject json = new JSONObject();
        System.out.println(img);
        json.put("subdetails", displayBlock.toString());
        out.println(json);
    }


%>
