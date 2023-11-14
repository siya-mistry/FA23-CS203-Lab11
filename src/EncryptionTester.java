
public class EncryptionTester {
	
	public static void main(String[] args) throws Exception {
        String encryptedFilePath = "encrypted.txt";
        String decryptedFilePath = "decrypted.txt";
        String inputFilePath = "encryptMe.txt";
        String outputFilePath = "newEncrypted.txt";
		
        int shift = -4; // Says how much you would like to shift

        Encrypter enc = new Encrypter(shift);

		enc.caesarCipher(inputFilePath, outputFilePath);
		enc.caesarCipher(encryptedFilePath, decryptedFilePath);

	}


}
