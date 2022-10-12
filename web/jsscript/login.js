
function connectUser()
{
    userid=$("#username").val();
    password=$("#password").val();
    
    
//    if (validate() === false)
//    {
//
//        swal("Access denied", "Please enter valid userid /Password", "error");
//        return;
//    }
    let data = {

        userid: userid,
        password: password

    };
            console.log(data);
            let xhr = $.post("LoginControllerServlet", data, processresponse); //ajax object xhr
            xhr.fail(handleError);
        }
        
    

function processresponse(responseText,textStatus,xhr)
    {
        
        if(responseText.trim()==="error")
       {
           swal("Access denied","login failed","error");
    }
        
        
        console.log(responseText);
        
       if(responseText.trim().indexOf("jsessionid")!==-1)
       {
           let pr=swal("success","login successfull","success");
           pr.then((value)=>{
               window.location=responseText.trim();
           });
    }
    else
    {
        console.log("respndText is "+responseText);
         swal("Access denied","some problem occured","error");

    }

    }






//function validate()
//{
//    if(userid===""||password==="")
//    {
//        swal("Error","All fields are mandatory ","error");
//        return false;
//    }
//    return true;
//    
//    
//}

function handleError(xhr)
{
    
    swal("Error","Problem in server communication :"+xhr.statusText,"error");
}