<%-- 
    Document   : showcandidate
    Created on : 30 Jun, 2022, 12:51:43 PM
    Author     : Shrasti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,evoting.dto.CandidateInfo"%>
<html>
<head>
<link href="stylesheet/showcandidate.css" type="text/css" rel="stylesheet">
<link href="stylesheet/backgroundimage.css" rel="stylesheet">
<link href="stylesheet/pageheader.css" rel="stylesheet">
<script src="jsscript/vote.js"></script>
<script src="jsscript/jquery.js"></script>
<title>show candidate</title>
</head>
<body>
<%
          String userid=(String)session.getAttribute("userid");
    if(userid==null)
            {
response.sendRedirect("accessdenied.html");
                return;
            }
    
    
StringBuffer displayBlock=new StringBuffer("<div class='sticky'><div class='candidate'>VOTE FOR CHANGE</div> "
                  + "<br><div class='subcandidate'>Whom do you want to vote ?</div>"
                  +"<div class='logout'><a href='login.html'>logout</a></div>" 
                  +"</div></div><div class='buttons'>");

ArrayList<CandidateInfo> candidate=(ArrayList)request.getAttribute("candidateList");

for(CandidateInfo c:candidate)
          {
displayBlock.append("<input id='"+c.getCandidateId()+"' value='"+c.getCandidateId()+"' name='flat' type='radio' onclick='addvote()' />");
displayBlock.append("<label for='"+c.getCandidateId()+"'>/></label>"
                  + "<br/><div class='candidateprofile'><p>Candidate Id:"+c.getCandidateId()+"<br/>"
                 +"Candidate Name:"+c.getCandidateName()+"<br/>"
                         + " Party:"+c.getParty()+"</label><br/></div>");
          }
out.println(displayBlock);//since yeh call ajax ka nahi tha ,direct widow.location se aaye hain ,therefore it will not go to js rather browser itself
      %>
</div>
</div>
</body>
</html>