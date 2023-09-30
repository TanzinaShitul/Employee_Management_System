package shitul;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login implements ActionListener {
    JFrame f;
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    Login() {

        f = new JFrame("Login");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(110, 20, 100, 30);
        f.add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(110, 70, 100, 30);
        f.add(l2);

        t1 = new JTextField();
        t1.setBounds(190, 20, 150, 30);
        f.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(190, 70, 150, 30);
        f.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(100, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(230, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);

        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(600, 300);
        f.setLocation(400, 300);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            f.setVisible(false);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        try {
            Conn c1 = new Conn();
            String user = t1.getText();
            String pass = t2.getText();

            String q = "select * from login where username='" + user + "' and password='" + pass + "' ";
            ResultSet rs = c1.s.executeQuery(q);
            if (rs.next()) {
                new Details().f.setVisible(true);
                f.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Login l = new Login();
    }
}
