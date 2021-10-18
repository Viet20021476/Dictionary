package dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {

    private Dictionary dictionary;
    /**
     * class dictionary la con cua class DictionaryManagement(khong phai ke thua)
     * 
     * @param child 
     */

    public DictionaryManagement(Dictionary child) {
        this.dictionary = child;
    }

    public void insertFromCommandline() {
        ArrayList<Word> words_list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numOfWords = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfWords; i++) {
            String word_target = scanner.next();
            String word_explain = scanner.nextLine();

            words_list.add(new Word(word_target, word_explain));
        }
        dictionary.setWords_list(words_list);
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

}
