import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultiplicationTableUI extends JFrame {
    private JTextField numberField;
    private JTextArea resultArea;
    private JButton calculateButton;

    public MultiplicationTableUI() {
        setSize(400, 285);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        Font font1 = new Font("SansSerif", Font.BOLD, 15);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.GRAY);
        inputPanel.setPreferredSize(new Dimension(10, 40));

        numberField = new JTextField(10);
        addPlaceholder(numberField, "Entrez un nombre");
        numberField.setFont(font1);

        calculateButton = new JButton("Calculer");

        inputPanel.add(numberField);
        inputPanel.add(calculateButton);
        inputPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

        Font font2 = new Font("SansSerif", Font.ITALIC, 14);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBackground(Color.BLACK);
        resultArea.setForeground(Color.WHITE);
        resultArea.setFont(font2);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTable();
            }
        });

        numberField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTable();
            }
        });

        setVisible(true);

    }

    private void calculateTable() {
        try {
            int nbr = Integer.parseInt(numberField.getText());
            resultArea.setText("La table de multiplication de " + nbr + " : \n");
            for (int i = 1; i <= 10; i++) {
                resultArea.append(nbr + " x " + i + " = " + (nbr * i) + "\n");

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer un nombre valide.", "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MultiplicationTableUI();
    }

    public static void addPlaceholder(JTextField field, String text) {
        field.setText(text);
        field.setForeground(Color.GRAY);
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(text)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(text);
                    field.setForeground(Color.GRAY);
                }
            }
        });
    }
}
