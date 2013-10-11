/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.model;

import java.util.Map;

/**
 *
 * @author Ezzored
 */
public class JsonResponse {
    private static final float version = 1.0f;  
 
    private String status;
    private int message;
    private Map<String, Object> fieldErrors;
    private Object data;
 
    public JsonResponse() {
    }
     
    public JsonResponse(String status) {
        this.status = status;
    }    
     
    //@XmlElement //we don't need this thanks to Jackson
    public float getVersion() {
        return JsonResponse.version;
    }
         
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
     
    public int getMessage() {
        return message;
    }
 
    public void setMessage(int errorMsg) {
        this.message = errorMsg;
    }
 
    public Map<String, Object> getFieldErrors() {
        return fieldErrors;
    }
 
    public void setFieldErrors(Map<String, Object> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
     
    public Object getData() {
        return data;
    }
 
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResponse{" + "status=" + status + ", message=" + message + ", fieldErrors=" + fieldErrors + ", data=" + data + '}';
    }
}
