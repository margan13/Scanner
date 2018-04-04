import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Scanner {


    public static void main(String[] args) throws IOException {

        String inText = readFromFile();
        Interpreter interpret = new Interpreter(inText);
        writeToFile(interpret.interpret());
    }


    public static String readFromFile() throws IOException {
        FileInputStream fis = new FileInputStream("cppFile.txt");
        StringBuilder sb = new StringBuilder();

        while (fis.available() > 0) {
            char current = (char) fis.read();
            sb.append(current);
        }

        return sb.toString();
    }

    public static void writeToFile(String html) throws IOException {
        File file = new File("htmlFile.html");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fop = new FileOutputStream(file);
        byte[] bytesArray = html.getBytes();
        fop.write(bytesArray);
        fop.close();
    }

}