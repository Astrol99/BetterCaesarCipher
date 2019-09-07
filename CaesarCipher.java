import java.util.Scanner;
import java.util.Random;

//WORK ON BRUTEFORCE FEATURE

public class CaesarCipher{
    public static void main(String []args){

        boolean alpha;
        String newLine = System.getProperty("line.separator");
        String product = "";
        String EncryptedText = "";
        String LowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String UpperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String finalAlphabet = "";
        int key = 0;

        //Input of user
        System.out.print("Enter text: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int strInt = input.length();

        //Option between Encrypt, Decrypt, or BruteForce

        System.out.print("Would you like to (E)ncrypt, (D)ecrypt or (B)ruteforce?: ");
        Scanner cry = new Scanner(System.in);
        String crypt = cry.nextLine().toLowerCase();

        if (crypt.equals("e")){

            //Option between Random generated key or custom key
            System.out.print("(R)andom generated key or (C)ustom key?: ");
            Scanner opt = new Scanner(System.in);
            String option = opt.nextLine().toLowerCase();

            //If R or C is selected
            if (option.equals("c")){

                System.out.print("Enter key: ");
                Scanner ke = new Scanner(System.in);
                key = ke.nextInt();

                if (key%26 == 0){
                    System.out.println("Oops! Your key has been altered due to {key} % 26 == 0.");
                    key += 1;
                }    

                System.out.println("Key: " + key);
                
            }else if (option.equals("r")){

                Random KEY = new Random();
                key = KEY.nextInt(1000);

                if (key%26 == 0){
                    System.out.println("Oops! Your key has been altered due to {key} % 26 == 0.");
                    key += 1;
                }    

                System.out.println("Key: " + key);
            
            }else {
                
                System.out.println("Invalid Answer - Please try again...");
            
            }

            //Main Encryption
            for (int i = 0; i < strInt; i++){

                char letter = input.charAt(i);

                if (letter == ' '){
                    EncryptedText += " ";
                    continue;
                }

                boolean check = Character.isUpperCase(letter);

                if (check == true){
                    finalAlphabet = UpperAlphabet;
                }else if (check == false){
                    finalAlphabet = LowerAlphabet;
                }

                if (finalAlphabet.contains(String.valueOf(letter)) == false){
                    EncryptedText += letter;
                    continue;
                }

                int initalInputInt = finalAlphabet.indexOf(letter);
                int finalInputInt = (key + initalInputInt) % 26;
                char finalCharOne = finalAlphabet.charAt(finalInputInt);
                    
                    EncryptedText += finalCharOne;
            
            product = "Encrypted";
            
            }
        }else if (crypt.equals("d")){

            System.out.print("Enter the key given: ");
            Scanner Dokey = new Scanner(System.in);
            int Dekey = Dokey.nextInt();

            for (int i = 0; i < strInt; i++){

                char letter = input.charAt(i);

                
                if (letter == ' '){
                    EncryptedText += " ";
                    continue;
                }

                boolean check = Character.isUpperCase(letter);
                
                if (check == true){
                    finalAlphabet = UpperAlphabet;
                }else if (check == false){
                    finalAlphabet = LowerAlphabet;
                }

                if (finalAlphabet.contains(String.valueOf(letter)) == false){
                    EncryptedText += letter;
                    continue;
                }

                int initalInputInt = finalAlphabet.indexOf(letter);

                int DecryptKey = initalInputInt - Dekey;

                if (DecryptKey < 0){
                    fix:
                        while (true) {
                            DecryptKey = Math.abs(DecryptKey);
                            DecryptKey = finalAlphabet.length() - DecryptKey;

                            if (DecryptKey <= finalAlphabet.length() && DecryptKey >= 0){
                                break fix;
                            }
                        }
                }

                int finalInputInt = (DecryptKey) % 26;
                char finalCharOne = finalAlphabet.charAt(finalInputInt);

                    EncryptedText += finalCharOne;
            }

            product = "Decrypted";

        }else if (crypt.equals("b")){
            
            for (int a = 0; a < LowerAlphabet.length(); a++){
    
                for (int i = 0; i < strInt; i++){

                    char letter = input.charAt(i);

                    if (letter == ' '){
                        EncryptedText += " ";
                        continue;
                    }

                    boolean check = Character.isUpperCase(letter);
                    
                    if (check == true){
                        finalAlphabet = UpperAlphabet;
                    }else if (check == false){
                        finalAlphabet = LowerAlphabet;
                    }

                    if (finalAlphabet.contains(String.valueOf(letter)) == false){
                        EncryptedText += letter;
                        continue;
                    }

                    int initalInputInt = finalAlphabet.indexOf(letter);

                    int DecryptKey = initalInputInt - a;

                    if (DecryptKey < 0){
                        fix:
                            while (true) {
                                DecryptKey = Math.abs(DecryptKey);
                                DecryptKey = finalAlphabet.length() - DecryptKey;

                                if (DecryptKey <= finalAlphabet.length() && DecryptKey >= 0){
                                    break fix;
                                }
                            }
                    }

                    int finalInputInt = (DecryptKey) % 26;
                    char finalCharOne = finalAlphabet.charAt(finalInputInt);

                        EncryptedText += finalCharOne;
                }

                EncryptedText += "," + newLine + Integer.toString(a) + "-";
                product = "Decrypted";
            }
        }else{
            System.out.println("Invalid answer - Please try again later...");
        }
        System.out.println(product + " text: " + EncryptedText);
        }
}    