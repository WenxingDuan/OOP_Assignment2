package pk;
import java.util.*;
public class SearchCmd extends LibraryCommand {
    private String argumentInput;

    public SearchCmd(String argumentInput) {

        super(CommandType.SEARCH, argumentInput);
    }

    public void execute(LibraryData data) {
        Objects.requireNonNull(data, "data connot be null");
        int numberFound = 0;
        for (BookEntry theBook : data.getBookData()) {
            if (search(argumentInput, theBook.getTitle())) {
                System.out.println(theBook.getTitle());
                numberFound++;
            }
        }
        if (numberFound == 0) {
            System.out.println("No hits found for search term: " + argumentInput);
        }

    }

    protected boolean parseArguments(String argumentInput) {
        if (search(" ", argumentInput) || argumentInput.equals("")) {
            return false;
        } else {
            this.argumentInput = argumentInput;
            return true;
        }

    }
    public boolean search(String keyWord, String contant) {
        contant = contant.toLowerCase();
        keyWord = keyWord.toLowerCase();
        if (keyWord.length() > contant.length()) {
            return false;
        }
        int loopTime = contant.length() - keyWord.length() + 1;
        int keyWordLength = keyWord.length();
        boolean flag = false;
        for (int i = 0; i < loopTime; i++) {
            flag = keyWord.equals(contant.substring(i, i + keyWordLength));
            if (flag) {
                break;
            }
        }
        return flag;
    }


}
