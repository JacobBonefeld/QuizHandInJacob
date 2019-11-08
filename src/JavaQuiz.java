
import java.util.Random;
import java.util.Scanner;

/**
 * @author Jacob Bonefeld
 */

public class JavaQuiz {
    public static void main(String[] args) {

        Boolean[] IsAnswered = {false,false,false,false,false,false,false,false,false,false}; // Stores if question has been answered
        int questionNumber;       // Stores the number of the question, which the player need to answer
        int player1Score = 0;
        int player2Score = 0;
        int questionCounter = 0;  // Counts how many questions that have been answered
        final int NUM_OF_QUESTIONS = 10;

        do{
            System.out.println("Player 1");
            questionNumber = getQuestionNumber(IsAnswered);   // Get question that has not been answered yet
            player1Score += askQuestion(questionNumber);      // Update score

            System.out.println("Player 2");
            questionNumber = getQuestionNumber(IsAnswered);
            player2Score += askQuestion(questionNumber);

            questionCounter += 2;                             // Update number of questions answered

        } while(questionCounter < NUM_OF_QUESTIONS);          // Continue loop until all questions is answered

        System.out.println("Scores \nPlayer 1: " + player1Score + "\nPlayer 2: " + player2Score);   // Print final score
    }

    public static int getQuestionNumber(Boolean[] IsAnswered){
        Random ran = new Random();
        int var;                             // Stores random generated number

        do{
            var = ran.nextInt(10);    // Generate random number for question

        } while(IsAnswered[var]);            // Until finding a not answered question

        IsAnswered[var] = true;              // Update that this question has been answered, so it will not be used again

        return var;                          // Return question number

    }

    public static int askQuestion(int questionNumber){

        Scanner in = new Scanner(System.in);
        String answer;

        String[][] QuestionAnswers = {      // 2 Dimensional array with questions and answers
                // Questions
                {
                        "Is Java an object oriented programming language?",
                        "Is String a primitive data type?",
                        "A method has exactly one return statement",
                        "Arrays can also be created and initialize as int x[] = new int[]{10,20,30};",
                        "Garbage Collection is manual process.",
                        "The JRE deletes objects when it determines that they are no longer being used. This process is called Garbage Collection.",
                        "Variable name can begin with a letter, \"$\", or \"_\".",
                        "Constructor overloading is not possible in Java.",
                        "In an instance method or a constructor, \"this\" is a reference to the current object.",
                        "Boolean means a statement can be either True, False, or Equal",

                },
                {// answers
                        "1", "0", "1", "1", "0", "1", "1", "0", "1", "0",
                }
        };


        System.out.println(QuestionAnswers[0][questionNumber] + "\nTrue(1) / False(0)");

        do{                                                        // Get input and check if valid
            answer = in.next();

            if(!(answer.equals("0")) && !(answer.equals("1"))){
                System.out.println("Error - Please enter 1 or 0");
            }

        } while(!(answer.equals("0")) && !(answer.equals("1")));


        if(answer.equals(QuestionAnswers[1][questionNumber])){    // Check if answer is correct
            return 1;
        }
        else return 0;


    }


}
