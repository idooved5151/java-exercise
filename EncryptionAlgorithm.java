package encryptor1;



public interface EncryptionAlgorithm {

	public void handle_ecncryption(String originalFilePath,char keyPath,int AddOrMulty);
	
	public void handle_decryption(String encryptedFilePath,String keyPath,int AddOrMulti);


}
