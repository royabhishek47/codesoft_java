/*Task 2
Word Counter System
 * Prompt the user to enter a text or provide a file to count the words.
2. Read the input text or file and store it in a string.
3. Split the string into an array of words using space or punctuation as delimiters.
4. Initialize a counter variable to keep track of the number of words.
5. Iterate through the array of words and increment the counter for each word encountered.
6. Display the total count of words to the user.

You can further enhance the project by adding features such as:

7. Ignoring common words or stop words.
8. Providing statistics like the number of unique words or the frequency of each word.
9. Implementing input validation to handle empty inputs or file errors.
10. Adding a graphical user interface (GUI) for a more user-friendly experience.
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class WordCounterGUIs extends JFrame {

    private JTextArea inputTextArea;
    private JButton countButton;
    private JButton refreshButton;
    private JTextArea resultTextArea;

    public WordCounterGUIs() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        initComponents(); // Initialize and configure components
    }

    private void initComponents() {
        inputTextArea = new JTextArea();
        countButton = new JButton("Count Words");
        refreshButton = new JButton("Refresh");
        resultTextArea = new JTextArea();

        // ActionListener for the "Count Words" button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords(); // Call method to count words
            }
        });

        // ActionListener for the "Refresh" button
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextArea.setText(""); // Clear input text area
                resultTextArea.setText(""); // Clear result text area
            }
        });

        // Create scroll panes for the text areas
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);

        setLayout(new BorderLayout());

        // Create top panel for input
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("Input Text:"), BorderLayout.NORTH);
        topPanel.add(inputScrollPane, BorderLayout.CENTER);

        // Create button panel for "Count" and "Refresh" buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(countButton);
        buttonPanel.add(refreshButton);

        // Create center panel for buttons and result
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(buttonPanel, BorderLayout.NORTH);
        centerPanel.add(resultScrollPane, BorderLayout.CENTER);

        // Add panels to the main frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void countWords() {
        String inputText = inputTextArea.getText();
        inputText = inputText.replace(",", "").replace(".", ""); // Remove commas and full stops
        String[] words = inputText.split("\\s+");

        Map<Character, Integer> charFrequency = new HashMap<>();
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase(); // Convert to lowercase to treat words case-insensitively

            for (char c : word.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
                }
            }

            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Word Frequencies:\n");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            resultBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        resultBuilder.append("\nAlphabet Frequencies:\n");
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            resultBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        resultTextArea.setText(resultBuilder.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WordCounterGUIs gui = new WordCounterGUIs();
                gui.setVisible(true);
            }
        });
    }
}
