package com.leo.readerdbhibernate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.sql.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ListView myvistview;

    DAObotuser dbcollector = new DAObotuser();

    @FXML
    protected void onHelloButtonClick() throws SQLException {
        ArrayList<Botuser> dat = (ArrayList<Botuser>) dbcollector.getlistdata().stream().limit(10).collect(Collectors.toList());
        ObservableList<Botuser> olist = FXCollections.observableArrayList(dat);
        myvistview.setItems(olist);
    }

    public void writeRecordtoDB(ActionEvent actionEvent) {
        Botuser btu = new Botuser();
        btu.setChatid(190);
        btu.setId(123451); //unique key
        btu.setText("TestHibernateWrite");
        btu.setAcknowledge(1);
        boolean state = dbcollector.writetoDB(btu);
        welcomeText.setText("add to db " + state);
    }
}