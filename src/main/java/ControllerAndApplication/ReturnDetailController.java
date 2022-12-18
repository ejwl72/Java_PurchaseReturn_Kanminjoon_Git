package ControllerAndApplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import ReturnDetailAndSearch.ReturnDetail;
import ReturnDetailAndSearch.ReturnSearch;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;

public class ReturnDetailController {
    @FXML
    private TextField d_pono;
    @FXML
    private TextField d_orderdate;
    @FXML
    private TextField d_supplier;
    @FXML
    private TextField d_contactname;
    @FXML
    private TextField d_contacttitle;
    @FXML
    private TextField d_requireddate;
    @FXML
    private TextField d_promiseddate;
    @FXML
    private TextField d_paymentdate;
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
            DetailRepository.delete(POLineNumber.getText(), itemID.getText(),Description.getText(),ManufacturerPartNo.getText(), Uom.getText(), OrderQty.getText(), UnitPrice.getText(),NetAmount.getText());
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
            DetailRepository.insertCus(d_pono.getText(), d_orderdate.getText(),d_supplier.getText(),d_contactname.getText(), d_contacttitle.getText(), d_requireddate.getText(), d_promiseddate.getText(),d_paymentdate.getText());

        } catch (SQLException e) {
            System.out.println("Problem occurred while inserting Customer " + e);
            throw e;
        }
    }
    private void fillReturnDetail(ActionEvent event) throws SQLException, ClassNotFoundException {
        Task<List<ReturnDetail>> task = new Task<List<ReturnDetail>>(){
            @Override
            public ObservableList<ReturnDetail> call() throws Exception{
                return DetailRepository.searchReturnDetail();
            }
        };
        task.setOnFailed(e-> task.getException().printStackTrace());
        task.setOnSucceeded(e-> ReturnDetailTable.setItems((ObservableList<ReturnDetail>) task.getValue()));
        exec.execute(task);
    }
    @FXML
    private void populateDetail (ReturnDetail rd) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<ReturnDetail> resData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        resData.add(rd);
        //Set items to the employeeTable
        ReturnDetailTable.setItems(resData);
    }

    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowDetail(ReturnDetail rd) throws ClassNotFoundException {
        if (rd != null) {
            populateDetail(rd);
        } else {
            System.out.println("This Detail does not exist!\n");
        }
    }
}
