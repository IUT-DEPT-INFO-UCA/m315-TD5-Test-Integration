

import java.util.Scanner;

import quizzPK.*;

public class MainScenario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		QuizInterface quiz = new Quiz();
		QuestionInterface q1 = new Question("Capitale de la France ?", "Paris");
		QuestionInterface q2 = new Question("Capitale de l'Allemagne ?", "Berlin");
		QuestionInterface q3 = new Question("Capitale de l'Italie", "Rome");

		quiz.addQuestion(q1);
		quiz.addQuestion(q2);
		quiz.addQuestion(q3);
		GameInterface game = new Game(quiz);

		game.startGame();

		while (game.isNotOver()) {
			System.out.println(game.nextQuestion() + " : ") ;
			String answer = sc.nextLine();
			boolean valid = game.isAnswerValid(answer);
			if (!valid ) {
				System.out.println("You failed, the correct answer is : " + game.getRightAnswer() );
			}
			else
				System.out.println("Well done ! ");
		}

		System.out.println("Score : " + game.getPoints());
	}



}
