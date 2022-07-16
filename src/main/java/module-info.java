module com.leo.readerdbhibernate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.naming;
    requires org.hibernate.orm.core;
    requires mysql.connector.java;
    requires java.sql;


    opens com.leo.readerdbhibernate; //to javafx.fxml;
    exports com.leo.readerdbhibernate;
}