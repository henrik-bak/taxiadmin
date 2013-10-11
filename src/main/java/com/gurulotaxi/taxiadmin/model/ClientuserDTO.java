/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ezzored
 */
@XmlRootElement
public class ClientuserDTO {
    private String email;
    private String fName;
    private String lName;
    private String password1;
    private String password2;
    private String phone;

    public ClientuserDTO() {
    }

    
    public ClientuserDTO(String email, String fName, String lName, String password1, String password2, String phone) {
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.password1 = password1;
        this.password2 = password2;
        this.phone = phone;
    }
     
    public String getFName() {
        return fName;
    }
     
    public void setFName(String firstName) {
        this.fName = firstName;
    }
  
    public String getLName() {
        return lName;
    }
  
    public void setLName(String lastName) {
        this.lName = lastName;
    }
  
    public String getEmail() {
        return email;
    } 
 
    public void setEmail(String email) {
        this.email = email;
    }
  
    public String getPassword1() {
        return password1;
    }
     
    public void setPassword1(String password) {
        this.password1 = password;
    }
     
    public String getPassword2() {
        return password2;
    }
     
    public void setPassword2(String password) {
        this.password2 = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
      
    @Override
    public String toString() {
        return "User [email=" + email + ", fName=" + fName
                + ", lName=" + lName + ", password1=" + password1 +", password2=" + password2 + "]";
    }
}
