package com.example.mazebank.Models;

import com.example.mazebank.Views.AccountType;
import com.example.mazebank.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private AccountType logInAccountType = AccountType.CLIENT;

    private final Client client;
    private boolean clientLogInSuccessFlag;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        this.clientLogInSuccessFlag = false;
        this.client = new Client("", "", "", null, null, null);
    }

    public static synchronized Model getInstance() {
        if (model == null){
            model = new Model();
        } return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
    public DatabaseDriver getDatabaseDriver() {return databaseDriver;}

    public AccountType getLogInAccountType(){
        return logInAccountType;
    }

    public void setLogInAccountType(AccountType logInAccountType) {
        this.logInAccountType = logInAccountType;
    }

    public boolean getClientLogInSuccessFlag() {return clientLogInSuccessFlag;}

    public void setClientLogInSuccessFlag(boolean flag) {this.clientLogInSuccessFlag = flag;}

    public  Client getClient(){
        return client;
    }

    public void evaluateClientCard(String pAddress, String password){
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
        try {
            if (resultSet.isBeforeFirst()){
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.payeeAddressProperty().set(resultSet.getString("PayeeAddress"));
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.client.dateProperty().set(date);
                this.clientLogInSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
