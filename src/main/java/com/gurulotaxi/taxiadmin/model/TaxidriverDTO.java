/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.model;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ezzored
 */
@XmlRootElement
public class TaxidriverDTO {

    private Integer licensenumber;
    private String phoneNumber;
    private String password1;
    private String password2;
    private TaxiDTO taxi;

    public TaxidriverDTO() {
    }

    public TaxidriverDTO(String phoneNumber, String password1, String password2, Integer licensenumber, TaxiDTO taxi) {
        this.phoneNumber = phoneNumber;
        this.password1 = password1;
        this.password2 = password2;
        this.licensenumber = licensenumber;
        this.taxi=taxi;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public TaxiDTO getTaxi() {
        return taxi;
    }

    public void setTaxi(TaxiDTO taxi) {
        this.taxi = taxi;
    }

    public Integer getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(Integer licensenumber) {
        this.licensenumber = licensenumber;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.licensenumber);
        hash = 29 * hash + Objects.hashCode(this.phoneNumber);
        hash = 29 * hash + Objects.hashCode(this.password1);
        hash = 29 * hash + Objects.hashCode(this.password2);
        hash = 29 * hash + Objects.hashCode(this.taxi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaxidriverDTO other = (TaxidriverDTO) obj;
        if (!Objects.equals(this.licensenumber, other.licensenumber)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.password1, other.password1)) {
            return false;
        }
        if (!Objects.equals(this.password2, other.password2)) {
            return false;
        }
        if (!Objects.equals(this.taxi, other.taxi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TaxidriverDTO{" + "licensenumber=" + licensenumber + ", phoneNumber=" + phoneNumber + ", password1=" + password1 + ", password2=" + password2 + ", taxi=" + taxi + '}';
    }

}
