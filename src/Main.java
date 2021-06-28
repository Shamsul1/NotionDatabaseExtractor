import Directories.Directories;
import Model.Question;
import Utils.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    private static final String FILE_PATH = Directories.DESTINATION_FOLDER;
    private static final String DESTINATION_PATH = Directories.DESTINATION_FOLDER;
    private static final String LEARNED_STATE = Directories.LEARNED_STATE;
    private static final String REVIEW_STATE = Directories.REVIEW_STATE;

    public static void main(String[] args) throws Exception {

        List<Question> questions;

        extractZipFiles();
        converCSVtoXLSX();
        questions = getValidQuestions();
        getAnswers(questions);
        printQuestions(questions);
    }






    // Find and unzips zip files
    private static File[] getZipFiles(){

        File[] files = FileFinderUtils.findFile(FILE_PATH,".zip");

        System.out.println(files.length+" zip file(s) have been found!");
        for (File file :files) {

            System.out.println(file.getName());
        }
        System.out.println("---------------------------------------------------");
        return files;


    }
    private static void extractZipFiles(){

        File[] files = getZipFiles();

        for (File file: files) {

            UnzipUtils.unZip(file.getAbsolutePath(),DESTINATION_PATH);


        }

    }

    // Finds and converts csv files to xlsx files
    private static String getCSVfile(){

        File[] files = FileFinderUtils.findFile(FILE_PATH,".csv");

        System.out.println(files.length+" CSV file(s) have been found!");
        for (File file :files) {

            System.out.println(file.getName());
        }
        System.out.println("---------------------------------------------------");

        return files[0].getAbsolutePath();
    }
    private static void converCSVtoXLSX(){

       String csvPath = getCSVfile();

        ExcelUtils.convertCSVtoXLSX(csvPath,DESTINATION_PATH);

    }

    //Finds and gets valid questions from the xlsx file
    private static String getXlSXfile(){
        File[] files = FileFinderUtils.findFile(FILE_PATH,".xlsx");

        System.out.println(files.length+" xlsx file(s) have been found!");
        for (File file :files) {

            System.out.println(file.getName());
        }
        System.out.println("---------------------------------------------------");
        return files[0].getAbsolutePath();
    }
    private static List<Question> getValidQuestions() throws IOException {
        String filePath = getXlSXfile();
        List<Question> questions = ExcelUtils.getValidQuestions(filePath,LEARNED_STATE);
        return questions;

    }


    private static void getAnswers(List<Question> questions) throws Exception {

        List<String> subFolders = FileFinderUtils.findSubdirectories(Directories.HOME_FOLDER);
        String subFolder = subFolders.get(0)+"\\";

        File[] mdFiles = FileFinderUtils.findFile(subFolder, ".md");
        List<String> trimmedMDfiles = ProcessFileUtils.trimIDs(mdFiles);

        ProcessQuestionUtils.addMatchingMdFiles(questions,trimmedMDfiles);
        ProcessQuestionUtils.addMdAbsolutePath(mdFiles,questions);
        ProcessQuestionUtils.addAnswers(questions);

    }

    private static void printQuestions(List<Question> questions){

        for (Question question: questions) {

            System.out.println("Question: "+question.getQuestion());
            System.out.println("Answer: "+question.getAnswer());
            System.out.println("MD name: "+question.getMdFileName());
            System.out.println("Absolute path: "+question.getMdAbsolutePath());
            System.out.println("----------------------------------");

        }

    }


}
