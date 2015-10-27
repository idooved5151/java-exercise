package encryptor1;



public class ShiftMultiplyEncryption  implements EncryptionAlgorithm {
	
	private EncryptionAlgorithm encryption_Alg = new ShiftUpEncryption();

	@Override
	public void handle_ecncryption(String originalFilePath, char keyPath,int number) {
		encryption_Alg.handle_ecncryption(originalFilePath, keyPath, 2);
	

	}

	@Override
	public void handle_decryption(String encryptedFilePath, String keyPath,int AddOrMulti) {
		encryption_Alg.handle_decryption(encryptedFilePath, keyPath, 2);
	}

}
