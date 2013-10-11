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
public class TaxiDTO {
    
    private String name;
    
    private Integer maxSize;
    
    private Boolean airConditioned;
    
    private String company;

    public TaxiDTO() {
    }

    public TaxiDTO(String name, Integer maxSize, Boolean airConditioned, String company) {
        this.name = name;
        this.maxSize = maxSize;
        this.airConditioned = airConditioned;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Boolean getAirConditioned() {
        return airConditioned;
    }

    public void setAirConditioned(Boolean airConditioned) {
        this.airConditioned = airConditioned;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.maxSize);
        hash = 67 * hash + Objects.hashCode(this.airConditioned);
        hash = 67 * hash + Objects.hashCode(this.company);
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
        final TaxiDTO other = (TaxiDTO) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.maxSize, other.maxSize)) {
            return false;
        }
        if (!Objects.equals(this.airConditioned, other.airConditioned)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TaxiDTO{" + "name=" + name + ", maxSize=" + maxSize + ", airConditioned=" + airConditioned + ", company=" + company + '}';
    }   
}
