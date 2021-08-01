package Utils;

import Directories.Directories;
import Model.Question;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputUtils {


    public static void main(String[] args) {



    }



    public static void output(List<Question> questions, String validationState, StringBuilder stringBuilder){


        for (Question question: questions) {

            if(validationState.equalsIgnoreCase("Anki")){
                stringBuilder.append(question.getQuetionOriginal()).append("\t").append(question.getAnswer()).append("\t").append(question.getTag()).append("\n");

            }else {
                stringBuilder.append(question.getQuetionOriginal()).append("\t").append(question.getAnswer()).append("\n==++");

            }
        }

    }

    public static void writeText(String strings) {
        try {
            FileWriter myWriter = new FileWriter(Directories.HOME_FOLDER+"\\filename.txt");
            myWriter.write(strings);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
