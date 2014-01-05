package douzi.kaoshi.scpm;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个单选题,只有一个题干,但其可能对应若干个选择题目
 * @author wenbaolin
 *
 */
public class SingleChoiceQues {
	
	/**
	 * 题目编号
	 */
	private int 				mID;
	
	/**
	 * 题干内容
	 */
	private String				mContent;
	
	/**
	 * 题干下对应的若干题目(即问题)
	 */
	private List<SubChoiceQues>		mSubChoice;
	
	public SingleChoiceQues(){
		mSubChoice = new ArrayList<SubChoiceQues>();
	}
	
	public void addSubQuestion(SubChoiceQues ci){
		
		ci.mMain = this;
		
		mSubChoice.add(ci);
	}
	
	public List<SubChoiceQues> getSubQuestion(){
		return mSubChoice;
	}
	
	public void setID(int id){
		mID = id;
	}
	
	public int getID(){
		return mID;
	}
	
	public void setContent(String strContent){
		this.mContent = strContent;
	}
	
	public String getContent(){
		
		return this.mContent;
	}
}
