package dictionary;

import java.util.Scanner;

public class DictionaryCommandLine {

    private DictionaryManagement dictionaryManagement;

    /**
     * class DictionaryManagement la con cua class DictionaryCommandLine(khong
     * phai ke thua)
     *
     * @param child
     */
    public DictionaryCommandLine(DictionaryManagement child) {
        this.dictionaryManagement = child;
    }

    /**
     * In ra tat ca tu trong tu dien.
     */
    public void showAllWords() {
        int maxWordTargetLength = 0;
        for (Word word : dictionaryManagement.getDictionary().getWords_list()) {
            if (word.getWord_target().length() > maxWordTargetLength) {
                maxWordTargetLength = word.getWord_target().length();
            }
        }
        if (maxWordTargetLength < 7) {
            maxWordTargetLength = 7;
        }
        String nextPrintedLine = "No   | English";
        for (int i = 7; i < maxWordTargetLength + 3; i++) {
            nextPrintedLine += " ";
        }
        nextPrintedLine += "| Vietnamese";
        System.out.println(nextPrintedLine);
        for (Word word : dictionaryManagement.getDictionary().getWords_list()) {
            int numberOfCountDigit = 1;
            while (dictionaryManagement.getCount() >= Math.pow(10, numberOfCountDigit)) {
                numberOfCountDigit++;
            }
            nextPrintedLine = dictionaryManagement.getCount() + "";
            for (int i = numberOfCountDigit; i <= 4; i++) {
                nextPrintedLine += " ";
            }
            nextPrintedLine += "| " + word.getWord_target();
            for (int i = word.getWord_target().length(); i < maxWordTargetLength + 3; i++) {
                nextPrintedLine += " ";
            }
            nextPrintedLine += "| " + word.getWord_explain();
            System.out.println(nextPrintedLine);
            dictionaryManagement.setCount();
        }
        dictionaryManagement.renewCount();
    }

    /**
     * Tim kiem mot tu trong tu dien.
     */
    public void dictionarySearcher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tu ban can tim kiem: ");
        String word_search = scanner.next();
        for (Word word : dictionaryManagement.getDictionary().getWords_list()) {
            if (word.getWord_target().toLowerCase().contains(word_search.toLowerCase())) {
                System.out.println(word.getWord_target());
            }
        }
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        Scanner scanner = new Scanner(System.in);
        dictionaryManagement.insertFromFile();

        System.out.println("1. In ra toan bo tu dien");
        System.out.println("2. Tra cuu mot tu");
        System.out.println("3. Tra cuu nhieu tu");
        System.out.println("4. Them tu");
        System.out.println("5. Sua tu");
        System.out.println("6. Xoa tu");
        System.out.println("7. Thoat");

        int user_choice = Integer.parseInt(scanner.nextLine());
        switch (user_choice) {
            case 1:
                showAllWords();
                break;
            case 2:
                dictionaryManagement.dictionaryLookup();
                break;
            case 3:
                dictionarySearcher();
                break;
            case 4:
                dictionaryManagement.addWord();
                break;
            case 5:
                dictionaryManagement.editWord();
                break;
            case 6:
                dictionaryManagement.deleteWord();
                break;
            case 7:
                System.out.println("Goodbye.");
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
        while (user_choice != 7) {
            System.out.println("1. In ra toan bo tu dien");
            System.out.println("2. Tra cuu mot tu");
            System.out.println("3. Tra cuu nhieu tu");
            System.out.println("4. Them tu");
            System.out.println("5. Sua tu");
            System.out.println("6. Xoa tu");
            System.out.println("7. Thoat");

            user_choice = Integer.parseInt(scanner.nextLine());
            switch (user_choice) {
                case 1:
                    showAllWords();
                    break;
                case 2:
                    dictionaryManagement.dictionaryLookup();
                    break;
                case 3:
                    dictionarySearcher();
                    break;
                case 4:
                    dictionaryManagement.addWord();
                    break;
                case 5:
                    dictionaryManagement.editWord();
                    break;
                case 6:
                    dictionaryManagement.deleteWord();
                    break;
                case 7:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
        dictionaryManagement.dictionaryExportToFile();
    }

    public void dictionaryRun() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("___ TU DIEN TIENG ANH - VIET ___");
        System.out.println("1. Nhap tu dien tu command line");
        System.out.println("2. Nhap tu dien tu file dictionaries.txt");
        int user_choice = Integer.parseInt(scanner.nextLine());
        switch (user_choice) {
            case 1:
                dictionaryBasic();
                break;
            case 2:
                dictionaryAdvanced();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
        }
        while (user_choice != 1 && user_choice != 2) {
            user_choice = Integer.parseInt(scanner.nextLine());
            switch (user_choice) {
                case 1:
                    dictionaryBasic();
                    break;
                case 2:
                    dictionaryAdvanced();
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
