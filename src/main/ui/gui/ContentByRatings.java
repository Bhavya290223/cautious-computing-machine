package ui.gui;

import model.ListOfContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ContentByRatings extends JFrame implements ActionListener {
    private int r1;
    private JTextField ratingsText;
    private JLabel ratingsLabel;
    private JLabel answerLabel;
    private ListOfContent loc;
    private JPanel panel;
    private JList list;
    private JButton ok;
    private JScrollPane jsp;


    public ContentByRatings(ListOfContent loc) {
        this.loc = loc;
        setSize(800, 800);
        setLocationRelativeTo(null);

        panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        ratingsLabel = new JLabel("Enter ratings: ");
        ratingsLabel.setBounds(0, 10, 400, 20);
        panel.add(ratingsLabel);

        ratingsText = new JTextField();
        ratingsText.setBounds(310, 20, 200, 20);
        panel.add(ratingsText);

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
        answerLabel.setText("Here is the list of Contents of this rating: ");

        r1 = Integer.parseInt(ratingsText.getText());

        List<String> finalList = loc.contentbyRatings(r1);
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
