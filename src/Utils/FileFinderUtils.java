package Utils;

import Directories.Directories;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FileFinderUtils {

    private final static String FOLDER_PATH = "C:\\Users\\Samsul Karim\\Desktop\\The.Mess.You.Leave.Behind\\";
    private final static String FILE_TYPE_ENDING = ".srt";


    public static void main(String[] args) {

        getImageFolders(Directories.EXTRACTION_FOLDER);
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

    public static List<File> getImageFolders(String extractionFolderPath){

        List<String> extractionFolders = findSubdirectories(extractionFolderPath);
        List<String> stringImageFolders = findSubdirectories(extractionFolders.get(0)+"\\");
        List<File> imageFolders = new ArrayList<>();

        System.out.println(stringImageFolders.size());

        for (int i = 0; i < stringImageFolders.size(); i++) {

            File file = new File(stringImageFolders.get(i));
            imageFolders.add(file);
            System.out.println("Image folder: "+file.getName());

        }

        return imageFolders;

    }

    public static void findImage(File[] imageFolder){

        String[] imageTypes = {".jpg",".png"};

        for( int i = 0; i < imageFolder.length; i++){




            for (String imageType: imageTypes) {




            }

        }
    }


}
