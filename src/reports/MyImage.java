/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author admin
 */
public class MyImage {
        //trying to load image onto reports with relative path
    public MyImage() {
    }

    public static final Image loadImage(String fileName) {
        try {
            URL url = ClassLoader.getSystemResource(fileName);
//if (url == null) return null; 
            return Toolkit.getDefaultToolkit().getImage(url);
        } catch (Exception e) {
            return null;
        }
    }

}
