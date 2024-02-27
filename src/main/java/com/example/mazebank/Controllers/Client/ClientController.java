package com.example.mazebank.Controllers.Client;


import com.example.mazebank.Models.Model;
import com.example.mazebank.Views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    public BorderPane client_parent;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            if (newVal.equals(ClientMenuOptions.TRANSACTIONS)) {
                client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
            } else if (newVal.equals(ClientMenuOptions.ACCOUNTS)) {
                client_parent.setCenter(Model.getInstance().getViewFactory().getAccountView());
            } else{
                client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
}
