/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.orderofmalta;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.joda.time.DateTime;

/**
 *
 * @author admin
 */
public class Calculations implements Serializable {

    //declare data members
    DateTime dt = new DateTime();
    int month = dt.getMonthOfYear();
     SimpleDateFormat formatter;   
     String today; 
    DecimalFormat df = new DecimalFormat("#.00");    
    private double amt[] = new double[100];
    private String cat[] = new String[100];
    private String date[] = new String[100];
    private String note[] = new String[100];
    private double amtTotal;
    //Receipts posted variables
    public double bankIntReceived, basicFA, cadetInc, cfrClasses, churchGate, comps, comCare, charityDonations, dutyDonations, unitsDonations,
            otherVolDonations, flagDays, grantsHSE, grantsLocalAuth, grantsLottery, grantsVEC, grantsOther, membersSub, occupFAClasses, otherClasses,
            otherFundraising, pilgrimages, rentReceived, saleOfAmbo, sundry, supermarket, receiptsTotal;
    //Payments posted variables
    public double amboEmerEquip, amboFAEquip, amboMaint, amboNewVeh, bankCharges, bankInt, bankLoan, cadetExp, comCatering, comMaint, comServ, comOutings, coursesFA, coursesOFA,
            donationsOtherUnit, donationsOtherVol, fundraisingExp, hqFund, hqCerts, hqIns, hqPilgrimages, hqSupplies, hqTraining, hqUniforms, regionalFund, regionalMeetExp,
            regionalTrainExp, sundry2, unitComps, unitLightHeat, unitConfExp, unitPetrolDiesel, unitStationary, unitRent, unitPropRepair, unitTel, unitTrainCourses, unitTrainEquip,
            clearedPaymentsTotal;
    //Uncleared Receipts variables
    public double unrecBankIntReceived, unrecBasicFA, unrecCadetInc, unrecCfrClasses, unrecChurchGate, unrecComps, unrecComCare, unrecCharityDonations, unrecDutyDonations, unrecUnitsDonations,
            unrecOtherVolDonations, unrecFlagDays, unrecGrantsHSE, unrecGrantsLocalAuth, unrecGrantsLottery, unrecGrantsVEC, unrecGrantsOther, unrecMembersSub, unrecOccupFAClasses,
            unrecOtherClasses, unrecOtherFundraising, unrecPilgrimages, unrecRentReceived, unrecSaleOfAmbo, unrecSundry, unrecSupermarket, unclearedReceiptsTotal;
    //Uncleared Payments variables
    public double unpayAmboEmerEquip, unpayAmboFAEquip, unpayAmboMaint, unpayAmboNewVeh, unpayBankCharges, unpayBankInt, unpayBankLoan, unpayCadetExp, unpayComCatering, unpayComMaint,
            unpayComServ, unpayComOutings, unpayCoursesFA, unpayCoursesOFA,
            unpayDonationsOtherUnit, unpayDonationsOtherVol, unpayFundraisingExp, unpayHqFund, unpayHqCerts, unpayHqIns, unpayHqPilgrimages, unpayHqSupplies, unpayHqTraining,
            unpayHqUniforms, unpayRegionalFund, unpayRegionalMeetExp,
            unpayRegionalTrainExp, unpaySundry2, unpayUnitComps, unpayUnitLightHeat, unpayUnitConfExp, unpayUnitPetrolDiesel, unpayUnitStationary, unpayUnitRent,
            unpayUnitPropRepair, unpayUnitTel, unpayUnitTrainCourses, unpayUnitTrainEquip, unclearedPaymentsTotal;
    public double over1k[] = new double [100];
    public String over1kDate[] = new String[100];
    public String over1kNote[] = new String[100];
    public String over1kCat[] = new String[100];
    public double sundryInc[] = new double[100];
    public double sundryExp[] = new double[100];
    public String sundryIncDate[] = new String [100];
    public String sundryIncCat[] = new String [100];
    public String sundryIncNote[] = new String [100];
    public String sundryExpDate[] = new String [100];
    public String sundryExpCat[] = new String [100];
    public String sundryExpNote[] = new String [100];
    private String unit;
    private String category;
    private double acBalance, finalTotal, over1kTotal, sundryIncTotal, sundryExpTotal;
    private ArrayList<Receipts> rec;
    private ArrayList<Payments> pay;
    private ArrayList<Receipts> uncleared;
    private ArrayList<Payments> uncleared1;
    private ArrayList<Double> amount;
    private ArrayList<String> cat1;
    private ArrayList<String> note1;
    private ArrayList<String> date1;

    //constructor
    public Calculations() {
        formatter = new SimpleDateFormat("yyyy");
        today = formatter.format(new java.util.Date());
        rec = new ArrayList<Receipts>();
        pay = new ArrayList<Payments>();
        uncleared = new ArrayList<Receipts>();
        uncleared1 = new ArrayList<Payments>();
        amount = new ArrayList<Double>();
        cat1 = new ArrayList<String>();
        note1 = new ArrayList<String>();
        date1 = new ArrayList<String>();
        category = "";
        loadReceipts();
        bankIntReceived = calcReceipts("Bank Interest Received");
        basicFA = calcReceipts("Basic First Aid Classes");
        cadetInc = calcReceipts("Cadet Unit Income");
        cfrClasses = calcReceipts("CFR Classes");
        churchGate = calcReceipts("Church Gate & House to House");
        comps = calcReceipts("Competitions");
        comCare = calcReceipts("Community Care - Center Donations");
        charityDonations = calcReceipts("Donations - Charitable");
        dutyDonations = calcReceipts("Donations - Dutys");
        unitsDonations = calcReceipts("Donations from other Units/Regions");
        otherVolDonations = calcReceipts("Donations from other voluntary aid societies");
        flagDays = calcReceipts("Flag Days");
        grantsHSE = calcReceipts("Grants - HSE");
        grantsLocalAuth = calcReceipts("Grants - Local Authority");
        grantsLottery = calcReceipts("Grants - National Lottery");
        grantsVEC = calcReceipts("Grants - V.E.C.");
        grantsOther = calcReceipts("Grants - Other");
        membersSub = calcReceipts("Members Subscriptions");
        occupFAClasses = calcReceipts("Occupational First Aid Classes");
        otherClasses = calcReceipts("Other Classes");
        otherFundraising = calcReceipts("Other Fundraising (specify)");
        pilgrimages = calcReceipts("Pilgrimages");
        rentReceived = calcReceipts("Rent Received");
        saleOfAmbo = calcReceipts("Sale of Ambulance");
        sundry = calcReceipts("Sundry*");
        supermarket = calcReceipts("Supermarket Bag Packing");
        receiptsTotal = bankIntReceived + basicFA + cadetInc + cfrClasses + churchGate + comps + comCare + charityDonations + dutyDonations + unitsDonations
                + otherVolDonations + flagDays + grantsHSE + grantsLocalAuth + grantsLottery + grantsVEC + grantsOther + membersSub + occupFAClasses + otherClasses
                + otherFundraising + pilgrimages + rentReceived + saleOfAmbo + sundry + supermarket;
        //load uncleared receipts
        loadUnclearedReceipts();
        unrecBankIntReceived = calcReceipts("Bank Interest Received");
        unrecBasicFA = calcReceipts("Basic First Aid Classes");
        unrecCadetInc = calcReceipts("Cadet Unit Income");
        unrecCfrClasses = calcReceipts("CFR Classes");
        unrecChurchGate = calcReceipts("Church Gate & House to House");
        unrecComps = calcReceipts("Competitions");
        unrecComCare = calcReceipts("Community Care - Center Donations");
        unrecCharityDonations = calcReceipts("Donations - Charitable");
        unrecDutyDonations = calcReceipts("Donations - Dutys");
        unrecUnitsDonations = calcReceipts("Donations from other Units/Regions");
        unrecOtherVolDonations = calcReceipts("Donations from other voluntary aid societies");
        unrecFlagDays = calcReceipts("Flag Days");
        unrecGrantsHSE = calcReceipts("Grants - HSE");
        unrecGrantsLocalAuth = calcReceipts("Grants - Local Authority");
        unrecGrantsLottery = calcReceipts("Grants - National Lottery");
        unrecGrantsVEC = calcReceipts("Grants - V.E.C.");
        unrecGrantsOther = calcReceipts("Grants - Other");
        unrecMembersSub = calcReceipts("Members Subscriptions");
        unrecOccupFAClasses = calcReceipts("Occupational First Aid Classes");
        unrecOtherClasses = calcReceipts("Other Classes");
        unrecOtherFundraising = calcReceipts("Other Fundraising (specify)");
        unrecPilgrimages = calcReceipts("Pilgrimages");
        unrecRentReceived = calcReceipts("Rent Received");
        unrecSaleOfAmbo = calcReceipts("Sale of Ambulance");
        unrecSundry = calcReceipts("Sundry*");
        unrecSupermarket = calcReceipts("Supermarket Bag Packing");
        unclearedReceiptsTotal = unrecBankIntReceived + unrecBasicFA + unrecCadetInc + unrecCfrClasses + unrecChurchGate + unrecComps + unrecComCare + unrecCharityDonations + unrecDutyDonations + unrecUnitsDonations
                + unrecOtherVolDonations + unrecFlagDays + unrecGrantsHSE + unrecGrantsLocalAuth + unrecGrantsLottery + unrecGrantsVEC + unrecGrantsOther + unrecMembersSub + unrecOccupFAClasses
                + unrecOtherClasses + unrecOtherFundraising + unrecPilgrimages + unrecRentReceived + unrecSaleOfAmbo + unrecSundry + unrecSupermarket;
        //load payments calcs
        loadPayments();
        amboEmerEquip = calcPayments("Ambulance - Emergency Equipment");
        amboFAEquip = calcPayments("Ambulance - First Aid Equipment");
        amboMaint = calcPayments("Ambulance - Maintenance");
        amboNewVeh = calcPayments("Ambulance - New Vehicle Purchase");
        bankCharges = calcPayments("Bank - Charges");
        bankInt = calcPayments("Bank - Interest Payable");
        bankLoan = calcPayments("Bank - Loan Repayments");
        cadetExp = calcPayments("Cadet - Unit Expenses");
        comCatering = calcPayments("Community Care - Catering");
        comMaint = calcPayments("Community Care - Center Maintenance/Upkeep");
        comServ = calcPayments("Community Care - Center Services");
        comOutings = calcPayments("Community Care - Outings");
        coursesFA = calcPayments("Courses - First Aid Classes Expenses");
        coursesOFA = calcPayments("Courses - OFA Instructor Expenses");
        donationsOtherUnit = calcPayments("Donations - to other Units/Regions");
        donationsOtherVol = calcPayments("Donations - to other Voluntary Aid Societies");
        fundraisingExp = calcPayments("Fundraising - Expenses");
        hqFund = calcPayments("HQ - Central Fund");
        hqCerts = calcPayments("HQ - First Aid Certificates (All)");
        hqIns = calcPayments("HQ - Insurance (All)");
        hqPilgrimages = calcPayments("HQ - Pilgrimages");
        hqSupplies = calcPayments("HQ - Supplies (Books)");
        hqTraining = calcPayments("HQ - Training Courses");
        hqUniforms = calcPayments("HQ - Uniforms (All)");
        regionalFund = calcPayments("Regional - Central Fund");
        regionalMeetExp = calcPayments("Regional - Meeting Expenses");
        regionalTrainExp = calcPayments("Regional - Training Courses");
        sundry2 = calcPayments("Sundry*");
        unitComps = calcPayments("Unit - Competitions Expenses");
        unitLightHeat = calcPayments("Unit - Light & Heat");
        unitConfExp = calcPayments("Unit - National Conference Expenses");
        unitPetrolDiesel = calcPayments("Unit - Petrol/Diesel");
        unitStationary = calcPayments("Unit - Postage & Stationary");
        unitRent = calcPayments("Unit - Rent Payable");
        unitPropRepair = calcPayments("Unit - Repair to Property");
        unitTel = calcPayments("Unit - Telephone");
        unitTrainCourses = calcPayments("Unit - Training Courses");
        unitTrainEquip = calcPayments("Unit - Training Equipment");
        clearedPaymentsTotal = amboEmerEquip + amboFAEquip + amboMaint + amboNewVeh + bankCharges + bankInt + bankLoan + cadetExp + comCatering + comMaint + comServ + comOutings + coursesFA + coursesOFA
                + donationsOtherUnit + donationsOtherVol + fundraisingExp + hqFund + hqCerts + hqIns + hqPilgrimages + hqSupplies + hqTraining + hqUniforms + regionalFund + regionalMeetExp
                + regionalTrainExp + sundry2 + unitComps + unitLightHeat + unitConfExp + unitPetrolDiesel + unitStationary + unitRent + unitPropRepair + unitTel + unitTrainCourses + unitTrainEquip;
        //load Uncleared Payments
        loadUnclearedPayments();
        unpayAmboEmerEquip = calcPayments("Ambulance - Emergency Equipment");
        unpayAmboFAEquip = calcPayments("Ambulance - First Aid Equipment");
        unpayAmboMaint = calcPayments("Ambulance - Maintenance");
        unpayAmboNewVeh = calcPayments("Ambulance - New Vehicle Purchase");
        unpayBankCharges = calcPayments("Bank - Charges");
        unpayBankInt = calcPayments("Bank - Interest Payable");
        unpayBankLoan = calcPayments("Bank - Loan Repayments");
        unpayCadetExp = calcPayments("Cadet - Unit Expenses");
        unpayComCatering = calcPayments("Community Care - Catering");
        unpayComMaint = calcPayments("Community Care - Center Maintenance/Upkeep");
        unpayComServ = calcPayments("Community Care - Center Services");
        unpayComOutings = calcPayments("Community Care - Outings");
        unpayCoursesFA = calcPayments("Courses - First Aid Classes Expenses");
        unpayCoursesOFA = calcPayments("Courses - OFA Instructor Expenses");
        unpayDonationsOtherUnit = calcPayments("Donations - to other Units/Regions");
        unpayDonationsOtherVol = calcPayments("Donations - to other Voluntary Aid Societies");
        unpayFundraisingExp = calcPayments("Fundraising - Expenses");
        unpayHqFund = calcPayments("HQ - Central Fund");
        unpayHqCerts = calcPayments("HQ - First Aid Certificates (All)");
        unpayHqIns = calcPayments("HQ - Insurance (All)");
        unpayHqPilgrimages = calcPayments("HQ - Pilgrimages");
        unpayHqSupplies = calcPayments("HQ - Supplies (Books)");
        unpayHqTraining = calcPayments("HQ - Training Courses");
        unpayHqUniforms = calcPayments("HQ - Uniforms (All)");
        unpayRegionalFund = calcPayments("Regional - Central Fund");
        unpayRegionalMeetExp = calcPayments("Regional - Meeting Expenses");
        unpayRegionalTrainExp = calcPayments("Regional - Training Courses");
        unpaySundry2 = calcPayments("Sundry*");
        unpayUnitComps = calcPayments("Unit - Competitions Expenses");
        unpayUnitLightHeat = calcPayments("Unit - Light & Heat");
        unpayUnitConfExp = calcPayments("Unit - National Conference Expenses");
        unpayUnitPetrolDiesel = calcPayments("Unit - Petrol/Diesel");
        unpayUnitStationary = calcPayments("Unit - Postage & Stationary");
        unpayUnitRent = calcPayments("Unit - Rent Payable");
        unpayUnitPropRepair = calcPayments("Unit - Repair to Property");
        unpayUnitTel = calcPayments("Unit - Telephone");
        unpayUnitTrainCourses = calcPayments("Unit - Training Courses");
        unpayUnitTrainEquip = calcPayments("Unit - Training Equipment");
        unclearedPaymentsTotal = unpayAmboEmerEquip + unpayAmboFAEquip + unpayAmboMaint + unpayAmboNewVeh + unpayBankCharges + unpayBankInt + unpayBankLoan + unpayCadetExp + unpayComCatering + unpayComMaint
                + unpayComServ + unpayComOutings + unpayCoursesFA + unpayCoursesOFA
                + unpayDonationsOtherUnit + unpayDonationsOtherVol + unpayFundraisingExp + unpayHqFund + unpayHqCerts + unpayHqIns + unpayHqPilgrimages + unpayHqSupplies + unpayHqTraining
                + unpayHqUniforms + unpayRegionalFund + unpayRegionalMeetExp
                + unpayRegionalTrainExp + unpaySundry2 + unpayUnitComps + unpayUnitLightHeat + unpayUnitConfExp + unpayUnitPetrolDiesel + unpayUnitStationary + unpayUnitRent
                + unpayUnitPropRepair + unpayUnitTel + unpayUnitTrainCourses + unpayUnitTrainEquip;

        loadUnitDetails();
        loadAssetsLiabilities();
        finalTotal = acBalance + ((unclearedReceiptsTotal + receiptsTotal) - (clearedPaymentsTotal + unclearedPaymentsTotal));
        loadExpOver1k();
        loadIncomeSundrys();
        loadExpSundrys();
    }
    
    public void setArraystoZero(){
         //set values in amt,cat, note and date arrays to 0.0 up to 8, so first 7 values will show in pg2 of report
        for(int i = 0; i <amt.length; i++){
            amt[i] = 0.0;
            cat[i] = "";
            date[i] = "";
            note[i] = "";
        }
    }

    public double getFinalTotal() {
        return Double.valueOf(df.format(finalTotal));
    }

    public double getUnrecBankIntReceived() {
        return Double.valueOf(df.format(unrecBankIntReceived));
    }

    public double getUnrecBasicFA() {
        return Double.valueOf(df.format(unrecBasicFA));
    }

    public double getUnrecCadetInc() {
        return Double.valueOf(df.format(unrecCadetInc));
    }

    public double getUnrecCfrClasses() {
        return Double.valueOf(df.format(unrecCfrClasses));
    }

    public double getUnrecChurchGate() {
        return Double.valueOf(df.format(unrecChurchGate));
    }

    public double getUnrecComps() {
        return Double.valueOf(df.format(unrecComps));
    }

    public double getUnrecComCare() {
        return Double.valueOf(df.format(unrecComCare));
    }

    public double getUnrecCharityDonations() {
        return Double.valueOf(df.format(unrecCharityDonations));
    }

    public double getUnrecDutyDonations() {
        return Double.valueOf(df.format(unrecDutyDonations));
    }

    public double getUnrecUnitsDonations() {
        return Double.valueOf(df.format(unrecUnitsDonations));
    }

    public double getUnrecOtherVolDonations() {
        return Double.valueOf(df.format(unrecOtherVolDonations));
    }

    public double getUnrecFlagDays() {
        return Double.valueOf(df.format(unrecFlagDays));
    }

    public double getUnrecGrantsHSE() {
        return Double.valueOf(df.format(unrecGrantsHSE));
    }

    public double getUnrecGrantsLocalAuth() {
        return Double.valueOf(df.format(unrecGrantsLocalAuth));
    }

    public double getUnrecGrantsLottery() {
        return Double.valueOf(df.format(unrecGrantsLottery));
    }

    public double getUnrecGrantsVEC() {
        return Double.valueOf(df.format(unrecGrantsVEC));
    }

    public double getUnrecGrantsOther() {
        return Double.valueOf(df.format(unrecGrantsOther));
    }

    public double getUnrecMembersSub() {
        return Double.valueOf(df.format(unrecMembersSub));
    }

    public double getUnrecOccupFAClasses() {
        return Double.valueOf(df.format(unrecOccupFAClasses));
    }

    public double getUnrecOtherClasses() {
        return Double.valueOf(df.format(unrecOtherClasses));
    }

    public double getUnrecOtherFundraising() {
        return Double.valueOf(df.format(unrecOtherFundraising));
    }

    public double getUnrecPilgrimages() {
        return Double.valueOf(df.format(unrecPilgrimages));
    }

    public double getUnrecRentReceived() {
        return Double.valueOf(df.format(unrecRentReceived));
    }

    public double getUnrecSaleOfAmbo() {
        return Double.valueOf(df.format(unrecSaleOfAmbo));
    }

    public double getUnrecSundry() {
        return Double.valueOf(df.format(unrecSundry));
    }

    public double getUnrecSupermarket() {
        return Double.valueOf(df.format(unrecSupermarket));
    }

    public double getUnclearedReceiptsTotal() {
        return Double.valueOf(df.format(unclearedReceiptsTotal));
    }

    public double getUnpayAmboEmerEquip() {
        return Double.valueOf(df.format(unpayAmboEmerEquip));
    }

    public double getUnpayAmboFAEquip() {
        return Double.valueOf(df.format(unpayAmboFAEquip));
    }

    public double getUnpayAmboMaint() {
        return Double.valueOf(df.format(unpayAmboMaint));
    }

    public double getUnpayAmboNewVeh() {
        return Double.valueOf(df.format(unpayAmboNewVeh));
    }

    public double getUnpayBankCharges() {
        return Double.valueOf(df.format(unpayBankCharges));
    }

    public double getUnpayBankInt() {
        return Double.valueOf(df.format(unpayBankInt));
    }

    public double getUnpayBankLoan() {
        return Double.valueOf(df.format(unpayBankLoan));
    }

    public double getUnpayCadetExp() {
        return Double.valueOf(df.format(unpayCadetExp));
    }

    public double getUnpayComCatering() {
        return Double.valueOf(df.format(unpayComCatering));
    }

    public double getUnpayComMaint() {
        return Double.valueOf(df.format(unpayComMaint));
    }

    public double getUnpayComServ() {
        return Double.valueOf(df.format(unpayComServ));
    }

    public double getUnpayComOutings() {
        return Double.valueOf(df.format(unpayComOutings));
    }

    public double getUnpayCoursesFA() {
        return Double.valueOf(df.format(unpayCoursesFA));
    }

    public double getUnpayCoursesOFA() {
        return Double.valueOf(df.format(unpayCoursesOFA));
    }

    public double getUnpayDonationsOtherUnit() {
        return Double.valueOf(df.format(unpayDonationsOtherUnit));
    }

    public double getUnpayDonationsOtherVol() {
        return Double.valueOf(df.format(unpayDonationsOtherVol));
    }

    public double getUnpayFundraisingExp() {
        return Double.valueOf(df.format(unpayFundraisingExp));
    }

    public double getUnpayHqFund() {
        return Double.valueOf(df.format(unpayHqFund));
    }

    public double getUnpayHqCerts() {
        return Double.valueOf(df.format(unpayHqCerts));
    }

    public double getUnpayHqIns() {
        return Double.valueOf(df.format(unpayHqIns));
    }

    public double getUnpayHqPilgrimages() {
        return Double.valueOf(df.format(unpayHqPilgrimages));
    }

    public double getUnpayHqSupplies() {
        return Double.valueOf(df.format(unpayHqSupplies));
    }

    public double getUnpayHqTraining() {
        return Double.valueOf(df.format(unpayHqTraining));
    }

    public double getUnpayHqUniforms() {
        return Double.valueOf(df.format(unpayHqUniforms));
    }

    public double getUnpayRegionalFund() {
        return Double.valueOf(df.format(unpayRegionalFund));
    }

    public double getUnpayRegionalMeetExp() {
        return Double.valueOf(df.format(unpayRegionalMeetExp));
    }

    public double getUnpayRegionalTrainExp() {
        return Double.valueOf(df.format(unpayRegionalTrainExp));
    }

    public double getUnpaySundry2() {
        return Double.valueOf(df.format(unpaySundry2));
    }

    public double getUnpayUnitComps() {
        return Double.valueOf(df.format(unpayUnitComps));
    }

    public double getUnpayUnitLightHeat() {
        return Double.valueOf(df.format(unpayUnitLightHeat));
    }

    public double getUnpayUnitConfExp() {
        return Double.valueOf(df.format(unpayUnitConfExp));
    }

    public double getUnpayUnitPetrolDiesel() {
        return Double.valueOf(df.format(unpayUnitPetrolDiesel));
    }

    public double getUnpayUnitStationary() {
        return Double.valueOf(df.format(unpayUnitStationary));
    }

    public double getUnpayUnitRent() {
        return Double.valueOf(df.format(unpayUnitRent));
    }

    public double getUnpayUnitPropRepair() {
        return Double.valueOf(df.format(unpayUnitPropRepair));
    }

    public double getUnpayUnitTel() {
        return Double.valueOf(df.format(unpayUnitTel));
    }

    public double getUnpayUnitTrainCourses() {
        return Double.valueOf(df.format(unpayUnitTrainCourses));
    }

    public double getUnpayUnitTrainEquip() {
        return Double.valueOf(df.format(unpayUnitTrainEquip));
    }

    public double getUnclearedPaymentsTotal() {
        return Double.valueOf(df.format(unclearedPaymentsTotal));
    }

    //NewBean bean = new NewBean();
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    //payments getters
    public double getAmboEmerEquip() {
        return Double.valueOf(df.format(amboEmerEquip));
    }

    public double getAmboFAEquip() {
        return Double.valueOf(df.format(amboFAEquip));
    }

    public double getAmboMaint() {
        return Double.valueOf(df.format(amboMaint));
    }

    public double getAmboNewVeh() {
        return Double.valueOf(df.format(amboNewVeh));
    }

    public double getBankCharges() {
        return Double.valueOf(df.format(bankCharges));
    }

    public double getBankInt() {
        return Double.valueOf(df.format(bankInt));
    }

    public double getBankLoan() {
        return Double.valueOf(df.format(bankLoan));
    }

    public double getCadetExp() {
        return Double.valueOf(df.format(cadetExp));
    }

    public double getComCatering() {
        return Double.valueOf(df.format(comCatering));
    }

    public double getComMaint() {
        return Double.valueOf(df.format(comMaint));
    }

    public double getComServ() {
        return Double.valueOf(df.format(comServ));
    }

    public double getComOutings() {
        return Double.valueOf(df.format(comOutings));
    }

    public double getCoursesFA() {
        return Double.valueOf(df.format(coursesFA));
    }

    public double getCoursesOFA() {
        return Double.valueOf(df.format(coursesOFA));
    }

    public double getDonationsOtherUnit() {
        return Double.valueOf(df.format(donationsOtherUnit));
    }

    public double getDonationsOtherVol() {
        return Double.valueOf(df.format(donationsOtherVol));
    }

    public double getFundraisingExp() {
        return Double.valueOf(df.format(fundraisingExp));
    }

    public double getHqFund() {
        return Double.valueOf(df.format(hqFund));
    }

    public double getHqCerts() {
        return Double.valueOf(df.format(hqCerts));
    }

    public double getHqIns() {
        return Double.valueOf(df.format(hqIns));
    }

    public double getHqPilgrimages() {
        return Double.valueOf(df.format(hqPilgrimages));
    }

    public double getHqSupplies() {
        return Double.valueOf(df.format(hqSupplies));
    }

    public double getHqTraining() {
        return Double.valueOf(df.format(hqTraining));
    }

    public double getHqUniforms() {
        return Double.valueOf(df.format(hqUniforms));
    }

    public double getRegionalFund() {
        return Double.valueOf(df.format(regionalFund));
    }

    public double getRegionalMeetExp() {
        return Double.valueOf(df.format(regionalMeetExp));
    }

    public double getRegionalTrainExp() {
        return Double.valueOf(df.format(regionalTrainExp));
    }

    public double getSundry2() {
        return Double.valueOf(df.format(sundry2));
    }

    public double getUnitComps() {
        return Double.valueOf(df.format(unitComps));
    }

    public double getUnitLightHeat() {
        return Double.valueOf(df.format(unitLightHeat));
    }

    public double getUnitConfExp() {
        return Double.valueOf(df.format(unitConfExp));
    }

    public double getUnitPetrolDiesel() {
        return Double.valueOf(df.format(unitPetrolDiesel));
    }

    public double getUnitStationary() {
        return Double.valueOf(df.format(unitStationary));
    }

    public double getUnitRent() {
        return Double.valueOf(df.format(unitRent));
    }

    public double getUnitPropRepair() {
        return Double.valueOf(df.format(unitPropRepair));
    }

    public double getUnitTel() {
        return Double.valueOf(df.format(unitTel));
    }

    public double getUnitTrainCourses() {
        return Double.valueOf(df.format(unitTrainCourses));
    }

    public double getUnitTrainEquip() {
        return Double.valueOf(df.format(unitTrainEquip));
    }

    public double getClearedPaymentsTotal() {
        return Double.valueOf(df.format(clearedPaymentsTotal));
    }

   //receipts getters
    public double getReceiptsTotal() {
        return Double.valueOf(df.format(receiptsTotal));
    }

    public double getBasicFA() {
        return Double.valueOf(df.format(basicFA));
    }

    public double getCadetInc() {
        return Double.valueOf(df.format(cadetInc));
    }

    public double getCfrClasses() {
        return Double.valueOf(df.format(cfrClasses));
    }

    public double getChurchGate() {
        return Double.valueOf(df.format(churchGate));
    }

    public double getComps() {
        return Double.valueOf(df.format(comps));
    }

    public double getComCare() {
        return Double.valueOf(df.format(comCare));
    }

    public double getCharityDonations() {
        return Double.valueOf(df.format(charityDonations));
    }

    public double getDutyDonations() {
        return Double.valueOf(df.format(dutyDonations));
    }

    public double getUnitsDonations() {
        return Double.valueOf(df.format(unitsDonations));
    }

    public double getOtherVolDonations() {
        return Double.valueOf(df.format(otherVolDonations));
    }

    public double getFlagDays() {
        return Double.valueOf(df.format(flagDays));
    }

    public double getGrantsHSE() {
        return Double.valueOf(df.format(grantsHSE));
    }

    public double getGrantsLocalAuth() {
        return Double.valueOf(df.format(grantsLocalAuth));
    }

    public double getGrantsLottery() {
        return Double.valueOf(df.format(grantsLottery));
    }

    public double getGrantsVEC() {
        return Double.valueOf(df.format(grantsVEC));
    }

    public double getGrantsOther() {
        return Double.valueOf(df.format(grantsOther));
    }

    public double getMembersSub() {
        return Double.valueOf(df.format(membersSub));
    }

    public double getOccupFAClasses() {
        return Double.valueOf(df.format(occupFAClasses));
    }

    public double getOtherClasses() {
        return Double.valueOf(df.format(otherClasses));
    }

    public double getOtherFundraising() {
        return Double.valueOf(df.format(otherFundraising));
    }

    public double getPilgrimages() {
        return Double.valueOf(df.format(pilgrimages));
    }

    public double getRentReceived() {
        return Double.valueOf(df.format(rentReceived));
    }

    public double getSaleOfAmbo() {
        return Double.valueOf(df.format(saleOfAmbo));
    }

    public double getSundry() {
        return Double.valueOf(df.format(sundry));
    }

    public double getSupermarket() {
        return Double.valueOf(df.format(supermarket));
    }

    public String getCategory() {
        return category;
    }

    public double getBankIntReceived() {
        return Double.valueOf(df.format(bankIntReceived));
    }

    public double getAmtTotal() {
        return Double.valueOf(df.format(amtTotal));
    }

    public void setAmtTotal(double amtTotal) {
        this.amtTotal = amtTotal;
    }

    private void loadReceipts() {
        //setArraystoZero();
        
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("ReceiptsPosted.dat"));
            Receipts temp;
            //Receipts temp2;
            rec.clear();
            while (true) {
                temp = (Receipts) in.readObject();
                rec.add(temp);

                //String amount = Double.toString(temp.getAmount());
            }

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class Not Found Exception: " + e);
        } catch (EOFException ex) {
            //end of file exception will be thrown when end of file reached
            //do nothing with this exception
            //JOptionPane.showMessageDialog(null, "End of File Reached");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOError: " + e);
        }

        //loop through arraylist to get individual objects
        for (int i = 0; i < rec.size(); i++) {
            Receipts temp;
            temp = rec.get(i);
            String currentYear = temp.getDate().substring(temp.getDate().length()-4, temp.getDate().length());
            //System.out.println("date in object: " + temp.getDate().substring(temp.getDate().length()-4, temp.getDate().length()));
            if(today.equals(currentYear)){
            amt[i] = temp.getAmount();
            cat[i] = temp.getCategory();
            date[i] = temp.getDate();
            note[i] = temp.getNote();
            }
        }

    }

    private void loadPayments() {
        try {
            //set arrays to 0 to prevent contamination
            setArraystoZero();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("PaymentsPosted.dat"));
            Payments temp;
            //clear pay arraylist
            pay.clear();

            while (true) {
                temp = (Payments) in.readObject();
                pay.add(temp);

                //String amount = Double.toString(temp.getAmount());
            }

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class Not Found Exception: " + e);
        } catch (EOFException ex) {
            //end of file exception will be thrown when end of file reached
            //do nothing with this exception
            //JOptionPane.showMessageDialog(null, "End of File Reached");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOError: " + e);
        }
       

        //loop through arraylist to get individual objects
        for (int i = 0; i < pay.size(); i++) {
            Payments temp;
            temp = pay.get(i);
            String currentYear = temp.getDate().substring(temp.getDate().length()-4, temp.getDate().length());
            if(today.equals(currentYear)){
            amt[i] = temp.getAmount();
            cat[i] = temp.getCategory();
            date[i] = temp.getDate();
            note[i] = temp.getNote();
            }

        }
        //System.out.println("amt array after pay arraylist: " + amt[0] + amt[1] + amt[2]+ amt[3]+ amt[4]+ amt[5]+ amt[6]);

    }

    private void loadUnclearedReceipts() {

        try {
            //set arrays to 0 to prevent contamination
            setArraystoZero();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Receipts.dat"));
            Receipts temp;
            uncleared.clear();

            while (true) {
                temp = (Receipts) in.readObject();
                uncleared.add(temp);

            }

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class Not Found Exception: " + e);
        } catch (EOFException ex) {
            //end of file exception will be thrown when end of file reached
            //do nothing with this exception
            //JOptionPane.showMessageDialog(null, "End of File Reached");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOError: " + e);
        }

        for (int i = 0; i < uncleared.size(); i++) {
            Receipts temp;
            temp = uncleared.get(i);
            String currentYear = temp.getDate().substring(temp.getDate().length()-4, temp.getDate().length());
            if(today.equals(currentYear)){
            amt[i] = temp.getAmount();
            cat[i] = temp.getCategory();
            date[i] = temp.getDate();
            note[i] = temp.getNote();
            }

        }
    }

    private void loadUnclearedPayments() {

        try {
            //set arrays to zero to prevent contamination from loading cleared payments
            setArraystoZero();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Payments.dat"));
            Payments temp;
            uncleared1.clear();

            while (true) {
                temp = (Payments) in.readObject();
                uncleared1.add(temp);

            }

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class Not Found Exception: " + e);
        } catch (EOFException ex) {
            //end of file exception will be thrown when end of file reached
            //do nothing with this exception
            //JOptionPane.showMessageDialog(null, "End of File Reached");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOError: " + e);
        }

        for (int i = 0; i < uncleared1.size(); i++) {
            Payments temp;
            temp = uncleared1.get(i);
            String currentYear = temp.getDate().substring(temp.getDate().length()-4, temp.getDate().length());
            if(today.equals(currentYear)){
            amt[i] = temp.getAmount();
            cat[i] = temp.getCategory();
            date[i] = temp.getDate();
            note[i] = temp.getNote();
            }

        }
    }

    private void loadUnitDetails() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("UnitDetails.dat"));
            UnitDetails details;
            UnitDetails det;
            //list.clear();
            while (true) {
                details = (UnitDetails) in.readObject();
                //account.add(accTemp);
                unit = details.getUnit();
            }

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class Not Found Exception: " + e);
        } catch (EOFException ex) {
            //end of file exception will be thrown when end of file reached
            //do nothing with this exception
            //JOptionPane.showMessageDialog(null, "End of File Reached");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOError: " + e);
        }
    }

    private void loadAssetsLiabilities() {
        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("AssetsLiabilities.dat"));
            AssetsLiabilities assTemp;

            while (true) {
                assTemp = (AssetsLiabilities) in.readObject();
                if (assTemp.getYear().equals(today)) {
                    acBalance = assTemp.getBankOpenBal() + assTemp.getCreditOpenBal() + assTemp.getPostOpenBal();
                }

            }
            //JOptionPane.showMessageDialog(null,"Loaded!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class Not Found Exception: " + e);
        } catch (EOFException ex) {
            //end of file exception will be thrown when end of file reached
            //do nothing with this exception
            //JOptionPane.showMessageDialog(null, "End of File Reached");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "IOError: " + e);
        }

    }

    public double getAcBalance() {
        return acBalance;
    }

    //methods
    //method to calculate amounts under each category, based on category parameter passed in
    private double calcReceipts(String category) {
        this.category = category;
        amtTotal = 0.00;
        for (int i = 0; i < cat.length; i++) {
            if (category.equals(cat[i])) {
                amtTotal += amt[i];
            }
        }
        return amtTotal;

    }

    private double calcPayments(String category) {
        this.category = category;
        amtTotal = 0.00;
        for (int i = 0; i < cat.length; i++) {
            if (category.equals(cat[i])) {
                amtTotal += amt[i];
            }
        }
        return amtTotal;
    }

    //load page 2 expenses over 1k
    private void loadExpOver1k() {
        //System.out.println("amt array: " + amt[0] + amt[1] + amt[2] + amt[3] + amt[4] + amt[5] + amt[6] + amt[7]);
        //use ArrayList of type String to dynamically add amounts over 1k to list (starting from 0).
        //add all as String as its easier
        //uncleared payments already loaded and arrays set so loop through these first
        amount.clear();
        cat1.clear();
        note1.clear();
        date1.clear();
        for (int i = 0; i < amt.length; i++) {
            if (amt[i] >= 1000) {
                amount.add(Double.valueOf(df.format(amt[i])));
                cat1.add(cat[i]);
                note1.add(note[i]);
                date1.add(date[i]);

            }
        }
        //then load payments
        loadPayments();
        for (int i = 0; i < amt.length; i++) {
            if (amt[i] >= 1000) {
                amount.add(Double.valueOf(df.format(amt[i])));
                cat1.add(cat[i]);
                note1.add(note[i]);
                date1.add(date[i]);

            }
        }
        
        //set array list items to string array "over1k" so they can be displayed in report
        for (int i = 0; i < amount.size(); i++) {
            over1k[i] = amount.get(i);
        }

        for (int i = 0; i < cat1.size(); i++) {
            over1kCat[i] = cat1.get(i);
        }
        
        for (int i = 0; i < note1.size(); i++) {
            over1kNote[i] = note1.get(i);
        }
        
        for (int i = 0; i < date1.size(); i++) {
            over1kDate[i] = date1.get(i);
        }
        //System.out.println("over1k File: "+ over1k[0] + " " + over1k[1] + " " + over1k[2] + over1k[3] + over1k[4] + over1k[5]);
        //System.out.println("Assets arraylist: " + amount.get(0) + " " + amount.get(1));
        //get total of over1k amounts
        for (int i = 0; i < over1k.length; i++){
            over1kTotal += over1k[i];
        }

    }
    
    public void loadIncomeSundrys(){
        //load income sundrys
        //set arrays to 0 to prevent contamination
        setArraystoZero();
        //load cleared receipts
        loadReceipts();
        //clear arraylists
        amount.clear();
        cat1.clear();
        note1.clear();
        date1.clear();
        for (int i = 0; i < cat.length; i++) {
            if (cat[i].equals("Sundry*")) {
                amount.add(Double.valueOf(df.format(amt[i])));
                cat1.add(cat[i]);
                note1.add(note[i]);
                date1.add(date[i]);

            }
        }
        
        //load uncleared receipts
        loadUnclearedReceipts();

        for (int i = 0; i < cat.length; i++) {
            if (cat[i].equals("Sundry*")) {
                amount.add(Double.valueOf(df.format(amt[i])));
                cat1.add(cat[i]);
                note1.add(note[i]);
                date1.add(date[i]);

            }
        }
        //add to variables for report use
        for (int i = 0; i < amount.size(); i++) {
            sundryInc[i] = amount.get(i);
        }
        
        for (int i = 0; i < cat1.size(); i++) {
            sundryIncCat[i] = cat1.get(i);
        }
        
        for (int i = 0; i < note1.size(); i++) {
            sundryIncNote[i] = note1.get(i);
        }
        
        for (int i = 0; i < date1.size(); i++) {
            sundryIncDate[i] = date1.get(i);
        }
        
        for (int i = 0; i < sundryInc.length; i++){
            sundryIncTotal += sundryInc[i];
        }
        
    }
    
    public void loadExpSundrys(){
        //load expenditure sundrys
        setArraystoZero();
        //load cleared payments
        loadPayments();
        //clear arraylists
        amount.clear();
        cat1.clear();
        note1.clear();
        date1.clear();
        for (int i = 0; i < cat.length; i++) {
            if (cat[i].equals("Sundry*")) {
                amount.add(Double.valueOf(df.format(amt[i])));
                cat1.add(cat[i]);
                note1.add(note[i]);
                date1.add(date[i]);

            }
        }
        
        //load uncleared payments
        loadUnclearedPayments();

        for (int i = 0; i < cat.length; i++) {
            if (cat[i].equals("Sundry*")) {
                amount.add(Double.valueOf(df.format(amt[i])));
                cat1.add(cat[i]);
                note1.add(note[i]);
                date1.add(date[i]);

            }
        }
        //add to variables for report use
        for (int i = 0; i < amount.size(); i++) {
            sundryExp[i] = amount.get(i);
        }
        
        for (int i = 0; i < cat1.size(); i++) {
            sundryExpCat[i] = cat1.get(i);
        }
        
        for (int i = 0; i < note1.size(); i++) {
            sundryExpNote[i] = note1.get(i);
        }
        
        for (int i = 0; i < date1.size(); i++) {
            sundryExpDate[i] = date1.get(i);
        }
        
        for (int i = 0; i < sundryExp.length; i++){
            sundryExpTotal += sundryExp[i];
        }
    }

    public double getSundryIncTotal() {
        return Double.valueOf(df.format(sundryIncTotal));
    }

    public double getSundryExpTotal() {
        return Double.valueOf(df.format(sundryExpTotal));
    }

    public String[] getSundryExpDate() {
        return sundryExpDate;
    }

    public String[] getSundryExpCat() {
        return sundryExpCat;
    }

    public String[] getSundryExpNote() {
        return sundryExpNote;
    }

    public double[] getSundryInc() {
        return sundryInc;
    }

    public double[] getSundryExp() {
        return sundryExp;
    }

    public String[] getSundryIncDate() {
        return sundryIncDate;
    }

    public String[] getSundryIncCat() {
        return sundryIncCat;
    }

    public String[] getSundryIncNote() {
        return sundryIncNote;
    }

    public double getOver1kTotal() {
        return Double.valueOf(df.format(over1kTotal));
    }

    public String[] getOver1kDate() {
        return over1kDate;
    }

    public String[] getOver1kNote() {
        return over1kNote;
    }

    public String[] getOver1kCat() {
        return over1kCat;
    }

    public double[] getOver1k() {
        return over1k;
    }

    public double[] getAmt() {
        return amt;
    }

    public String[] getCat() {
        return cat;
    }

    public String[] getDate() {
        return date;
    }

    public String[] getNote() {
        return note;
    }

}
