package Utils;

import Directories.Directories;
import Model.Question;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Dictionary;
import java.util.List;

public class OutputUtils {


    public static void main(String[] args) {


    }



    public static void output(List<Question> questions){

        StringBuilder stringBuilder = new StringBuilder();

        for (Question question: questions) {


        }


    }

    private static void writeText() {
        try {
            FileWriter myWriter = new FileWriter(Directories.HOME_FOLDER+"\\filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
