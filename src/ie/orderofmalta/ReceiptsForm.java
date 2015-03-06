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
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class ReceiptsForm extends javax.swing.JFrame {

    /**
     * Creates new form ReceiptsForm
     */
    private DefaultTableModel model;
    private ArrayList<Receipts> receipts;
    private ArrayList<Receipts> receipts1;
    private AccountForm form;
    private String accArray[] = new String [100];

    public ReceiptsForm() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();
        //load account number automatically
        form = new AccountForm();
        loadAccount();
        receipts = new ArrayList<Receipts>();
        receipts1 = new ArrayList<Receipts>();
        //load receipts save file
        loadReceipts();
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        accLbl = new javax.swing.JLabel();
        catLbl = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        amountLbl = new javax.swing.JLabel();
        amountTxt = new javax.swing.JTextField();
        receiptLbl = new javax.swing.JLabel();
        receiptTxt = new javax.swing.JTextField();
        invLbl = new javax.swing.JLabel();
        invTxt = new javax.swing.JTextField();
        chqLbl = new javax.swing.JLabel();
        chqTxt = new javax.swing.JTextField();
        lodLbl = new javax.swing.JLabel();
        lodTxt = new javax.swing.JTextField();
        noteLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        noteTxt = new javax.swing.JTextArea();
        addBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        postingLbl = new javax.swing.JLabel();
        postBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Receipts");

        dateLbl.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        dateLbl.setText("Date");

        accLbl.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        accLbl.setText("Account");

        catLbl.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        catLbl.setText("Category");

        dateTxt.setText("DD/MM/YYYY");
        dateTxt.setToolTipText("Use DD/MM/YYYY format");
        dateTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateTxtMouseClicked(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bank Interest Received", "Basic First Aid Classes", "Cadet Unit Income", "CFR Classes",
            "Church Gate & House to House", "Competitions", "Community Care - Center Donations", "Donations - Charitable", "Donations - Dutys", "Donations from other Units/Regions", "Donations from other voluntary aid societies", "Flag Days", "Grants - HSE",
            "Grants - Local Authority", "Grants - National Lottery", "Grants - V.E.C.","Grants - Other", "Members Subscriptions", "Occupational First Aid Classes", "Other Classes", "Other Fundraising (specify)","Pilgrimages", "Rent Received","Sale of Ambulance",
            "Sundry*","Supermarket Bag Packing"}));

amountLbl.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
amountLbl.setText("Amount");

amountTxt.setText("0.00");

receiptLbl.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
receiptLbl.setText("Receipt No");

invLbl.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
invLbl.setText("Invoice No");

chqLbl.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
chqLbl.setText("Cheque No");

lodLbl.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
lodLbl.setText("Lodgement ID");

noteLbl.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
noteLbl.setText("Note");

noteTxt.setColumns(20);
noteTxt.setRows(5);
jScrollPane1.setViewportView(noteTxt);

addBtn.setText("Add Item");
addBtn.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        addBtnActionPerformed(evt);
    }
    });

    jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
    jSeparator1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Date", "Account No", "Category", "Amount", "Receipt No", "Invoice No", "Cheque No", "Lodgement ID", "Note", "Cleared"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }
    });
    jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
    jTable1.getTableHeader().setReorderingAllowed(false);
    jScrollPane2.setViewportView(jTable1);

    postingLbl.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
    postingLbl.setText("Posting Area");

    postBtn.setText("Post");
    postBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            postBtnActionPerformed(evt);
        }
    });

    deleteBtn.setText("Delete");
    deleteBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            deleteBtnActionPerformed(evt);
        }
    });

    jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jSeparator1)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(noteLbl)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(receiptTxt)
                                                    .addComponent(dateLbl, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(dateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                                                .addComponent(receiptLbl))
                                            .addGap(29, 29, 29)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(accLbl)
                                                .addComponent(invTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(invLbl)
                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(52, 52, 52)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(catLbl)
                                                .addComponent(chqLbl)
                                                .addComponent(chqTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lodLbl)
                                                .addComponent(amountLbl)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(lodTxt)
                                                    .addComponent(amountTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                                            .addGap(114, 114, 114))
                                        .addComponent(addBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(14, 795, Short.MAX_VALUE))))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(postingLbl)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(postBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGap(41, 41, 41))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(56, 56, 56)
            .addComponent(jLabel1)
            .addGap(18, 24, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(dateLbl)
                .addComponent(accLbl)
                .addComponent(catLbl)
                .addComponent(amountLbl))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(amountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(receiptLbl)
                .addComponent(invLbl)
                .addComponent(chqLbl)
                .addComponent(lodLbl))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(receiptTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(invTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(chqTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lodTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(noteLbl)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(postingLbl)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(postBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    setSize(new java.awt.Dimension(1030, 772));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private ComboBoxModel getComboModel (AccountForm myOtherClass){
        
  return new DefaultComboBoxModel (myOtherClass.getAccArr());
}
    
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if (amountTxt.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Please enter an amount!");
        } else {
            //add to Receipts class
            Receipts rec = new Receipts();
            rec.setDate(dateTxt.getText());
            rec.setAccount(jComboBox3.getSelectedItem().toString());
            rec.setCategory(jComboBox2.getSelectedItem().toString());
            rec.setAmount(Double.parseDouble(amountTxt.getText()));
            rec.setReceipt(receiptTxt.getText());
            rec.setInvoice(invTxt.getText());
            rec.setCheque(chqTxt.getText());
            rec.setLodgement(lodTxt.getText());
            rec.setNote(noteTxt.getText());
            //add to arraylist
            receipts.add(rec);
            //add to jTable
            model.addRow(new String[]{dateTxt.getText(), jComboBox3.getSelectedItem().toString(), jComboBox2.getSelectedItem().toString(), amountTxt.getText(), receiptTxt.getText(), invTxt.getText(),
                chqTxt.getText(), lodTxt.getText(), noteTxt.getText()});
            //save
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Receipts.dat"));

                for (int i = 0; i < receipts.size(); i++) {
                    out.writeObject(receipts.get(i));
                }
                //close stream
                out.close();
            } catch (EOFException e) {
                //End of file always throws exception, do nothing with this
            } catch (FileNotFoundException ev) {
                JOptionPane.showMessageDialog(null, "File Not Found Exception: " + ev);
            } catch (IOException evn) {
                JOptionPane.showMessageDialog(null, "IOException: " + evn);
            }
            //JOptionPane.showMessageDialog(null, "Added to posting area");
        }
    }//GEN-LAST:event_addBtnActionPerformed

    public void loadReceipts() {
        //clear arraylist
        receipts.clear();
        
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Receipts.dat"));
            Receipts temp;
            //Receipts temp2;
            
            while (true) {
                temp = (Receipts) in.readObject();
                receipts.add(temp);
                
                String amount = Double.toString(temp.getAmount());
                model.addRow(new String[]{temp.getDate(), temp.getAccount(), temp.getCategory(), amount, temp.getReceipt(), temp.getInvoice(),
                temp.getCheque(), temp.getLodgement(), temp.getNote()});
                
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
    private void dateTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateTxtMouseClicked
        dateTxt.setText("");
    }//GEN-LAST:event_dateTxtMouseClicked

    private void postBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postBtnActionPerformed
        //boolean istrue = Boolean.parseBoolean(jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString());
        //JOptionPane.showMessageDialog(null,"" + jTable1.getValueAt(jTable1.getSelectedRow(), 9));
        
        //new arraylist
        //ArrayList<Receipts> receipts1 = new ArrayList<Receipts>();
        Receipts acc = new Receipts();
        if (jTable1.getSelectedRow() == -1 | jTable1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Select a row");
        }
            
            //checkbox is null by default if not checked
            //so if checked, then save and delete row and arraylist entry
            else if(jTable1.getValueAt(jTable1.getSelectedRow(), 9) == null){
                JOptionPane.showMessageDialog(rootPane,"Items must be cleared before posting");
            
            }
            else{
                
                
                //save + load first receiptsposted.dat, add to arraylist, then add new entry to arraylist and resave
                //in order to save all without overwriting
            try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("ReceiptsPosted.dat"));
            Receipts accTemp;
            
            receipts1.clear();
            while (true) {
                accTemp = (Receipts) in.readObject();
                receipts1.add(accTemp);

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
            
            
                
                
                
                
                
                
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ReceiptsPosted.dat"));
                    //add new entry
                    //add selected entry, it is the same index in the original receipts array
                    receipts1.add(receipts.get(jTable1.getSelectedRow()));
                    
                    for(int i = 0; i < receipts1.size(); i++){
                    out.writeObject(receipts1.get(i));
            }
                //close stream
                out.close();
            } catch (EOFException e) {
                //End of file always throws exception, do nothing with this
            } catch (FileNotFoundException ev) {
                JOptionPane.showMessageDialog(null, "File Not Found Exception: " + ev);
            } catch (IOException evn) {
                JOptionPane.showMessageDialog(null, "IOException: " + evn);
            }
            JOptionPane.showMessageDialog(rootPane, "Entry Posted");
            
            //delete from table row and arraylist since all are added
            //for(int j = 0; j <receipts.size(); j++){
                receipts.remove(jTable1.getSelectedRow());
                model.removeRow(jTable1.getSelectedRow());
            //}
            
        
        //resave receipts.dat so entry doesn't show next time app opens
        try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Receipts.dat"));

                for (int i = 0; i < receipts.size(); i++) {
                    out.writeObject(receipts.get(i));
                }
                //close stream
                out.close();
            } catch (EOFException e) {
                //End of file always throws exception, do nothing with this
            } catch (FileNotFoundException ev) {
                JOptionPane.showMessageDialog(null, "File Not Found Exception: " + ev);
            } catch (IOException evn) {
                JOptionPane.showMessageDialog(null, "IOException: " + evn);
            }
        }

        
    }//GEN-LAST:event_postBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            if (jTable1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Table is empty");
            } else {
                JOptionPane.showMessageDialog(rootPane, "You must select a row");
            }
        } else {
            //delete from table row and arraylist
            receipts.remove(jTable1.getSelectedRow());
            model.removeRow(jTable1.getSelectedRow());
            
            //resave so deleted items wont show up on startup anymore
            //save
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Receipts.dat"));

                for (int i = 0; i < receipts.size(); i++) {
                    out.writeObject(receipts.get(i));
                }
                //close stream
                out.close();
            } catch (EOFException e) {
                //End of file always throws exception, do nothing with this
            } catch (FileNotFoundException ev) {
                JOptionPane.showMessageDialog(null, "File Not Found Exception: " + ev);
            } catch (IOException evn) {
                JOptionPane.showMessageDialog(null, "IOException: " + evn);
            }
            //JOptionPane.showMessageDialog(null, "Added to posting area");
        

        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    public void loadAccount() {
        accArray = form.getAccArr();
        jComboBox3.addItem(accArray[0]);
        jComboBox3.addItem(accArray[1]);
        jComboBox3.addItem(accArray[2]);
        jComboBox3.addItem(accArray[3]);
        
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
            java.util.logging.Logger.getLogger(ReceiptsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceiptsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceiptsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceiptsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceiptsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accLbl;
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel amountLbl;
    private javax.swing.JTextField amountTxt;
    private javax.swing.JLabel catLbl;
    private javax.swing.JLabel chqLbl;
    private javax.swing.JTextField chqTxt;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel invLbl;
    private javax.swing.JTextField invTxt;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lodLbl;
    private javax.swing.JTextField lodTxt;
    private javax.swing.JLabel noteLbl;
    private javax.swing.JTextArea noteTxt;
    private javax.swing.JButton postBtn;
    private javax.swing.JLabel postingLbl;
    private javax.swing.JLabel receiptLbl;
    private javax.swing.JTextField receiptTxt;
    // End of variables declaration//GEN-END:variables
}