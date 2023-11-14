import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * This both encrypts and decrypts files based on the shift used. It checks to see if a character is a letter 
     * and if it is, it shifts it by the shift value.
     * @throws Exception if an error occurs while reading or writing the files
     * @param inputFilePath where the data is read from
     * @param outputFilePath where the shifted data is written
     */
    public void caesarCipher(String inputFilePath, String outputFilePath) throws Exception {
        //TODO: Call the read method, encrypt the file contents, and then write to new file
    	String data=FileReader.readFile(inputFilePath);
    	String result="";
    	for(int i=0;i<data.length();i++) {
        	char character=data.charAt(i);
        	if(Character.isLetter(character)) {
        	char c=(char)(data.charAt(i)+shift);
        	 if (Character.isLowerCase(data.charAt(i)) && c < 'a') {
                 result += (char) (data.charAt(i) + (26 + shift));
             } else if (Character.isUpperCase(data.charAt(i)) && c < 'A') {
                 result += (char) (data.charAt(i) + (26 + shift));
             } else {
                 result += c;
             }
        }else result+=character;
    }
    	FileReader.writeFile(result, outputFilePath);
}


    public class FileReader {

    	 /**
         * Reads data from a file.
         *
         * @param fileName the path to the file where the data will be read from.
         */
    	
    	
        private static String readFile(String fileName) throws Exception {
            String message = "";

            try (Scanner fileScanner = new Scanner(Paths.get(fileName))) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    message += line;
                } fileScanner.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());}

            return message;
        }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     */
    private static void writeFile(String data, String filePath) {
        //TODO: Write to filePath
    	
    	try(PrintWriter output=new PrintWriter(filePath)){
    		output.print(data);
    		output.close();
    	}catch(Exception e) {
    		System.out.println("Error: "+ e.toString());
    	}
    }

    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}}
