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
    public CaesarCipher(String input, String output, int secretKey){
        plainText = input;
        cipherText = output;
        key = secretKey;
    }
    public static void main(String[] args) {
        
    }
}    