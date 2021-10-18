package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DictionaryManagement {

    private Dictionary dictionary;
    private int count; // So thu tu khi in ra man hinh
    private ArrayList<Word> temp_words_list = new ArrayList<>();

    /**
     * class dictionary la con cua class DictionaryManagement(khong phai ke
     * thua)
     *
     * @param child
     */
    public DictionaryManagement(Dictionary child) {
        count = 1;
        this.dictionary = child;
    }

    /**
     * Ham nay doc du lieu tu dong lenh.
     */
    public void insertFromCommandline() {
        ArrayList<Word> words_list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong tu: ");
        int numOfWords = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap cac tu:");

        for (int i = 0; i < numOfWords; i++) {
            String word_target = scanner.next();
            String[] s = word_target.split(" "); // Xu ly troi lenh
            String word_explain = scanner.nextLine();

            words_list.add(new Word(s[0], word_explain));
        }
        dictionary.setWords_list(words_list);
    }

    /**
     * Ham nay doc du lieu tu file txt.
     */
    public void insertFromFile() {
        ArrayList<Word> words_list = new ArrayList<>();

        try {
            File file = new File(".\\src\\txtFiles\\dictionaries.txt");
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                String word_target = readFile.next();
                String word_explain = readFile.nextLine();
                word_explain = word_explain.substring(1, word_explain.length()); // loai bo dau cach o dau
                words_list.add(new Word(word_target, word_explain));
            }
            dictionary.setWords_list(words_list);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DictionaryManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Tim kiem nghia cua mot tu vung.
     */
    public void dictionaryLookup() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap tu ban can tim kiem: ");
        String word_target_find = scanner.nextLine();
        boolean wordExists = false;
        for (Word word : dictionary.getWords_list()) {
            if (word.getWord_target().toLowerCase().equals(word_target_find.toLowerCase())) {
                System.out.println("Nghia cua tu do la:" + word.getWord_explain());
                wordExists = true;
            }
        }
        if (!wordExists) {
            System.out.println("Tu nay khong ton tai trong tu dien!");
            System.out.println("Ban muon them tu nay vao khong?");
            System.out.println("1. Co\n2. Khong");

            int user_choice = Integer.parseInt(scanner.nextLine());
            switch (user_choice) {
                case 1:
                    addWord();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
            while (user_choice != 1 && user_choice != 2) {
                user_choice = Integer.parseInt(scanner.nextLine());
                switch (user_choice) {
                    case 1:
                        addWord();
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            }
        }
    }

    /**
     * Them mot tu vung vao tu dien
     */
    public void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap tu vung can them: ");
        String new_word_target = scanner.nextLine();
        String[] s = new_word_target.split(" "); // Xu ly troi lenh
        System.out.print("Nhap nghia cua tu: ");
        String new_word_explain = scanner.nextLine();
        dictionary.getWords_list().add(new Word(s[0], new_word_explain));
    }

    /**
     * Sua mot tu vung trong tu dien
     */
    public void editWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap tu ban muon sua: ");
        String word_to_edit = scanner.nextLine();

        for (int i = 0; i < dictionary.getWords_list().size(); i++) {
            if (dictionary.getWords_list().get(i).getWord_target().toLowerCase().equals(word_to_edit.toLowerCase())) {
                System.out.println("1.Sua tu vung\n2.Sua nghia cua tu vung\n3.Sua ca hai");
                int user_choice = Integer.parseInt(scanner.nextLine());

                switch (user_choice) {
                    case 1:
                        System.out.print("Nhap tu vung moi: ");
                        String new_word_target = scanner.nextLine();
                        String[] s = new_word_target.split(" "); // Xu ly troi lenh
                        dictionary.getWords_list().get(i).setWord_target(s[0]);
                        break;
                    case 2:
                        System.out.print("Nhap nghia moi cua tu: ");
                        String new_word_explain = scanner.nextLine();
                        dictionary.getWords_list().get(i).setWord_explain(new_word_explain);
                        break;
                    case 3:
                        System.out.print("Nhap tu vung moi: ");
                        new_word_target = scanner.nextLine();
                        s = new_word_target.split(" "); // Xu ly troi lenh
                        System.out.print("Nhap nghia moi cua tu: ");
                        new_word_explain = scanner.nextLine();
                        dictionary.getWords_list().get(i).setWord_target(s[0]);
                        dictionary.getWords_list().get(i).setWord_explain(new_word_explain);
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
                while (user_choice < 1 || user_choice > 3) {
                    user_choice = Integer.parseInt(scanner.nextLine());

                    switch (user_choice) {
                        case 1:
                            System.out.print("Nhap tu vung moi: ");
                            String new_word_target = scanner.nextLine();
                            String[] s = new_word_target.split(" "); // Xu ly troi lenh
                            dictionary.getWords_list().get(i).setWord_target(s[0]);
                            break;
                        case 2:
                            System.out.print("Nhap nghia moi cua tu: ");
                            String new_word_explain = scanner.nextLine();
                            dictionary.getWords_list().get(i).setWord_explain(new_word_explain);
                            break;
                        case 3:
                            System.out.print("Nhap tu vung moi: ");
                            new_word_target = scanner.nextLine();
                            s = new_word_target.split(" "); // Xu ly troi lenh
                            System.out.print("Nhap nghia moi cua tu: ");
                            new_word_explain = scanner.nextLine();
                            dictionary.getWords_list().get(i).setWord_target(s[0]);
                            dictionary.getWords_list().get(i).setWord_explain(new_word_explain);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                }
            }
        }
        renewCount();
    }

    /**
     * Xoa 1 tu vung trong tu dien
     */
    public void deleteWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap tu ban muon xoa: ");
        String word_to_delete = scanner.next();
        for (int i = 0; i < dictionary.getWords_list().size(); i++) {
            if (dictionary.getWords_list().get(i).getWord_target().toLowerCase().equals(word_to_delete.toLowerCase())) {
                dictionary.getWords_list().remove(i);
                renewCount();
                System.out.println("Tu " + word_to_delete + " da duoc xoa.");
            } else {
                System.out.println("Tu ban muon xoa khong ton tai.");
            }
        }
    }

    /**
     * Ghi du lieu ra file txt
     */
    public void dictionaryExportToFile() {
        renewCount();
        try {
            File file = new File(".\\src\\txtFiles\\dictionaries.txt");
            FileWriter fileWriter = new FileWriter(file, false);
            PrintWriter printWriter = new PrintWriter(fileWriter, true);
            for (Word word : this.getDictionary().getWords_list()) {
                printWriter.println(word.getWord_target() + " " + word.getWord_explain());
                setCount();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        count++;
    }

    public void renewCount() {
        count = 1;
    }
}
