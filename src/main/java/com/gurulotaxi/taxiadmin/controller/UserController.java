/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ezzored
 */
public class UserController implements Initializable {
    
    @FXML
    private TableView table;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn fnameCol;
    @FXML
    private TableColumn lnameCol;
    @FXML
    private TableColumn phoneCol;
    @FXML
    private TableColumn mailCol;
    
    @FXML
    TextField fnameTextField;
    @FXML
    TextField lnameTextField;
    @FXML
    TextField phoneTextField;
    @FXML
    private TextField mailTextField;
    @FXML
    private TextField passwordTextField;
    
    @FXML
    private Button registerBtn;
    @FXML
    private Button deleteBtn;
    
    @FXML
    private void registerBtnClick(ActionEvent event) {

    }
    
    @FXML
    private void deleteBtnClick(ActionEvent event) {
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
