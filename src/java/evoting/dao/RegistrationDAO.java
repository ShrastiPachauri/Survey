/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dao;

/**
 *
 * @author Shrasti
 */

    
    
import evoting.dbutil.DBConnection;
import evoting.dto.UserDetails;
  //types of import in java
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;


//note in our tables we have jumbled order of data ,beware while setting using Prepared Statement setString()etc;
public class RegistrationDAO
{
private static PreparedStatement ps,ps1;
static
{
try
{

ps=DBConnection.getConnection().prepareStatement("select * from user_details where aadhar_no=?");
ps1=DBConnection.getConnection().prepareStatement("insert into user_details values (?,?,?,?,?,?,?,?)");
}
catch(SQLException ex)
{
ex.printStackTrace();
}
}
public static boolean searchUser(String userid)throws SQLException
{
    System.out.println("in search user");
ps.setString(1,userid);
return ps.executeQuery().next();
//userid is actually aadhar no which is on 6th column in my table

}

public static boolean registerUser(UserDetails user)throws SQLException
{System.out.println("in registeruser");
ps1.setString(1,user.getUsername());
ps1.setString(2,user.getAddress());

ps1.setString(3,user.getCity());

ps1.setString(4,user.getEmail());

ps1.setLong(5,user.getMobile());   //write using getter values and set as per column number

ps1.setString(6,user.getUserid());

 //I have varchar2 in table for mobile  ,check if any issue arise
ps1.setString(7,"VOTER");
ps1.setString(8,user.getPassword());

return (ps1.executeUpdate()!=0);

}





    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
