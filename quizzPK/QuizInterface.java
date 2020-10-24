package quizzPK;

public interface QuizInterface {

	public String getQuestion(int currentQuestionNumber) ;

	public boolean isGoodAnswer(int currentQuestionNumber, String answer);

	public String getAnswer(int currentQuestionNumber);

	public int size();

	public void addQuestion(QuestionInterface q1);

}
