package com.example.mazebank.Models;

import com.example.mazebank.Controllers.Client.TransactionCellController;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private final StringProperty sender;
    private final StringProperty reciever;
    private final DoubleProperty amount;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty massage;

    public Transaction(String sender, String reciever, Double amount, LocalDate date, String massage){
        this.sender = new SimpleStringProperty(this, "sender", sender);
        this.reciever = new SimpleStringProperty(this, "reciever", reciever);
        this.amount = new SimpleDoubleProperty(this, "Amount", amount);
        this.date = new SimpleObjectProperty<>(this, "Date", date);
        this.massage = new SimpleStringProperty(this, "massage", massage);
    }


    public StringProperty senderProperty() {return this.sender;}
    public StringProperty recieverProperty(){return this.reciever;}
    public DoubleProperty amountProperty(){return this.amount;}
    public ObjectProperty<LocalDate> dateProperty(){return this.date;}
    public StringProperty massageProperty(){return this.massage;}
}
