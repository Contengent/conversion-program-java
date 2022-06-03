/**
 * @author 
 *
 *   /\_/\  _     ___
 *  |>'v'<||"| -/\, ,`>
 *     -=Edelstein=-
 * 
 */
package newconversionprogram.project;
import java.util.Scanner;


public class NewConversionProgramProject {
    public static void main(String[] args) {
        /* Variables */
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String toPrint;
        int userInput;
        String userInput2;
        int menuSelect;
        
        /* Main menu */
        System.out.println("Welcome to the conversion program!");
        System.out.println("Select one of the options using a number:");
        System.out.println("[1] Decimal to binary");
        System.out.println("[2] Binary to decimal");
        System.out.println("[3] Decimal to hexidecimal");
        System.out.println("[4] Hexidecimal to decimal");
        System.out.println("[0] Exit");
        menuSelect = input.nextInt();

        
        /* Menu filter */
        // I don't know why I did it like this
        if(menuSelect == 1 || menuSelect == 3){
            System.out.println("Now enter a decimal number to convert:");
            userInput = input.nextInt();
            
            if(menuSelect == 1){
                toPrint = decimalToBianry(userInput);
                System.out.println("The Binary svalue of inputted value is: " + toPrint);
            } else if(menuSelect == 3){
                toPrint = decimalToHexideciml(userInput);
                System.out.println("The hexadecimal value of inputted value is: " + toPrint);
            }
        } else if(menuSelect == 2 || menuSelect == 4){
            System.out.println("Now enter a binary, or hexidecimal number to convert:");
            userInput2 = input2.nextLine();
            if(menuSelect == 2){
                if(checkIfBinary(userInput2)){
                    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    System.out.println("The Binary/hexadecimal value of inputted value is: " + binaryToDecimal(userInput2));
                }
            } else if(menuSelect == 4){
                //
            }
        } else if(menuSelect == 0 || menuSelect > 4){
            if(menuSelect == 0){
                System.out.println("Exiting...");
                System.exit(0);
            } else if(menuSelect > 4){
                System.out.println("Error: invalid menu option selected!");
            }
        }

    }
    
    public static String decimalToBianry(int input){
        return Integer.toBinaryString(input); // built in java function
    }
    public static String decimalToHexideciml(int input){
        return Integer.toHexString(input); // built in java function
    }
    
    
    
    public static boolean checkIfBinary(String input){
        // return var
        boolean result = false;
        
        // main loop continue for length of input
        for(int i = 0; i < input.length(); i++){
            
            // checks if character at each point of input is 1, or 0
            if((int)input.charAt(i) == 49 || (int)input.charAt(i) == 48){
                if(i+1 == input.length()){ // i+1 is so this only happens once
                    System.out.println("Your Binary number checks out!");
                    result = true;
                }
            } else{ // if not, the input is not binary
                System.out.println("Error! You might not have entered a binary number!");
                result = false;
            }
        }
        
        return result;
    }
    
    public static int binaryToDecimal(String input){
        int binary = Integer.parseInt(input);
        int decimal = 0;
        int i = 0;
        // main loop
        do{
            int temp = binary % 10; // I on't rmem er ( I forgor)
            decimal += temp*Math.pow(2, i); // main calculation
            binary = binary/10; // removing the last number ex. 1001 -> 100
            i++;
        }while(binary > 0);
        
        return decimal;
    }
    
    
    static int hexadecimalToDecimal(String input){
        // I don't remember what any of this does
        int base = 1;
        int decimalValue = 0;
        
        for(int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                decimalValue += (input.charAt(i) - 48)  * base;
                base = base * 16;
            } else if(input.charAt(i) >= 'A' && input.charAt(i) <= 'F') {
                decimalValue += (input.charAt(i) - 55) * base;
                base = base * 16;
            }
        }
  
        return decimalValue;
    }
    
    
}