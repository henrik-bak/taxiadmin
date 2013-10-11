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
public class OrderWindowController implements Initializable {
    
    @FXML
    private TableView table;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn locationCol;
    @FXML
    private TableColumn acceptedCol;
    @FXML
    private TableColumn driverJSONCol;
    @FXML
    private TableColumn userJSONCol;
    
    @FXML
    TextField latitudeTextField;
    @FXML
    TextField longitudeTextField;
    @FXML
    TextField userIDTextField;
    @FXML
    private TextField driverIDTextField;
    @FXML
    private Button orderBtn;
    
    @FXML
    private void orderBtnClick(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
