package org.PikanshiExpenseTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class MyActionListener extends Component implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getActionCommand().equals("ADD NEW EXPENSE")) {
                new NewExpense();
            }

            if (e.getActionCommand().equals("Summary")) {
//                System.out.println(ExpenseDB.totalExpenses());
                String[] rs = ExpenseDB.getCategories();
                StringBuilder summary = new StringBuilder();
                summary.append("Summary:\n\n");

                for (String s : rs) {
                    summary.append(s).append(" : ").append(ExpenseDB.totalExpenses(s)).append("\n");
                }
                summary.append("\n").append(ExpenseDB.totalExpenses("All")).append("\n");

                JOptionPane.showMessageDialog(this, summary.toString(), "Expense Summary", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource() instanceof JComboBox) {
//            System.out.println("pressed!" + ((JComboBox<?>) e.getSource()).getSelectedItem());

            try {
                HomeWindow.updateTable();
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
            HomeWindow.updateTotal();
        }
    }
}
