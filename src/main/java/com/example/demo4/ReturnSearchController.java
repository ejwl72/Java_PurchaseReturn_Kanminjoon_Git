package com.example.demo4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import models.ReturnDetail;
import models.ReturnSearch;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ReturnSearchController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private AnchorPane rootPane;


    @FXML
    private TableView ReturnSearchTable;
    @FXML
    private TableColumn<ReturnDetail, Integer> PurchaseReturnID;
    @FXML
    private TableColumn<ReturnDetail, Integer>  purchaseOrderID;
    @FXML
    private TableColumn<ReturnDetail, Integer> SupplierID;
    @FXML
    private TableColumn<ReturnDetail, String> ContactName;
    @FXML
    private TableColumn<ReturnDetail, String> ContactTitle;
    @FXML
    private TableColumn<ReturnDetail, String> OrderDate;
    @FXML
    private TableColumn<ReturnDetail, String> Status;
    @FXML
    private TableColumn<ReturnDetail, Double> NetAmount;


    private Executor exec;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void initialize () {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Employee objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */

        //For multithreading: Create executor that uses daemon threads:
        exec = Executors.newCachedThreadPool((runnable) -> {
            Thread t = new Thread (runnable);
            t.setDaemon(true);
            return t;
        });

    @FXML //search버튼
    public void Returnsearch(ActionEvent event) {
        try {
            //Get Employee information
            ReturnSearch cus = CustomerRepository.searchCustomer(cusIdText.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowCustomer(cus);
        } catch (SQLException e) {
            e.printStackTrace();
            //resultArea.setText("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }
    }
    @FXML //add버튼
    public void insertCustomer(ActionEvent event) {
        try {
            //add new employee
            CustomerRepository.insertCus(idText.getText(), nameText.getText(),surnameText.getText(),emailText.getText(), jobText.getText());
            System.out.println("Customer inserted! \n");

            //reload all records
            searchCustomer(actionEvent);
        } catch (SQLException e) {
            System.out.println("Problem occurred while inserting Customer " + e);
            throw e;
        }
    }

        @FXML
        private void populateCustomer(ReturnSearch res) throws ClassNotFoundException {
            //Declare and ObservableList for table view
            ObservableList<ReturnSearch> cusData = FXCollections.observableArrayList();
            //Add employee to the ObservableList
            cusData.add(cus);
            //Set items to the employeeTable
            ReturnSearchTable.setItems(cusData);
        }

        @FXML
        private void populateAndShowSearch(ReturnSearch sea) throws ClassNotFoundException {
            if (cus != null) {
                populateEmployee(cus);
                setEmpInfoToTextArea(cus);
            } else {
                System.out.println("This customer does not exist!\n");
            }
        }
    }

    public void OpenDetail(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("return_reason.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}