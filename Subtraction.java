/**
 * This class provides subtraction questions
 * 
 * @author Jason Zhu
 * @version January 22, 2018
 */
public class Subtraction extends Arithmetic{
    /**
     * This method returns a question in the format of ( leftOperand - rightOperand = )
     * It takes no parameters
     * 
     * @return String - "left operand - right operand ="
     */ 
    @Override
    public String getQuestion(){
        // ensure no negative answers required
        if (leftOperand < rightOperand){
            // swap operands to avoid negatives
            int tempLeft = leftOperand;
            leftOperand = rightOperand;
            rightOperand = tempLeft;
        }
        return leftOperand + " - " + rightOperand + " = ";
    }
    /**
     * This method takes in an integer value as answer, checks whether it is correct,
     * and returns the result
     * 
     * @param answer The answer(int) given by the user
     * @return boolean - result
     */ 
    @Override
    public boolean checkAnswer(int answer){
        if (answer == leftOperand - rightOperand){
            return true;
        }else{
            return false;
        }
    }
}