/*
The program encrypts standard plain text with
an old cipher technique made by Julius Caesar

Author: Astrol99
Date: 09/07/19
*/

import java.util.Scanner;
import java.util.Random;

public class BetterCC{
    
    String plainText;
    String cipherText;
    boolean caps;
    int cryptMode; // 0 = encrypt; 1 = decrypt; 2 = bruteforce
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
                System.err.println("Error: Error determining crypt mode");      // Prints this out if something wrong happens
                return;                                                         // then exits out of program
            }
        }

        System.out.println(cipherText);
    }

    public static void main(String[] args) {
        BetterCC caeser = new BetterCC("Aa Bb Zz", 30, 1);      // Make sure limit of key is 0-26
        caeser.mainCipher();
    }
}    