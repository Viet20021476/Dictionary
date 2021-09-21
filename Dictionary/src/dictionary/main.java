package dictionary;

public class main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement dictionaryManagement = new DictionaryManagement(dictionary);
        DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine(dictionaryManagement);
        dictionaryCommandLine.dictionaryBasic();
        
    }

}
