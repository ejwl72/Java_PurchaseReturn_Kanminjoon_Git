package models;

import javafx.beans.property.*;

public class ReturnSearch {

    private IntegerProperty PurchaseReturnID;
    private IntegerProperty PurchaseOrderID;
    private IntegerProperty SuppilerID;
    private StringProperty ContactName;
    private StringProperty ContactTitle;
    private StringProperty Remarks;
    private StringProperty ShipMethod;
    private DoubleProperty NetAmount;
    private IntegerProperty CreatedBy;
    private StringProperty CreatedOn;///??????????????????????????
    private IntegerProperty LastUpdateBy;
    private StringProperty LastUpdateOn; /////??????????????????
    private StringProperty Status;
    private StringProperty StatusDate; ////////??????????????????
    private IntegerProperty FinalizedBy;
    private StringProperty FinalizedOn; //////////????????????????
    private StringProperty OrderDate;

    public ReturnSearch() {
            this.PurchaseReturnID = new SimpleIntegerProperty();
            this.PurchaseOrderID = new SimpleIntegerProperty();
            this.SuppilerID = new SimpleIntegerProperty();
            this.ContactName = new SimpleStringProperty();
            this.ContactTitle = new SimpleStringProperty();
            this.Remarks = new SimpleStringProperty();
            this.ShipMethod = new SimpleStringProperty();
            this.NetAmount = new SimpleDoubleProperty();
            this.CreatedBy = new SimpleIntegerProperty();
            this.CreatedOn = new SimpleStringProperty();
            this.LastUpdateBy = new SimpleIntegerProperty();
            this.LastUpdateOn = new SimpleStringProperty();
            this.Status = new SimpleStringProperty();
            this.StatusDate = new SimpleStringProperty();
            this.FinalizedBy = new SimpleIntegerProperty();
            this.FinalizedOn = new SimpleStringProperty();
            this.OrderDate = new SimpleStringProperty();
    }

    public int getPurchaseReturnID () {return PurchaseReturnID.get();}
    public void setPurchaseReturnID (int PurchaseReturnID) {this.PurchaseReturnID.set(PurchaseReturnID);}
    public IntegerProperty PurchaseReturnIDProperty(){
        return PurchaseReturnID;
    }

    public int getPurchaseOrderID () {return PurchaseOrderID.get();}
    public void setPurchaseOrderID (int PurchaseOrderID) {this.PurchaseOrderID.set(PurchaseOrderID);}
    public IntegerProperty PurchaseOrderIDProperty(){ return PurchaseOrderID;}

    public int getSuppilerID () {return SuppilerID.get();}
    public void setSuppilerID (int SuppilerID) {this.SuppilerID.set(SuppilerID);}
    public IntegerProperty SuppilerIDProperty(){ return SuppilerID;}

    public String getContactName() {return ContactName.get();}
    public void setContactName(String ContactName){this.ContactName.set(ContactName);}
    public StringProperty ContactNameProperty() {
        return ContactName;
    }

    public String getContactTitle() {return ContactTitle.get();}
    public void setContactTitle(String ContactTitle){this.ContactTitle.set(ContactTitle);}
    public StringProperty ContactTitleProperty() { return ContactTitle; }

    public String getRemarks() {return Remarks.get();}
    public void setRemarks(String Remarks){this.Remarks.set(Remarks);}
    public StringProperty RemarksProperty() { return Remarks; }

    public String getShipMethod() {return ShipMethod.get();}
    public void setShipMethod(String ShipMethod){this.ShipMethod.set(ShipMethod);}
    public StringProperty ShipMethodProperty() { return ShipMethod; }

    public double getNetAmount () {return NetAmount.get();}
    public void setNetAmount (double NetAmount) {this.NetAmount.set(NetAmount);}
    public DoubleProperty NetAmountProperty(){ return NetAmount;}

    public int getCreatedBy () {return CreatedBy.get();}
    public void setCreatedBy (int CreatedBy) {this.CreatedBy.set(CreatedBy);}
    public IntegerProperty CreatedByProperty(){ return CreatedBy;}

    public String getCreatedOn() {return CreatedOn.get();}
    public void setCreatedOn(String CreatedOn){this.CreatedOn.set(CreatedOn);}
    public StringProperty CreatedOnProperty() { return CreatedOn; }

    public int getLastUpdateBy () {return LastUpdateBy.get();}
    public void setLastUpdateBy (int LastUpdateBy) {this.LastUpdateBy.set(LastUpdateBy);}
    public IntegerProperty LastUpdateByProperty(){ return LastUpdateBy;}

    public String getLastUpdateOn() {return LastUpdateOn.get();}
    public void setLastUpdateOn(String LastUpdateOn){this.LastUpdateOn.set(LastUpdateOn);}
    public StringProperty LastUpdateOnProperty() { return LastUpdateOn; }

    public String getStatus() {return Status.get();}
    public void setStatus(String Status){this.Status.set(Status);}
    public StringProperty StatusProperty() { return Status; }

    public String getStatusDate() {return StatusDate.get();}
    public void setStatusDate(String StatusDate){this.StatusDate.set(StatusDate);}
    public StringProperty StatusDateProperty() { return StatusDate; }

    public int getFinalizedBy () {return FinalizedBy.get();}
    public void setFinalizedBy (int FinalizedBy) {this.FinalizedBy.set(FinalizedBy);}
    public IntegerProperty FinalizedByProperty(){ return FinalizedBy;}

    public String getFinalizedOn() {return FinalizedOn.get();}
    public void setFinalizedOn(String FinalizedOn){this.FinalizedOn.set(FinalizedOn);}
    public StringProperty FinalizedOnProperty() { return FinalizedOn; }

    public String getOrderDate() {return OrderDate.get();}
    public void setOrderDate(String OrderDate){this.OrderDate.set(OrderDate);}
    public StringProperty OrderDateProperty() { return OrderDate; }
}