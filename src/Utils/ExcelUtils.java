package Utils;


import Model.Question;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelUtils {

    private static final String file_path = "C:\\Users\\Samsul Karim\\Desktop\\The.Mess.You.Leave.Behind\\Local Database e41899488a2b4e149b128c097d0f460e.csv";
    private static final String destination_path = "C:\\Users\\Samsul Karim\\Desktop\\The.Mess.You.Leave.Behind\\";
    private static final String excel_file_path = "C:\\Users\\Samsul Karim\\Desktop\\The.Mess.You.Leave.Behind\\Loca.xlsx";

    private static final String LEARNED_STATE = "Learned";
    private static final String REVIEW_STATE = "Review";



    public static void main(String[] args) throws IOException {


        //convertCSVtoXLSX(file_path,destination_path);
        //getValidQuestions(excel_file_path);
    }

    public static void convertCSVtoXLSX(String csvFilePath, String destinationPath){

        try {
            String csvFileAddress = csvFilePath; //csv file address
            String xlsxFileAddress = destinationPath+"excel_file.xlsx"; //xlsx file address
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("sheet1");
            String currentLine=null;
            int RowNum=0;
            BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
            while ((currentLine = br.readLine()) != null) {
                String str[] = currentLine.split(",");

                XSSFRow currentRow=sheet.createRow(RowNum);
                for(int i=0;i<str.length;i++){
                    currentRow.createCell(i).setCellValue(str[i]);
                }
                RowNum++;
            }

            FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
            br.close();
            System.out.println("Done");
        } catch (Exception ex) {
            System.out.println(ex.getMessage()+"Exception in try");
        }



    }

    public static List<Question> getValidQuestions(String excelFilePath, String stateValidity) throws IOException {
        List<Question> questions = new ArrayList<>();

        File file = new File(excelFilePath);   //creating a new file instance
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
        //creating Workbook instance that refers to .xlsx file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object

        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        while (itr.hasNext()) {
            Row row = itr.next();

          if(pickQuestions(row, stateValidity) != null){

              questions.add(pickQuestions(row,stateValidity));
          }
        }

        System.out.println(questions.size()+" valid questions have been found!");
        for (Question question : questions) {
            System.out.println(question.getQuestion());
        }
        System.out.println("---------------------------------------------------");
        return questions;
    }

    private static Question pickQuestions(Row row, String stateValidity){

        if(row.getCell(3) == null){

            //System.out.println(row.getCell(1).getStringCellValue()+" has a null state!");
            return null;

        }
        if(row.getCell(3).getStringCellValue().equalsIgnoreCase(stateValidity)){

            Question question = new Question();

            question.setQuestion(row.getCell(1).getStringCellValue());
            question.setQuetionOriginal(row.getCell(1).getStringCellValue());
            question.setTag(row.getCell(2).getStringCellValue());
            return question;

        }else {
            return null;
        }

    }
}