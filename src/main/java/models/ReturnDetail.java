package models;

import javafx.beans.property.*;

public class ReturnDetail {

    private IntegerProperty PurchaseReturnDetailID;
    private IntegerProperty PurchaseReturnID;
    private IntegerProperty POLineNumber;
    private IntegerProperty ItemID;
    private StringProperty ManufacturerPartNo;
    private StringProperty Uom;
    private FloatProperty OrderQty;
    private FloatProperty UnitPrice;
    private FloatProperty NetAmount;
    private StringProperty Description;

    public ReturnDetail() {
        this.PurchaseReturnDetailID = new SimpleIntegerProperty();
        this.PurchaseReturnID = new SimpleIntegerProperty();
        this.POLineNumber = new SimpleIntegerProperty();
        this.ItemID = new SimpleIntegerProperty();
        this.ManufacturerPartNo = new SimpleStringProperty();
        this.Uom = new SimpleStringProperty();
        this.OrderQty = new SimpleFloatProperty();
        this.UnitPrice = new SimpleFloatProperty();
        this.NetAmount = new SimpleFloatProperty();
        this.Description = new SimpleStringProperty();
    }

    public int getPurchaseReturnDetailID () {return PurchaseReturnDetailID.get();}
    public void setPurchaseReturnDetailID (int PurchaseReturnDetailID) {this.PurchaseReturnDetailID.set(PurchaseReturnDetailID);}
    public IntegerProperty PurchaseReturnDetailIDProperty(){ return PurchaseReturnDetailID;}

    public int getPurchaseReturnID () {return PurchaseReturnID.get();}
    public void setPurchaseReturnID (int PurchaseReturnID) {this.PurchaseReturnID.set(PurchaseReturnID);}
    public IntegerProperty PurchaseReturnIDProperty(){ return PurchaseReturnID;}

    public int getPOLineNumber () {return POLineNumber.get();}
    public void setPOLineNumber (int POLineNumber) {this.POLineNumber.set(POLineNumber);}
    public IntegerProperty POLineNumberProperty(){ return POLineNumber;}

    public int getItemID () {return ItemID.get();}
    public void setItemID (int ItemID) {this.ItemID.set(ItemID);}
    public IntegerProperty ItemIDProperty(){ return ItemID;}

    public String getManufacturerPartNo() {return ManufacturerPartNo.get();}
    public void setManufacturerPartNo(String ManufacturerPartNo){this.ManufacturerPartNo.set(ManufacturerPartNo);}
    public StringProperty ManufacturerPartNoProperty() { return ManufacturerPartNo; }

    public String getUom() {return Uom.get();}
    public void setUom(String Uom){this.Uom.set(Uom);}
    public StringProperty UomProperty() { return Uom; }

    public float getOrderQty () {return OrderQty.get();}
    public void setOrderQty (float OrderQty) {this.OrderQty.set(OrderQty);}
    public FloatProperty OrderQtyProperty(){ return OrderQty;}

    public float getUnitPrice () {return UnitPrice.get();}
    public void setUnitPrice (float UnitPrice) {this.UnitPrice.set(UnitPrice);}
    public FloatProperty UnitPriceProperty(){ return UnitPrice;}

    public float getNetAmount () {return NetAmount.get();}
    public void setNetAmount (float NetAmount) {this.NetAmount.set(NetAmount);}
    public FloatProperty NetAmountProperty(){ return NetAmount;}

    public String getDescription() {return Description.get();}
    public void setDescription(String Description){this.Description.set(Description);}
    public StringProperty DescriptionProperty() { return Description; }
}