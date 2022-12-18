package com.example.demo4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;

public class ReturnDetailController {

    @FXML
    private Label welcomeText;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView ReturnDetailTable;
    @FXML
    private TableColumn<ReturnDetail, Integer> POLineNumber;
    @FXML
    private TableColumn<ReturnDetail, String>  itemID;
    @FXML
    private TableColumn<ReturnDetail, String> Description;
    @FXML
    private TableColumn<ReturnDetail, String> ManufacturerPartNo;
    @FXML
    private TableColumn<ReturnDetail, String> Uom;
    @FXML
    private TableColumn<ReturnDetail, String> OrderQty;
    @FXML
    private TableColumn<ReturnDetail, Date> UnitPrice;
    @FXML
    private TableColumn<ReturnDetail, Date> NetAmount;


    private Executor exec;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML //delete 버튼
    public void deleteDetail(ActionEvent event) {
        try {
            CustomerRepository.deleteCusWithId(resIdText.getText());
            System.out.println("Customer deleted! Customer id: " + resIdText.getText() + "\n");
        } catch (SQLException e) {
            System.out.println("Problem occurred while deleting Customer " + e);
            throw e;
        }
    }

    public void CloseDetail(ActionEvent event) {

    }

    public void SaveDetail(ActionEvent event) {

    }
    @FXML //add 버튼
    public void addDetail(ActionEvent event) {
        try {
            //add new employee
            CustomerRepository.insertCus(idText.getText(), nameText.getText(),surnameText.getText(),emailText.getText(), jobText.getText());
        } catch (SQLException e) {
            System.out.println("Problem occurred while inserting Customer " + e);
            throw e;
        }
    }
    private void fillReturnDetail(ActionEvent event) throws SQLException, ClassNotFoundException {
        Task<List<ReturnDetail>> task = new Task<List<ReturnDetail>>(){
            @Override
            public ObservableList<ReturnDetail> call() throws Exception{
                return CustomerRepository.searchReturnDetail();
            }
        };

        task.setOnFailed(e-> task.getException().printStackTrace());
        task.setOnSucceeded(e-> ReturnDetailTable.setItems((ObservableList<ReturnDetail>) task.getValue()));
        exec.execute(task);
    }
    @FXML
    private void populateDetail (ReturnSearch res) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<ReturnSearch> resData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        resData.add(res);
        //Set items to the employeeTable
        ReturnDetailTable.setItems(resData);
    }

    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowDetail(ReturnSearch res) throws ClassNotFoundException {
        if (res != null) {
            populateDetail(res);
        } else {
            System.out.println("This customer does not exist!\n");
        }
    }
}
