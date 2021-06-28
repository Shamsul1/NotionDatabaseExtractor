package Utils;

import Directories.Directories;
import Model.Question;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProcessQuestionUtils {

    public static void main(String[] args) throws IOException {
       List<Question> question =  ExcelUtils.getValidQuestions(Directories.EXCEL_FILE_PATH,Directories.LEARNED_STATE);
       File[] mdFiles = FileFinderUtils.findFile(Directories.MD_FOLDER_PATH, ".md");
       List<String> trimmedMDfiles = ProcessFileUtils.trimIDs(mdFiles);
       addMatchingMdFiles(question,trimmedMDfiles);
       addMdAbsolutePath(mdFiles,question);


    }



    public static void addMatchingMdFiles(List<Question> questions, List<String> mdFiles){


        for( int i = 0; i < mdFiles.size(); i++){

            for(int k = 0; k < questions.size(); k++){

                if( questions.get(k).getQuestion().contains(mdFiles.get(i))){

                    questions.get(k).setMdFileName(mdFiles.get(i));

                    System.out.println(questions.get(k).getQuestion()+"\n"+mdFiles.get(i)+" is a match!");
                }
            }

        }



    }

    public static void addMdAbsolutePath(File[] mdFile, List<Question> questions){

        for(int i = 0; i < mdFile.length; i++){


            for(int k = 0; k < questions.size(); k++){

                if(mdFile[i].getName().contains(questions.get(k).getMdFileName())){

                    questions.get(k).setMdAbsolutePath(mdFile[i].getAbsolutePath());
                }
            }
        }



    }

    public static void addAnswers(List<Question> questions) throws Exception {


        for (Question question: questions) {

            question.setAnswer(FileReaderUtils.readMdFile(question.getMdAbsolutePath()).toString());

        }


    }





}
