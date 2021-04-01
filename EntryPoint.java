import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EntryPoint {

    public static void main(String[] args) throws IOException{
        Scanner keyboard = new Scanner (System.in);
        String message = " Enter the full file path : ";
        System.out.println(message);
        String file_path = keyboard.nextLine();
        // /Users/rachitajain/Desktop/intro.txt
        readText(file_path);
    }
    private static void readText(String fileName) throws IOException {

        int word = 0;
        int whitespace = 0;
        int sentence = 0;
        int paragraphs = 0;

        try {
            FileInputStream fileStream = new FileInputStream(fileName);
            InputStreamReader input = new InputStreamReader(fileStream);
            BufferedReader reader = new BufferedReader(input);
            String line = reader.readLine();
            //read line by line
            while ((line = reader.readLine()) != null) {
                // remove extra spaces
                line = line.trim();

                // account paragraphs when there are empty lines
                if (line.equals("")) {
                    paragraphs++;
                    while (line != null && line.equals("")) {
                        line = reader.readLine();
                    }
                }
                // read textual part line by line
                if (line != null) {
                    String[] wordList = line.split("\\s+");
                    word += wordList.length;
                    whitespace += word - 1;
                    String[] sentenceList = line.split("[!?.:]+[\\s\"]+");
                    //                int i = 0;
                    //                for (i = 0; i<sentenceList.length; i++) {
                    //                    System.out.println("word in second :");
                    //                    System.out.println(sentenceList[i]);
                    //                }
                    sentence += sentenceList.length;

                }
//
            }

            reader.close();
            System.out.println("words : " + word);
            System.out.println("sentences : " + sentence);
            System.out.println("paragraphs :" + paragraphs);
        }
        catch (FileNotFoundException e){
            System.out.println("File does not exists");
        }
    }

}
