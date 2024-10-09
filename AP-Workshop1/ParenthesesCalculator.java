import java.io.*;
import java.util.*;

import javax.swing.plaf.TreeUI;

@SuppressWarnings("unused")

public class ParenthesesCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inputQuestion = scanner.nextLine();
        //Clear the space place of scanned string
        inputQuestion = inputQuestion.replace(" ","");
        //Call the method that calculate the answer and print it
        Double answer = stackBaseParentheses(inputQuestion);
        System.out.println("The final answer is : " + answer);
    }
    //////////The method that use the prefix algotithm to calculate the order of operations 
    public static Double stackBaseParentheses(String inputString){
        //StringBuilder and ArrayList are the type that use because we can to delete or change the value of these variables
        StringBuilder stackString = new StringBuilder();
        ArrayList<Double> prefixString = new ArrayList<>();
        //This flag show us that the character should to add as a new member or sum with previos
        short flagDigitNumber = 0;
        //in the folowing lines we move on the character of inputs
        for(int i=0;i<inputString.length();i++){
            //This check the priority of plus and minus:
            if(inputString.charAt(i) == '+' || inputString.charAt(i) == '-'){
                flagDigitNumber = 0;
                while(stackString.length() != 0 && stackString.charAt(stackString.length()-1) != '('){
                    double answer = calculatorOperation(prefixString.get(prefixString.size()-1), prefixString.get(prefixString.size()-2), stackString.charAt(stackString.length()-1));
                    prefixString.set(prefixString.size()-2, answer);     
                    prefixString.remove(prefixString.size()-1);
                    stackString.deleteCharAt(stackString.length()-1);
                    //-->
                    System.out.println("The answer is : " + answer);
                } 
                if(inputString.charAt(i) == '+')      stackString.append("+");
                else       stackString.append("-");
            }
            //This check the priority of multiplication and division:
            else if(inputString.charAt(i) == '*' || inputString.charAt(i) == '/'){
                flagDigitNumber = 0;
                while (stackString.length() != 0 && (stackString.charAt(stackString.length()-1) == '*' || stackString.charAt(stackString.length()-1) == '/')) {
                    double answer = calculatorOperation(prefixString.get(prefixString.size()-1), prefixString.get(prefixString.size()-2), stackString.charAt(stackString.length()-1));
                    prefixString.set(prefixString.size()-2, answer);     
                    prefixString.remove(prefixString.size()-1);
                    stackString.deleteCharAt(stackString.length()-1);
                    //-->
                    System.out.println("The answer is : " + answer);
                }
                if(inputString.charAt(i) == '*')      stackString.append("*");
                else       stackString.append("/");
            }
            //The priority of openParenthes is uppest
            else if(inputString.charAt(i) == '('){
                flagDigitNumber = 0;
                stackString.append("(");
            } 
            //The priority of closeParenthes is upto openParenthes.
            else if(inputString.charAt(i) == ')'){
                flagDigitNumber = 0;
                while (stackString.charAt(stackString.length()-1) != '('){
                    double answer = calculatorOperation(prefixString.get(prefixString.size()-1), prefixString.get(prefixString.size()-2), stackString.charAt(stackString.length()-1));
                    prefixString.set(prefixString.size()-2, answer);     
                    prefixString.remove(prefixString.size()-1);
                    stackString.deleteCharAt(stackString.length()-1);
                    //-->
                    System.out.println("The answer is : " + answer);
                }
                stackString.deleteCharAt(stackString.length()-1);
            }
            //Create the numbers:
            else{
                if(flagDigitNumber == 0){    
                    prefixString.add(Double.parseDouble(Character.toString(inputString.charAt(i))));
                    flagDigitNumber = 1;
                }
                else    
                    prefixString.set(prefixString.size()-1, prefixString.get(prefixString.size()-1) * 10 + Double.parseDouble(Character.toString(inputString.charAt(i))));
            }
        }
        //Calculate the remained operations:
        while (stackString.length() != 0) {
            double answer = calculatorOperation(prefixString.get(prefixString.size()-1), prefixString.get(prefixString.size()-2), stackString.charAt(stackString.length()-1));
            prefixString.set(prefixString.size()-2, answer);     
            prefixString.remove(prefixString.size()-1);
            stackString.deleteCharAt(stackString.length()-1);
            //-->
            System.out.println("The answer is : " + answer);
        }
        //Return the resault:
        return prefixString.get(prefixString.size()-1);
    }
    //////////The method that calculate based the operator and numbers:
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
