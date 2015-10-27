package encryptor1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileEncryptor {

	private int status;
	private EncryptionAlgorithm encryption_Algorithem;

	public FileEncryptor(int encryptionOrDecryption,
			EncryptionAlgorithm encryption_Alg) {
		status = encryptionOrDecryption;
		encryption_Algorithem = encryption_Alg;
	}

	public void run() throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		if (1 == status) {
			System.out.println("Enter Source Path File");
			String originalFilePath = buffer.readLine();
			int keyPath = 100 +  (int)(Math.random()*(100));
			encryption_Algorithem.handle_ecncryption(originalFilePath,
					(char)keyPath,1);
		}
		if (2 == status) {
			System.out.println("Enter Encrypted Path File");
			String encriptedFilePath = buffer.readLine();
			System.out.println("Enter Key Path File");
			String key = buffer.readLine();
			encryption_Algorithem.handle_decryption(encriptedFilePath, key,1);
		}
	}

}