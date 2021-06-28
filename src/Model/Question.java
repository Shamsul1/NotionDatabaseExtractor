package Model;

public class Question {

    private String question;
    private String answer;
    private String  mdFileName;
    private String mdAbsolutePath;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMdAbsolutePath() {
        return mdAbsolutePath;
    }

    public void setMdAbsolutePath(String mdAbsolutePath) {
        this.mdAbsolutePath = mdAbsolutePath;
    }

    public String getMdFileName() {
        return mdFileName;
    }

    public void setMdFileName(String mdFileName) {
        this.mdFileName = mdFileName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
