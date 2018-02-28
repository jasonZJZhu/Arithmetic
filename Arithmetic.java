import java.util.Scanner;
/**
 * This abstract class sets the framework for all other calculation classes
 * 
 * @author Jason Zhu
 * @version January 22, 2018
 */ 
abstract class Arithmetic{
    protected int leftOperand;
    protected int rightOperand;
    protected Scanner input = new Scanner( System.in );
    /**
     * This constructor method randomly sets the values for both operand between 1 to 9 inclusive
     * 
     * @see Math
     */ 
    public Arithmetic(){
        //multiplying the float by 9 and add one afterwards, the answer will never exceed 9 and will not be 0
        leftOperand = (int)(Math.random()*9)+1;
        rightOperand = (int)(Math.random()*9)+1;
    }
    /**
     * This mutator method changes the leftOperand variable to the integer parameter, if the parameter
     * is not a valid value, leftOperand is set automatically to 1
     * It does not return a value
     * 
     * @param operand The operand value(int) the user wishes to use
     */
    public void setLeftOperand(int operand){
        if ((operand >=  1) && (operand <= 9)){
            leftOperand = operand;
        }else{
            System.err.println("Invalid value of operand, set to 1 by default");
        }
    }
    /**     
     * This mutator method changes the RightOperand variable to the integer parameter, if the parameter
     * is not a valid value, rightOperand is set automatically to 1
     * It does not return a value
     * 
     * @param operand The operand value(int) the user wishes to use
     */ 
    public void setRightOperand(int operand){
        if ((operand >=  1) && (operand <= 9)){
            rightOperand = operand;
        }else{
            System.err.println("Invalid value of operand, set to 1 by default");
        }
    }
    /**
     * This method returns the value of leftOperand
     * It takes no parameters
     * 
     * @return int - left operand
     */ 
    public int getLeftOperand(){
        return leftOperand;
    }
    /**
     * This method returns the value of rightOperand
     * It takes no parameters
     * 
     * @return int - right operand
     */ 
    public int getRightOperand(){
        return rightOperand;
    }
    /**
     * This abstract method requires subclasses to have a getQuestion() method
     */ 
    public abstract String getQuestion();
    /**
     * This method uses a Scanner object to get an integer as answer from the user
     * It takes no parameters
     * 
     * @return int - answer
     * 
     * @see Scanner
     */ 
    public int getAnswer(){
        boolean valid = false;
        String temp = "";
        int answer = 0;
        while (valid == false) {
            try {
                temp = input.nextLine();
                // eliminate empty inputs
                if (temp.trim().equals("")){
                    System.err.println("Please enter a value");
                }else{
                    answer = Integer.parseInt(temp.trim());
                    valid = true;
                }
            }
            // eliminate non-int inputs
            catch (NumberFormatException numberFormatException){
                System.err.print("You must enter an integer. Please answer again: ");
            }
        }
        return answer;
    }
    /**
     * This abstract method requires subclasses to have a checkAnaswer() method
     */ 
    public abstract boolean checkAnswer(int a);
}