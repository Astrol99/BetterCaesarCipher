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

    // Main cipher class    
    public BetterCC(String input, int secretKey){
        plainText = input;
        key = secretKey;
    }

    // Encrypts plain text with caesar cipher method
    public void encrypt(){
        
        int len = plainText.length();
        System.out.println(len);
    }
    public static void main(String[] args) {
        
    }
}    