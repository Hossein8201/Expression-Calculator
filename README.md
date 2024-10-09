# Expression Calculator

This Java program is designed to calculate mathematical expressions that include the operations of addition (`+`), subtraction (`-`), multiplication (`*`), and division (`/`). It supports complex expressions with parentheses to ensure ordered operations and precedence.

## Features

- **Basic Operations**: The calculator can handle the four basic arithmetic operations: addition, subtraction, multiplication, and division.
- **Order of Operations**: The program respects the standard rules of operator precedence (PEMDAS — parentheses, exponents, multiplication/division, addition/subtraction).
- **Parentheses Support**: You can include multiple layers of parentheses to define the order of operations.
- **Prefix Algorithm**: This program uses the prefix (Polish notation) algorithm to evaluate expressions efficiently. Prefix notation allows operators to precede their operands, simplifying the parsing of expressions, especially when parentheses are involved.

## How It Works

1. **Input**: The user provides a mathematical expression as a string.
2. **Processing**: The program converts the expression to prefix notation and evaluates it. The prefix algorithm simplifies expression evaluation by ensuring the correct order of operations is applied without needing extensive backtracking.
3. **Output**: The result of the mathematical expression is printed to the console.

## Installation

1. Clone or download the repository to your local machine.
2. Ensure that you have a Java Development Kit (JDK) installed on your machine.

## Usage

1. Compile the Java program:
   ```bash
   javac ExpressionCalculator.java
   ```

2. Run the program:
   ```bash
   java ExpressionCalculator
   ```

3. Enter a mathematical expression when prompted, for example:
   ```
   6 + ((5 + 7 * 9) / (2 - 3 / 1) + 5 - 1) * 2
   ```

4. The program will output the result of the expression:
   ```
   Result: <calculated_value>
   ```

## Example

**Input:**
```
6 + ((5 + 7 * 9) / (2 - 3 / 1) + 5 - 1) * 2
```

**Output:**
```
Result: <calculated_value>
```

## Code Structure

- **ExpressionCalculator.java**: The main program file that includes logic to parse and calculate expressions using the prefix algorithm.
- **Helper Methods**: You may have utility methods to handle parsing, calculating sub-expressions, and managing parentheses.

## Dependencies

- This program requires **Java 8** or higher.

## Future Improvements

- Add support for additional operators like exponentiation (`^`).
- Improve error handling for invalid input (e.g., unbalanced parentheses, invalid characters).

## Contributing

If you'd like to contribute to this project, feel free to fork the repository and submit a pull request. All contributions are welcome!

## License

This project is licensed under the MIT License.
