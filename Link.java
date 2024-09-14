public class Link {
    private Topic otherTopic;
    private String description;


    public Link(Topic otherTopic, String description) {
        this.otherTopic = otherTopic;
        this.description = description;
    }
    public Topic getOtherTopic() {
        return otherTopic;
    }
    public String getDescription() {
        return description;
    }
}
