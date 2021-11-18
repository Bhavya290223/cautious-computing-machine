package ui.gui;

import model.ListOfContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ContentByLocation extends JFrame implements ActionListener {
    private String l1;
    private JTextField locationText;
    private JLabel locationLabel;
    private JLabel answerLabel;
    private ListOfContent loc;
    private JPanel panel;
    private JList list;
    private JButton ok;
    private JScrollPane jsp;


    public ContentByLocation(ListOfContent loc) {
        this.loc = loc;
        setSize(800, 800);
        setLocationRelativeTo(null);

        panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        locationLabel = new JLabel("Enter location: ");
        locationLabel.setBounds(0, 10, 400, 20);
        panel.add(locationLabel);

        locationText = new JTextField();
        locationText.setBounds(310, 20, 200, 20);
        panel.add(locationText);

        answerLabel = new JLabel();
        answerLabel.setBounds(100, 150, 340, 20);
        panel.add(answerLabel);

        ok = new JButton("OK");
        ok.setBounds(150, 200, 200, 20);
        panel.add(ok);
        ok.addActionListener(this);

        backButton();

        setVisible(true);
    }

    private void backButton() {
        JButton backButton = new JButton("Back");
        backButton.setBounds(410, 80, 80, 20);
        backButton.addActionListener(e -> {
            dispose();
        });
        panel.add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jsp != null) {
            jsp.removeAll();
            displayList();
        }

        displayList();
        jsp.revalidate();
    }

    private void displayList() {
        answerLabel.setText("Here is the list of Contents of this site: ");

        l1 = locationText.getText();

        List<String> finalList = loc.contentbySite(l1);
        int size = finalList.size();

        String[] names = new String[size];

        for (int i = 0;i < size;i++) {
            names[i] = finalList.get(i);
        }

        list = new JList(names);

        jsp = new JScrollPane(list);
        jsp.setBounds(100,180,300,80);
        panel.add(jsp,list);
    }
}
