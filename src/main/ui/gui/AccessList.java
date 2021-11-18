package ui.gui;

import model.Content;
import model.ListOfContent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AccessList extends JFrame implements ListSelectionListener {
    JPanel accessPanel;
    ListOfContent loc;
    JLabel nameLabel;
    JLabel yearLabel;
    JLabel ratingLabel;
    JLabel genreLabel;
    JLabel locationLabel;
    JLabel langLabel;
    JList list;

    public AccessList(ListOfContent loc) {
        this.loc = loc;
        setSize(800, 800);
        setLocationRelativeTo(null);
        accessPanel = new JPanel();

        add(accessPanel);

        addLabels();

        accessPanel.setLayout(null);

        String[] listr = new String[loc.getList().size()];

        for (int i = 0; i < loc.getList().size(); i++) {
            listr[i] = loc.getNames().get(i);
        }
        
        list = new JList(listr);
        
        list.addListSelectionListener(this);
        
        JScrollPane jsp = new JScrollPane(list);
        jsp.setBounds(20, 40, 300, 80);
        accessPanel.add(jsp, list);
        
        backButton();
        
        setVisible(true);
    }

    private void backButton() {
        JButton back = new JButton("Back");
        back.setBounds(20, 150, 80,20);
        back.addActionListener(e -> {
            dispose();
        });
        accessPanel.add(back);
    }

    private void addLabels() {
        nameLabel = new JLabel();
        nameLabel.setBounds(20, 180, 150, 20);

        yearLabel = new JLabel();
        yearLabel.setBounds(20, 210, 150, 20);

        ratingLabel = new JLabel();
        ratingLabel.setBounds(20, 240, 150, 20);

        langLabel = new JLabel();
        langLabel.setBounds(20, 270, 150, 20);

        locationLabel = new JLabel();
        locationLabel.setBounds(20, 300, 150, 20);

        genreLabel = new JLabel();
        genreLabel.setBounds(20, 330, 150, 20);

        accessPanel.add(nameLabel);
        accessPanel.add(yearLabel);
        accessPanel.add(ratingLabel);
        accessPanel.add(genreLabel);
        accessPanel.add(langLabel);
        accessPanel.add(locationLabel);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        String name = (String) list.getSelectedValue();
        for (Content c : loc.getList()) {
            if (c.getName().equals(name)) {

                nameLabel.setText("Name: " + c.getName());
                yearLabel.setText("Year: " + c.getYear());
                ratingLabel.setText("Ratings: " + c.getRatings());
                genreLabel.setText("Genre: " + c.getGenre());
                langLabel.setText("Language: " + c.getLanguage());
                locationLabel.setText("Location: " + c.getLocation());
            }
        }
    }
}