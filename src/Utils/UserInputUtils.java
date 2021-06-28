package Utils;

import Directories.Directories;

import javax.swing.*;

public class UserInputUtils {

    public static void main(String[] args) {


    }



    public static String getValidationStateUserInpu(){


        String[] sports = { "Review", "Learned", "Learn", "Anki" };
        String res = (String) JOptionPane.showInputDialog(null, "What questions would you like to get?", "Notion Database Extractor",
                JOptionPane.PLAIN_MESSAGE, null, sports, sports[0]);

        switch (res) {
            case "Review" -> {
                return Directories.REVIEW_STATE;
            }
            case "Learned" -> {
                return Directories.LEARNED_STATE;
            }
            case "Learn" -> {
                return Directories.LEARN_STATE;
            }
            case "Anki" -> {
                return Directories.ANKI_STATE;
            }
        }


        return null;
    }
}
