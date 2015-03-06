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
public class Account implements Serializable{
    //declare member variables
    protected String IBANNum;
    protected String accountPurpose;
    protected String BICNum;
    protected String bankName;
    protected String bankAdd;
    protected String bankphone;
    protected String accType;
    protected String sig1;
    protected String sig2;
    protected String sig3;
    protected String sig4;
    protected String accNum;

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }
    
    //constructor
    public Account(){
        
    }

    public String getIBANNum() {
        return IBANNum;
    }

    public void setIBANNum(String IBANNum) {
        this.IBANNum = IBANNum;
    }

    public String getAccountPurpose() {
        return accountPurpose;
    }

    public void setAccountPurpose(String accountPurpose) {
        this.accountPurpose = accountPurpose;
    }

    public String getBICNum() {
        return BICNum;
    }

    public void setBICNum(String BICNum) {
        this.BICNum = BICNum;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAdd() {
        return bankAdd;
    }

    public void setBankAdd(String bankAdd) {
        this.bankAdd = bankAdd;
    }

    public String getBankphone() {
        return bankphone;
    }

    public void setBankphone(String bankphone) {
        this.bankphone = bankphone;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getSig1() {
        return sig1;
    }

    public void setSig1(String sig1) {
        this.sig1 = sig1;
    }

    public String getSig2() {
        return sig2;
    }

    public void setSig2(String sig2) {
        this.sig2 = sig2;
    }

    public String getSig3() {
        return sig3;
    }

    public void setSig3(String sig3) {
        this.sig3 = sig3;
    }

    public String getSig4() {
        return sig4;
    }

    public void setSig4(String sig4) {
        this.sig4 = sig4;
    }
    
    
}
