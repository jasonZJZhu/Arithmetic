import java.util.Scanner;
/**
 * This class uses and tests the Addition, Subtraction, and Multiplication classes
 *
 * @author Jason Zhu
 * @version January 22, 2018
 */
public class ArithmeticTest{
    /**
     * This is the main() function
     */
    public static void main(String[] args){
        boolean valid = false;
        int numQuestions = 0;
        int numAnswers = 0;
        int questionType = 0;
        int tempType = 0;
        String question = "";
        boolean answer = false;
        Arithmetic arithmetic;
        
        // getting number of questions
        System.out.println("How many questions would you like (1-10)? ");
        numQuestions = inputValidation(1,10);
        
        // getting type of questions
        System.out.println("What would you like to practice?\n");
        System.out.println("1. Addition only\n2. Subtraction only\n3. Multiplication only\n4. Random mix (all 3 types)\n");
        System.out.println("Choice: ");
        questionType = inputValidation(1,4);
        
        // giving questions
        for (int i = 1; i <= numQuestions; i++){
            if (questionType == 4){
                // 40% chance of addition, 20% of subtraction, 40% of multiplication
                tempType = (int)(Math.random()*3 +1);
            }else{
                tempType = questionType;
            }
            switch(tempType){
                // addition case
                case 1:
                    arithmetic = new Addition();
                    // get question
                    question = arithmetic.getQuestion();
                    System.out.println( "Q" + i + ": " + question );
                    // get and check answer
                    answer = arithmetic.checkAnswer( arithmetic.getAnswer() );
                    // restate question if the user gives wrong answer
                    if (answer == false){
                        do {
                            System.out.println( negativeString() );
                            System.out.println( "Q" + i + ": " + question );
                            answer = arithmetic.checkAnswer( arithmetic.getAnswer() );
                            numAnswers++;
                        } while ( answer  == false);
                    }
                    break;
                    // subtraction case
                case 2:
                    arithmetic = new Subtraction();
                    // get question
                    question = arithmetic.getQuestion();
                    System.out.println( "Q" + i + ": " + question );
                    // get and check answer
                    answer = arithmetic.checkAnswer( arithmetic.getAnswer() );
                    // restate question if the user gives wrong answer
                    if (answer == false){
                        do {
                            System.out.println( negativeString() );
                            System.out.println( "Q" + i + ": " + question );
                            answer = arithmetic.checkAnswer( arithmetic.getAnswer() );
                            numAnswers++;
                        } while ( answer  == false);
                    }
                    break;
                    // multiplication case
                case 3:
                    arithmetic = new Multiplication();
                    // get question
                    question = arithmetic.getQuestion();
                    System.out.println( "Q" + i + ": " + question );
                    // get and check answer
                    answer = arithmetic.checkAnswer( arithmetic.getAnswer() );
                    // restate question if the user gives wrong answer
                    if (answer == false){
                        do {
                            System.out.println( negativeString() );
                            System.out.println( "Q" + i + ": " + question );
                            answer = arithmetic.checkAnswer( arithmetic.getAnswer() );
                            numAnswers++;
                        } while ( answer  == false);
                    }
                    break;
            }
            // records the number of answers used
            numAnswers++;
            System.out.println( positiveString() );
        }
        // rounds the tenth digit
        System.out.printf("You answered %d questions using %d responses, your score is %.1f%%",numQuestions, numAnswers, numQuestions*100.0/numAnswers);
    }
    /**
     * This helper method helps to take in and validate user input, and returning the user input back to main
     *
     * @param minRange - lower end of the range of valid values
     * @param maxRange - higher end of the range of valid values
     * @return int - the user input
     */
    private static int inputValidation(int minRange, int maxRange){
        Scanner input = new Scanner( System.in );
        boolean valid = false;
        String number = "";
        int result = -1;
        boolean isInt = false;
        // input validation
        while (valid == false){
            try {
                number = input.nextLine();
                // eliminate empty inputs
                if (number.trim().equals("")){
                    System.err.println("Please enter a value. ");
                    isInt = false;
                }else{
                    result = Integer.parseInt(number.trim());
                    isInt = true;
                }
            }
            // eliminate non-int inputs
            catch ( NumberFormatException numberFormatException ) {
                System.err.println("Please enter an integer value. ");
                isInt = false;
            }
            // eliminate negative inputs
            if (isInt){
                if ((result >= minRange) && (result <= maxRange)){
                    valid = true;
                }else{
                    System.err.println("Please enter a value within the given range. ");
                }          
            }
        }
        return result;
    }
    /**
     * This helper method randomly selects 1 of 5 positive responses as a String
     *
     * @return String - response
     */
    private static String positiveString(){
        // randomize reply
        int reply = (int)(Math.random()*10+1);
        if (reply > 5){
            reply -= 5;
        }
        switch (reply){
            case 1:
                return "Correct!\n";
            case 2:
                return "Good work!\n";
            case 3:
                return "Nice job!\n";
            case 4:
                return "Keep up the good work!\n";
            case 5:
                return "Brilliant!\n";
        }
        return "";
    }
    /**
     * This helper method randomly selects 1 of 5 negative responses as a String
     *
     * @return String - response
     */
    private static String negativeString(){
        // randomize reply
        int reply = (int)(Math.random()*5)+1;
        switch (reply){
            case 1:
                return "Inccorrect!\n";
            case 2:
                return "You can do better!\n";
            case 3:
                return "Sorry, try again.\n";
            case 4:
                return "Um.. no.\n";
            case 5:
                return "Not even close!\n";
        }
        return "";
    }
}