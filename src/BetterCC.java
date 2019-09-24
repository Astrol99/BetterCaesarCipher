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
                System.exit(1);                                                        // then exits out of program
            }
        }
    }

    // Sends user results and data
    public void output(){
        System.out.println("\nOriginal String: "+plainText);
        System.out.println("Key: "+key);
        if (cryptMode == 0){
            System.out.println("Encrypted String: "+cipherText);
        }else if (cryptMode == 1){
            System.out.println("Decrypted String: "+cipherText);
        }
    }

    // Built-in help command
    public void help(){
        System.out.print("s");
    }

    public static void main(String[] args) {
        BetterCC caeser = new BetterCC(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));      // Make sure limit of key is 0-26
        caeser.mainCipher();
        caeser.output();
    }
}    