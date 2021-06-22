package Utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class FileFinderUtils {

    private final static String FOLDER_PATH = "C:\\Users\\Samsul Karim\\Desktop\\The.Mess.You.Leave.Behind\\";
    private final static String FILE_TYPE_ENDING = ".srt";


    public static void main(String[] args) {
       File[] files =  findFile(FOLDER_PATH, FILE_TYPE_ENDING);
        for (File file :files) {
            System.out.println(file.getName().toString());
        }

       ArrayList<String> subdirs =  findSubdirectories(FOLDER_PATH);

        for (String name: subdirs) {

            System.out.println(name);
        }
    }

    public static File[] findFile(String filePath, String fileEnging){

        File dir = new File(filePath);

        File[] matches = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name)
            {
                return name.endsWith(fileEnging);
            }
        });

        return matches;

    }

    public static ArrayList<String> findSubdirectories(String directory){

        ArrayList<String> mainDirectoryAdded = new ArrayList<>();
        File file = new File(directory);

        String[] names = file.list();

        for (String name:names) {

            if(new File(directory+name).isDirectory()){
                mainDirectoryAdded.add(directory+name);
            }

        }

        return mainDirectoryAdded;
    }
}
