/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.controller;

import com.google.gson.Gson;
import com.gurulotaxi.taxiadmin.model.Clientuser;
import com.gurulotaxi.taxiadmin.model.JsonResponse;
import com.gurulotaxi.taxiadmin.model.TaxiDTO;
import com.gurulotaxi.taxiadmin.model.Taxidriver;
import com.gurulotaxi.taxiadmin.model.TaxidriverDTO;
import com.gurulotaxi.taxiadmin.service.CommunicationService;
import com.gurulotaxi.taxiadmin.util.ServerUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextArea responseArea;
    Taxidriver selectedDriver;
    final ObservableList<Taxidriver> driverList = FXCollections.observableArrayList();

    @FXML
    private void registerBtnClick(ActionEvent event) throws IOException {
        String url = ServerUtil.SERVER_BASE_URL + "driver/register";
        TaxiDTO taxiDto = new TaxiDTO(nameTextField.getText(), Integer.parseInt(sizeTextField.getText()), airconditionedCheckBox.isSelected(), companyNameTextField.getText());
        TaxidriverDTO driver = new TaxidriverDTO(phoneTextField.getText(), passwordTextField.getText(), passwordTextField.getText(), Integer.parseInt(licenseNumberTextField.getText()), taxiDto);

        JsonResponse response = CommunicationService.postObject(url, driver);
        responseArea.setText(response.toString());
        getDrivers();
    }
    
    @FXML
    private void deleteBtnClick(ActionEvent event) throws IOException {
        if (selectedDriver != null) {
        String url = ServerUtil.SERVER_BASE_URL + "driver/delete";
        
        JsonResponse response = CommunicationService.postObject(url, selectedDriver.getIdTaxiDriver());
        responseArea.setText(response.toString());
        }
        getDrivers();
    }

    private void getDrivers() throws IOException {
        String url = ServerUtil.SERVER_BASE_URL + "driver/getDrivers";
        JsonResponse response = CommunicationService.getResponse(url);

        driverList.clear();


        Object listObj = response.getData();
        System.out.println(listObj.toString());
        Gson gson = new Gson();
        Taxidriver[] drivers = gson.fromJson(listObj.toString(), Taxidriver[].class);

        driverList.addAll(drivers);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            // this method will be called whenever user selected row
            @Override
            public void changed(ObservableValue observale, Object oldValue, Object newValue) {
                selectedDriver = (Taxidriver) newValue;
            }
        });

        try {
            getDrivers();
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        idCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, Integer>("idTaxiDriver"));

        licenseNumberCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, String>("licensenumber"));

        licenseCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, Boolean>("licensed"));

        phoneCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, String>("phoneNumber"));

        table.setItems(driverList);
    }
}
