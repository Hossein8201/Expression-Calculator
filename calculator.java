import java.util.Scanner;

public class calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double firstNumber = scanner.nextDouble();
        String operation = scanner.next();
        double secondNumber = scanner.nextDouble();

        double resault = 0;

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
            default:
                break;
        }
        
        System.out.println("the resault is : " + firstNumber+" "+operation+" "+secondNumber+" = "+resault);
    }
}