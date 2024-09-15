import java.util.*;

public class Topic {
    private String name;
    private HashSet<Link> links;
    private HashSet<String> tags;
    private String info;
    private List<Question> questions;

    public Topic(String name, String info) {
        this.name = name;
        this.info = info;
        this.links = new HashSet<>();
        this.tags = new HashSet<>();
        this.questions = new ArrayList<>();
    }

    /**
     * Stores a link in this topic and another topic
     * @param otherTopic topic that links to current topic
     * @param description description of the relation between the two topics
     */
    public void link(Topic otherTopic, String description) {
        links.add(new Link(otherTopic, description));
        otherTopic.links.add(new Link(this, description));
    }

    /**
     * Stores a link only in this topic
     * @param otherTopic topic that links to current topic
     * @param description description of the relation between the two topics
     */
    public void linkThis(Topic otherTopic, String description) {
        links.add(new Link(otherTopic, description));
    }

    /**
     * Stores a link only in the other topic
     * @param otherTopic topic that links to current topic
     * @param description description of the relation between the two topics
     */
    public void linkOther(Topic otherTopic, String description) {
        otherTopic.links.add(new Link(this, description));
    }

    /**
     * Getter for name of Topic
     */
    public String getName() {
        return name;
    }

    /**
     * Prints all links for this Topic
     */
    public void printLinks() {
        if (links.isEmpty()) {
            return;
        }
        for (Link link : links) {
            System.out.println(link.getOtherTopic().getName());
            System.out.println(link.getDescription() +"\n");
        }
    }

    /**
     * getter for the description of this Topic
     */
    public String getInfo() {
        return info;
    }

    /**
     * Prints the name, description, and links for this topic
     */
    public void printAll() {
        System.out.print("All About " +getName() + "\nDescription: ");
        System.out.println(getInfo());
        System.out.print("\nLinks:\n");
        printLinks();
    }

    public void addQuestion(String question, String answer, String type) {
        questions.add(new Question(question, answer, type));
    }

    /**
     * Asks a random question for this topic
     */
    public void askQuestion() {
        if (questions.size() == 0) {
            System.out.println("There are no questions for this topic yet");
        }
        Random random = new Random();
        int randomQ = random.nextInt(questions.size());
        questions.get(randomQ).askQuestion();
    };
    public String toString() {
        return getName();
    }

    public void tag(String tag) {
        tags.add(tag);
    }

}

