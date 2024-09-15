import java.util.HashSet;

public class Main {
    public static void main(String args[]) {
//        Topic AlbertBandura = new Topic("Albert Bandura", "Albert Bandura was famous for the Bobo Doll Expiriment.");
//        Topic Freud = new Topic("Sigmund Freud", "Weird ass guy");
//        AlbertBandura.link(Freud, "I wonder if these guys were friends");
//        //Freud.printLinks();
//        //AlbertBandura.printLinks();
//        //AlbertBandura.printAll();
//        //Freud.printAll();
//        Freud.addQuestion("What does this guy love?", "sex! (and incest)", "mc");
//        Freud.addQuestion("When is Freud's b-day?", "idk, google it :)", "mc");
//        Freud.addQuestion("Who did freud want to fuq?", "Def his mom", "mc");
//        //Freud.askQuestion();
//        AlbertBandura.addQuestion("Name of the doll?", "bobo", "w");
//        AlbertBandura.addQuestion("Type of learning studied?", "Behavioral Learning", "mc");
//        AlbertBandura.askQuestion();
//        HashSet<Topic> Psych = new HashSet<>();
//        Psych.add(new Topic("Fundamental Attribution Error", "Tendancy to assume actions are result of disposition rather than situation"));
//        Psych.add(AlbertBandura);
//        Psych.add(Freud);
//        for (Topic topic : Psych) {
//            topic.printAll();
//        }
        new Answer("Default: 1", "default");
        new Answer("Default: 2", "default");
        new Answer("Default: 3", "default");
        new Answer("Taylor Swift", "people");
        new Answer("70", "default");
        new Answer("40", "term");
        new Answer("440", "term");
        new Answer("Albert Bandura", "peeps");
        Answer a =new Answer("Albert Bandura");
        Answer b =new Answer("Albert Bandura", "people");
        new Answer("Sigmund Freud", "people");
        Answer E = new Answer("Albert Einstein", "people");
        //System.out.println(Answer.pools());
        Question q = new Question("What color is the sky?", new Answer("Albert Einstein" ), "mc");
        //new Answer("Albert Einstein", "Term");
        //System.out.println(Answer.getAllPools());
        //System.out.println(b.getAnswerPool());

        q.askQuestion();
        Answer.allInstancesInfo();
    }
}
