import java.io.*;
import java.util.*;

import javax.swing.plaf.TreeUI;

@SuppressWarnings("unused")

public class ParenthesesCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String inputQuestion = scanner.nextLine();

        inputQuestion = inputQuestion.replace(" ","");

        Double answer = stackBaseParentheses(inputQuestion);

        System.out.println("The final answer is : " + answer);
    }

    //////////
    public static Double stackBaseParentheses(String inputString){

        StringBuilder stackString = new StringBuilder();
        ArrayList<Double> prefixString = new ArrayList<>();

        short flagDigitNumber = 0;

        for(int i=0;i<inputString.length();i++){

            if(inputString.charAt(i) == '+' || inputString.charAt(i) == '-'){
                flagDigitNumber = 0;
                while(stackString.length() != 0 && stackString.charAt(stackString.length()-1) != '('){
                    double answer = calculatorOperation(prefixString.get(prefixString.size()-1), prefixString.get(prefixString.size()-2), stackString.charAt(stackString.length()-1));
                    prefixString.set(prefixString.size()-2, answer);     
                    prefixString.remove(prefixString.size()-1);
                    stackString.deleteCharAt(stackString.length()-1);

                    System.out.println("The answer is : " + answer);
                } 
                if(inputString.charAt(i) == '+')      stackString.append("+");
                else       stackString.append("-");
            }

            else if(inputString.charAt(i) == '*' || inputString.charAt(i) == '/'){
                flagDigitNumber = 0;
                while (stackString.length() != 0 && (stackString.charAt(stackString.length()-1) == '*' || stackString.charAt(stackString.length()-1) == '/')) {
                    double answer = calculatorOperation(prefixString.get(prefixString.size()-1), prefixString.get(prefixString.size()-2), stackString.charAt(stackString.length()-1));
                    prefixString.set(prefixString.size()-2, answer);     
                    prefixString.remove(prefixString.size()-1);
                    stackString.deleteCharAt(stackString.length()-1);

                    System.out.println("The answer is : " + answer);
                }
                if(inputString.charAt(i) == '*')      stackString.append("*");
                else       stackString.append("/");
            }

            else if(inputString.charAt(i) == '('){
                flagDigitNumber = 0;
                stackString.append("(");
            } 

            else if(inputString.charAt(i) == ')'){
                flagDigitNumber = 0;
                while (stackString.charAt(stackString.length()-1) != '('){
                    double answer = calculatorOperation(prefixString.get(prefixString.size()-1), prefixString.get(prefixString.size()-2), stackString.charAt(stackString.length()-1));
                    prefixString.set(prefixString.size()-2, answer);     
                    prefixString.remove(prefixString.size()-1);
                    stackString.deleteCharAt(stackString.length()-1);

                    System.out.println("The answer is : " + answer);
                }
                stackString.deleteCharAt(stackString.length()-1);
            }

            else{
                if(flagDigitNumber == 0){    
                    prefixString.add(Double.parseDouble(Character.toString(inputString.charAt(i))));
                    flagDigitNumber = 1;
                }
                else    
                    prefixString.set(prefixString.size()-1, prefixString.get(prefixString.size()-1) * 10 + Double.parseDouble(Character.toString(inputString.charAt(i))));
            }
        }
        //////
        while (stackString.length() != 0) {
            double answer = calculatorOperation(prefixString.get(prefixString.size()-1), prefixString.get(prefixString.size()-2), stackString.charAt(stackString.length()-1));
            prefixString.set(prefixString.size()-2, answer);     
            prefixString.remove(prefixString.size()-1);
            stackString.deleteCharAt(stackString.length()-1);

            System.out.println("The answer is : " + answer);
        }
        //////
        return prefixString.get(prefixString.size()-1);
    }

    ////////
    public static double calculatorOperation(Double secondNumber, Double firstNumber, Character operator){

        Double resault = 0.0;

        switch(operator) {
            case '+':
                resault = firstNumber + secondNumber;
                break;
            case '-':
                resault = firstNumber - secondNumber;
                break;
            case '*':
                resault = firstNumber * secondNumber;
                break;
            case '/':
                // The condition to check the secondNumber for divide operation:
                if(secondNumber == 0){
                    System.out.println("the operation is not true to calculate because the divide by zero eror !!!");
                    System.exit(0);
                }
                resault = firstNumber / secondNumber;
                break;
        }

        return resault;
    }
}
