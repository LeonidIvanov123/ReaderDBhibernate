package com.leo.readerdbhibernate;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.sql.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ListView myvistview;


    @FXML
    protected void onHelloButtonClick() throws SQLException {

        //Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:50770/", "hiberuser", "991_Roter");
        //welcomeText.setText("state : " + dbCon.toString());

        DAObotuser dbcollector = new DAObotuser();

        ArrayList<Botuser> dat = (ArrayList<Botuser>) dbcollector.getlistdata().stream().limit(10).collect(Collectors.toList());

        ObservableList<Botuser> olist = FXCollections.observableArrayList(dat);

        //System.out.println(dat);
        myvistview.setItems(olist);


    }
}