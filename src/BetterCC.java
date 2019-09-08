/*
The program encrypts standard plain text with
an old cipher technique made by Julius Caesar

Author: Astrol99
Date: 09/07/19
*/

import java.util.Scanner;
import java.util.Random;

public class BetterCC{
    
    // Parameters for cipher
    String plainText;
    String cipherText;
    int key;

    // Main cipher base
    static String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String alphabetLower = alphabetUpper.toLowerCase();
    String alphabet;

    // Main cipher class    
    public BetterCC(String input, int secretKey){
        plainText = input;
        key = secretKey;
        cipherText = ""; // Gets rid of null in string
    }

    // Encrypts plain text with caesar cipher method
    public void encrypt(){

        for (int i=0;i<=plainText.length()-1;i++){
            cipherText += alphabetUpper.charAt(alphabetUpper.indexOf(plainText.charAt(i))+key);
        }
        System.out.println(cipherText);
    }
    public static void main(String[] args) {
        BetterCC caeser = new BetterCC("AAAA", 5);
        caeser.encrypt();
    }
}    