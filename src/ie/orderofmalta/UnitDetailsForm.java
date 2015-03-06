/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ie.orderofmalta;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class UnitDetailsForm extends javax.swing.JFrame {

    /**
     * Creates new form UnitDetailsForm
     */
    
    OMFinancialsForm form;
    
    //private ArrayList<UnitDetails> unitDetails;
    public UnitDetailsForm() {
        initComponents();
        //close window if close button clicked (instead of whole program)
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      //  unitDetails = new ArrayList<UnitDetails>();
        //thi.form = form sets this form object reference to the one in the main panel
        this.form = form;
        loadDetails();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        unitLbl = new javax.swing.JLabel();
        unitTxt = new javax.swing.JTextField();
        addressLbl = new javax.swing.JLabel();
        addressTxt = new javax.swing.JTextField();
        phoneLbl = new javax.swing.JLabel();
        phoneTxt = new javax.swing.JTextField();
        faxLbl = new javax.swing.JLabel();
        faxTxt = new javax.swing.JTextField();
        mobileLbl = new javax.swing.JLabel();
        mobileTxt = new javax.swing.JTextField();
        emailLbl = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        SaveBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        unitLbl.setText("Unit:");

        addressLbl.setText("Unit Address:");

        phoneLbl.setText("Unit Phone No:");

        faxLbl.setText("Unit Fax No:");

        mobileLbl.setText("Unit Mobile:");

        emailLbl.setText("Unit Email:");

        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Unit Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressLbl)
                            .addComponent(unitLbl))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(faxLbl)
                            .addComponent(phoneLbl)
                            .addComponent(mobileLbl)
                            .addComponent(emailLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(unitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(mobileTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(faxTxt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(phoneTxt, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unitLbl)
                    .addComponent(unitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLbl)
                    .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLbl)
                    .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faxLbl)
                    .addComponent(faxTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileLbl)
                    .addComponent(mobileTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLbl)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(450, 472));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        //add details to Unit Details class and Save details in same button click
        if(unitTxt.getText().equals("") | emailTxt.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane,"Please enter unit name and email at minimum!");
        }
        else{
            //create unitdetails object
            UnitDetails details = new UnitDetails();
            //set UnitNameLabel in main Jframe to unit name
            String unitName = unitTxt.getText();
            //OMFinancialsForm form = new OMFinancialsForm();
            //form.unitNameLbl.setText(unitName);
            
            
            //add info to object
            details.setUnit(unitTxt.getText());
            details.setUnitAddress(addressTxt.getText());
            details.setUnitPhoneNum(phoneTxt.getText());
            details.setUnitFax(faxTxt.getText());
            details.setUnitMobileNum(mobileTxt.getText());
            details.setUnitEmail(emailTxt.getText());
            
            //OMFinancialsForm form = new OMFinancialsForm();
            form.unitNameLbl.setText(unitName);
            
            
            //clear txt fields
            //unitTxt.setText("");
            //addressTxt.setText("");
            //phoneTxt.setText("");
            //faxTxt.setText("");
            //mobileTxt.setText("");
            //emailTxt.setText("");
        
        
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UnitDetails.dat"));
            
            out.writeObject(details);
            //close stream
            out.close();
            
        }
        catch(EOFException e){
                //End of file always throws exception, do nothing with this
                }
        catch(FileNotFoundException ev){
                JOptionPane.showMessageDialog(null, "File Not Found Exception: "+ ev);
                }
        catch(IOException evn){
                JOptionPane.showMessageDialog(null, "IOException: "+ evn);
                }
        JOptionPane.showMessageDialog(rootPane,"Saved!");
        }
        
    }//GEN-LAST:event_SaveBtnActionPerformed

    public void loadDetails(){
        try {
           ObjectInputStream in = new ObjectInputStream(new FileInputStream("UnitDetails.dat"));
            UnitDetails details;
            UnitDetails det;
            //list.clear();
            while (true) {
                details = (UnitDetails) in.readObject();
                //account.add(accTemp);
                det = new UnitDetails();
                //load data from UnitDetails.dat to UnitDetails class
                det.setUnit(details.getUnit());
                det.setUnitAddress(details.getUnitAddress());
                det.setUnitPhoneNum(details.getUnitPhoneNum());
                det.setUnitFax(details.getUnitFax());
                det.setUnitMobileNum(details.getUnitMobileNum());
                det.setUnitEmail(details.getUnitEmail());
                
                //set txt fields to entries from saved object
                unitTxt.setText(details.getUnit());
                addressTxt.setText(details.getUnitAddress());
                phoneTxt.setText(details.getUnitPhoneNum());
                faxTxt.setText(details.getUnitFax());
                mobileTxt.setText(details.getUnitMobileNum());
                emailTxt.setText(details.getUnitEmail());
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UnitDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnitDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnitDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnitDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnitDetailsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SaveBtn;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel faxLbl;
    private javax.swing.JTextField faxTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mobileLbl;
    private javax.swing.JTextField mobileTxt;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JLabel unitLbl;
    private javax.swing.JTextField unitTxt;
    // End of variables declaration//GEN-END:variables
}
