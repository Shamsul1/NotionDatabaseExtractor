package Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProcessFileUtils {

    public static void main(String[] args) {
        //getFileIdRemoved();
        List<String> trimmedMds = trimIDs(FileFinderUtils.findFile("C:\\Users\\Samsul Karim\\Desktop\\The.Mess.You.Leave.Behind\\Local Database e41899488a2b4e149b128c097d0f460e\\",".md"));

        for (String file: trimmedMds) {

            System.out.println(file);
        }

    }

    public static String getFileIdRemoved(String fileName){

        StringBuilder stringBuffer = new StringBuilder();

        for (String word : fileName.split(" ")){

            if(word.length()<15){
                stringBuffer.append(" ").append(word);
            }
        }

        return stringBuffer.toString().trim();

    }

    public static List<String> trimIDs(File[] files){

        List<String> fileNames = new ArrayList<>();

        for (File file: files) {

            fileNames.add(getFileIdRemoved(file.getName()));

        }

        return fileNames;




    }



}
