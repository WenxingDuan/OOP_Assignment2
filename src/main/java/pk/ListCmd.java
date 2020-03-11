package pk;

import java.util.ArrayList;

public class ListCmd extends LibraryCommand {
    private String argumentInput;

    public ListCmd(String argumentInput) {

        super(CommandType.LIST, argumentInput);
        
    }

    public void execute(LibraryData data) {
        if (data.getBookData().size() == 0) {
            System.out.println(data.getBookData().size() + " The library has no book entries.");
        } else {
            System.out.println(data.getBookData().size() + " books in library:");

            for (BookEntry theBook : data.getBookData()) {
                if (argumentInput.equals("short") || argumentInput.equals("")) {
                    System.out.println(theBook.getTitle());
                }
                if (argumentInput.equals("long")) {
                    System.out.println(theBook.toString() + "\n");
                }
            }
        }

    }

    protected boolean parseArguments(String argumentInput) {
        if (argumentInput.equals("short") || argumentInput.equals("long") || argumentInput.equals("")) {
            this.argumentInput = argumentInput;
            return true;
        } else {
            return false;
        }

    }

}