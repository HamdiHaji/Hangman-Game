import java.util.Random; 
import java.util.Scanner;



public class Hangman {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("****Welcome to Hangman****\n");
        System.out.println(gallows[6]);
        System.out.println("Word: h _ n g m a n");
        System.out.print("Guess: (letter guessed here) ");
        System.out.println("\nHangman is a word-guessing game. The game keeps asking users to guess characters until: ");
        System.out.println("\t1. They guess every character correctly (win).");
        System.out.println("\t2. They miss 6 guesses(loss)");
        System.out.println("\nAre you ready to play? Press 'y' for yes and 'n' for no.");
        String readyToPlay = scan.nextLine();

        if (readyToPlay.equals("y")) {
            System.out.println("\nGreat! Time for the game!\n");

        } else {
            System.out.println("No worries...next time!");
            System.exit(0);
        }

     
       
        String word = randomWordString();
        
        char[] wordArray = word.toCharArray();
        char[] hiddenWord = new char[wordArray.length];
        for (int i = 0; i < wordArray.length; i++) {
            hiddenWord[i] = '_';
        }
        int guesses = 0;
        int maxGuesses = 6;
        while (guesses < maxGuesses) {
        System.out.println(gallows[guesses]);
        System.out.println("Word: " + new String(hiddenWord));
        System.out.print("Guess: ");
        char guess = scan.next().charAt(0);
        System.out.println("\n");
        boolean found = false;

        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] == guess) {
                hiddenWord[i] = guess;
                found = true;
            }
        }
        System.out.println("Word: " + new String(hiddenWord));
        
        if (!found) {
            System.out.println("\nIncorrect!");
            guesses++;
        }

        if (new String(hiddenWord).equals(word)) {
            System.out.println("Congrats - you won! The word was: " + word);
            break;
        } 

        if (guesses >= maxGuesses){
            System.out.println("Sorry you lost the game. The word was " + word);
            break;
        }
    
    } 
    scan.close();  
    }    

    //function that will choose a random word
    public static String randomWordString() {
        Random random = new Random();
        int randomWords = random.nextInt(words.length);
        return words[randomWords];
    
    }

    public static String[] gallows = {
        "+---+\n" +
        "|   |\n" +
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",
    
        "+---+\n" +
        "|   |\n" +
        "O   |\n" +
        "    |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",
    
        "+---+\n" +
        "|   |\n" +
        "O   |\n" +
        "|   |\n" +
        "    |\n" +
        "    |\n" +
        "=========\n",
    
        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|   |\n" +
        "     |\n" +
        "     |\n" +
        " =========\n",
    
        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" + 
        "     |\n" +
        "     |\n" +
        " =========\n",
    
        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" +
        "/    |\n" +
        "     |\n" +
        " =========\n",
    
        " +---+\n" +
        " |   |\n" +
        " O   |\n" +
        "/|\\  |\n" + 
        "/ \\  |\n" +
        "     |\n" +
        " =========\n"};

        public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
        "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
        "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
        "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
        "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
        "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
        "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
        "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
        "wombat", "zebra"
        };

    

}
