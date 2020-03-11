package pk;

import java.util.ArrayList;
import java.util.Arrays;

public class GroupCmd extends LibraryCommand {
    private String argumentInput;

    public GroupCmd(String argumentInput) {

        super(CommandType.GROUP, argumentInput);
    }

    public void execute(LibraryData data) {
        if(data.getBookData().isEmpty()){
            System.out.println("The library has no book entries.");
            return;
        }

        if (argumentInput.equals("TITLE")) {
            System.out.println("Grouped data by TITLE");
            String[] bookTitle = new String[data.getBookData().size()];
            int index = 0;
            for (BookEntry theBook : data.getBookData()) {
                bookTitle[index] = theBook.getTitle();
                index++;
            }
            Arrays.sort(bookTitle);
            boolean needCharBefore = true;
            for (int i = 0; i < bookTitle.length; i++) {
                if (needCharBefore) {
                    System.out.println("## " + bookTitle[i].toUpperCase().charAt(0));
                    System.out.println("   " + bookTitle[i]);
                    if (i + 1 <= bookTitle.length) {
                        needCharBefore = bookTitle[i].toUpperCase().charAt(0) != bookTitle[i + 1].toUpperCase()
                                .charAt(0);
                    }
                } else {
                    System.out.println("   " + bookTitle[i]);
                    if (i + 1 <= bookTitle.length) {
                        needCharBefore = bookTitle[i].toUpperCase().charAt(0) != bookTitle[i + 1].toUpperCase()
                                .charAt(0);
                    }

                }

            }

        }

        if (argumentInput.equals("AUTHOR")) {
            System.out.println("Grouped data by AUTHOR");
            String[] bookAuthor = new String[data.getBookData().size()];
            int index = 0;
            for (BookEntry theBook : data.getBookData()) {
                bookAuthor[index] = theBook.getAuthors()[0];
                index++;
            }
            Arrays.sort(bookAuthor);
            ArrayList<String> cleanedBook = clean(bookAuthor);
            for (String theAuthor : cleanedBook) {
                System.out.println("## " + theAuthor);

                for (BookEntry theBook : data.getBookData()) {
                    if (theBook.getAuthors()[0].equals(theAuthor)) {
                        System.out.println("   " + theBook.getTitle());
                    }
                }


            }
        }

    }

    private ArrayList<String> clean (String[] uncleaned){
        ArrayList<String> theList = new ArrayList<String>();
        for (String theString:uncleaned){
            if(!theList.contains(theString)){
                theList.add(theString);
            }
        }
        return theList;
    }

    protected boolean parseArguments(String argumentInput) {
        if (argumentInput.equals("AUTHOR") || argumentInput.equals("TITLE")) {
            this.argumentInput = argumentInput;
            return true;
        } else {
            return false;
        }
    }
}