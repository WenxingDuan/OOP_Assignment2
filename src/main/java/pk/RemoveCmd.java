package pk;

import java.util.*;

public class RemoveCmd extends LibraryCommand {
    private String argumentInput;

    public RemoveCmd(String argumentInput) {

        super(CommandType.REMOVE, argumentInput);
    }

    public void execute(LibraryData data) {
        Objects.requireNonNull(data, "data connot be null");
        int numberBooks = 0;
        String keyword = formatArguement(argumentInput)[1];
        String searchType = formatArguement(argumentInput)[0];

        if (searchType.equals("AUTHOR")) {
            Iterator<BookEntry> it = data.getBookData().iterator();
            while (it.hasNext()) {

                boolean searchSucess = search(keyword, it.next().getAuthors()[0]);
                if (searchSucess) {
                    it.remove();
                    numberBooks++;
                    break;
                }
            }

            System.out.println(numberBooks + " books removed for author: " + keyword);
        }

        if (searchType.equals("TITLE")) {
            Iterator<BookEntry> it = data.getBookData().iterator();
            while (it.hasNext()) {
                String title = it.next().getTitle();
                boolean searchSucess = search(keyword, title);

                if (searchSucess) {

                    System.out.println(title + ": removed successfully.");
                    it.remove();
                    numberBooks++;
                    break;
                }
            }
            if (numberBooks == 0) {
                System.out.println("some unknown value: not found.");
            }

        }
    }

    private String[] formatArguement(String argumentInput) {
        String[] arguement = argumentInput.split(" ");
        String secondPart = "";
        for (int i = 1; i < arguement.length; i++) {
            secondPart = secondPart + arguement[i] + " ";
        }

        secondPart = secondPart.substring(0, secondPart.length() - 1);
        String[] returnValue = { arguement[0], secondPart };
        return returnValue;

    }

    protected boolean parseArguments(String argumentInput) {
        if (search(" ", argumentInput) == false) {
            return false;
        }
        String[] word = argumentInput.split(" ");
        if (word.length < 2) {
            return false;
        }
        if ((word[0].equals("AUTHOR") || word[0].equals("TITLE")) && !word[1].equals("")) {
            this.argumentInput = argumentInput;
            return true;
        } else {
            return false;
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