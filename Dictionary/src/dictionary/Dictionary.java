package dictionary;

import java.util.ArrayList;

public class Dictionary {

    private ArrayList<Word> words_list;

    public Dictionary() {
    }

    /**
     * Khoi tao 1 danh sach cac tu
     *
     * @param words_list
     */
    public Dictionary(ArrayList<Word> words_list) {
        this.words_list = words_list;
    }

    public ArrayList<Word> getWords_list() {
        return words_list;
    }

    public void setWords_list(ArrayList<Word> words_list) {
        this.words_list = words_list;
    }

}
