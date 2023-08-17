/* Task 4
   ATM Interface
 * 1.Create a class to represent the ATM machine.

2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.

3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().

4. Create a class to represent the user's bank account, which stores the account balance.

5. Connect the ATM class with the user's bank account class to access and modify the account
balance.

6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).

7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMGUI extends JFrame {
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton checkBalanceButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private double balance = 1000.0;

    public ATMGUI() {
        setTitle("ATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Create components
        balanceLabel = new JLabel("Balance: $" + balance);
        amountField = new JTextField(10);
        checkBalanceButton = new JButton("Check Balance");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        // Create panels
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        // Add components to panels
        topPanel.add(balanceLabel);
        centerPanel.add(new JLabel("Amount:"));
        centerPanel.add(amountField);
        bottomPanel.add(checkBalanceButton);
        bottomPanel.add(depositButton);
        bottomPanel.add(withdrawButton);

        // Add panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listeners
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your balance is: $" + balance);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount > 0) {
                        balance += amount;
                        balanceLabel.setText("Balance: $" + balance);
                        JOptionPane.showMessageDialog(null, "Deposited $" + amount + " successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        balanceLabel.setText("Balance: $" + balance);
                        JOptionPane.showMessageDialog(null, "Withdrawn $" + amount + " successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient funds or invalid amount.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ATMGUI().setVisible(true);
            }
        });
    }
}
