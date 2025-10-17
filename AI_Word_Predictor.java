import java.util.*;

public class WordPredictor {
    private static Map<String, List<String>> markovChain = new HashMap<>();

    public static void trainModel(String text) {
        String[] words = text.split("\\s+");
        for (int i = 0; i < words.length - 1; i++) {
            markovChain
                .computeIfAbsent(words[i].toLowerCase(), k -> new ArrayList<>())
                .add(words[i + 1].toLowerCase());
        }
    }

    public static String predictNext(String word) {
        List<String> nextWords = markovChain.get(word.toLowerCase());
        if (nextWords == null || nextWords.isEmpty()) return "No prediction!";
        Random rand = new Random();
        return nextWords.get(rand.nextInt(nextWords.size()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter training text:");
        String text = sc.nextLine();
        trainModel(text);

        System.out.println("Enter a word to predict next:");
        String word = sc.next();
        System.out.println("Predicted next word: " + predictNext(word));
    }
}
