package encryptor1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ShiftUpEncryption implements EncryptionAlgorithm {

	public void handle_ecncryption(String originalFilePaths, char keyPath,
			int AddOrMulti) {
		try {
			PrintWriter encriptedFile = new PrintWriter(
					getOutPutFileName(originalFilePaths));
			PrintWriter keyFile = new PrintWriter(
					getOutPutFileNameKey(originalFilePaths));
			keyFile.print((int) keyPath);
			keyFile.close();
			FileReader fileReader = new FileReader(new File(originalFilePaths));
			BufferedReader br = new BufferedReader(fileReader);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				for (int i = 0; i < temp.length(); i++) {
					if (1 == AddOrMulti)
						encriptedFile.println(Math.addExact(keyPath,
								temp.charAt(i)));
					else
						encriptedFile.println(Math.multiplyExact(keyPath,
								temp.charAt(i)));
				}
			}

			encriptedFile.close();
			System.out.println("The Encrypted File is in  - "
					+ getOutPutFileNameKey(originalFilePaths));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void handle_decryption(String encryptedFilePath, String keyPath,
			int AddOrMulti) {
		try {
			PrintWriter encriptedFile = new PrintWriter(
					getOutPutFileNameDec(encryptedFilePath));

			FileReader fileReader1 = new FileReader(new File(keyPath));
			BufferedReader br1 = new BufferedReader(fileReader1);
			int key = Integer.parseInt(br1.readLine());
			FileReader fileReader = new FileReader(new File(encryptedFilePath));
			BufferedReader br = new BufferedReader(fileReader);
			String temp = null;
			while ((temp = br.readLine()) != null) {
				if (1 == AddOrMulti) {
					int number = Integer.parseInt(temp);
					encriptedFile.print((char) (number - key));
				}
				if (2 == AddOrMulti) {
					int number = Integer.parseInt(temp);
					encriptedFile.print((char) (number / key));
				}
			}

			encriptedFile.close();
			System.out.println("The Decrypted File is in  - "
					+ getOutPutFileNameDec(encryptedFilePath));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	String getOutPutFileName(String originalFilePaths) {
		int lastDot = 0;
		for (int i = 0; i < originalFilePaths.length(); i++) {
			if (originalFilePaths.substring(i, i + 1).equals("."))
				lastDot = i;
		}
		return originalFilePaths.substring(0, lastDot)
				+ "_encrypted"
				+ originalFilePaths.substring(lastDot,
						originalFilePaths.length());
	}

	String getOutPutFileNameDec(String originalFilePaths) {
		int lastDot = 0, lastDot2 = 0;
		for (int i = 0; i < originalFilePaths.length(); i++) {
			if (originalFilePaths.substring(i, i + 1).equals("_"))
				lastDot = i;
		}
		for (int i = 0; i < originalFilePaths.length(); i++) {
			if (originalFilePaths.substring(i, i + 1).equals("."))
				lastDot2 = i;
		}
		return originalFilePaths.substring(0, lastDot)
				+ "_decrypted"
				+ originalFilePaths.substring(lastDot2,
						originalFilePaths.length());
	}

	String getOutPutFileNameKey(String originalFilePaths) {
		int lastDot = 0;
		for (int i = 0; i < originalFilePaths.length(); i++) {
			if (originalFilePaths.substring(i, i + 1).equals("\\"))
				lastDot = i;
		}
		int lastDot2 = 0;
		for (int i = 0; i < originalFilePaths.length(); i++) {
			if (originalFilePaths.substring(i, i + 1).equals("."))
				lastDot2 = i;
		}
		return originalFilePaths.substring(0, lastDot2 - 1) + "key.txt";
	}

}
