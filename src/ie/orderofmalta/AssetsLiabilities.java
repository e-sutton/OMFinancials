/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ie.orderofmalta;
import java.io.Serializable;

/**
 *
 * @author admin
 */
public class AssetsLiabilities implements Serializable{
    //declare member variables
    protected double bankOpenBal;
    protected double bankCloseBal;
    protected double creditOpenBal;
    protected double creditCloseBal;
    protected double postOpenBal;
    protected double postCloseBal;
    protected double coh;
    protected double vehicleVal;
    protected double buildingVal;
    protected double equipVal;
    protected double overdrawn;
    protected double loan;
    protected String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    //Constructor
    public AssetsLiabilities(){
        
    }

    public double getBankOpenBal() {
        return bankOpenBal;
    }

    public void setBankOpenBal(double bankOpenBal) {
        this.bankOpenBal = bankOpenBal;
    }

    public double getBankCloseBal() {
        return bankCloseBal;
    }

    public void setBankCloseBal(double bankCloseBal) {
        this.bankCloseBal = bankCloseBal;
    }

    public double getCreditOpenBal() {
        return creditOpenBal;
    }

    public void setCreditOpenBal(double creditOpenBal) {
        this.creditOpenBal = creditOpenBal;
    }

    public double getCreditCloseBal() {
        return creditCloseBal;
    }

    public void setCreditCloseBal(double creditCloseBal) {
        this.creditCloseBal = creditCloseBal;
    }

    public double getPostOpenBal() {
        return postOpenBal;
    }

    public void setPostOpenBal(double postOpenBal) {
        this.postOpenBal = postOpenBal;
    }

    public double getPostCloseBal() {
        return postCloseBal;
    }

    public void setPostCloseBal(double postCloseBal) {
        this.postCloseBal = postCloseBal;
    }

    public double getCoh() {
        return coh;
    }

    public void setCoh(double coh) {
        this.coh = coh;
    }

    public double getVehicleVal() {
        return vehicleVal;
    }

    public void setVehicleVal(double vehicleVal) {
        this.vehicleVal = vehicleVal;
    }

    public double getBuildingVal() {
        return buildingVal;
    }

    public void setBuildingVal(double buildingVal) {
        this.buildingVal = buildingVal;
    }

    public double getEquipVal() {
        return equipVal;
    }

    public void setEquipVal(double equipVal) {
        this.equipVal = equipVal;
    }

    public double getOverdrawn() {
        return overdrawn;
    }

    public void setOverdrawn(double overdrawn) {
        this.overdrawn = overdrawn;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    
    
    
}
