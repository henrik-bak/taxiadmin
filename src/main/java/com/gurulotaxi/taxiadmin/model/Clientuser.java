/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.model;

import java.io.Serializable;

/**
 *
 * @author Ezzored
 */

public class Clientuser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idClientUser;
    

    private String firstName;
    

    private String lastName;
    

    private String phoneNumber;
    
    private String email;
    
    private String password;

    public Clientuser() {
    }

    public Clientuser(Integer idClientUser) {
        this.idClientUser = idClientUser;
    }

    public Clientuser(String firstName, String lastName, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public Integer getIdClientUser() {
        return idClientUser;
    }

    public void setIdClientUser(Integer idClientUser) {
        this.idClientUser = idClientUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientUser != null ? idClientUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientuser)) {
            return false;
        }
        Clientuser other = (Clientuser) object;
        if ((this.idClientUser == null && other.idClientUser != null) || (this.idClientUser != null && !this.idClientUser.equals(other.idClientUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clientuser{" + "idClientUser=" + idClientUser + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password + '}';
    }

}
