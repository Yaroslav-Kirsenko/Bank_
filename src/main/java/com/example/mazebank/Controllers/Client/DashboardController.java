package com.example.mazebank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text user_name;
    public Text login_date;
    public Label checking_bal;
    public Label checking_acc_num;
    public Label savings_bal;
    public Label savings_acc_number;
    public Label income_lbl;
    public Label expense_lbl;
    public ListView transaction_listview;
    public TextField peyee_fld;
    public TextField amount_fld;
    public TextArea massage_fld;
    public Button send_money_btm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
