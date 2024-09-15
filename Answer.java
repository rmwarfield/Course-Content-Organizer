import java.util.*;


/**
 * Answer's to Questions. Provides pools of similar answers accessed by the multiple choice function
 */
public class Answer {
    private static final Set<Answer> allInstances = new HashSet<>();
    private String name;
    private String pool;

    public Answer(String name) {
        this.name = name;
        if (allInstances.contains(this)) {
            for (Answer answer : allInstances) {
                if (this.equals(answer)) {
                    this.pool = answer.pool;
                }
            }
        } else {
            this.pool = "default";
        }
    }
    public Answer(String name, String pool) {
        this.name = name.toLowerCase();
        this.pool = pool.toLowerCase();
        allInstances.remove(this);
        allInstances.add(this);
    }
    public Answer(String pool, String... name) {
        for (String ans : name) {
            new Answer(ans, pool);
        }
    }

    /**
     * @return answers pool
     */
    public String getPool() {
        return pool;
    }

    /**
     * @return answer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Change answer's pool
     * @param pool
     */
    public void setPool(String pool) {
        this.pool = pool;
    }

    /**
     * @return answers from answer pool excluding current
     */
    public Set<Answer> othersFromPool() {
        Set<Answer> thisInstance = new HashSet<>();
        for (Answer ans : allInstances) {
            if (ans.getPool().equals(getPool()) && !(ans.equals(this))) {
                thisInstance.add(ans);
            }
        }
        return thisInstance;
    }

    /**
     * @return name of answer
     */
    public String toString() {
        return getName();
    }

    /**
     * @return all pools in the class
     */
    public static Set<String> getAllPools() {
        Set<String> pools = new HashSet<>();
        for (Answer ans : allInstances) {
            pools.add(ans.getPool());
        }
        return pools;
    }

    /**
     * @return set of all answers in the class
     */
    public static Set<Answer> getAllInstances() {
        return allInstances;
    }


    /**
     * when String matches Answer.name
     */
    public boolean equals(Object o) {
        if (!(o instanceof String)) return false;
        return (o.toString().equals(getName()));
    }

    public int hashCode() {
        return Objects.hash(getName());
    }

    /**
     * Returns a random answer as a string from a pool
     * @param pool collection of types of answers
     * @return the name of an answer from the pool
     */
    public String randomAnswer(Set<Answer> pool) {
        List<Answer> list = new ArrayList<>(pool);

        // Generate a random index
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());

        // Get the element at the random index
        Answer randomElement = list.get(randomIndex);
        return randomElement.getName();
    }

    /**
     * Prints to console name and pool lines '' *name : *pool \n ''
     */
    public static void allInstancesInfo() {
        for (Answer answer : allInstances) {
            System.out.println(answer.getName() + " : " + answer.getPool());
        }
    }

    public static Answer find(String name) {
        Answer rAns;
        for (Answer answer : allInstances) {
            if (name.equals(answer) ){
                return answer;
            }
        }
        return null;
    }
}

