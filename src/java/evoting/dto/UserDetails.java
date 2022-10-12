/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dto;

/**
 *
 * @author Shrasti
 */
public class UserDetails {

    @Override
    public String toString() {
        return "UserDetails{" + "Username=" + Username + ", Userid=" + Userid + ", Password=" + Password + ", Email=" + Email + ", Address=" + Address + ", Mobile=" + Mobile + ", City=" + City + '}';
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String Userid) {
        this.Userid = Userid;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public long getMobile() {
        return Mobile;
    }

    public void setMobile(long Mobile) {
        this.Mobile = Mobile;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }
    // create getters and setter and toString()
    private String Username;
    private String Userid;
    private String Password;
    private String Email;
    private String Address;
    private long Mobile; // but you have created varchar2 in table also Beware of case of u and sir's

    private String City;

}
