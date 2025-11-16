/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package GVJ.app;

/**
 *
 * @author mspriggs
 */
public class GenevizJava {

    public static void main(String[] args) {
        // Use dedicated thread – advised for Swing applications
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create the main application window
                mainFrame frame = new mainFrame();
                // Make the window visible to the user
                frame.setVisible(true);
            }
        });
    }
}