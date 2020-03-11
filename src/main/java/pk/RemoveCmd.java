package pk;

public class RemoveCmd extends LibraryCommand {
    private String argumentInput;

    public RemoveCmd(String argumentInput) {

        super(CommandType.REMOVE, argumentInput);
    }

    public void execute(LibraryData data) {
        int numberBooks = 0;

        String keyword = formatArguement(argumentInput)[1];
        String searchType = formatArguement(argumentInput)[0];

        if (searchType.equals("AUTHOR")) {
            for (BookEntry theBook : data.getBookData()) {

                for (String theAuther : theBook.getAuthors()) {
                    boolean searchSucess = search(keyword, theAuther);
                    if (searchSucess) {
                        data.removeBook(theBook);
                        numberBooks++;
                        break;
                    }
                }

            }
            System.out.println(numberBooks + " books removed for author: " + keyword);
        }

        if (searchType.equals("TITLE")) {
            for (BookEntry theBook : data.getBookData()) {

                boolean searchSucess = search(keyword, theBook.getTitle());
                if (searchSucess) {
                    data.removeBook(theBook);
                    System.out.println(keyword + ": removed successfully.");
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
}