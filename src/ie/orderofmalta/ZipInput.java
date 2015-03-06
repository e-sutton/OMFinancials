/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.orderofmalta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author admin
 */
public class ZipInput {

    public void loadZip() {

        // Create a filter so that we only see .zip files
        FileFilter filter = new FileNameExtensionFilter(null, "zip");
        

        // Create and show the file filter
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);
        fc.removeChoosableFileFilter(fc.getAcceptAllFileFilter());
        int response = fc.showOpenDialog(null);

        // Check the user pressed OK, and not Cancel.
        if (response == JFileChooser.APPROVE_OPTION) {
            File backUp = fc.getSelectedFile();

            byte[] buffer = new byte[1024];

            try {

                //get the zip file content
                ZipInputStream zis = new ZipInputStream(new FileInputStream(backUp));
                //get the zipped file list entry
                ZipEntry ze = zis.getNextEntry();

                while (ze != null) {

                    String fileName = ze.getName();
                    File newFile = new File(fileName);

                    System.out.println("file unzip : " + newFile.getAbsoluteFile());

                    //create all non exists folders
                    //else you will hit FileNotFoundException for compressed folder
                    //new File(newFile.getParent()).mkdirs();
                    FileOutputStream fos = new FileOutputStream(newFile);

                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }

                    fos.close();
                    ze = zis.getNextEntry();
                }

                zis.closeEntry();
                zis.close();

                JOptionPane.showMessageDialog(null,"Files loaded successfully!");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
