package dictionary;

public class DictionaryCommandLine {

    private DictionaryManagement dictionaryManagement;
    private int count; // So thu tu khi in ra man hinh
    
    /**
     * class DictionaryManagement la con cua class DictionaryCommandLine(khong phai ke thua)
     * 
     * @param child 
     */

    public DictionaryCommandLine(DictionaryManagement child) {
        count = 1;
        this.dictionaryManagement = child;
    }

    public void showAllWords() {
        System.out.println("No  |English   |Vietnamese\n");
        for (Word word : dictionaryManagement.getDictionary().getWords_list()) {
            System.out.println(count + "    " + word.getWord_target() + "      " + word.getWord_explain());
            count++;
        }

    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        showAllWords();
    }

}
