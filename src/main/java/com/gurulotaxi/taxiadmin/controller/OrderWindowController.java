/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.controller;

import com.google.gson.Gson;
import com.gurulotaxi.taxiadmin.model.Clientuser;
import com.gurulotaxi.taxiadmin.model.JsonResponse;
import com.gurulotaxi.taxiadmin.model.Taxidriver;
import com.gurulotaxi.taxiadmin.model.Taxiorder;
import com.gurulotaxi.taxiadmin.model.TaxiorderDTO;
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
    private TextArea responseArea;
    
    Taxiorder order;
    final ObservableList<Taxiorder> orderList = FXCollections.observableArrayList();
    
    @FXML
    private void orderBtnClick(ActionEvent event) throws IOException {
        TaxiorderDTO taxiDto = new TaxiorderDTO(Integer.parseInt(driverIDTextField.getText()), Integer.parseInt(userIDTextField.getText()), latitudeTextField.getText()+"|"+longitudeTextField.getText());
        String url = ServerUtil.SERVER_BASE_URL + "order/createOrder";
         JsonResponse response = CommunicationService.postObject(url,taxiDto);
         responseArea.setText(response.toString());
         getOrders();
    }
    
    @FXML
    private void deleteBtnClick(ActionEvent event) throws IOException {
        if (order != null) {
        String url = ServerUtil.SERVER_BASE_URL + "order/delete?orderid="+order.getIdOrder();
        
        JsonResponse response = CommunicationService.postObject(url,null);
        responseArea.setText(response.toString());
        }
        getOrders();
    }

    
    private void getOrders() throws IOException {
        String url = ServerUtil.SERVER_BASE_URL + "order/getOrders";
        JsonResponse response = CommunicationService.getResponse(url);

        orderList.clear();

        Object listObj = response.getData();
        System.out.println(listObj.toString());
        Gson gson = new Gson();
        Taxiorder[] orders = gson.fromJson(listObj.toString(), Taxiorder[].class);

        orderList.addAll(orders);
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
                order = (Taxiorder) newValue;
            }
        });

        try {
            getOrders();
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        idCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, Integer>("idOrder"));

        locationCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, String>("location"));

        acceptedCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, Boolean>("accepted"));

        driverJSONCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, String>("taxidriveridTaxiDriver"));
        
        userJSONCol.setCellValueFactory(
                new PropertyValueFactory<Clientuser, String>("clientuseridClientUser"));

        table.setItems(orderList);
    }    
}
