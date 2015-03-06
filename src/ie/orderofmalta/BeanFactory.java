/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ie.orderofmalta;

import java.io.Serializable;
import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class BeanFactory implements Serializable{
   
    //collection for javabeans
    public static Collection getCalcs()
            
    {
        
        Vector calculations = new Vector();
        
        Calculations calc = new Calculations();
        
        try
        {
            
            //alc.calcReceipts("Bank Interest Received");
            calc.getBankIntReceived();
            calc.getBasicFA();
            calc.getCadetInc();
            calc.getCadetInc();
            calc.getCfrClasses();
            calc.getCharityDonations();
            calc.getChurchGate();
            calc.getComCare();
            calc.getComps();
            calc.getDutyDonations();
            calc.getFlagDays();
            calc.getGrantsHSE();
            calc.getGrantsLocalAuth();
            calc.getGrantsLottery();
            calc.getGrantsOther();
            calc.getGrantsVEC();
            calc.getMembersSub();
            calc.getOccupFAClasses();
            calc.getOtherClasses();
            calc.getOtherFundraising();
            calc.getOtherVolDonations();
            calc.getPilgrimages();
            calc.getRentReceived();
            calc.getSaleOfAmbo();
            calc.getSundry();
            calc.getSupermarket();
            calc.getUnitsDonations();
            calc.getReceiptsTotal();
            calc.getAmboEmerEquip();
            calc.getAmboFAEquip();
            calc.getAmboMaint();
            calc.getAmboNewVeh();
            calc.getBankCharges();
            calc.getBankInt();
            calc.getBankLoan();
            calc.getCadetExp();
            calc.getComCatering();
            calc.getComMaint();
            calc.getComServ();
            calc.getComOutings();
            calc.getCoursesFA();
            calc.getCoursesOFA();
            calc.getDonationsOtherUnit();
            calc.getDonationsOtherVol();
            calc.getFundraisingExp();
            calc.getHqFund();
            calc.getHqCerts();
            calc.getHqIns();
            calc.getHqPilgrimages();
            calc.getHqSupplies();
            calc.getHqTraining();
            calc.getHqUniforms();
            calc.getRegionalFund();
            calc.getRegionalMeetExp();
            calc.getRegionalTrainExp();
            calc.getSundry2();
            calc.getUnitComps();
            calc.getUnitLightHeat();
            calc.getUnitConfExp();
            calc.getUnitPetrolDiesel();
            calc.getUnitStationary();
            calc.getUnitRent();
            calc.getUnitPropRepair();
            calc.getUnitTel();
            calc.getUnitTrainCourses();
            calc.getUnitTrainEquip();
            calc.getClearedPaymentsTotal();
            //add uncleared items
            calc.getUnclearedPaymentsTotal();
            calc.getUnclearedReceiptsTotal();
            calc.getUnpayAmboEmerEquip();
            calc.getUnpayAmboFAEquip();
            calc.getUnpayAmboMaint();
            calc.getUnpayAmboNewVeh();
            calc.getUnpayBankCharges();
            calc.getUnpayBankInt();
            calc.getUnpayBankLoan();
            calc.getUnpayCadetExp();
            calc.getUnpayComCatering();
            calc.getUnpayComMaint();
            calc.getUnpayComOutings();
            calc.getUnpayComServ();
            calc.getUnpayCoursesFA();
            calc.getUnpayCoursesOFA();
            calc.getUnpayDonationsOtherUnit();
            calc.getUnpayDonationsOtherVol();
            calc.getUnpayFundraisingExp();
            calc.getUnpayHqCerts();
            calc.getUnpayHqFund();
            calc.getUnpayHqIns();
            calc.getUnpayHqPilgrimages();
            calc.getUnpayHqSupplies();
            calc.getUnpayHqTraining();
            calc.getUnpayHqUniforms();
            calc.getUnpayRegionalFund();
            calc.getUnpayRegionalMeetExp();
            calc.getUnpayRegionalTrainExp();
            calc.getUnpaySundry2();
            calc.getUnpayUnitComps();
            calc.getUnpayUnitConfExp();
            calc.getUnpayUnitLightHeat();
            calc.getUnpayUnitPetrolDiesel();
            calc.getUnpayUnitPropRepair();
            calc.getUnpayUnitRent();
            calc.getUnpayUnitStationary();
            calc.getUnpayUnitTel();
            calc.getUnpayUnitTrainCourses();
            calc.getUnpayUnitTrainEquip();
            calc.getUnrecBankIntReceived();
            calc.getUnrecBasicFA();
            calc.getUnrecCadetInc();
            calc.getUnrecCfrClasses();
            calc.getUnrecCharityDonations();
            calc.getUnrecChurchGate();
            calc.getUnrecComCare();
            calc.getUnrecComps();
            calc.getUnrecDutyDonations();
            calc.getUnrecFlagDays();
            calc.getUnrecGrantsHSE();
            calc.getUnrecGrantsLocalAuth();
            calc.getUnrecGrantsLottery();
            calc.getUnrecGrantsOther();
            calc.getUnrecGrantsVEC();
            calc.getUnrecMembersSub();
            calc.getUnrecOccupFAClasses();
            calc.getUnrecOtherClasses();
            calc.getUnrecOtherFundraising();
            calc.getUnrecOtherVolDonations();
            calc.getUnrecPilgrimages();
            calc.getUnrecRentReceived();
            calc.getUnrecSaleOfAmbo();
            calc.getUnrecSundry();
            calc.getUnrecSupermarket();
            calc.getUnrecUnitsDonations();
            calc.getFinalTotal();
            calc.getOver1k();
            calc.getOver1kCat();
            calc.getOver1kDate();
            calc.getOver1kNote();
            calc.getOver1kTotal();
            calc.getSundryExp();
            calc.getSundryExpCat();
            calc.getSundryExpDate();
            calc.getSundryExpNote();
            calc.getSundryInc();
            calc.getSundryIncCat();
            calc.getSundryIncDate();
            calc.getSundryIncNote();
            calc.getSundryExpTotal();
            calc.getSundryIncTotal();
            calculations.add(calc);

            
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return calculations;
    }
    
    
            
                
      
               
    
}
