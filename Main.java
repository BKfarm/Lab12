import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());
        int lines = 0;
        int words = 0;
        int characters = 0;
        
        try  // Code that might trigger the exception goes here
        {
                        
                if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                {
                    target = chooser.getSelectedFile().toPath();  // this is a File object not a String filename 

                inFile = new Scanner(target);

                while(inFile.hasNextLine())
                {
                    line = inFile.nextLine();
                    lines += 1;
                    characters += line.length();
                    for(int b = 0; b < line.length(); b++)
                    {
                        if (Character.isWhitespace(line.charAt(b)));
                        {
                            words += 1;
                        }
                    }
                    //System.out.println(line);
                    words += 1;
                }

                 inFile.close();
                 System.out.println("Filename: " + target);
                 System.out.println("lines in file: " + lines);
                 System.out.println("words in file: " + words);
                 System.out.println("characters in file: " + characters);
            }
            else   // User did not pick a file, closed the chooser
            {
                System.out.println("Sorry, you must select a file! Termininating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Error");
            e.printStackTrace();           
        }
        catch (IOException e) // code to handle this exception
        {
            System.out.println("IOException Error");
            e.printStackTrace();
        }

    }
}