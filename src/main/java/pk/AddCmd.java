package pk;

import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * class to add the datavase into program
 */
public class AddCmd extends LibraryCommand {
    private Path filePath;

    /**
     * 
     * @param argumentInput path string inputed to program
     * @throws IllegalArgumentException if given arguments are invalid
     * @throws NullPointerException if the given argumentInput is null.
     */
    public AddCmd(String argumentInput) {

        super(CommandType.ADD, argumentInput);
    }

    @Override
    public void execute(LibraryData data) {
        Objects.requireNonNull(data, "data connot be null");
        data.loadData(filePath);

    }

    /**
     * @return true if path ending with .csv
     */
    protected boolean parseArguments(String argumentInput) {
        if (argumentInput.length() <= 4) {
            return false;
        }
        String fileType = argumentInput.substring(argumentInput.length() - 3, argumentInput.length());
        if (fileType.equals("csv")) {
            filePath = Paths.get(argumentInput);
            return true;
        } else {
            return false;
        }

    }
}