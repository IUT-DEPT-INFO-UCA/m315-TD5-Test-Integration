package quizzPK;

public interface GameInterface {

	void startGame();

	boolean isNotOver();

	String nextQuestion();

	boolean isAnswerValid(String answer);

	String getRightAnswer();

	int getPoints();

}
