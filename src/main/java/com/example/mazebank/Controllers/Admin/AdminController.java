package com.example.mazebank.Controllers.Admin;

import com.example.mazebank.Models.Model;
import com.example.mazebank.Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuUtem().addListener(((observableValue, oldVal, newVal) ->{
            if (Objects.requireNonNull(newVal) == AdminMenuOptions.CLIENTS) {
                admin_parent.setCenter(Model.getInstance().getViewFactory().getClientsView());
            } else {
                admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
            }
        }));
    }
}

