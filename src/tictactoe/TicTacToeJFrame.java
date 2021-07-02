/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Yan David
 */
public class TicTacToeJFrame extends javax.swing.JFrame {

    int clic;
    String status;
    JPanel panelGrid;

    /**
     * Creates new form TicTacToeJFrame
     */
    public TicTacToeJFrame() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        clic = 0;
        status = "RUNNING";

        createDashboard();
    }

    public void createDashboard() {
        panelGrid = new JPanel(new GridLayout(3, 3));

        String[][] matrix = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        for (int i = 0; i < (3 * 3); i++) {
            JButton button = new JButton();
            button.setLayout(new BorderLayout());            
            button.addActionListener((ActionEvent e) -> {
                if (status.equals("RUNNING")) {
                    boolean flag = true;
                    String data;
                    switch (panelGrid.getComponentZOrder(button)) {
                        case 0:
                            data = matrix[0][0];
                            if (data.equals("-")) {
                                if (clic % 2 == 0) {
                                    matrix[0][0] = "X";
                                } else {
                                    matrix[0][0] = "O";
                                }
                            } else {
                                flag = false;
                            }
                            ;
                            break;
                        case 1:
                            data = matrix[0][1];
                            if (data.equals("-")) {
                                if (clic % 2 == 0) {
                                    matrix[0][1] = "X";
                                } else {
                                    matrix[0][1] = "O";
                                }
                            } else {
                                flag = false;
                            }
                            ;
                            break;
                        case 2:
                            data = matrix[0][2];
                            if (data.equals("-")) {
                                if (clic % 2 == 0) {
                                    matrix[0][2] = "X";
                                } else {
                                    matrix[0][2] = "O";
                                }
                            } else {
                                flag = false;
                            }
                            ;
                            break;
                        case 3:
                            data = matrix[1][0];
                            if (data.equals("-")) {
                                if (clic % 2 == 0) {
                                    matrix[1][0] = "X";
                                } else {
                                    matrix[1][0] = "O";
                                }
                            } else {
                                flag = false;
                            }
                            ;
                            break;
                        case 4:
                            data = matrix[1][1];
                            if (data.equals("-")) {
                                if (clic % 2 == 0) {
                                    matrix[1][1] = "X";
                                } else {
                                    matrix[1][1] = "O";
                                }
                            } else {
                                flag = false;
                            }
                            ;
                            break;
                        case 5:
                            data = matrix[1][2];
                            if (data.equals("-")) {
                                if (clic % 2 == 0) {
                                    matrix[1][2] = "X";
                                } else {
                                    matrix[1][2] = "O";
                                }
                            } else {
                                flag = false;
                            }
                            ;
                            break;
                        case 6:
                            data = matrix[2][0];
                            if (data.equals("-")) {
                                if (clic % 2 == 0) {
                                    matrix[2][0] = "X";
                                } else {
                                    matrix[2][0] = "O";
                                }
                            } else {
                                flag = false;
                            }
                            ;
                            break;
                        case 7:
                            data = matrix[2][1];
                            if (data.equals("-")) {
                                if (clic % 2 == 0) {
                                    matrix[2][1] = "X";
                                } else {
                                    matrix[2][1] = "O";
                                }
                            } else {
                                flag = false;
                            }
                            ;
                            break;
                        case 8:
                            data = matrix[2][2];
                            if (data.equals("-")) {
                                if (clic % 2 == 0) {
                                    matrix[2][2] = "X";
                                } else {
                                    matrix[2][2] = "O";
                                }
                            } else {
                                flag = false;
                            }
                            ;
                            break;
                    }
                    if (flag) {
                        if (clic % 2 == 0) {
                            button.setIcon(new ImageIcon(getClass().getResource("/tictactoe/images/28946-middle.png")));
                        } else {
                            button.setIcon(new ImageIcon(getClass().getResource("/tictactoe/images/circle.png")));
                        }
                        clic++;
                    }
                    printMatrix(matrix);
                    if (clic > 4) {
                        Object[] object = check3Line(matrix);
                        if ((boolean) object[0]) {
                            System.out.println((String) object[1] + " !!!WON THE GAME!!!");
                            status = "FINISHED";
                            makeWin(1);
                        }
                    }
                }
            });
            panelGrid.add(button);
        }
        this.setContentPane(panelGrid);
    }

    public void makeWin(int code) {
        Component [] components = panelGrid.getComponents();
        Color [] colors = {Color.BLUE , Color.GREEN};
        switch(code){
            case 1: highLightComponent(components, colors);
                break;
        }
    }
    
    public void highLightComponent(Component [] components, Color[] colors){
       // while(status.equals("FINISHED")){
            for (Component component : components) {
                for (Color color : colors) {
                    try {
                        component.setBackground(color);                
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TicTacToeJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
       // }
    }

    public Object[] check3Line(String[][] matrix) {
        String data1 = matrix[0][0];
        String data2 = matrix[0][1];
        String data3 = matrix[0][2];
        String data4 = matrix[1][0];
        String data5 = matrix[1][1];
        String data6 = matrix[1][2];
        String data7 = matrix[2][0];
        String data8 = matrix[2][1];
        String data9 = matrix[2][2];
        Object[] object = new Object[3];

        if (data1.equals(data2) && data1.equals(data3)) {
            object[0] = true;
            object[1] = data1;
            object[2] = 1;
            return object;
        } else if (data1.equals(data4) && data1.equals(data7)) {
            object[0] = true;
            object[1] = data1;
            object[2] = 2;
            return object;
        } else if (data3.equals(data6) && data3.equals(data9)) {
            object[0] = true;
            object[1] = data3;
            object[2] = 3;
            return object;
        } else if (data7.equals(data8) && data7.equals(data9)) {
            object[0] = true;
            object[1] = data7;
            object[2] = 4;
            return object;
        } else if (data1.equals(data5) && data1.equals(data9)) {
            object[0] = true;
            object[1] = data1;
            object[2] = 5;
            return object;
        } else if (data3.equals(data5) && data3.equals(data7)) {
            object[0] = true;
            object[1] = data3;
            object[2] = 6;
            return object;
        }
        object[0] = false;
        object[1] = null;
        return object;
    }
    
        public void printMatrix(String[][] matrix) {
        for (String[] matrix1 : matrix) {
            for (String matrix11 : matrix1) {
                System.out.print("    " + matrix11);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TicTacToeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
