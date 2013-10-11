/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.controller;

import com.google.gson.Gson;
import com.gurulotaxi.taxiadmin.model.Clientuser;
import com.gurulotaxi.taxiadmin.model.ClientuserDTO;
import com.gurulotaxi.taxiadmin.model.JsonResponse;
import com.gurulotaxi.taxiadmin.service.CommunicationService;
import com.gurulotaxi.taxiadmin.util.ServerUtil;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
    private TextArea responseArea;
    final ObservableList<Clientuser> clientList = FXCollections.observableArrayList();
    
    Clientuser selectedUser;

    @FXML
    private void registerBtnClick(ActionEvent event) throws IOException {
        String url = ServerUtil.SERVER_BASE_URL + "user/register";
        ClientuserDTO user = new ClientuserDTO(mailTextField.getText(), fnameTextField.getText(), lnameTextField.getText(),
                passwordTextField.getText(), passwordTextField.getText(), phoneTextField.getText());
        
        JsonResponse response = CommunicationService.postObject(url, user);
        responseArea.setText(response.toString());
        getUsers();
    }

    @FXML
    private void deleteBtnClick(ActionEvent event) throws IOException {
        if (selectedUser != null) {
        String url = ServerUtil.SERVER_BASE_URL + "user/delete";
        
        JsonResponse response = CommunicationService.postObject(url, selectedUser.getIdClientUser());
        responseArea.setText(response.toString());
        }
        getUsers();
    }
    
    private void getUsers() throws IOException {
        String url = ServerUtil.SERVER_BASE_URL + "user/getUsers";
        JsonResponse response = CommunicationService.getResponse(url);
        
        clientList.clear();
        
        
        Object listObj = response.getData();
        System.out.println(listObj.toString());
        Gson gson = new Gson();
        Clientuser[] clients = gson.fromJson(listObj.toString(), Clientuser[].class);
        
        clientList.addAll(clients);
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
                selectedUser = (Clientuser) newValue;
            }
        });
        
        try {
            getUsers();
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        idCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, Integer>("idClientUser"));

        fnameCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, String>("firstName"));

        lnameCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, String>("lastName"));

        phoneCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, String>("phoneNumber"));

        mailCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, String>("email"));

        table.setItems(clientList);
    }
}
