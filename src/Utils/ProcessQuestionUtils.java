package Utils;

import Directories.Directories;
import Model.Question;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProcessQuestionUtils {

    public static void main(String[] args) throws IOException {
       List<Question> question =  ExcelUtils.getValidQuestions(Directories.EXCEL_FILE_PATH,Directories.LEARNED_STATE);
       File[] mdFiles = FileFinderUtils.findFile(Directories.MD_FOLDER_PATH, ".md");
       List<String> trimmedMDfiles = ProcessFileUtils.trimIDs(mdFiles);
       addMatchingMdFiles(question,trimmedMDfiles);
       addMdAbsolutePath(mdFiles,question);


    }



    public static void addMatchingMdFiles(List<Question> questions, List<String> mdFiles){


        for( int i = 0; i < questions.size(); i++){

            boolean isMatch = false;

            for(int k = 0; k < mdFiles.size(); k++){

                System.out.println(questions.get(i).getQuestion()+" - "+mdFiles.get(k));
                if( questions.get(i).getQuestion().contains(mdFiles.get(k))){

                    questions.get(i).setMdFileName(mdFiles.get(k));

                    System.out.println(questions.get(i).getQuestion()+"\n"+mdFiles.get(k)+" is a match!");
                    isMatch = true;
                }
            }
            if(!isMatch){
                System.out.println("No match found for file: "+questions.get(i).getQuestion());
            }

        }



    }

    public static void addMdAbsolutePath(File[] mdFile, List<Question> questions){

        System.out.println("md file lenght"+mdFile.length);
        System.out.println("question lenght"+questions.size());


        for (Question question: questions) {

            System.out.println(question.getMdFileName());
        }

        for(int i = 0; i < questions.size(); i++){


            for(int k = 0; k < mdFile.length; k++){

                if(mdFile[k].getName().contains(questions.get(i).getMdFileName())){

                    questions.get(i).setMdAbsolutePath(mdFile[k].getAbsolutePath());
                }
            }
        }



    }

    public static void addAnswers(List<Question> questions) throws Exception {


        for (Question question: questions) {

            question.setAnswer(FileReaderUtils.readMdFile(question.getMdAbsolutePath()).toString());

        }


    }

    public static List<Question> removeSymbols(List<Question> questions){

        String[] symbols = {"/","\\","*"};

        for (int i = 0; i < symbols.length; i++) {

            for (Question question: questions) {

                if( question.getQuestion().contains(symbols[i])){

                    String newQuestion = question.getQuestion().replace(symbols[i]," ");
                    question.setQuestion(newQuestion);
                    System.out.println("Symbol removed from question: "+newQuestion);
                }

                if(question.getQuestion().contains("?")){


                    question.setQuestion(question.getQuestion().replace("?",""));
                }


            }


        }


        return questions;
    }

    public static void stylingAnswers(List<Question> questions, String state){

        String[] styles = {"**","*"};

        if(state.equalsIgnoreCase(Directories.ANKI_STATE)){

            for (Question question : questions) {

                String answer = question.getAnswer();

                Scanner scanner = new Scanner(answer);
                StringBuilder st = new StringBuilder();
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                        if(line.contains("*")){

                            if(line.contains("**")){

                                line = line.replace("**","");
                                line = "<b>"+line+"</b>";
                                st.append(line);

                            }else {

                                line = line.replace("*","");
                                line = "<i>"+line+"</i>";
                                st.append(line);
                            }
                            System.out.println(line);
                            question.setAnswer(st.toString());
                        }






                }

                scanner.close();

            }


        }



    }


}
