package encryptor1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		EncryptionAlgorithm encryption_Alg = new ShiftMultiplyEncryption();
		FileEncryptor file_enc=null;
	    String input = null;
	    int number = 0;
	    boolean keepWhile = true;
        System.out.println("Plese Choose 1 For Encription And 2 For Decription");    
	    while (keepWhile)
	    try {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        input = bufferedReader.readLine();
	        number = Integer.parseInt(input);
	        if (1==number||2==number ){
	        	 file_enc = new FileEncryptor(number, encryption_Alg);
	        	 file_enc.run();
	        }
	        System.out.println("Plese Choose 1 For Encription And 2 For Decription");    
	    } catch (NumberFormatException ex) {
	       System.out.println("Error Please Select again");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
