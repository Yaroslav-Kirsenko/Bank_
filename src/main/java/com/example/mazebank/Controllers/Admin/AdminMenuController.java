package com.example.mazebank.Controllers.Admin;

import com.example.mazebank.Models.Model;
import com.example.mazebank.Views.AdminMenuOptions;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_client_btn;
    public Button clients_btn;
    public Button deposit_btn;
    public Button logout_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        addListeners();
    }
    private void  addListeners(){
        create_client_btn.setOnAction(actionEvent -> onCreateClient());
        clients_btn.setOnAction(actionEvent -> onClients());
        deposit_btn.setOnAction(actionEvent -> onDeposit());
    }

    private void onCreateClient()
    {
        Model.getInstance().getViewFactory().getAdminSelectedMenuUtem().set(AdminMenuOptions.CREATE_CLIENT);
    }

    private void onClients(){
        Model.getInstance().getViewFactory().getAdminSelectedMenuUtem().set(AdminMenuOptions.CLIENTS);
    }

    private void onDeposit() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuUtem().set(AdminMenuOptions.DEPOSIT);
    }
}
