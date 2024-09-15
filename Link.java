public class Link {
    private Topic otherTopic;
    private String description;


    public Link(Topic otherTopic, String description) {
        this.otherTopic = otherTopic;
        this.description = description;
    }

    /**
     * @return what topic is linked to
     */
    public Topic getOtherTopic() {
        return otherTopic;
    }

    /**
     * @return relation of the two linked topics
     */
    public String getDescription() {
        return description;
    }
}
