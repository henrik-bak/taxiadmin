/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.model;

/**
 *
 * @author Ezzored
 */
public class TaxiorderDTO {
    private Integer taxidriverid;
    private Integer clientuserid;
    private String location;

    public TaxiorderDTO() {
    }

    public TaxiorderDTO(Integer taxidriverid, Integer clientuserid, String location) {
        this.taxidriverid = taxidriverid;
        this.clientuserid = clientuserid;
        this.location = location;
    }

    public Integer getTaxidriverid() {
        return taxidriverid;
    }

    public void setTaxidriverid(Integer taxidriverid) {
        this.taxidriverid = taxidriverid;
    }

    public Integer getClientuserid() {
        return clientuserid;
    }

    public void setClientuserid(Integer clientuserid) {
        this.clientuserid = clientuserid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "TaxiorderDTO{" + "taxidriverid=" + taxidriverid + ", clientuserid=" + clientuserid + ", location=" + location + '}';
    }

    
}
