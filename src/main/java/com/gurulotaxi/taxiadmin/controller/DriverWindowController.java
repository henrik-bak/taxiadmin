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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ezzored
 */
public class DriverWindowController implements Initializable {

    @FXML
    private TableView table;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn licenseNumberCol;
    @FXML
    private TableColumn licenseCol;
    @FXML
    private TableColumn phoneCol;
    @FXML
    TextField phoneTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    private CheckBox licensedCheckBox;
    @FXML
    private TextField licenseNumberTextField;
    @FXML
    TextField nameTextField;
    @FXML
    TextField sizeTextField;
    @FXML
    private CheckBox airconditionedCheckBox;
    @FXML
    private TextField companyNameTextField;
    @FXML
    private Button registerBtn;

    @FXML
    private void registerBtnClick(ActionEvent event) {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
