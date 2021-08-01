package Utils;


import Directories.Directories;
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FinalizeUtils {


    public static void main(String[] args) throws IOException {
        cleanFolder(Directories.EXTRACTION_FOLDER);
    }
    public static void openTextFile(File file) throws IOException {


        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().edit(file);
        }

    }

    public static void cleanFolder(String folderPath) throws IOException {

        FileUtils.cleanDirectory(new File(folderPath));
    }

}

