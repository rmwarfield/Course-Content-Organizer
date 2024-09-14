import java.util.HashSet;

public class Main {
    public static void main(String args[]) {
        Topic AlbertBandura = new Topic("Albert Bandura", "Albert Bandura was famous for the Bobo Doll Expiriment.");
        Topic Freud = new Topic("Sigmund Freud", "Weird ass guy");
        AlbertBandura.makeLink(Freud, "I wonder if these guys were friends");
        //Freud.printLinks();
        //AlbertBandura.printLinks();
        //AlbertBandura.printAll();
        //Freud.printAll();
        Freud.addQuestion("What does this guy love?", "sex! (and incest)");
        Freud.addQuestion("When is Freud's b-day?", "idk, google it :)");
        Freud.addQuestion("Who did freud want to fuq?", "Def his mom");
        //Freud.askQuestion();
        AlbertBandura.addQuestion("Name of the doll?", "bobo");
        AlbertBandura.addQuestion("Type of learning studied?", "Behavioral Learning");
        AlbertBandura.askQuestion();
        HashSet<Topic> Psych = new HashSet<>();
        Psych.add(new Topic("Fundamental Attribution Error", "Tendancy to assume actions are result of disposition rather than situation"));
        Psych.add(AlbertBandura);
        Psych.add(Freud);
        for (Topic topic : Psych) {
            topic.printAll();
        }
    }
}
