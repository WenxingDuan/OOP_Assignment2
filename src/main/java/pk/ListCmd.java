package pk;

import java.util.*;

/**
 * class to list all book
 */

public class ListCmd extends LibraryCommand {
    
    private String argumentInput;
    /**
     * 
     * @param argumentInput Long/Short
     * @throws IllegalArgumentException if given arguments are invalid
     * @throws NullPointerException if the given argumentInput is null.
     */
    public ListCmd(String argumentInput) {

        super(CommandType.LIST, argumentInput);
        
    }

    /**
     * print out the library data base of arguementInput
     */
    @Override
    public void execute(LibraryData data) {
        Objects.requireNonNull(data, "data connot be null");

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
    /**
     * @return True if input arguement is long/short or nullF
     */
    protected boolean parseArguments(String argumentInput) {
        if (argumentInput.equals("short") || argumentInput.equals("long") || argumentInput.equals("")) {
            this.argumentInput = argumentInput;
            return true;
        } else {
            return false;
        }

    }

}