/*
The program encrypts standard plain text with
an old cipher technique made by Julius Caesar

Author: Astrol99
Date: 09/07/19
*/

public class BetterCC{
    
    String plainText;
    String cipherText;
    boolean caps;
    int cryptMode; // 0 = encrypt; 1 = decrypt;
    int key; // Secret key to decrypt already encrypted string

    // Main cipher base
    static String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String alphabetLower = alphabetUpper.toLowerCase();
    String alphabet;    // Final alphabet that decides if it is lowercase or uppercase

    // Main cipher class    
    public BetterCC(String input, int secretKey, int crypt){
        plainText = input;
        key = secretKey;
        cryptMode = crypt;
        cipherText = "";   // Gets rid of null in string
    }

    // Decides between lower and upper chars
    public void alphabetCaps(){
        if(caps == true){
            alphabet = alphabetUpper;
        }else{
            alphabet = alphabetLower;
        }
    }

    public char encryptChar(char initalChar){
        char convertedChar;

        try {                                                                           // Try if convertedChar isn't over 26 - which gives      
            convertedChar = alphabet.charAt(alphabet.indexOf(initalChar)+key);          // StringIndexOutOfBoundsException if true then uses  
        }catch (StringIndexOutOfBoundsException e){                                     // modulos to keep the number under 26
            int tempNum = (alphabet.indexOf(initalChar)+key)%26;            
            convertedChar = alphabet.charAt(tempNum);        
        }
        return convertedChar;
    }

    public char decryptChar(char initalChar){
        char convertedChar;

        try {                                                                        
            convertedChar = alphabet.charAt(alphabet.indexOf(initalChar)-key);          // Same thing with encrypt function but subtracts key
        }catch (StringIndexOutOfBoundsException e){                                     // instead and adds 26 while final key is less than 26
            int tempNum = (alphabet.indexOf(initalChar)-key);
            while (tempNum < 0){
                tempNum += 26;
            }                           
            convertedChar = alphabet.charAt(tempNum);                               
        }
        return convertedChar;
    }

    // Encrypts plain text with caesar cipher method
    public void mainCipher(){

        for (int i = 0;i <= plainText.length() - 1;i++){
            Character initalChar = plainText.charAt(i);
            String initalStr = initalChar.toString();

            caps = !initalStr.equals(initalStr.toLowerCase());     // Checks if char is caps and changes
            alphabetCaps();                                        // entire alphabet accordingly

            if (alphabet.contains(initalStr) == false){            // Checks if char is in alphabet string
                cipherText += initalChar; continue;                // Skips loop and adds it to cipherText if false
            }

            if (cryptMode == 0){                                   // Determines if you want to encrypt
                cipherText += encryptChar(initalChar);
            }else if (cryptMode == 1){
                cipherText += decryptChar(initalChar);
            }else{
                System.err.println("[!] Error: Invalid crypt mode");      // Prints this out if something wrong happens
                help();                                                        // then exits out of program
            }
        }
    }

    // Sends user results and data
    public void output(){
        System.out.println("\n<Original String>: "+plainText);
        System.out.println("<Key>: "+key);
        if (cryptMode == 0){
            System.out.println("<Encrypted String>: "+cipherText);
        }else if (cryptMode == 1){
            System.out.println("<Decrypted String>: "+cipherText);
        }
    }

    // Built-in help command
    static public void help(){
        System.out.println("\n[?] Usage: java BetterCC <String> <Key> <Crypt Mode>");
        System.out.println("\n<String>: If your input string has spaces, use quotation marks around the string");
        System.out.println("<Key>: The key for your string to either encrypt or decrypt it. You can use any number");
        System.out.println("<Crypt Mode>: Can only be either 0 or 1. | 0 = Encrypt | 1 = Decrypt |");
        System.out.println("\n~ Made by astrol99");

        System.exit(0);
    }

    // Checks for invalid command line args and prints proper error msg
    static public void invalidCommand(){
        System.out.println("[!] Error: Invalid Command Usage");
        help();
        System.exit(1);
    }

    public static void main(String[] args) {
        try {
            String plain = args[0];
            int key = Integer.parseInt(args[1]);
            int mode = Integer.parseInt(args[2]);
            
            if (plain.equals("help") || plain.equals("-h")){
                help();
            }

            BetterCC caeser = new BetterCC(plain, key, mode);
            caeser.mainCipher();
            caeser.output();
        } catch (NumberFormatException e){
            invalidCommand();
        } catch (ArrayIndexOutOfBoundsException e){
            invalidCommand();
        }	       
    }
}    
