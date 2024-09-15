import java.util.*;

public class Question {
    String question;
    Answer answer;

    String type;
    public Question(String question, Answer answer, String type) {
        if (!(type.equalsIgnoreCase("mc") || type.equalsIgnoreCase("tf") ||
                type.equalsIgnoreCase("w") )) {
            throw new IllegalArgumentException("No such type of question");
        }
        if (type.equalsIgnoreCase("tf") && (!(answer.getName().equalsIgnoreCase("t") ||
                answer.getName().equalsIgnoreCase("f")))) {
            throw new IllegalArgumentException("True/False Questions need answer of 't' or 'f'");
        }
        this.question = question;
        this.answer = answer;
        this.type = type;
    }
    public Question(String question, String answer, String type) {
        new Question(question, new Answer(answer), type);
    }

    public void askQuestion() {
        switch (type) {
            case "mc":
                multipleChoice();
                break;
            case "tf":
                trueOrFalse();
                break;
            case "w":
                written();
                break;
            default:
                return;
        }
    }



    private void trueOrFalse() {
        System.out.println("True or False\n");
        System.out.println(question);
        checkAnswer(this.answer.getName());
    }


    private void multipleChoice() {

        // create a set of 4 answers, including the correct one
        Set<String> choices = new HashSet<>();
        choices.add(answer.getName());
        // prioritize similar answers
        Set<Answer> pool = answer.othersFromPool();
        for (Answer ans : Answer.getAllInstances()) {

            if (ans.getName() == answer.getName()) {
                pool = answer.othersFromPool();
                System.out.println("Yay boobs");
            }
        }
        if (pool.size() < 3) {
            while ((choices.size() - 1) < pool.size()) {
                choices.add(answer.randomAnswer(pool));
            }
            pool = answer.getAllInstances();
            while ((choices.size() - 1) < pool.size() && choices.size() < 4) {
                choices.add(answer.randomAnswer(pool));
            }
        } else {
            while (choices.size() < 4) {
                choices.add(answer.randomAnswer(pool));
            }
        }

        System.out.println(question);
        // shuffle list of answers
        List<String> finalChoices = new ArrayList<>(choices);
        Collections.shuffle(finalChoices);
        String letter = "ABCD";
        int count = 0;
        char rightAnswer = 0;
        //print out right answers
        for (String choice : finalChoices) {
            System.out.println("\t" + letter.charAt(count) + ". " + choice);
            if (answer.equals(choice)) {
                rightAnswer = letter.charAt(count);
            }
            count++;
        }

        checkAnswer(String.valueOf(rightAnswer));
    }
    private void written() {
        System.out.println(question);
        checkAnswer(answer.getName());
    }

    private boolean checkAnswer( String rightAnswer) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");

        String input = scanner.nextLine();
        if (input.equalsIgnoreCase(rightAnswer)) {
            System.out.println("You're Right!");
            return true;
        } else {
            System.out.println("Not quite. the answer is: " + rightAnswer);
            return false;
        }
    }

}

