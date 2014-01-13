package douzi.kaoshi.scpm.jni;

public class DBManagerNative {

	public static native long open_db(String strDBFile);
	
	public static native String[] getSingleChoiceMainQues(long handle);
	
	public static native String[] getSubChoiceQues(long handle);
	
	public static native void close_db(long handle);
	
	static{
		System.loadLibrary("douziexam");
	}
}
