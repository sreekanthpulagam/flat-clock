package org.dcs.system.utils;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Clock extends JDialog {

    private Container window = getContentPane();
    private JLabel tijd;
    final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    public Clock(){
        initGUI();

    }   

    public void initGUI(){
    	setUndecorated(true);
    	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);        
        setPreferredSize(new Dimension(800, 600));
        setLayout(null);                

        Calendar now = Calendar.getInstance();
        tijd = new JLabel(dateFormat.format(now.getTime()));
        tijd.setBounds(10, 10, 115, 10);
        tijd.setForeground(Color.WHITE);
        //tijd.setBackground(Color.BLACK);
        //tijd.setOpaque(true);
        window.add(tijd);

        new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                tijd.setText(dateFormat.format(now.getTime()));
            }
        }).start();

        pack();
    }
    public static void main(String[] args){
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	double width = screenSize.getWidth();
    	double height = screenSize.getHeight();
    	//System.out.println(width + " X " + height);
    	Clock tester = new Clock();
    	tester.setOpacity(0.5f);
    	tester.getContentPane().setBackground(Color.BLACK);
    	
    	tester.setSize(130, 30);    	
    	tester.setAlwaysOnTop(true);
    	tester.setResizable(false);
    	tester.setLocation((int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getWidth()-tester.getWidth()), (int) (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight()-tester.getHeight()));
    	tester.setVisible(true);
    }
    }