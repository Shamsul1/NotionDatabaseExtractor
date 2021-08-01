package Model;

public class Question {

    private String quetionOriginal;
    private String question;
    private String answer;
    private String  mdFileName;
    private String mdAbsolutePath;
    private String tag;

    public String getQuetionOriginal() {
        return quetionOriginal;
    }

    public void setQuetionOriginal(String quetionOriginal) {
        this.quetionOriginal = quetionOriginal;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

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
