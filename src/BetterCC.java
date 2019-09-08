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
    boolean encryptMode; 
    int key; // Secret key to decrypt already encrypted string

    // Main cipher base
    static String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String alphabetLower = alphabetUpper.toLowerCase();
    String alphabet;    // Final alphabet that decides if it is lowercase or uppercase

    // Main cipher class    
    public BetterCC(String input, int secretKey, boolean crypt){
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

    public char cryptChar(char initalChar){
        char convertedChar;
        
        try {                                                                        
            convertedChar = alphabet.charAt(alphabet.indexOf(initalChar)+key);      // If the key or letter is over the   
        }catch (StringIndexOutOfBoundsException e){                                 // limit of 26 or 'z', it will use
            int tempNum = (alphabet.indexOf(initalChar)+key)%26;                    // the modulos operator to find 
            convertedChar = alphabet.charAt(tempNum);                               // the key that is less than 27
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

            cipherText += cryptChar(initalChar);
        }

        System.out.println(cipherText);
    }

    public static void main(String[] args) {
        BetterCC caeser = new BetterCC("Aa Bb Zz", 30);
        caeser.mainCipher();
    }
}    