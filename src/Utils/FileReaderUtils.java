package Utils;


import Directories.Directories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReaderUtils {

    public static final String NOT_VALID1= "#";
    public static final String NOT_VALID2= "Recall:";
    public static final String NOT_VALID3= "State:";
    public static final String NOT_VALID4= "Tag:";
    public static final String NOT_VALID5= ".png";



    public static void main(String[] args) throws Exception {

    }



    public static StringBuilder readMdFile(String mdFilePath) throws Exception {

        StringBuilder answer = new StringBuilder();
        File file = new File(mdFilePath);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null){

           if(validateLine(st) != null){

               answer.append(validateLine(st));

           }
        }
        return answer;
    }


    public static String validateLine(String line){

        String[] validaitonRules = {NOT_VALID1,NOT_VALID2,NOT_VALID3,NOT_VALID4,NOT_VALID5};

        boolean isMatch = false;


        for(int i = 0; i < validaitonRules.length; i++){

            if(line.contains(validaitonRules[i])){
                isMatch = true;

            }
        }

        if(line.length()==0){
            isMatch = true;
        }


        if(isMatch){
            return null;
        }else {
            return line;
        }



    }



}
