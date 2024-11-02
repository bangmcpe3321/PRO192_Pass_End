import java.util.StringTokenizer;

public class MyString implements IString {

    @Override
    public int f1(String str) {
        // Using StringTokenizer to split the string into words
        StringTokenizer tokenizer = new StringTokenizer(str);
        int count = 0;
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            // Checking if the word contains at least one letter
            if (word.matches(".*[a-zA-Z].*")) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String f2(String str) {
        // Using lastIndexOf to find the last space character
        int lastIndex = str.lastIndexOf(' ');
        // Returning the substring from the beginning to the last space character
        if (lastIndex != -1) {
            return str.substring(0, lastIndex);
        } else {
            // If there's no space, return an empty string or handle the case accordingly
            return "";
        }
    }

    public static void main(String[] args) {
        // Example usage
        MyString myString = new MyString();
        String inputString = "Hello world! This is a test string.";
        System.out.println("Number of words with at least one letter: " + myString.f1(inputString));
        System.out.println("String after removing the last word: " + myString.f2(inputString));
    }
}

