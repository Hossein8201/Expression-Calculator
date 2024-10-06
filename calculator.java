// This is the JAVA code for Calculator Program:
import java.util.Scanner;

public class calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // The inputs variables and their data types:
        double firstNumber = scanner.nextDouble();
        String operation = scanner.next();
        double secondNumber = scanner.nextDouble();
        double resault = 0;
        // Define the operation that we want to do:
        switch (operation) {
            case "+":
                resault = firstNumber + secondNumber;
                break;
            case "-":
                resault = firstNumber - secondNumber;
                break;
            case "*":
                resault = firstNumber * secondNumber;
                break;
            case "/":
                resault = firstNumber / secondNumber;
                break;
            // the condition that show us the operation is not define for program:
            default:
                System.out.println("the operation is not defined!!!");
                return;
        }
        // show the answer:
        System.out.println("the resault is : " +firstNumber+" "+operation+" "+secondNumber+" = "+resault);
    }
}