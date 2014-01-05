package douzi.kaoshi.scpm;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class EncryptUtil {

	//�㷨����  
	public static final String KEY_ALGORITHM = "DES"; 
	
	//�㷨����/����ģʽ/��䷽ʽ  
	public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";  
	
	//��ȡKey
	private static Key toKey(byte[] key) throws Exception {  
	    DESKeySpec des = new DESKeySpec(key);  
	    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);  
	    SecretKey secretKey = keyFactory.generateSecret(des);  
	    return secretKey;  
	}  
	
	/**
	 * ����
	 * @param data
	 * @param key
	 * @return
	 */
	public static byte[] Encode(byte[] data,byte[] key,byte[] biv){
		
		try {
			Key k = toKey(key);  
		    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);  
		    
		    AlgorithmParameterSpec iv = new IvParameterSpec(biv);//��������\
		    
		    cipher.init(Cipher.ENCRYPT_MODE, k,iv);  
	    
			return cipher.doFinal(data);
		} catch (IllegalBlockSizeException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}  
	    
		return null;
	}
	
	/**
	 * ����
	 * @param data
	 * @param key
	 * @return
	 */
	public static byte[] Decode(byte[] data ,byte[] key,byte[]biv){
		try {
			
			Key k = toKey(key);  
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);  
		
			AlgorithmParameterSpec iv = new IvParameterSpec(biv);//��������
			cipher.init(Cipher.DECRYPT_MODE, k,iv);
			return cipher.doFinal(data);  
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}  
		
		return null;
	}
}
