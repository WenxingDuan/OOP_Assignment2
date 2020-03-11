package pk;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AddCmd extends LibraryCommand {
    private Path filePath;

    public AddCmd(String argumentInput) {

        super(CommandType.ADD, argumentInput);
    }

    public void execute(LibraryData data) {
        data.loadData(filePath);

    }

    protected boolean parseArguments(String argumentInput) {
        if (argumentInput.length()<=4){
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