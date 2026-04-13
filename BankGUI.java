import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BankGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Balance App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel balanceLabel = new JLabel("Balance: $0.0");
        JTextField amountField = new JTextField(10);

        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton exitBtn = new JButton("Exit");

        double[] balance = {0.0}; // used so we can modify inside buttons

        frame.add(balanceLabel);
        frame.add(new JLabel("Amount:"));
        frame.add(amountField);
        frame.add(depositBtn);
        frame.add(withdrawBtn);
        frame.add(exitBtn);

        // 🔵 Deposit button
        depositBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());

                if (amount > 0) {
                    balance[0] += amount;
                    balanceLabel.setText("Balance: $" + balance[0]);
                } else {
                    JOptionPane.showMessageDialog(frame, "Enter a positive amount!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input!");
            }
        });

        // 🔴 Withdraw button
        withdrawBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());

                if (amount > 0 && amount <= balance[0]) {
                    balance[0] -= amount;
                    balanceLabel.setText("Balance: $" + balance[0]);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid withdrawal!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input!");
            }
        });

        // ⚫ Exit button
        exitBtn.addActionListener(e -> {
            System.exit(0);
        });

        frame.setVisible(true);
    }
}