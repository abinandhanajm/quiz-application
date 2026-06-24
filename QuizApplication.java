import javax.swing.*;
import java.awt.event.*;

public class QuizApplication extends JFrame implements ActionListener {

    JLabel questionLabel;
    JRadioButton optionA, optionB, optionC, optionD;
    JButton nextButton;

    int score = 0;
    int currentQuestion = 0;

    String[][] questions = {
            {"Which keyword is used to create a class in Java?", "class", "define", "create", "object", "A"},
            {"Which method is the entry point of a Java program?", "start()", "run()", "main()", "init()", "C"},
            {"Which package contains Scanner class?", "java.io", "java.util", "java.lang", "java.net", "B"}
    };

    ButtonGroup group;

    public QuizApplication() {

        setTitle("Java Quiz Application");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        questionLabel = new JLabel();
        questionLabel.setBounds(20, 20, 450, 30);

        optionA = new JRadioButton();
        optionA.setBounds(20, 60, 300, 30);

        optionB = new JRadioButton();
        optionB.setBounds(20, 90, 300, 30);

        optionC = new JRadioButton();
        optionC.setBounds(20, 120, 300, 30);

        optionD = new JRadioButton();
        optionD.setBounds(20, 150, 300, 30);

        group = new ButtonGroup();
        group.add(optionA);
        group.add(optionB);
        group.add(optionC);
        group.add(optionD);

        nextButton = new JButton("Next");
        nextButton.setBounds(180, 200, 100, 30);
        nextButton.addActionListener(this);

        add(questionLabel);
        add(optionA);
        add(optionB);
        add(optionC);
        add(optionD);
        add(nextButton);

        loadQuestion();

        setVisible(true);
    }

    public void loadQuestion() {

        questionLabel.setText(questions[currentQuestion][0]);

        optionA.setText("A. " + questions[currentQuestion][1]);
        optionB.setText("B. " + questions[currentQuestion][2]);
        optionC.setText("C. " + questions[currentQuestion][3]);
        optionD.setText("D. " + questions[currentQuestion][4]);

        group.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String correctAnswer = questions[currentQuestion][5];

        if ((optionA.isSelected() && correctAnswer.equals("A")) ||
            (optionB.isSelected() && correctAnswer.equals("B")) ||
            (optionC.isSelected() && correctAnswer.equals("C")) ||
            (optionD.isSelected() && correctAnswer.equals("D"))) {

            score++;
        }

        currentQuestion++;

        if (currentQuestion < questions.length) {
            loadQuestion();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Quiz Finished!\nScore: " + score + "/" + questions.length);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new QuizApplication();
    }
}