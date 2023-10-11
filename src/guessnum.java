import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class guessnum extends JFrame implements ActionListener {
    private JLabel titleLabel, guessLabel, resultLabel;
    private JTextField guessField;
    private JButton guessButton;
    private int num, attempts;

    public guessnum() {
        setTitle("Number Guessing Game");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        titleLabel = new JLabel("Welcome to the Number Guessing Game!");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        guessLabel = new JLabel("Guess a two-digit number in minimum attempts. All the best");
        guessLabel.setHorizontalAlignment(JLabel.CENTER);

        guessField = new JTextField();
        guessField.setHorizontalAlignment(JTextField.CENTER);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);

        resultLabel = new JLabel("");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        add(titleLabel);
        add(guessLabel);
        add(guessField);
        add(guessButton);
        add(resultLabel);

        num = generateRandomNumber();
        attempts = 0;
    }

    public int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }
    public void actionPerformed(ActionEvent e) {
        try {
            int entered = Integer.parseInt(guessField.getText());

            if (entered < 0 || entered > 100) {
                resultLabel.setText("Invalid input. Please enter a valid number.");
            } else {
                attempts++;
                if (entered > num) {
                    resultLabel.setText("Please guess a smaller number.");
                } else if (entered < num) {
                    resultLabel.setText("Please guess a bigger number.");
                } else {
                    resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts");
                    guessField.setEnabled(false);
                    guessButton.setEnabled(false);
                }
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            guessnum game = new guessnum();
            game.setVisible(true);
        });
    }
}