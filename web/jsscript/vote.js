/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function addvote()
{
      var id= $('input[type=radio][name=flat]:checked').attr('id');
    data={candidateid:id};
    console.log("about to add a vote");
    $.post("AddVoteController",data,processresponse);
}
function processresponse(responseText)
{
    responseText=responseText.trim();
    if(responseText==="success")
        window.location="votingresponse.jsp";
    else
        window.location="accessdenied.html";
}
