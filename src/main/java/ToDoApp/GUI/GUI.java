package ToDoApp.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JTextField taskInput;
    private JButton addButton;
    private JButton deleteButton;

    public GUI() {
        frame = new JFrame();
        panel = new JPanel();
        listModel = new DefaultListModel<>();

        addButton = new JButton("Add Task");
        addButton.addActionListener(this);

        deleteButton = new JButton("Delete Task");
        deleteButton.addActionListener(this);

        taskInput = new JTextField();
        taskList = new JList<>(listModel);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BorderLayout());
        panel.add(taskInput, BorderLayout.PAGE_START);
        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.LINE_END);
        panel.add(deleteButton, BorderLayout.PAGE_END);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("To-Do List App");
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskInput.setText("");
            }
        } else if (e.getSource() == deleteButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
