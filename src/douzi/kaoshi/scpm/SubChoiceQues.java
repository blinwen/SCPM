package douzi.kaoshi.scpm;

public class SubChoiceQues {

	public int 			mID;
	
	/**
	 * 正确答案 1/2/3/4 -> A/B/C/D
	 */
	private int 			mTrueChoice;
	
	public String		mAItem;
	public String		mBItem;
	public String		mCItem;
	public String		mDItem;
	
	public SingleChoiceQues	mMain;
	
	public	int getTrueChoice(){
		
		return mTrueChoice;
	}
	
	public void setTrueChoice(int trueChoice){
		
		this.mTrueChoice = trueChoice;
	}
}
