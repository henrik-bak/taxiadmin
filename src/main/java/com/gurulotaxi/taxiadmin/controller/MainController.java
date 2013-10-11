package com.gurulotaxi.taxiadmin.controller;

import com.gurulotaxi.taxiadmin.service.MockService;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Vladislav Korecký
 */
public class MainController implements Initializable {

    private static final Logger logger = Logger.getLogger(MainController.class.getName());
    @FXML //  fx:id="lblHello"
    private Label lblHello; // Value injected by FXMLLoader


    // Handler for Button[id="btnHello"] onAction
    public void btnHelloOnAction(ActionEvent event) throws Exception {
        lblHello.setText("Hello");
        MockService service = new MockService();
        System.out.println(service.getMockFreeTaxis());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
