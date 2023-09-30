package shitul;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    JFrame f;
    JLabel id;
    JButton b;
    public Main() {
        f=new JFrame("Employee Management System");
        f.setBackground(Color.red);
        f.setLayout(null);

        b = new JButton("CLICK HERE TO CONTINUE");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);

        b.setBounds(350,300,300,70);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1360,750);
        id.setLayout(null);

        JLabel lid=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        lid.setBounds(80,130,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,50));
        lid.setForeground(Color.red);
        id.add(lid);

        id.add(b);
        f.add(id);

        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setSize(1000,550);
        f.setLocation(200,100);

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            f.setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
	Main main = new Main();
    }
}
