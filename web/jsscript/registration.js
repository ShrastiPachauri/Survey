let username,password,cpassword,city,address,adhar,email,mobile;

    
function addUser()
{
    username=$("#username").val();
    password=$("#password").val();
    cpassword=$("#cpassword").val();
    city=$("#city").val();
    email=$("#email").val();
    mobile=$("#mobile").val();
    adhar=$("#adhar").val();
    address=$("#address").val();
    
    if(validateUser())
    {
        if (password !== cpassword)
        {
            swal("Error", "request Denied", "error");
            return;                                      //return 
        } 
        
        else
        {
            if (checkEmail() === false)
            {
                return;
            }
            if(checkMobile()===false)
            {
                return;
            }
            let data = {

                username: username,
                password: password,
                city: city,
                address: address,
                userid: adhar,
                email: email,
                mobile: mobile

            };
            console.log(data);
            let xhr = $.post("RegistrationController", data, processresponse); //ajax object xhr
            handleError(xhr);
        }
        
    }
}
    function processresponse(responseText,textStatus,xhr)
    {
        console.log("Inside processresponse"+responseText);
        let str=responseText.trim();
        if(str==="success")
        {
            swal("Registration done","registration is successfull","success");
            setTimeout(redirectUser,3000);
        }
        else if(str==="uap")
        {
            swal("Sorry the userid is already present","error");
            
        }
        else
        {
            swal("Registration failed!!","Try again later","error");
        }
    }
 
    
    function handleError(xhr)
    {
        console.log("Inside handleERROR"+xhr);
        console.log(data);
        swal("Error ","Problem in server communication"+xhr.statusText,"error");
        
        
    }

function checkEmail()
{
    
    let attheratepos=email.indexOf("@");
    let dotpos=email.indexOf(".");
    
    if(attheratepos<1||dotpos<attheratepos+2||dotpos+2>=email.length)
    {
        swal("Error","request Denied","please write valid email");
        return false;
    }
   return true;
}
function validateUser()
{
    if(username===""||password===""||cpassword===""||city===""||address===""||adhar===""||mobile===""||email==="")
    {
        swal("Error","All fields are mandatory ","error");
        return false;
    }
    return true;
    
    
}


function checkMobile()
{
    
    if(mobile.length>10 || mobile.length<10)
    {
        swal("Enter 10 digit number","Wrong Input","error");
    }
    
    if(mobile.indexOf(" ")!==-1)
    {
        swal("Dont't enter spaces","Wrong Input","error");
    }
    return true;
    
    
}




function redirectUser(){

    
    window.location="login.html";
}
