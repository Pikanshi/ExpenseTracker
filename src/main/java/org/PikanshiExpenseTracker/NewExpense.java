package org.PikanshiExpenseTracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import org.jdesktop.swingx.JXDatePicker;


public class NewExpense {
    public NewExpense() {

        JFrame frame = new JFrame("Input Details");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2));
        frame.setLocationRelativeTo(null);
                
        frame.add(new JLabel("Category:"));
        String[] categoryList = ExpenseDB.getCategories();
        JComboBox<String> categoryField = new JComboBox<>(categoryList);
        frame.add(categoryField);

        frame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        frame.add(nameField);

        frame.add(new JLabel("Description:"));
        JTextField descriptionField = new JTextField();
        frame.add(descriptionField);

        frame.add(new JLabel("Amount:"));
        JTextField amountField = new JTextField();
        frame.add(amountField);

        frame.add(new JLabel("Date:"));
        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        frame.add(picker);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e1 -> {
            String name = nameField.getText();
            String description = descriptionField.getText();
            int amount = Integer.parseInt(amountField.getText());
            String date = picker.getDate().toString();
            String category = (String) categoryField.getSelectedItem();
            frame.dispose();
            ExpenseDB.insertExpenses(category, name, description, amount, date);
            try {
                HomeWindow.updateTable();
                HomeWindow.updateTotal();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        frame.add(submitButton);

        frame.pack();
        frame.setVisible(true);
    }
}
