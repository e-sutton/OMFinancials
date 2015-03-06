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
public class UnitDetails implements Serializable{
    //declare member variables
    protected String unit;
    protected String unitAddress;
    protected String unitPhoneNum;
    protected String unitFax;
    protected String unitMobileNum;
    protected String unitEmail;
    
    //constructor
    public UnitDetails(){
        
    }
    
    //setters and Getters
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress;
    }

    public String getUnitPhoneNum() {
        return unitPhoneNum;
    }

    public void setUnitPhoneNum(String unitPhoneNum) {
        this.unitPhoneNum = unitPhoneNum;
    }

    public String getUnitFax() {
        return unitFax;
    }

    public void setUnitFax(String unitFax) {
        this.unitFax = unitFax;
    }

    public String getUnitMobileNum() {
        return unitMobileNum;
    }

    public void setUnitMobileNum(String unitMobileNum) {
        this.unitMobileNum = unitMobileNum;
    }

    public String getUnitEmail() {
        return unitEmail;
    }

    public void setUnitEmail(String unitEmail) {
        this.unitEmail = unitEmail;
    }
    
    
            
   
    
}
