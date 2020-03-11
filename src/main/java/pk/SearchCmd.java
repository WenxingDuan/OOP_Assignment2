package pk;

public class SearchCmd extends LibraryCommand {
    private String argumentInput;

    public SearchCmd(String argumentInput) {

        super(CommandType.SEARCH, argumentInput);
    }

    public void execute(LibraryData data) {
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


}
